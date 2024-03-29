package com.action.actpo.controller;
import com.action.actpo.entity.VwRpPoPayPlanEntity;
import com.action.actpo.service.VwRpPoPayPlanServiceI;
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
 * @Description: 采购付款计划表
 * @author onlineGenerator
 * @date 2019-09-25 00:08:25
 * @version V1.0   
 *
 */
@Api(value="VwRpPoPayPlan",description="采购付款计划表",tags="vwRpPoPayPlanController")
@Controller
@RequestMapping("/vwRpPoPayPlanController")
public class VwRpPoPayPlanController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwRpPoPayPlanController.class);

	@Autowired
	private VwRpPoPayPlanServiceI vwRpPoPayPlanService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 采购付款计划表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actpo/vwRpPoPayPlanList");
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
	public void datagrid(VwRpPoPayPlanEntity vwRpPoPayPlan,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwRpPoPayPlanEntity.class, dataGrid);
		//模糊查询
		
		if(StringUtil.isNotEmpty(vwRpPoPayPlan.getBpmName())){
			vwRpPoPayPlan.setBpmName("*"+vwRpPoPayPlan.getBpmName()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpPoPayPlan.getBpProjId())){
			vwRpPoPayPlan.setBpProjId("*"+vwRpPoPayPlan.getBpProjId()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpPoPayPlan.getBpManager())){
			vwRpPoPayPlan.setBpManager("*"+vwRpPoPayPlan.getBpManager()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpPoPayPlan.getBsName())){
			vwRpPoPayPlan.setBsName("*"+vwRpPoPayPlan.getBsName()+"*");
		}
		
		
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpPoPayPlan, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwRpPoPayPlanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除采购付款计划表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwRpPoPayPlanEntity vwRpPoPayPlan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vwRpPoPayPlan = systemService.getEntity(VwRpPoPayPlanEntity.class, vwRpPoPayPlan.getId());
		message = "采购付款计划表删除成功";
		try{
			vwRpPoPayPlanService.delete(vwRpPoPayPlan);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购付款计划表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除采购付款计划表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "采购付款计划表删除成功";
		try{
			for(String id:ids.split(",")){
				VwRpPoPayPlanEntity vwRpPoPayPlan = systemService.getEntity(VwRpPoPayPlanEntity.class, 
				id
				);
				vwRpPoPayPlanService.delete(vwRpPoPayPlan);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "采购付款计划表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加采购付款计划表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwRpPoPayPlanEntity vwRpPoPayPlan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "采购付款计划表添加成功";
		try{
			vwRpPoPayPlanService.save(vwRpPoPayPlan);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购付款计划表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新采购付款计划表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwRpPoPayPlanEntity vwRpPoPayPlan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "采购付款计划表更新成功";
		VwRpPoPayPlanEntity t = vwRpPoPayPlanService.get(VwRpPoPayPlanEntity.class, vwRpPoPayPlan.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vwRpPoPayPlan, t);
			vwRpPoPayPlanService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "采购付款计划表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 采购付款计划表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwRpPoPayPlanEntity vwRpPoPayPlan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpPoPayPlan.getId())) {
			vwRpPoPayPlan = vwRpPoPayPlanService.getEntity(VwRpPoPayPlanEntity.class, vwRpPoPayPlan.getId());
			req.setAttribute("vwRpPoPayPlanPage", vwRpPoPayPlan);
		}
		return new ModelAndView("com/action/actpo/vwRpPoPayPlan-add");
	}
	/**
	 * 采购付款计划表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwRpPoPayPlanEntity vwRpPoPayPlan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpPoPayPlan.getId())) {
			vwRpPoPayPlan = vwRpPoPayPlanService.getEntity(VwRpPoPayPlanEntity.class, vwRpPoPayPlan.getId());
			req.setAttribute("vwRpPoPayPlanPage", vwRpPoPayPlan);
		}
		return new ModelAndView("com/action/actpo/vwRpPoPayPlan-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vwRpPoPayPlanController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwRpPoPayPlanEntity vwRpPoPayPlan,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VwRpPoPayPlanEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpPoPayPlan, request.getParameterMap());
		List<VwRpPoPayPlanEntity> vwRpPoPayPlans = this.vwRpPoPayPlanService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"采购付款计划表");
		modelMap.put(NormalExcelConstants.CLASS,VwRpPoPayPlanEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("采购付款计划表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vwRpPoPayPlans);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwRpPoPayPlanEntity vwRpPoPayPlan,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"采购付款计划表");
    	modelMap.put(NormalExcelConstants.CLASS,VwRpPoPayPlanEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("采购付款计划表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VwRpPoPayPlanEntity> listVwRpPoPayPlanEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VwRpPoPayPlanEntity.class,params);
				for (VwRpPoPayPlanEntity vwRpPoPayPlan : listVwRpPoPayPlanEntitys) {
					vwRpPoPayPlanService.save(vwRpPoPayPlan);
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
	@ApiOperation(value="采购付款计划表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VwRpPoPayPlanEntity>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize > Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VwRpPoPayPlanEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VwRpPoPayPlanEntity> listVwRpPoPayPlans = this.vwRpPoPayPlanService.getListByCriteriaQuery(query,true);
		return Result.success(listVwRpPoPayPlans);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取采购付款计划表信息",notes="根据ID获取采购付款计划表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VwRpPoPayPlanEntity task = vwRpPoPayPlanService.get(VwRpPoPayPlanEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取采购付款计划表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建采购付款计划表")
	public ResponseMessage<?> create(@ApiParam(name="采购付款计划表对象")@RequestBody VwRpPoPayPlanEntity vwRpPoPayPlan, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwRpPoPayPlanEntity>> failures = validator.validate(vwRpPoPayPlan);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vwRpPoPayPlanService.save(vwRpPoPayPlan);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("采购付款计划表信息保存失败");
		}
		return Result.success(vwRpPoPayPlan);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新采购付款计划表",notes="更新采购付款计划表")
	public ResponseMessage<?> update(@ApiParam(name="采购付款计划表对象")@RequestBody VwRpPoPayPlanEntity vwRpPoPayPlan) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwRpPoPayPlanEntity>> failures = validator.validate(vwRpPoPayPlan);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vwRpPoPayPlanService.saveOrUpdate(vwRpPoPayPlan);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新采购付款计划表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新采购付款计划表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除采购付款计划表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			vwRpPoPayPlanService.deleteEntityById(VwRpPoPayPlanEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("采购付款计划表删除失败");
		}

		return Result.success();
	}
}
