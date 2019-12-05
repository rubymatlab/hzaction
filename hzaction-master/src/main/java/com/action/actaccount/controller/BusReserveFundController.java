package com.action.actaccount.controller;
import com.action.actaccount.entity.BusReserveFundEntity;
import com.action.actaccount.service.BusReserveFundServiceI;
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
 * @Description: 备用金或借款领用单
 * @author onlineGenerator
 * @date 2019-12-05 00:44:07
 * @version V1.0   
 *
 */
@Api(value="BusReserveFund",description="备用金或借款领用单",tags="busReserveFundController")
@Controller
@RequestMapping("/busReserveFundController")
public class BusReserveFundController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BusReserveFundController.class);

	@Autowired
	private BusReserveFundServiceI busReserveFundService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 备用金或借款领用单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/busReserveFundList");
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
	public void datagrid(BusReserveFundEntity busReserveFund,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BusReserveFundEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, busReserveFund, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.busReserveFundService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除备用金或借款领用单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BusReserveFundEntity busReserveFund, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		busReserveFund = systemService.getEntity(BusReserveFundEntity.class, busReserveFund.getId());
		message = "备用金或借款领用单删除成功";
		try{
			busReserveFundService.delete(busReserveFund);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "备用金或借款领用单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除备用金或借款领用单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "备用金或借款领用单删除成功";
		try{
			for(String id:ids.split(",")){
				BusReserveFundEntity busReserveFund = systemService.getEntity(BusReserveFundEntity.class, 
				id
				);
				busReserveFundService.delete(busReserveFund);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "备用金或借款领用单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加备用金或借款领用单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BusReserveFundEntity busReserveFund, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "备用金或借款领用单添加成功";
		try{
			busReserveFundService.save(busReserveFund);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "备用金或借款领用单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新备用金或借款领用单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BusReserveFundEntity busReserveFund, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "备用金或借款领用单更新成功";
		BusReserveFundEntity t = busReserveFundService.get(BusReserveFundEntity.class, busReserveFund.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(busReserveFund, t);
			busReserveFundService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "备用金或借款领用单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 备用金或借款领用单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BusReserveFundEntity busReserveFund, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(busReserveFund.getId())) {
			busReserveFund = busReserveFundService.getEntity(BusReserveFundEntity.class, busReserveFund.getId());
			req.setAttribute("busReserveFundPage", busReserveFund);
		}
		return new ModelAndView("com/action/actaccount/busReserveFund-add");
	}
	/**
	 * 备用金或借款领用单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BusReserveFundEntity busReserveFund, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(busReserveFund.getId())) {
			busReserveFund = busReserveFundService.getEntity(BusReserveFundEntity.class, busReserveFund.getId());
			req.setAttribute("busReserveFundPage", busReserveFund);
		}
		return new ModelAndView("com/action/actaccount/busReserveFund-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","busReserveFundController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BusReserveFundEntity busReserveFund,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BusReserveFundEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, busReserveFund, request.getParameterMap());
		List<BusReserveFundEntity> busReserveFunds = this.busReserveFundService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"备用金或借款领用单");
		modelMap.put(NormalExcelConstants.CLASS,BusReserveFundEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("备用金或借款领用单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,busReserveFunds);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BusReserveFundEntity busReserveFund,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"备用金或借款领用单");
    	modelMap.put(NormalExcelConstants.CLASS,BusReserveFundEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("备用金或借款领用单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<BusReserveFundEntity> listBusReserveFundEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BusReserveFundEntity.class,params);
				for (BusReserveFundEntity busReserveFund : listBusReserveFundEntitys) {
					busReserveFundService.save(busReserveFund);
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
	@ApiOperation(value="备用金或借款领用单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BusReserveFundEntity>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize > Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(BusReserveFundEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<BusReserveFundEntity> listBusReserveFunds = this.busReserveFundService.getListByCriteriaQuery(query,true);
		return Result.success(listBusReserveFunds);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取备用金或借款领用单信息",notes="根据ID获取备用金或借款领用单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BusReserveFundEntity task = busReserveFundService.get(BusReserveFundEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取备用金或借款领用单信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建备用金或借款领用单")
	public ResponseMessage<?> create(@ApiParam(name="备用金或借款领用单对象")@RequestBody BusReserveFundEntity busReserveFund, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BusReserveFundEntity>> failures = validator.validate(busReserveFund);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			busReserveFundService.save(busReserveFund);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("备用金或借款领用单信息保存失败");
		}
		return Result.success(busReserveFund);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新备用金或借款领用单",notes="更新备用金或借款领用单")
	public ResponseMessage<?> update(@ApiParam(name="备用金或借款领用单对象")@RequestBody BusReserveFundEntity busReserveFund) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BusReserveFundEntity>> failures = validator.validate(busReserveFund);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			busReserveFundService.saveOrUpdate(busReserveFund);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新备用金或借款领用单信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新备用金或借款领用单信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除备用金或借款领用单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			busReserveFundService.deleteEntityById(BusReserveFundEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("备用金或借款领用单删除失败");
		}

		return Result.success();
	}
}
