package com.action.actproject.controller;
import com.action.actproject.entity.VwRpBusProgressInfoEntity;
import com.action.actproject.service.VwRpBusProgressInfoServiceI;
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
 * @Description: 施工进度报表
 * @author onlineGenerator
 * @date 2019-08-01 11:16:38
 * @version V1.0   
 *
 */
@Api(value="VwRpBusProgressInfo",description="施工进度报表",tags="vwRpBusProgressInfoController")
@Controller
@RequestMapping("/vwRpBusProgressInfoController")
public class VwRpBusProgressInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwRpBusProgressInfoController.class);

	@Autowired
	private VwRpBusProgressInfoServiceI vwRpBusProgressInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 施工进度报表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actproject/vwRpBusProgressInfoList");
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
	public void datagrid(VwRpBusProgressInfoEntity vwRpBusProgressInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwRpBusProgressInfoEntity.class, dataGrid);
		//查询条件组装器
		if(StringUtil.isNotEmpty(vwRpBusProgressInfo.getBpManager())){
			vwRpBusProgressInfo.setBpManager("*"+vwRpBusProgressInfo.getBpManager()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpBusProgressInfo.getBpmName())){
			vwRpBusProgressInfo.setBpmName("*"+vwRpBusProgressInfo.getBpmName()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpBusProgressInfo.getBpProjId())){
			vwRpBusProgressInfo.setBpProjId("*"+vwRpBusProgressInfo.getBpProjId()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpBusProgressInfo.getBcName())){
			vwRpBusProgressInfo.setBcName("*"+vwRpBusProgressInfo.getBcName()+"*");
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpBusProgressInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwRpBusProgressInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除施工进度报表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwRpBusProgressInfoEntity vwRpBusProgressInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vwRpBusProgressInfo = systemService.getEntity(VwRpBusProgressInfoEntity.class, vwRpBusProgressInfo.getId());
		message = "施工进度报表删除成功";
		try{
			vwRpBusProgressInfoService.delete(vwRpBusProgressInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "施工进度报表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除施工进度报表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "施工进度报表删除成功";
		try{
			for(String id:ids.split(",")){
				VwRpBusProgressInfoEntity vwRpBusProgressInfo = systemService.getEntity(VwRpBusProgressInfoEntity.class, 
				id
				);
				vwRpBusProgressInfoService.delete(vwRpBusProgressInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "施工进度报表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加施工进度报表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwRpBusProgressInfoEntity vwRpBusProgressInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "施工进度报表添加成功";
		try{
			vwRpBusProgressInfoService.save(vwRpBusProgressInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "施工进度报表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新施工进度报表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwRpBusProgressInfoEntity vwRpBusProgressInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "施工进度报表更新成功";
		VwRpBusProgressInfoEntity t = vwRpBusProgressInfoService.get(VwRpBusProgressInfoEntity.class, vwRpBusProgressInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vwRpBusProgressInfo, t);
			vwRpBusProgressInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "施工进度报表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 施工进度报表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwRpBusProgressInfoEntity vwRpBusProgressInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpBusProgressInfo.getId())) {
			vwRpBusProgressInfo = vwRpBusProgressInfoService.getEntity(VwRpBusProgressInfoEntity.class, vwRpBusProgressInfo.getId());
			req.setAttribute("vwRpBusProgressInfoPage", vwRpBusProgressInfo);
		}
		return new ModelAndView("com/action/actproject/vwRpBusProgressInfo-add");
	}
	/**
	 * 施工进度报表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwRpBusProgressInfoEntity vwRpBusProgressInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpBusProgressInfo.getId())) {
			vwRpBusProgressInfo = vwRpBusProgressInfoService.getEntity(VwRpBusProgressInfoEntity.class, vwRpBusProgressInfo.getId());
			req.setAttribute("vwRpBusProgressInfoPage", vwRpBusProgressInfo);
		}
		return new ModelAndView("com/action/actproject/vwRpBusProgressInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vwRpBusProgressInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwRpBusProgressInfoEntity vwRpBusProgressInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VwRpBusProgressInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpBusProgressInfo, request.getParameterMap());
		List<VwRpBusProgressInfoEntity> vwRpBusProgressInfos = this.vwRpBusProgressInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"施工进度报表");
		modelMap.put(NormalExcelConstants.CLASS,VwRpBusProgressInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("施工进度报表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vwRpBusProgressInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwRpBusProgressInfoEntity vwRpBusProgressInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"施工进度报表");
    	modelMap.put(NormalExcelConstants.CLASS,VwRpBusProgressInfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("施工进度报表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VwRpBusProgressInfoEntity> listVwRpBusProgressInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VwRpBusProgressInfoEntity.class,params);
				for (VwRpBusProgressInfoEntity vwRpBusProgressInfo : listVwRpBusProgressInfoEntitys) {
					vwRpBusProgressInfoService.save(vwRpBusProgressInfo);
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
	@ApiOperation(value="施工进度报表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VwRpBusProgressInfoEntity>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize > Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VwRpBusProgressInfoEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VwRpBusProgressInfoEntity> listVwRpBusProgressInfos = this.vwRpBusProgressInfoService.getListByCriteriaQuery(query,true);
		return Result.success(listVwRpBusProgressInfos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取施工进度报表信息",notes="根据ID获取施工进度报表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VwRpBusProgressInfoEntity task = vwRpBusProgressInfoService.get(VwRpBusProgressInfoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取施工进度报表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建施工进度报表")
	public ResponseMessage<?> create(@ApiParam(name="施工进度报表对象")@RequestBody VwRpBusProgressInfoEntity vwRpBusProgressInfo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwRpBusProgressInfoEntity>> failures = validator.validate(vwRpBusProgressInfo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vwRpBusProgressInfoService.save(vwRpBusProgressInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("施工进度报表信息保存失败");
		}
		return Result.success(vwRpBusProgressInfo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新施工进度报表",notes="更新施工进度报表")
	public ResponseMessage<?> update(@ApiParam(name="施工进度报表对象")@RequestBody VwRpBusProgressInfoEntity vwRpBusProgressInfo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwRpBusProgressInfoEntity>> failures = validator.validate(vwRpBusProgressInfo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vwRpBusProgressInfoService.saveOrUpdate(vwRpBusProgressInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新施工进度报表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新施工进度报表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除施工进度报表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			vwRpBusProgressInfoService.deleteEntityById(VwRpBusProgressInfoEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("施工进度报表删除失败");
		}

		return Result.success();
	}
}
