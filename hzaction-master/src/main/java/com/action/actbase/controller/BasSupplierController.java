package com.action.actbase.controller;
import com.action.actbase.entity.BasSupplierEntity;
import com.action.actbase.service.BasSupplierServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 供应商资料
 * @author onlineGenerator
 * @date 2019-08-02 18:09:04
 * @version V1.0   
 *
 */
@Api(value="BasSupplier",description="供应商资料",tags="basSupplierController")
@Controller
@RequestMapping("/basSupplierController")
public class BasSupplierController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BasSupplierController.class);

	@Autowired
	private BasSupplierServiceI basSupplierService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 供应商资料列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actbase/basSupplierList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BasSupplierEntity basSupplier,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//实现"名称"的模糊查询
		  if(basSupplier!=null&&basSupplier.getBsName()!=null){
			  basSupplier.setBsName("*"+basSupplier.getBsName()+"*");
		  }
		  if(basSupplier!=null&&basSupplier.getBsId()!=null){
			  basSupplier.setBsId("*"+basSupplier.getBsId()+"*");
		  }		
		CriteriaQuery cq = new CriteriaQuery(BasSupplierEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, basSupplier, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.basSupplierService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除供应商资料
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BasSupplierEntity basSupplier, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		basSupplier = systemService.getEntity(BasSupplierEntity.class, basSupplier.getId());
		message = "供应商资料删除成功";
		try{
			basSupplierService.delete(basSupplier);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "供应商资料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除供应商资料
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "供应商资料删除成功";
		try{
			for(String id:ids.split(",")){
				BasSupplierEntity basSupplier = systemService.getEntity(BasSupplierEntity.class, 
				id
				);
				basSupplierService.delete(basSupplier);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "供应商资料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加供应商资料
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BasSupplierEntity basSupplier, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "供应商资料添加成功";
		try{
			basSupplierService.save(basSupplier);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "供应商资料添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新供应商资料
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BasSupplierEntity basSupplier, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "供应商资料更新成功";
		BasSupplierEntity t = basSupplierService.get(BasSupplierEntity.class, basSupplier.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(basSupplier, t);
			basSupplierService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "供应商资料更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 供应商资料新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BasSupplierEntity basSupplier, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(basSupplier.getId())) {
			basSupplier = basSupplierService.getEntity(BasSupplierEntity.class, basSupplier.getId());
			req.setAttribute("basSupplierPage", basSupplier);
		}
		return new ModelAndView("com/action/actbase/basSupplier-add");
	}
	/**
	 * 供应商资料编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BasSupplierEntity basSupplier, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(basSupplier.getId())) {
			basSupplier = basSupplierService.getEntity(BasSupplierEntity.class, basSupplier.getId());
			req.setAttribute("basSupplierPage", basSupplier);
		}
		return new ModelAndView("com/action/actbase/basSupplier-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","basSupplierController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BasSupplierEntity basSupplier,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BasSupplierEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, basSupplier, request.getParameterMap());
		List<BasSupplierEntity> basSuppliers = this.basSupplierService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"供应商资料");
		modelMap.put(NormalExcelConstants.CLASS,BasSupplierEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("供应商资料列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,basSuppliers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BasSupplierEntity basSupplier,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"供应商资料");
    	modelMap.put(NormalExcelConstants.CLASS,BasSupplierEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("供应商资料列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<BasSupplierEntity> listBasSupplierEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BasSupplierEntity.class,params);
				for (BasSupplierEntity basSupplier : listBasSupplierEntitys) {
					basSupplierService.save(basSupplier);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(e.getMessage());
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
	@RequestMapping(value="/list/{pageNo}/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="供应商资料列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BasSupplierEntity>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize > Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(BasSupplierEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<BasSupplierEntity> listBasSuppliers = this.basSupplierService.getListByCriteriaQuery(query,true);
		return Result.success(listBasSuppliers);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取供应商资料信息",notes="根据ID获取供应商资料信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BasSupplierEntity task = basSupplierService.get(BasSupplierEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取供应商资料信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建供应商资料")
	public ResponseMessage<?> create(@ApiParam(name="供应商资料对象")@RequestBody BasSupplierEntity basSupplier, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BasSupplierEntity>> failures = validator.validate(basSupplier);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			basSupplierService.save(basSupplier);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("供应商资料信息保存失败");
		}
		return Result.success(basSupplier);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新供应商资料",notes="更新供应商资料")
	public ResponseMessage<?> update(@ApiParam(name="供应商资料对象")@RequestBody BasSupplierEntity basSupplier) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BasSupplierEntity>> failures = validator.validate(basSupplier);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			basSupplierService.saveOrUpdate(basSupplier);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新供应商资料信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新供应商资料信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除供应商资料")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			basSupplierService.deleteEntityById(BasSupplierEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("供应商资料删除失败");
		}

		return Result.success();
	}


	@RequestMapping(params = "doCreateSupplierId")
	@ResponseBody
	public AjaxJson doCreateProjectId(BasSupplierEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "产生客户编号成功";
		try{
			String sql = "select max(bs_id) from bas_supplier";
			List<Map<String,Object>> result = this.systemService.findForJdbc(sql);
			for(Map<String,Object> map : result){
				for(String key : map.keySet()){
					String maxid = map.get(key).toString();
					if(maxid.length() < 4){
						message = "S001";
					}else{
						maxid = maxid.substring(1);
						int i = Integer.parseInt( maxid );
						i++;
						if(i<10){
							message = "S00"+i;
						}else if(i<100){
							message = "S0"+i;
						}else{
							message = "S"+i;
						}
					}
				}
			}

			//vwBusProjectService.doBidSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "产生客户编号失败";
		}
		j.setMsg(message);
		return j;
	}
}
