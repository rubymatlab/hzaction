package com.action.actsale.controller;
import com.action.actsale.entity.BusBidEntity;
import com.action.actsale.entity.VwBusBidEntity;
import com.action.actsale.service.BusBidServiceI;
import com.action.actsale.service.VwBusBidServiceI;
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
import org.hibernate.criterion.Restrictions;
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
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 报价_投标审核
 * @author onlineGenerator
 * @date 2019-07-30 17:19:29
 * @version V1.0   
 *
 */
@Api(value="VwBusBid",description="报价_投标审核",tags="vwBusBidController")
@Controller
@RequestMapping("/vwBusBidController")
public class VwBusBidController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwBusBidController.class);

	@Autowired
	private VwBusBidServiceI vwBusBidService;
	@Autowired
	private BusBidServiceI busBidService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 报价_投标审核列表 页面跳转
	 * 
	 * @return
	 */
	//原生方法，跳转到主页
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		   return new ModelAndView("com/action/actsale/vwBusBidListMain");
	}
	
	//安信功能另加方法，跳转到未审核页
	@RequestMapping(params = "noVerify")
	public ModelAndView noVerify(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/vwBusBidListNoVf");
	}
	
	//安信功能另加方法，跳转到已审核页
	@RequestMapping(params = "verified")
	public ModelAndView verified(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/vwBusBidListVf");
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
	public void datagrid(VwBusBidEntity vwBusBid,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//实现"项目名称"的模糊查询
		if(vwBusBid!=null&&vwBusBid.getBpProjName()!=null){
			vwBusBid.setBpProjName("*"+vwBusBid.getBpProjName()+"*");
		}
		if(vwBusBid!=null&&vwBusBid.getBcName()!=null){
			vwBusBid.setBcName("*"+vwBusBid.getBcName()+"*");
		}
		CriteriaQuery cq = new CriteriaQuery(VwBusBidEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusBid, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwBusBidService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除报价_投标审核
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwBusBidEntity vwBusBid, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vwBusBid = systemService.getEntity(VwBusBidEntity.class, vwBusBid.getId());
		message = "报价_投标审核删除成功";
		try{
			vwBusBidService.delete(vwBusBid);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "报价_投标审核删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除报价_投标审核
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "报价_投标审核删除成功";
		try{
			for(String id:ids.split(",")){
				VwBusBidEntity vwBusBid = systemService.getEntity(VwBusBidEntity.class, 
				id
				);
				vwBusBidService.delete(vwBusBid);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "报价_投标审核删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加报价_投标审核
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwBusBidEntity vwBusBid, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "报价_投标审核添加成功";
		try{
			vwBusBidService.save(vwBusBid);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "报价_投标审核添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(vwBusBid);
		return j;
	}
	
	/**
	 * 更新报价_投标审核
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwBusBidEntity vwBusBid, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "报价_投标审核更新成功";
		//以下方式为刷新出BusBid实体，而不是视图实体
		BusBidEntity busBid = vwBusBidService.get(BusBidEntity.class, vwBusBid.getId());
		try {
			//复制视图实体数据到真正update的表实体
			MyBeanUtils.copyBeanNotNull2Bean(vwBusBid, busBid);
			//将修改update到表实体
			vwBusBidService.saveOrUpdate(busBid);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "报价_投标审核更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
 	/**
	 * 自定义按钮-[审核]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doVerifyBtn")
	@ResponseBody
	public AjaxJson doVerifyBtn(VwBusBidEntity vwBusBid, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核成功";
		VwBusBidEntity t = vwBusBidService.get(VwBusBidEntity.class, vwBusBid.getId());
		try{
			vwBusBidService.doVerifyBtnBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 报价_投标审核新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwBusBidEntity vwBusBid, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusBid.getId())) {
			vwBusBid = vwBusBidService.getEntity(VwBusBidEntity.class, vwBusBid.getId());
			req.setAttribute("vwBusBidPage", vwBusBid);
		}
		return new ModelAndView("com/action/actsale/vwBusBid-add");
	}
	/**
	 * 报价_投标审核编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwBusBidEntity vwBusBid, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusBid.getId())) {
			vwBusBid = vwBusBidService.getEntity(VwBusBidEntity.class, vwBusBid.getId());
			req.setAttribute("vwBusBidPage", vwBusBid);
		}
		return new ModelAndView("com/action/actsale/vwBusBid-update");
	}
	
	/**
	 * 报价_投标审核查看信息页面跳转，此为安信功能新增页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goView")
	public ModelAndView goView(VwBusBidEntity vwBusBid, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusBid.getId())) {
			vwBusBid = vwBusBidService.getEntity(VwBusBidEntity.class, vwBusBid.getId());
			req.setAttribute("vwBusBidPage", vwBusBid);
		}
		return new ModelAndView("com/action/actsale/vwBusBid-view");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vwBusBidController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwBusBidEntity vwBusBid,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VwBusBidEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusBid, request.getParameterMap());
		List<VwBusBidEntity> vwBusBids = this.vwBusBidService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"报价_投标审核");
		modelMap.put(NormalExcelConstants.CLASS,VwBusBidEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("报价_投标审核列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vwBusBids);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwBusBidEntity vwBusBid,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"报价_投标审核");
    	modelMap.put(NormalExcelConstants.CLASS,VwBusBidEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("报价_投标审核列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VwBusBidEntity> listVwBusBidEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VwBusBidEntity.class,params);
				for (VwBusBidEntity vwBusBid : listVwBusBidEntitys) {
					vwBusBidService.save(vwBusBid);
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
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id vwBusBid主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
	
	@RequestMapping(value="/list/{pageNo}/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="报价_投标审核列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VwBusBidEntity>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize > Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VwBusBidEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VwBusBidEntity> listVwBusBids = this.vwBusBidService.getListByCriteriaQuery(query,true);
		return Result.success(listVwBusBids);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取报价_投标审核信息",notes="根据ID获取报价_投标审核信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VwBusBidEntity task = vwBusBidService.get(VwBusBidEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取报价_投标审核信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建报价_投标审核")
	public ResponseMessage<?> create(@ApiParam(name="报价_投标审核对象")@RequestBody VwBusBidEntity vwBusBid, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwBusBidEntity>> failures = validator.validate(vwBusBid);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vwBusBidService.save(vwBusBid);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("报价_投标审核信息保存失败");
		}
		return Result.success(vwBusBid);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新报价_投标审核",notes="更新报价_投标审核")
	public ResponseMessage<?> update(@ApiParam(name="报价_投标审核对象")@RequestBody VwBusBidEntity vwBusBid) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwBusBidEntity>> failures = validator.validate(vwBusBid);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vwBusBidService.saveOrUpdate(vwBusBid);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新报价_投标审核信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新报价_投标审核信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除报价_投标审核")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			vwBusBidService.deleteEntityById(VwBusBidEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("报价_投标审核删除失败");
		}

		return Result.success();
	}
	
	//以下为检索下拉框的数据过滤（项目名称），注意：此项为安信项目独立要求
	@RequestMapping(value = "loadSuggestData")
	@ResponseBody
	public Object loadSuggestData(String keyword,HttpServletRequest request) {

		String sql = "select bp_proj_id,bp_proj_name from bus_project where bp_proj_name like '%" +keyword+"%'";
		JSONObject object = new JSONObject();
		object.put("message", "");
		try {
			List<Map<String,Object>> data = this.systemService.findForJdbc(sql);
			for (Map<String, Object> map : data) {
				for (String key : map.keySet()) {
					if(null == map.get(key)){
						map.put(key,"");
					}
				}
			}

			net.sf.json.JSONArray array = net.sf.json.JSONArray.fromObject(data);
			object.put("value", array);
			object.put("code", 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		object.put("redirect", "");
		return object;
	}

}
