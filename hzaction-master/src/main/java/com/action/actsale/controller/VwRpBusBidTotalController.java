package com.action.actsale.controller;
import com.action.actsale.entity.VwRpBusBidTotalEntity;
import com.action.actsale.service.VwRpBusBidTotalServiceI;
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
 * @Description: 投标阶段汇总表
 * @author onlineGenerator
 * @date 2019-08-01 14:17:31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vwRpBusBidTotalController")
public class VwRpBusBidTotalController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwRpBusBidTotalController.class);

	@Autowired
	private VwRpBusBidTotalServiceI vwRpBusBidTotalService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 投标阶段汇总表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/vwRpBusBidTotalList");
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
	public void datagrid(VwRpBusBidTotalEntity vwRpBusBidTotal,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		//模糊查询
		if(StringUtil.isNotEmpty(vwRpBusBidTotal.getBpProjName())){
			vwRpBusBidTotal.setBpProjName("*"+vwRpBusBidTotal.getBpProjName()+"*");
		}
		CriteriaQuery cq = new CriteriaQuery(VwRpBusBidTotalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpBusBidTotal, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwRpBusBidTotalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除投标阶段汇总表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwRpBusBidTotalEntity vwRpBusBidTotal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vwRpBusBidTotal = systemService.getEntity(VwRpBusBidTotalEntity.class, vwRpBusBidTotal.getId());
		message = "投标阶段汇总表删除成功";
		try{
			vwRpBusBidTotalService.delete(vwRpBusBidTotal);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "投标阶段汇总表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除投标阶段汇总表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "投标阶段汇总表删除成功";
		try{
			for(String id:ids.split(",")){
				VwRpBusBidTotalEntity vwRpBusBidTotal = systemService.getEntity(VwRpBusBidTotalEntity.class, 
				id
				);
				vwRpBusBidTotalService.delete(vwRpBusBidTotal);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "投标阶段汇总表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加投标阶段汇总表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwRpBusBidTotalEntity vwRpBusBidTotal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "投标阶段汇总表添加成功";
		try{
			vwRpBusBidTotalService.save(vwRpBusBidTotal);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "投标阶段汇总表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新投标阶段汇总表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwRpBusBidTotalEntity vwRpBusBidTotal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "投标阶段汇总表更新成功";
		VwRpBusBidTotalEntity t = vwRpBusBidTotalService.get(VwRpBusBidTotalEntity.class, vwRpBusBidTotal.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vwRpBusBidTotal, t);
			vwRpBusBidTotalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "投标阶段汇总表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 投标阶段汇总表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwRpBusBidTotalEntity vwRpBusBidTotal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpBusBidTotal.getId())) {
			vwRpBusBidTotal = vwRpBusBidTotalService.getEntity(VwRpBusBidTotalEntity.class, vwRpBusBidTotal.getId());
			req.setAttribute("vwRpBusBidTotalPage", vwRpBusBidTotal);
		}
		return new ModelAndView("com/action/actsale/vwRpBusBidTotal-add");
	}
	/**
	 * 投标阶段汇总表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwRpBusBidTotalEntity vwRpBusBidTotal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpBusBidTotal.getId())) {
			vwRpBusBidTotal = vwRpBusBidTotalService.getEntity(VwRpBusBidTotalEntity.class, vwRpBusBidTotal.getId());
			req.setAttribute("vwRpBusBidTotalPage", vwRpBusBidTotal);
		}
		return new ModelAndView("com/action/actsale/vwRpBusBidTotal-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vwRpBusBidTotalController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwRpBusBidTotalEntity vwRpBusBidTotal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VwRpBusBidTotalEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpBusBidTotal, request.getParameterMap());
		List<VwRpBusBidTotalEntity> vwRpBusBidTotals = this.vwRpBusBidTotalService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"投标阶段汇总表");
		modelMap.put(NormalExcelConstants.CLASS,VwRpBusBidTotalEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("投标阶段汇总表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vwRpBusBidTotals);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwRpBusBidTotalEntity vwRpBusBidTotal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"投标阶段汇总表");
    	modelMap.put(NormalExcelConstants.CLASS,VwRpBusBidTotalEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("投标阶段汇总表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VwRpBusBidTotalEntity> listVwRpBusBidTotalEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VwRpBusBidTotalEntity.class,params);
				for (VwRpBusBidTotalEntity vwRpBusBidTotal : listVwRpBusBidTotalEntitys) {
					vwRpBusBidTotalService.save(vwRpBusBidTotal);
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
