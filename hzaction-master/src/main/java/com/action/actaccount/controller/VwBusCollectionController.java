package com.action.actaccount.controller;
import com.action.actaccount.entity.VwBusCollectionEntity;
//import com.action.actaccount.service.BasBankAccountInfoServiceI;
import com.action.actaccount.service.BusCollectionServiceI;
import com.action.actaccount.service.BusPayInfoServiceI;
import com.action.actaccount.service.VwBusCollectionServiceI;
import com.action.actpo.entity.BusPoContractPayEntity;
import com.action.actpo.entity.VmBusPoContractEntity;
import com.action.actpo.entity.VmMergeBusPoApplyDetailEntity;
import com.action.actpo.page.VmBusPoContractPage;
import com.action.actproject.entity.VmBusCollectPlanEntity;
//import com.action.actaccount.entity.BasBankAccountInfoEntity;
//import com.action.actaccount.entity.BasBankAccountInfoEntity;
import com.action.actaccount.entity.BusCollectionEntity;
import com.action.actaccount.entity.BusPayInfoEntity;
import com.action.actbase.entity.BasBankAccountInfoEntity;

import com.action.actbase.service.BasBankAccountInfoServiceI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
 * @Description: 项目收款单
 * @author onlineGenerator
 * @date 2019-08-22 15:34:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vwBusCollectionController")
public class VwBusCollectionController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwBusCollectionController.class);

	@Autowired
	private VwBusCollectionServiceI vwBusCollectionService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private BusCollectionServiceI BusCollectionService;
	
	@Autowired
	private BasBankAccountInfoServiceI  basbank;
	@Autowired
	private BusPayInfoServiceI  busPayInfoService;

	@Autowired
	/**
	 * 项目收款单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/vwBusCollectionList");
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
	public void datagrid(VwBusCollectionEntity vwBusCollection,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwBusCollectionEntity.class, dataGrid);
		//查询条件组装器
		
		// 客户名称
		if(StringUtil.isNotEmpty(vwBusCollection.getBcCustContractor())){
			vwBusCollection.setBcCustContractor("*"+vwBusCollection.getBcCustContractor()+"*");
		}
		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusCollection, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwBusCollectionService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	
	
	/**
	 * 删除项目收款单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwBusCollectionEntity vwBusCollection, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
//		vwBusCollection = systemService.getEntity(VwBusCollectionEntity.class, vwBusCollection.getId());
		message = "项目收款单删除成功";
		try{
			BusCollectionEntity busConEntity = systemService.getEntity(BusCollectionEntity.class, vwBusCollection.getId());
//			MyBeanUtils.copyBeanNotNull2Bean(vwBusCollection ,busConEntity);
			BusCollectionService.delete(busConEntity);
			// 删除支付
			if(StringUtil.isNotEmpty(vwBusCollection.getFromPayinfoId())) {
				BusPayInfoEntity busPayInfoEntity = systemService.getEntity(BusPayInfoEntity.class, vwBusCollection.getFromPayinfoId());
//			MyBeanUtils.copyBeanNotNull2Bean(vwBusCollection ,busPayInfoEntity);
//			busPayInfoEntity.setId(vwBusCollection.getFromPayinfoId());
				busPayInfoService.delete(busPayInfoEntity);
			}
	
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目收款单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除项目收款单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目收款单删除成功";
		try{
			for(String id:ids.split(",")){

				VwBusCollectionEntity vwBusCollection = systemService.getEntity(VwBusCollectionEntity.class, 
				id
				);
				BusCollectionEntity busConEntity = new 	BusCollectionEntity();
				MyBeanUtils.copyBeanNotNull2Bean(vwBusCollection ,busConEntity);
				BusCollectionService.delete(busConEntity);
//				vwBusCollectionService.delete(vwBusCollection);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目收款单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目收款单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwBusCollectionEntity vwBusCollection, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
//		List<VmMergeBusPoApplyDetailEntity> vmlist =VmBusPoContractPage.getBusPo

//		List<>
//		List<VmMergeBusPoApplyDetailEntity>
		message = "项目收款单添加成功";
		BusCollectionEntity busConEntity = new 	BusCollectionEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vwBusCollection ,busConEntity);
			BusCollectionService.save(busConEntity);
			
//			vwBusCollectionService.save(vwBusCollection);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目收款单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(busConEntity);
		return j;
	}
	
	/**
	 * 更新项目收款单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwBusCollectionEntity vwBusCollection, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目收款单更新成功";
//		VwBusCollectionEntity t = vwBusCollectionService.findUniqueByProperty(VwBusCollectionEntity.class, "id",vwBusCollection.getId());
		
		
		try {

			if(StringUtil.isNotEmpty(vwBusCollection.getBpiVoucherno())) {
//				实收提交
				BusPayInfoEntity busPayInfo = null;
				if(StringUtil.isNotEmpty(vwBusCollection.getFromPayinfoId())){
					busPayInfo = busPayInfoService.findUniqueByProperty(BusPayInfoEntity.class, "id",vwBusCollection.getFromPayinfoId());
				}else {
					busPayInfo = new BusPayInfoEntity();
				}
				MyBeanUtils.copyBeanNotNull2Bean(vwBusCollection ,busPayInfo);
				
				// 业务外键
				busPayInfo.setBpiBusId(vwBusCollection.getId());
				// 功能分类 2
				busPayInfo.setBpiClass(2+"");
				if(StringUtil.isNotEmpty(vwBusCollection.getFromPayinfoId())){
					// 财务支付id
					busPayInfo.setId(vwBusCollection.getFromPayinfoId());
					busPayInfoService.saveOrUpdate(busPayInfo);
				}else {
					busPayInfoService.save(busPayInfo);
				}
				
				j.setObj(busPayInfo);
				
			}else {
//				编辑提交
				BusCollectionEntity busConEntity = BusCollectionService.findUniqueByProperty(BusCollectionEntity.class, "id",vwBusCollection.getId());
				MyBeanUtils.copyBeanNotNull2Bean(vwBusCollection, busConEntity);
				BusCollectionService.saveOrUpdate(busConEntity);
			}
				
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "项目收款单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		
		return j;
	}
	

	/**
	 * 项目收款单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwBusCollectionEntity vwBusCollection, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusCollection.getId())) {
			vwBusCollection = vwBusCollectionService.getEntity(VwBusCollectionEntity.class, vwBusCollection.getId());
			req.setAttribute("vwBusCollectionPage", vwBusCollection);
		}
		
		return new ModelAndView("com/action/actaccount/vwBusCollection-add");
	}
	/**
	 * 项目收款单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(String isPayment, VwBusCollectionEntity vwBusCollection, HttpServletRequest req) {
		
		
		if (StringUtil.isNotEmpty(vwBusCollection.getId())) {
			vwBusCollection = vwBusCollectionService.getEntity(VwBusCollectionEntity.class, vwBusCollection.getId());
			
			if(StringUtil.isNotEmpty(isPayment)) {
				// 如果凭证号不为空
				if(!StringUtil.isNotEmpty(vwBusCollection.getBpiVoucherno())){
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
					Calendar cal = Calendar.getInstance();
					Date date= cal.getTime();
					String now = sdf.format(date);
					String sql = "select  bpi_voucherno from bus_pay_info bpi_voucherno where bpi_voucherno like '"+now+"%' order by create_date desc";
					List<Map<String, Object>> data = this.systemService.findForJdbc(sql);
					String newNo = "001";
					if(data.size() != 0) {
						int num = data.size() + 1;
						if(num < 10) {
							newNo = now + "00" + num;
						}else if( num < 100) {
							newNo = now + "0" + num;
						}
					}else {
						newNo = now + newNo;
					}
					vwBusCollection.setBpiVoucherno(newNo);
				}
				
				req.setAttribute("payment", "true");
			}
			req.setAttribute("vwBusCollectionPage", vwBusCollection);
		}
		return new ModelAndView("com/action/actaccount/vwBusCollection-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vwBusCollectionController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwBusCollectionEntity vwBusCollection,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VwBusCollectionEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusCollection, request.getParameterMap());
		List<VwBusCollectionEntity> vwBusCollections = this.vwBusCollectionService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"项目收款单");
		modelMap.put(NormalExcelConstants.CLASS,VwBusCollectionEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目收款单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vwBusCollections);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwBusCollectionEntity vwBusCollection,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"项目收款单");
    	modelMap.put(NormalExcelConstants.CLASS,VwBusCollectionEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目收款单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VwBusCollectionEntity> listVwBusCollectionEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VwBusCollectionEntity.class,params);
				for (VwBusCollectionEntity vwBusCollection : listVwBusCollectionEntitys) {
					vwBusCollectionService.save(vwBusCollection);
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
	 * @param id vwBusCollection主键id
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
