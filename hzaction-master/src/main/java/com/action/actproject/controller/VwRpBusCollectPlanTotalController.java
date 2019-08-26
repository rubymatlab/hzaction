package com.action.actproject.controller;
import com.action.actproject.entity.VwRpBusCollectPlanTotalEntity;
import com.action.actproject.service.VwRpBusCollectPlanTotalServiceI;
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


/**   
 * @Title: Controller  
 * @Description: 回款计划汇总
 * @author onlineGenerator
 * @date 2019-08-01 17:23:34
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vwRpBusCollectPlanTotalController")
public class VwRpBusCollectPlanTotalController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwRpBusCollectPlanTotalController.class);

	@Autowired
	private VwRpBusCollectPlanTotalServiceI vwRpBusCollectPlanTotalService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 回款计划汇总列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actproject/vwRpBusCollectPlanTotalList");
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
	public void datagrid(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwRpBusCollectPlanTotalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpBusCollectPlanTotal, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwRpBusCollectPlanTotalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除回款计划汇总
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vwRpBusCollectPlanTotal = systemService.getEntity(VwRpBusCollectPlanTotalEntity.class, vwRpBusCollectPlanTotal.getId());
		message = "回款计划汇总删除成功";
		try{
			vwRpBusCollectPlanTotalService.delete(vwRpBusCollectPlanTotal);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "回款计划汇总删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除回款计划汇总
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "回款计划汇总删除成功";
		try{
			for(String id:ids.split(",")){
				VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal = systemService.getEntity(VwRpBusCollectPlanTotalEntity.class, 
				id
				);
				vwRpBusCollectPlanTotalService.delete(vwRpBusCollectPlanTotal);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "回款计划汇总删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加回款计划汇总
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "回款计划汇总添加成功";
		try{
			vwRpBusCollectPlanTotalService.save(vwRpBusCollectPlanTotal);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "回款计划汇总添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新回款计划汇总
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "回款计划汇总更新成功";
		VwRpBusCollectPlanTotalEntity t = vwRpBusCollectPlanTotalService.get(VwRpBusCollectPlanTotalEntity.class, vwRpBusCollectPlanTotal.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vwRpBusCollectPlanTotal, t);
			vwRpBusCollectPlanTotalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "回款计划汇总更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 回款计划汇总新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpBusCollectPlanTotal.getId())) {
			vwRpBusCollectPlanTotal = vwRpBusCollectPlanTotalService.getEntity(VwRpBusCollectPlanTotalEntity.class, vwRpBusCollectPlanTotal.getId());
			req.setAttribute("vwRpBusCollectPlanTotalPage", vwRpBusCollectPlanTotal);
		}
		return new ModelAndView("com/action/actproject/vwRpBusCollectPlanTotal-add");
	}
	/**
	 * 回款计划汇总编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpBusCollectPlanTotal.getId())) {
			vwRpBusCollectPlanTotal = vwRpBusCollectPlanTotalService.getEntity(VwRpBusCollectPlanTotalEntity.class, vwRpBusCollectPlanTotal.getId());
			req.setAttribute("vwRpBusCollectPlanTotalPage", vwRpBusCollectPlanTotal);
		}
		return new ModelAndView("com/action/actproject/vwRpBusCollectPlanTotal-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vwRpBusCollectPlanTotalController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VwRpBusCollectPlanTotalEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpBusCollectPlanTotal, request.getParameterMap());
		List<VwRpBusCollectPlanTotalEntity> vwRpBusCollectPlanTotals = this.vwRpBusCollectPlanTotalService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"回款计划汇总");
		modelMap.put(NormalExcelConstants.CLASS,VwRpBusCollectPlanTotalEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("回款计划汇总列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vwRpBusCollectPlanTotals);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"回款计划汇总");
    	modelMap.put(NormalExcelConstants.CLASS,VwRpBusCollectPlanTotalEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("回款计划汇总列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VwRpBusCollectPlanTotalEntity> listVwRpBusCollectPlanTotalEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VwRpBusCollectPlanTotalEntity.class,params);
				for (VwRpBusCollectPlanTotalEntity vwRpBusCollectPlanTotal : listVwRpBusCollectPlanTotalEntitys) {
					vwRpBusCollectPlanTotalService.save(vwRpBusCollectPlanTotal);
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
	
	
}
