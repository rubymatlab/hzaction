package com.action.actsale.controller;
import com.action.actsale.entity.BusBidEntity;
import com.action.actsale.entity.BusProjectEntity;
import com.action.actsale.entity.VwBusBidEntity;
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
 * @Description: 报价_投标审核
 * @author onlineGenerator
 * @date 2019-08-29 16:56:23
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vwBusBidController")
public class VwBusBidController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwBusBidController.class);

	@Autowired
	private VwBusBidServiceI vwBusBidService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 报价_投标审核列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/vwBusBidList");
	}
	/**
	 * 报价_投标审核列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list0")
	public ModelAndView list0(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/vwBusBidList0");
	}
	/**
	 * 报价_投标审核列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list1")
	public ModelAndView list1(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/vwBusBidList1");
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
		//vwBusBid = systemService.getEntity(VwBusBidEntity.class, vwBusBid.getId());
		message = "报价_投标审核删除成功";
		try{
			BusBidEntity t=systemService.getEntity(BusBidEntity.class,vwBusBid.getId());
			vwBusBidService.delete(t);

			BusProjectEntity o=systemService.getEntity(BusProjectEntity.class,t.getFromProjId());
			o.setBpmStatus("1");
			vwBusBidService.saveOrUpdate(o);
			//vwBusBidService.delete(vwBusBid);
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
				/*
				 * VwBusBidEntity vwBusBid = systemService.getEntity(VwBusBidEntity.class, id );
				 * vwBusBidService.delete(vwBusBid);
				 */
				
				BusBidEntity t=systemService.getEntity(BusBidEntity.class,id);
				vwBusBidService.delete(t);

				BusProjectEntity o=systemService.getEntity(BusProjectEntity.class,t.getFromProjId());
				o.setBpmStatus("1");
				vwBusBidService.saveOrUpdate(o);
				
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
		BusBidEntity t=new BusBidEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vwBusBid, t);
			vwBusBidService.save(t);
			
			BusProjectEntity o=systemService.getEntity(BusProjectEntity.class,t.getFromProjId());
			o.setBpmStatus("2");
			vwBusBidService.saveOrUpdate(o);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "报价_投标审核添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(t);
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
		//VwBusBidEntity t = vwBusBidService.get(VwBusBidEntity.class, vwBusBid.getId());
		try {
			BusBidEntity t=vwBusBidService.get(BusBidEntity.class, vwBusBid.getId());
			MyBeanUtils.copyBeanNotNull2Bean(vwBusBid, t);
			vwBusBidService.saveOrUpdate(t);
			//MyBeanUtils.copyBeanNotNull2Bean(vwBusBid, t);
			//vwBusBidService.saveOrUpdate(t);
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
		if (StringUtil.isNotEmpty(vwBusBid.getFromProjId())) {
			//vwBusBid = vwBusBidService.getEntity(VwBusBidEntity.class, vwBusBid.getId());
			List<VwBusBidEntity> listVwBusBid=vwBusBidService.findByProperty(VwBusBidEntity.class, "fromProjId", vwBusBid.getFromProjId());
			for(VwBusBidEntity o:listVwBusBid)
			{
				if(o.getId().equals("0"))
				{
					o.setBdState("0");
					o.setId(null);
					req.setAttribute("vwBusBidPage", o);
				}
			}
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
	
}
