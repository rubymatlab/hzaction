package com.action.actaccount.controller;
import com.action.actaccount.entity.VwRpCostAccountEntity;
import com.action.actaccount.service.VwRpCostAccountServiceI;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;
import com.action.actaccount.page.VwRpCostAccountPage;
import com.action.actaccount.entity.VwBusPoContractPayEntity;
import com.action.actaccount.entity.VwBusOthersProjPayEntity;
import com.action.actaccount.entity.VwBusOthersPayDetailEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.LogUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.export.ExcelExportServer;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.util.ExpiredFiles;
import org.jeecgframework.web.system.util.HashMapDataTableUtil;
import org.jeecgframework.web.system.util.LicenseUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;


/**   
 * @Title: Controller
 * @Description: 项目整体结算表
 * @author onlineGenerator
 * @date 2019-09-02 18:55:26
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vwRpCostAccountController")
public class VwRpCostAccountController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwRpCostAccountController.class);

	@Autowired
	private VwRpCostAccountServiceI vwRpCostAccountService;
	@Autowired
	private SystemService systemService;

	/**
	 * 项目整体结算表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/vwRpCostAccountList");
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
	public void datagrid(VwRpCostAccountEntity vwRpCostAccount,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwRpCostAccountEntity.class, dataGrid);

		//模糊查询
		if(StringUtil.isNotEmpty(vwRpCostAccount.getBpManager())){
			vwRpCostAccount.setBpManager("*"+vwRpCostAccount.getBpManager()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpCostAccount.getBpProjName())){
			vwRpCostAccount.setBpProjName("*"+vwRpCostAccount.getBpProjName()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpCostAccount.getBpProjId())){
			vwRpCostAccount.setBpProjId("*"+vwRpCostAccount.getBpProjId()+"*");
		}
		if(StringUtil.isNotEmpty(vwRpCostAccount.getBcName())){
			vwRpCostAccount.setBcName("*"+vwRpCostAccount.getBcName()+"*");
		}
		
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpCostAccount, request.getParameterMap());
		try{
		//自定义追加查询条件
			Map<String,Object> map = new HashMap<String,Object>();	
			map.put("bpProjId", "desc");
			cq.setOrder(map);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwRpCostAccountService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目整体结算表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwRpCostAccountEntity vwRpCostAccount, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vwRpCostAccount = systemService.getEntity(VwRpCostAccountEntity.class, vwRpCostAccount.getId());
		String message = "项目整体结算表删除成功";
		try{
			vwRpCostAccountService.delMain(vwRpCostAccount);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目整体结算表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除项目整体结算表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "项目整体结算表删除成功";
		try{
			for(String id:ids.split(",")){
				VwRpCostAccountEntity vwRpCostAccount = systemService.getEntity(VwRpCostAccountEntity.class,
				id
				);
				vwRpCostAccountService.delMain(vwRpCostAccount);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目整体结算表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加项目整体结算表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwRpCostAccountEntity vwRpCostAccount,VwRpCostAccountPage vwRpCostAccountPage, HttpServletRequest request) {
		List<VwBusPoContractPayEntity> vwBusPoContractPayList =  vwRpCostAccountPage.getVwBusPoContractPayList();
		List<VwBusOthersProjPayEntity> vwBusOthersProjPayList =  vwRpCostAccountPage.getVwBusOthersProjPayList();
		List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailList =  vwRpCostAccountPage.getVwBusOthersPayDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			vwRpCostAccountService.addMain(vwRpCostAccount, vwBusPoContractPayList,vwBusOthersProjPayList,vwBusOthersPayDetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目整体结算表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新项目整体结算表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwRpCostAccountEntity vwRpCostAccount,VwRpCostAccountPage vwRpCostAccountPage, HttpServletRequest request) {
		List<VwBusPoContractPayEntity> vwBusPoContractPayList =  vwRpCostAccountPage.getVwBusPoContractPayList();
		List<VwBusOthersProjPayEntity> vwBusOthersProjPayList =  vwRpCostAccountPage.getVwBusOthersProjPayList();
		List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailList =  vwRpCostAccountPage.getVwBusOthersPayDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			vwRpCostAccountService.updateMain(vwRpCostAccount, vwBusPoContractPayList,vwBusOthersProjPayList,vwBusOthersPayDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新项目整体结算表失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目整体结算表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwRpCostAccountEntity vwRpCostAccount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpCostAccount.getId())) {
			vwRpCostAccount = vwRpCostAccountService.getEntity(VwRpCostAccountEntity.class, vwRpCostAccount.getId());
			req.setAttribute("vwRpCostAccountPage", vwRpCostAccount);
		}
		return new ModelAndView("com/action/actaccount/vwRpCostAccount-add");
	}
	
	/**
	 * 项目整体结算表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwRpCostAccountEntity vwRpCostAccount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwRpCostAccount.getId())) {
			vwRpCostAccount = vwRpCostAccountService.getEntity(VwRpCostAccountEntity.class, vwRpCostAccount.getId());
			req.setAttribute("vwRpCostAccountPage", vwRpCostAccount);
		}
		return new ModelAndView("com/action/actaccount/vwRpCostAccount-update");
	}
	
	
	/**
	 * 加载明细列表[采购应付/已付明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "vwBusPoContractPayList")
	public ModelAndView vwBusPoContractPayList(VwRpCostAccountEntity vwRpCostAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = vwRpCostAccount.getId();
		//===================================================================================
		//查询-采购应付/已付明细
	    String hql0 = "from VwBusPoContractPayEntity where 1 = 1 AND formCostAccountId = ? ";
	    try{
	    	List<VwBusPoContractPayEntity> vwBusPoContractPayEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("vwBusPoContractPayList", vwBusPoContractPayEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actaccount/vwBusPoContractPayList");
	}
	/**
	 * 加载明细列表[其他支出汇总]
	 * 
	 * @return
	 */
	@RequestMapping(params = "vwBusOthersProjPayList")
	public ModelAndView vwBusOthersProjPayList(VwRpCostAccountEntity vwRpCostAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = vwRpCostAccount.getId();
		//===================================================================================
		//查询-其他支出汇总
	    String hql1 = "from VwBusOthersProjPayEntity where 1 = 1 AND id = ? ";
	    try{
	    	List<VwBusOthersProjPayEntity> vwBusOthersProjPayEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("vwBusOthersProjPayList", vwBusOthersProjPayEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actaccount/vwBusOthersProjPayList");
	}
	/**
	 * 加载明细列表[其他支出明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "vwBusOthersPayDetailList")
	public ModelAndView vwBusOthersPayDetailList(VwRpCostAccountEntity vwRpCostAccount, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = vwRpCostAccount.getId();
		//===================================================================================
		//查询-其他支出明细
	    String hql2 = "from VwBusOthersPayDetailEntity where 1 = 1 AND id = ? ";
	    try{
	    	List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("vwBusOthersPayDetailList", vwBusOthersPayDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actaccount/vwBusOthersPayDetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(VwRpCostAccountEntity vwRpCostAccount,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(VwRpCostAccountEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpCostAccount);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<VwRpCostAccountEntity> list=this.vwRpCostAccountService.getListByCriteriaQuery(cq, false);
    	List<VwRpCostAccountPage> pageList=new ArrayList<VwRpCostAccountPage>();
        if(list!=null&&list.size()>0){
        	for(VwRpCostAccountEntity entity:list){
        		try{
        		VwRpCostAccountPage page=new VwRpCostAccountPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
        		   
            	    Object id0 = entity.getId();
				    String hql0 = "from VwBusPoContractPayEntity where 1 = 1 AND formCostAccountId = ? ";
        	        List<VwBusPoContractPayEntity> vwBusPoContractPayEntityList = systemService.findHql(hql0,id0);
            		page.setVwBusPoContractPayList(vwBusPoContractPayEntityList);
            		
            	    Object id1 = entity.getId();
				    String hql1 = "from VwBusOthersProjPayEntity where 1 = 1 AND bpmProjId = ? ";
        	        List<VwBusOthersProjPayEntity> vwBusOthersProjPayEntityList = systemService.findHql(hql1,id1);
            		page.setVwBusOthersProjPayList(vwBusOthersProjPayEntityList);
            		
            	    Object id2 = entity.getId();
				    String hql2 = "from VwBusOthersPayDetailEntity where 1 = 1 AND id = ? ";
        	        List<VwBusOthersPayDetailEntity> vwBusOthersPayDetailEntityList = systemService.findHql(hql2,id2);
            		page.setVwBusOthersPayDetailList(vwBusOthersPayDetailEntityList);
            		
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"项目整体结算表");
        map.put(NormalExcelConstants.CLASS,VwRpCostAccountPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("项目整体结算表列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
   
    
//    重新导出
    @RequestMapping(params = "doCreatereport")
    @ResponseBody
	public AjaxJson doCreatereport(String ids,VwRpCostAccountEntity vwRpCostAccount,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    	
    	CriteriaQuery cq = new CriteriaQuery(VwRpCostAccountEntity.class, dataGrid);
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpCostAccount);
    	cq.add();
    	List<VwRpCostAccountEntity> list=this.vwRpCostAccountService.getListByCriteriaQuery(cq, false);
    	ids = "";
    	if(list != null && list.size()>0) {
    		for(VwRpCostAccountEntity entity : list) {
    			ids += entity.getId() + ",";
    		}
    	}
    	String message = null;
		AjaxJson j = new AjaxJson();
		message = "打印报表成功";
		try {
			if (!LicenseUtil.getLicense()) {
				LogUtil.info("获取License失败");
				j.setMsg("获取License失败");
				return j;
			}
			

			/*修改的部分*/
			String oldfilename="项目整体结算表.xlsx";
			String newfilename="项目整体结算表.xlsx";
			/*end修改的部分*/	

			long old = System.currentTimeMillis();
			String templateFilePath = request.getServletContext().getRealPath("/")+"export\\template\\"+oldfilename;
			System.out.println(templateFilePath);
			Workbook wb = new Workbook(templateFilePath);// 原始excel路径
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);

			/*修改的部分*/
			// 获取后台数据库数据
			List<Map<String, Object>> dataObject = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> dataObject1 = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> dataObject2 = new ArrayList<Map<String, Object>>();
			String mainIds = "";
			String forId = "";
			String[] idList = ids.split(",");
			for(int i = 0; i < idList.length; i++) {
				mainIds += "id='"+idList[i]+"'";
				forId += "form_cost_account_id='"+idList[i]+"'";
				
				if(i < idList.length - 1) {
					mainIds +=" or ";
					forId +=" or ";
				}
			}
	        
    		try{
    			// 主表信息 id=aaa or id=bb or			
    			StringBuffer sql = new StringBuffer("SELECT * FROM vw_rp_cost_account where "+mainIds+"order by bp_proj_id desc");
	            dataObject = systemService.findForJdbc(sql.toString());       
    	        // 采购明细
    	        
        	    sql = new StringBuffer("select vbpc.*,vtsti.typename  from vw_bus_po_contract_pay as vbpc, vw_t_s_typegroup_info as vtsti\r\n" + 
        	    		"where vtsti.typegroupcode = 'cost_stag' and vbpc.bpcp_progre_name = vtsti.typecode and ("+forId+")");
        	    dataObject1 = systemService.findForJdbc(sql.toString());
    	        if(dataObject1.size()==0){
    	        	Map<String, Object> e=new HashMap<String, Object>();
    	        	e.put("bpm_proj_id","");
    	        	e.put("bpm_name","");
    	        	e.put("bpcp_progre_name","");
    	        	e.put("bpcp_date","");
    	        	e.put("typename","");
    	        	e.put("bpp_pay_date","");
    	        	e.put("pay_amount","");
    	        	e.put("form_cost_account_id","");
    	        	dataObject1.add(e);
    	        }
    	        
        		// 其他支出明细
    	        sql = new StringBuffer(
    					"select vbotpd.*,vtsti.typename  from vw_bus_others_pay_detail as vbotpd, vw_t_s_typegroup_info as vtsti " + 
    					"where vtsti.typegroupcode = 'cost_type' and vbotpd.bus_type = vtsti.typecode and ("+mainIds+")");
        	    dataObject2 = systemService.findForJdbc(sql.toString());

    	        if(dataObject2.size() == 0){
    	        	Map<String, Object> e=new HashMap<String, Object>();
    	        	e.put("bpm_proj_id","");
    	        	e.put("bpm_name","");
    	        	e.put("bus_id","");
    	        	e.put("typename","");
    	        	e.put("apply_date","");
    	        	e.put("pay_amount","");
    	        	dataObject2.add(e);
    	        }
        		
        	}catch(Exception e){
        		logger.info(e.getMessage());
        	}
		            
						
			// 绑定数据源
			designer.setDataSource("order", new HashMapDataTableUtil(dataObject));
			designer.setDataSource("contarct", new HashMapDataTableUtil(dataObject1));
			designer.setDataSource("other", new HashMapDataTableUtil(dataObject2));
				
			/*end修改的部分*/
			
			
			// 执行
			designer.process(true);
			// 生成PDF
			String localTemp=request.getServletContext().getRealPath("/")+"temp\\";
			String exportPDF = localTemp+newfilename;
			File pdfFile = new File(exportPDF);// 输出路径
			FileOutputStream fileOS = new FileOutputStream(pdfFile);
			wb.save(fileOS, SaveFormat.XLSX);
			fileOS.close();
			wb.dispose();
			//过期文件删除
			ExpiredFiles.Delete(localTemp);
			long now = System.currentTimeMillis();
			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
			String tempUrl=request.getRequestURL().toString();
			message=tempUrl.substring(0,tempUrl.lastIndexOf("/")+1)+"temp/"+newfilename;
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "打印报表失败";
		}
		j.setMsg(message);
		return j;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<VwRpCostAccountPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), VwRpCostAccountPage.class, params);
				VwRpCostAccountEntity entity1=null;
				for (VwRpCostAccountPage page : list) {
					entity1=new VwRpCostAccountEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            vwRpCostAccountService.addMain(entity1, page.getVwBusPoContractPayList(),page.getVwBusOthersProjPayList(),page.getVwBusOthersPayDetailList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
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
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"项目整体结算表");
		map.put(NormalExcelConstants.CLASS,VwRpCostAccountPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("项目整体结算表列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "vwRpCostAccountController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
}
