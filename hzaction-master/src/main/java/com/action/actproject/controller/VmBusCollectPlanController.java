package com.action.actproject.controller;
import com.action.actproject.entity.VmBusCollectPlanEntity;
import com.action.actproject.service.VmBusCollectPlanServiceI;
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
import org.jeecgframework.tag.vo.datatable.SortDirection;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: vm_bus_collect_plan
 * @author onlineGenerator
 * @date 2019-08-25 18:38:59
 * @version V1.0   
 *
 */
@Api(value="VmBusCollectPlan",description="vm_bus_collect_plan",tags="vmBusCollectPlanController")
@Controller
@RequestMapping("/vmBusCollectPlanController")
public class VmBusCollectPlanController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VmBusCollectPlanController.class);

	@Autowired
	private VmBusCollectPlanServiceI vmBusCollectPlanService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * vm_bus_collect_plan列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actproject/vmBusCollectPlanList");
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
	public void datagrid(VmBusCollectPlanEntity vmBusCollectPlan,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VmBusCollectPlanEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusCollectPlan, request.getParameterMap());
		try{
		//自定义追加查询条件
			String fromId = vmBusCollectPlan.getFromId();
			cq.add(Restrictions.eq("fromId", fromId));
			cq.addOrder("brpProgressStages", SortDirection.asc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vmBusCollectPlanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除vm_bus_collect_plan
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VmBusCollectPlanEntity vmBusCollectPlan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vmBusCollectPlan = systemService.getEntity(VmBusCollectPlanEntity.class, vmBusCollectPlan.getId());
		message = "vm_bus_collect_plan删除成功";
		try{
			vmBusCollectPlanService.delete(vmBusCollectPlan);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "vm_bus_collect_plan删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除vm_bus_collect_plan
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "vm_bus_collect_plan删除成功";
		try{
			for(String id:ids.split(",")){
				VmBusCollectPlanEntity vmBusCollectPlan = systemService.getEntity(VmBusCollectPlanEntity.class, 
				id
				);
				vmBusCollectPlanService.delete(vmBusCollectPlan);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "vm_bus_collect_plan删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加vm_bus_collect_plan
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VmBusCollectPlanEntity vmBusCollectPlan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "vm_bus_collect_plan添加成功";
		try{
			vmBusCollectPlanService.save(vmBusCollectPlan);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "vm_bus_collect_plan添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新vm_bus_collect_plan
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VmBusCollectPlanEntity vmBusCollectPlan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "vm_bus_collect_plan更新成功";
		VmBusCollectPlanEntity t = vmBusCollectPlanService.get(VmBusCollectPlanEntity.class, vmBusCollectPlan.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vmBusCollectPlan, t);
			vmBusCollectPlanService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "vm_bus_collect_plan更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * vm_bus_collect_plan新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VmBusCollectPlanEntity vmBusCollectPlan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusCollectPlan.getId())) {
			vmBusCollectPlan = vmBusCollectPlanService.getEntity(VmBusCollectPlanEntity.class, vmBusCollectPlan.getId());
			req.setAttribute("vmBusCollectPlanPage", vmBusCollectPlan);
		}
		return new ModelAndView("com/action/actproject/vmBusCollectPlan-add");
	}
	/**
	 * vm_bus_collect_plan编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VmBusCollectPlanEntity vmBusCollectPlan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusCollectPlan.getId())) {
			vmBusCollectPlan = vmBusCollectPlanService.getEntity(VmBusCollectPlanEntity.class, vmBusCollectPlan.getId());
			req.setAttribute("vmBusCollectPlanPage", vmBusCollectPlan);
		}
		return new ModelAndView("com/action/actproject/vmBusCollectPlan-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vmBusCollectPlanController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VmBusCollectPlanEntity vmBusCollectPlan,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VmBusCollectPlanEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusCollectPlan, request.getParameterMap());
		List<VmBusCollectPlanEntity> vmBusCollectPlans = this.vmBusCollectPlanService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"vm_bus_collect_plan");
		modelMap.put(NormalExcelConstants.CLASS,VmBusCollectPlanEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("vm_bus_collect_plan列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vmBusCollectPlans);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VmBusCollectPlanEntity vmBusCollectPlan,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"vm_bus_collect_plan");
    	modelMap.put(NormalExcelConstants.CLASS,VmBusCollectPlanEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("vm_bus_collect_plan列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VmBusCollectPlanEntity> listVmBusCollectPlanEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VmBusCollectPlanEntity.class,params);
				for (VmBusCollectPlanEntity vmBusCollectPlan : listVmBusCollectPlanEntitys) {
					vmBusCollectPlanService.save(vmBusCollectPlan);
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
	@ApiOperation(value="vm_bus_collect_plan列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VmBusCollectPlanEntity>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize > Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VmBusCollectPlanEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VmBusCollectPlanEntity> listVmBusCollectPlans = this.vmBusCollectPlanService.getListByCriteriaQuery(query,true);
		return Result.success(listVmBusCollectPlans);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取vm_bus_collect_plan信息",notes="根据ID获取vm_bus_collect_plan信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VmBusCollectPlanEntity task = vmBusCollectPlanService.get(VmBusCollectPlanEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取vm_bus_collect_plan信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建vm_bus_collect_plan")
	public ResponseMessage<?> create(@ApiParam(name="vm_bus_collect_plan对象")@RequestBody VmBusCollectPlanEntity vmBusCollectPlan, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusCollectPlanEntity>> failures = validator.validate(vmBusCollectPlan);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vmBusCollectPlanService.save(vmBusCollectPlan);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("vm_bus_collect_plan信息保存失败");
		}
		return Result.success(vmBusCollectPlan);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新vm_bus_collect_plan",notes="更新vm_bus_collect_plan")
	public ResponseMessage<?> update(@ApiParam(name="vm_bus_collect_plan对象")@RequestBody VmBusCollectPlanEntity vmBusCollectPlan) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusCollectPlanEntity>> failures = validator.validate(vmBusCollectPlan);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vmBusCollectPlanService.saveOrUpdate(vmBusCollectPlan);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新vm_bus_collect_plan信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新vm_bus_collect_plan信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除vm_bus_collect_plan")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			vmBusCollectPlanService.deleteEntityById(VmBusCollectPlanEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("vm_bus_collect_plan删除失败");
		}

		return Result.success();
	}
}
