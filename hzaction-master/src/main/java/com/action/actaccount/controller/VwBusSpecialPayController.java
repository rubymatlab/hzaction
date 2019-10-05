package com.action.actaccount.controller;
import com.action.actaccount.entity.VwBusSpecialPayEntity;
import com.action.actaccount.service.VwBusSpecialPayServiceI;
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


import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 零星支出单
 * @author onlineGenerator
 * @date 2019-08-19 13:46:26
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vwBusSpecialPayController")
public class VwBusSpecialPayController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwBusSpecialPayController.class);

	@Autowired
	private VwBusSpecialPayServiceI vwBusSpecialPayService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 零星支出单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/vwBusSpecialPayList");
	}
	
	@RequestMapping(params = "listNo")
	public ModelAndView listNo(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/vwBusSpecialPayListNo");
	}
	
	@RequestMapping(params = "listYes")
	public ModelAndView listYes(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/vwBusSpecialPayListYes");
	}
	
	@RequestMapping(params = "index")
	public ModelAndView index(String bpmStatus, HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/vwBusSpecialPayIndex");
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
	public void datagrid(VwBusSpecialPayEntity vwBusSpecialPay,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwBusSpecialPayEntity.class, dataGrid);
		//查询条件组装器
		
		//模糊查询
		if(StringUtil.isNotEmpty(vwBusSpecialPay.getBsName())){
			vwBusSpecialPay.setBsName("*"+vwBusSpecialPay.getBsName()+"*");
		}
		if(StringUtil.isNotEmpty(vwBusSpecialPay.getBpProjName())){
			vwBusSpecialPay.setBpProjName("*"+vwBusSpecialPay.getBpProjName()+"*");
		}
		if(StringUtil.isNotEmpty(vwBusSpecialPay.getBsspApplyPeople())){
			vwBusSpecialPay.setBsspApplyPeople("*"+vwBusSpecialPay.getBsspApplyPeople()+"*");
		}
		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusSpecialPay, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwBusSpecialPayService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除零星支出单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vwBusSpecialPay = systemService.getEntity(VwBusSpecialPayEntity.class, vwBusSpecialPay.getId());
		message = "零星支出单删除成功";
		try{
			vwBusSpecialPayService.delete(vwBusSpecialPay);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "零星支出单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除零星支出单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "零星支出单删除成功";
		try{
			for(String id:ids.split(",")){
				VwBusSpecialPayEntity vwBusSpecialPay = systemService.getEntity(VwBusSpecialPayEntity.class, 
				id
				);
				vwBusSpecialPayService.delete(vwBusSpecialPay);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "零星支出单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加零星支出单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "零星支出单添加成功";
		try{
			vwBusSpecialPayService.save(vwBusSpecialPay);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "零星支出单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(vwBusSpecialPay);
		return j;
	}
	
	/**
	 * 更新零星支出单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "零星支出单更新成功";
		VwBusSpecialPayEntity t = vwBusSpecialPayService.get(VwBusSpecialPayEntity.class, vwBusSpecialPay.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vwBusSpecialPay, t);
			vwBusSpecialPayService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "零星支出单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
 	/**
	 * 自定义按钮-[送审]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAccess")
	@ResponseBody
	public AjaxJson doAccess(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "送审成功";
		VwBusSpecialPayEntity t = vwBusSpecialPayService.get(VwBusSpecialPayEntity.class, vwBusSpecialPay.getId());
		try{
			t.setBpmStatus("2");
			vwBusSpecialPayService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "送审失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 自定义按钮-[送审]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doConfirm")
	@ResponseBody
	public AjaxJson doConfirm(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核成功";
		VwBusSpecialPayEntity t = vwBusSpecialPayService.get(VwBusSpecialPayEntity.class, vwBusSpecialPay.getId());
		try{
			t.setBpmStatus("3");
			vwBusSpecialPayService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-[支付]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doPay")
	@ResponseBody
	public AjaxJson doPay(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "支付成功";
		VwBusSpecialPayEntity t = vwBusSpecialPayService.get(VwBusSpecialPayEntity.class, vwBusSpecialPay.getId());
		try{
			vwBusSpecialPayService.doPayBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "支付失败";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 零星支出单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusSpecialPay.getId())) {
			vwBusSpecialPay = vwBusSpecialPayService.getEntity(VwBusSpecialPayEntity.class, vwBusSpecialPay.getId());
			req.setAttribute("vwBusSpecialPayPage", vwBusSpecialPay);
		}
		return new ModelAndView("com/action/actaccount/vwBusSpecialPay-add");
	}
	/**
	 * 零星支出单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwBusSpecialPayEntity vwBusSpecialPay, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusSpecialPay.getId())) {
			vwBusSpecialPay = vwBusSpecialPayService.getEntity(VwBusSpecialPayEntity.class, vwBusSpecialPay.getId());
			req.setAttribute("vwBusSpecialPayPage", vwBusSpecialPay);
		}
		return new ModelAndView("com/action/actaccount/vwBusSpecialPay-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vwBusSpecialPayController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwBusSpecialPayEntity vwBusSpecialPay,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VwBusSpecialPayEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusSpecialPay, request.getParameterMap());
		List<VwBusSpecialPayEntity> vwBusSpecialPays = this.vwBusSpecialPayService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"零星支出单");
		modelMap.put(NormalExcelConstants.CLASS,VwBusSpecialPayEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("零星支出单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vwBusSpecialPays);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwBusSpecialPayEntity vwBusSpecialPay,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"零星支出单");
    	modelMap.put(NormalExcelConstants.CLASS,VwBusSpecialPayEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("零星支出单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VwBusSpecialPayEntity> listVwBusSpecialPayEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VwBusSpecialPayEntity.class,params);
				for (VwBusSpecialPayEntity vwBusSpecialPay : listVwBusSpecialPayEntitys) {
					vwBusSpecialPayService.save(vwBusSpecialPay);
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
	 * @param id vwBusSpecialPay主键id
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
	
}
