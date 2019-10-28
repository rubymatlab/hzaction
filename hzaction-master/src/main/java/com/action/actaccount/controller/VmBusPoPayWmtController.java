package com.action.actaccount.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.action.actaccount.entity.BusPayInfoEntity;
import com.action.actaccount.entity.VmBusPoContractPayWmtEntity;
import com.action.actaccount.entity.VmBusPoPayWmtEntity;
import com.action.actaccount.page.VmBusPoPayWmtPage;
import com.action.actaccount.service.VmBusPoPayWmtServiceI;
import com.alibaba.fastjson.JSONArray;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**   
 * @Title: Controller
 * @Description: 采购付款单视图_wmt
 * @author onlineGenerator
 * @date 2019-08-14 17:44:24
 * @version V1.0   
 *goUpdate
 */
@Api(value="VmBusPoPayWmt",description="采购付款单视图_wmt",tags="vmBusPoPayWmtController")
@Controller
@RequestMapping("/vmBusPoPayWmtController")
public class VmBusPoPayWmtController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VmBusPoPayWmtController.class);

	@Autowired
	private VmBusPoPayWmtServiceI vmBusPoPayWmtService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	
	/**
	 * 采购付款单视图_wmt列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "listTab")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/vmBusPoPayWmtListTab");
	}
	/**
	 * 采购付款单视图_wmt列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list0")
	public ModelAndView list0(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("com/action/actaccount/vmBusPoPayWmtList0");
		return modelAndView;
	}
	
	@RequestMapping(params = "list1")
	public ModelAndView list1(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("com/action/actaccount/vmBusPoPayWmtList1");
		return modelAndView;
	}
	
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("com/action/actaccount/vmBusPoPayWmtList2");
		return modelAndView;
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
	public void datagrid(VmBusPoPayWmtEntity vmBusPoPayWmt,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VmBusPoPayWmtEntity.class, dataGrid);
		//查询条件组装器
		String state = request.getParameter("state");
		logger.info("-- 单据状态:{} --",state);

		vmBusPoPayWmt.setBppState(state);
		
		// 模糊查询
		if(StringUtil.isNotEmpty(vmBusPoPayWmt.getBpmName())){
			vmBusPoPayWmt.setBpmName("*"+vmBusPoPayWmt.getBpmName()+"*");
		}
		if(StringUtil.isNotEmpty(vmBusPoPayWmt.getBsName())){
			vmBusPoPayWmt.setBsName("*"+vmBusPoPayWmt.getBsName()+"*");
		}
		
		
		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusPoPayWmt, request.getParameterMap());
		try{
			//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vmBusPoPayWmtService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除采购付款单视图_wmt
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vmBusPoPayWmt = systemService.getEntity(VmBusPoPayWmtEntity.class, vmBusPoPayWmt.getId());
		String message = "采购付款单删除成功";
		try{
			logger.info("-- 修改实体表【bus_po_contract_pay】外键bus_po_pay_id={}的字段[bpcp_remark,pay_amount,bus_po_pay_id]--",vmBusPoPayWmt.getId());
			vmBusPoPayWmtService.delMain(vmBusPoPayWmt);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购付款单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 驳回采购付款单视图_wmt
	 * 
	 * @return
	 */
	@RequestMapping(params = "doReturn")
	@ResponseBody
	public AjaxJson doReturn(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vmBusPoPayWmt = systemService.getEntity(VmBusPoPayWmtEntity.class, vmBusPoPayWmt.getId());
		String message = "驳回成功";
		try{
			vmBusPoPayWmt.setBppState("0");
			systemService.saveOrUpdate(vmBusPoPayWmt);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "驳回失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除采购付款单视图_wmt
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		logger.info("-- 批量删除采购付款单视图_wmt --");
		AjaxJson j = new AjaxJson();
		String message = "采购付款单驳回成功";
		try{
			for(String id:ids.split(",")){
				VmBusPoPayWmtEntity vmBusPoPayWmt = systemService.getEntity(VmBusPoPayWmtEntity.class,id);
				vmBusPoPayWmtService.delMain(vmBusPoPayWmt);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "采购付款单驳回失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加采购付款单视图_wmt
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VmBusPoPayWmtEntity vmBusPoPayWmt,VmBusPoPayWmtPage vmBusPoPayWmtPage, HttpServletRequest request) {
		logger.info("-- 添加采购付款单视图_wmt --");
		List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList =  vmBusPoPayWmtPage.getVmBusPoContractPayWmtList();
		List<BusPayInfoEntity> busPayInfoList =  vmBusPoPayWmtPage.getBusPayInfoList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			vmBusPoPayWmtService.addMain(vmBusPoPayWmt, vmBusPoContractPayWmtList,busPayInfoList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购付款单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(vmBusPoPayWmt);
		return j;
	}
	
	/**
	 * 更新采购付款单视图_wmt
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VmBusPoPayWmtEntity vmBusPoPayWmt,VmBusPoPayWmtPage vmBusPoPayWmtPage, HttpServletRequest request) {
		logger.info("-- 更新采购付款单视图_wmt --");
		
		List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList =  vmBusPoPayWmtPage.getVmBusPoContractPayWmtList();
		
		//根据bpcpId把实体附表BusPoContractPayWmt的[付款金额,备注,采购付款单外键]都清空
		String bpcpIds = request.getParameter("bpcpIds");
		if(bpcpIds!=null||bpcpIds!="") {
			logger.info("-- 根据bpcpId把实体附表BusPoContractPayWmt的[付款金额,备注,采购付款单外键]字段清空 --");
			bpcpIds = new String(bpcpIds);
			vmBusPoPayWmtService.doBpcpIdUpdate(bpcpIds);
		}
		
		List<BusPayInfoEntity> busPayInfoList =  vmBusPoPayWmtPage.getBusPayInfoList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			
			//清除字段的自带‘ , ’号
			for (BusPayInfoEntity busPayInfoEntity : busPayInfoList) {
				busPayInfoEntity.setBpiClass(busPayInfoEntity.getBpiClass().replaceAll(",", ""));
				busPayInfoEntity.setFromProjmId(busPayInfoEntity.getFromProjmId().replaceAll(",", ""));
				busPayInfoEntity.setFromPayId(busPayInfoEntity.getFromPayId().replaceAll(",", ""));
				busPayInfoEntity.setFromId(busPayInfoEntity.getFromId().replaceAll(",", ""));
				
				if(",".equals(busPayInfoEntity.getBpiBusId()))	
					busPayInfoEntity.setBpiBusId(busPayInfoEntity.getBpiBusId().replaceAll(",", ""));
				else
					busPayInfoEntity.setBpiBusId(busPayInfoEntity.getBpiBusId().split(",")[0]);
			}
			
			vmBusPoPayWmtService.updateMain(vmBusPoPayWmt, vmBusPoContractPayWmtList,busPayInfoList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新采购付款单视图_wmt失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购付款单视图_wmt新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusPoPayWmt.getId())) {
			vmBusPoPayWmt = vmBusPoPayWmtService.getEntity(VmBusPoPayWmtEntity.class, vmBusPoPayWmt.getId());
			req.setAttribute("vmBusPoPayWmtPage", vmBusPoPayWmt);
		}
		return new ModelAndView("com/action/actaccount/vmBusPoPayWmt-add");
	}

	/**
	 * 采购付款单视图_wmt编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusPoPayWmt.getId())) {
			vmBusPoPayWmt = vmBusPoPayWmtService.getEntity(VmBusPoPayWmtEntity.class, vmBusPoPayWmt.getId());
			req.setAttribute("vmBusPoPayWmtPage", vmBusPoPayWmt);
		}
		if("0".equals(req.getParameter("pay"))) req.setAttribute("pay", 0);
		if("1".equals(req.getParameter("pay"))) req.setAttribute("pay", 1);
		return new ModelAndView("com/action/actaccount/vmBusPoPayWmt-update");
	}


	/**
	 * 加载明细列表[采购付款单附表视图_wmt]
	 * 
	 * @return
	 */
	@RequestMapping(params = "vmBusPoContractPayWmtList")
	public ModelAndView vmBusPoContractPayWmtList(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest req) {

		//===================================================================================
		//获取参数
		Object id0 = vmBusPoPayWmt.getId();
		//===================================================================================
		//查询-采购付款单附表视图_wmt
		String hql0 = "from VmBusPoContractPayWmtEntity where 1 = 1 AND busPoPayId = ? ";
		try{
			List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("vmBusPoContractPayWmtList", vmBusPoContractPayWmtEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actaccount/vmBusPoContractPayWmtList");
	}
	/**
	 * 加载明细列表[财务支付信息实体]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPayInfoList")
	public ModelAndView busPayInfoList(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = vmBusPoPayWmt.getId();
//		System.out.println("获取参数:"+id1);
		//===================================================================================
		//查询-财务支付信息实体
	    String hql1 = "from BusPayInfoEntity where 1 = 1 AND bpiBusId = ? ";
	    try{
	    	List<BusPayInfoEntity> busPayInfoEntityList = systemService.findHql(hql1,id1);
	    	if(busPayInfoEntityList.size()==0)
	    		busPayInfoEntityList.add(new BusPayInfoEntity());
	    	for(BusPayInfoEntity o:busPayInfoEntityList)
	    	{
	    		o.setBpiClass("3");
	    		if(!StringUtil.isNotEmpty(o.getBpiVoucherno()))
	    		{
	    			String createBpiVoucherno = vmBusPoPayWmtService.getBpiVoucherno();
	    			o.setBpiVoucherno(createBpiVoucherno);
	    		}
	    	}
//	    	logger.info("== 【测试】加载明细列表[财务支付信息实体]: {}==",busPayInfoEntityList);
	    	
			req.setAttribute("busPayInfoList", busPayInfoEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actaccount/busPayInfoList");
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VmBusPoPayWmtEntity vmBusPoPayWmt,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
		CriteriaQuery cq = new CriteriaQuery(VmBusPoPayWmtEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusPoPayWmt);
		try{
			//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		List<VmBusPoPayWmtEntity> list=this.vmBusPoPayWmtService.getListByCriteriaQuery(cq, false);
		List<VmBusPoPayWmtPage> pageList=new ArrayList<VmBusPoPayWmtPage>();
		if(list!=null&&list.size()>0){
			for(VmBusPoPayWmtEntity entity:list){
				try{
					VmBusPoPayWmtPage page=new VmBusPoPayWmtPage();
					MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					String hql0 = "from VmBusPoContractPayWmtEntity where 1 = 1 AND busPoPayId = ? ";
					List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtEntityList = systemService.findHql(hql0,id0);
					page.setVmBusPoContractPayWmtList(vmBusPoContractPayWmtEntityList);
					pageList.add(page);
				}catch(Exception e){
					logger.info(e.getMessage());
				}
			}
		}
		map.put(NormalExcelConstants.FILE_NAME,"采购付款单");
		map.put(NormalExcelConstants.CLASS,VmBusPoPayWmtPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("采购付款单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
				"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,pageList);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
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
				List<VmBusPoPayWmtPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), VmBusPoPayWmtPage.class, params);
				VmBusPoPayWmtEntity entity1=null;
				for (VmBusPoPayWmtPage page : list) {
					entity1=new VmBusPoPayWmtEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
					vmBusPoPayWmtService.addMain(entity1, page.getVmBusPoContractPayWmtList(),page.getBusPayInfoList());
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
		map.put(NormalExcelConstants.FILE_NAME,"采购付款单");
		map.put(NormalExcelConstants.CLASS,VmBusPoPayWmtPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("采购付款单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "vmBusPoPayWmtController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 自定义按钮-sql增强-审核完成
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAuditFinish")
	@ResponseBody
	public AjaxJson doAuditFinish(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "审核完成成功";
		VmBusPoPayWmtEntity t = vmBusPoPayWmtService.get(VmBusPoPayWmtEntity.class, vmBusPoPayWmt.getId());
		try{
			vmBusPoPayWmtService.doAuditFinishSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核完成失败";
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 自定义按钮-sql增强-送审
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doSendAudit")
	@ResponseBody
	public AjaxJson doSendAudit(VmBusPoPayWmtEntity vmBusPoPayWmt, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "送审成功";
		VmBusPoPayWmtEntity t = vmBusPoPayWmtService.get(VmBusPoPayWmtEntity.class, vmBusPoPayWmt.getId());
		try{
			vmBusPoPayWmtService.doSendAuditSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "送审失败";
		}
		j.setMsg(message);
		return j;
	}

	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="采购付款单视图_wmt列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VmBusPoPayWmtPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VmBusPoPayWmtEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VmBusPoPayWmtEntity> list = this.vmBusPoPayWmtService.getListByCriteriaQuery(query,true);
		List<VmBusPoPayWmtPage> pageList=new ArrayList<VmBusPoPayWmtPage>();
		if(list!=null&&list.size()>0){
			for(VmBusPoPayWmtEntity entity:list){
				try{
					VmBusPoPayWmtPage page=new VmBusPoPayWmtPage();
					MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from VmBusPoContractPayWmtEntity where 1 = 1 AND busPoPayId = ? ";
	    			List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtOldList = this.vmBusPoPayWmtService.findHql(hql0,id0);
            		page.setVmBusPoContractPayWmtList(vmBusPoContractPayWmtOldList);
				     String hql1 = "from BusPayInfoEntity where 1 = 1 AND bpiBusId = ? ";
	    			List<BusPayInfoEntity> busPayInfoOldList = this.vmBusPoPayWmtService.findHql(hql1,id1);
            		page.setBusPayInfoList(busPayInfoOldList);
            		pageList.add(page);
				}catch(Exception e){
					logger.info(e.getMessage());
				}
			}
		}
		return Result.success(pageList);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取采购付款单视图_wmt信息",notes="根据ID获取采购付款单视图_wmt信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VmBusPoPayWmtEntity task = vmBusPoPayWmtService.get(VmBusPoPayWmtEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取采购付款单视图_wmt信息为空");
		}
		VmBusPoPayWmtPage page = new VmBusPoPayWmtPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
		    String hql0 = "from VmBusPoContractPayWmtEntity where 1 = 1 AND busPoPayId = ? ";
			List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtOldList = this.vmBusPoPayWmtService.findHql(hql0,id0);
			page.setVmBusPoContractPayWmtList(vmBusPoContractPayWmtOldList);
		    String hql1 = "from BusPayInfoEntity where 1 = 1 AND bpiBusId = ? ";
			List<BusPayInfoEntity> busPayInfoOldList = this.vmBusPoPayWmtService.findHql(hql1,id1);
			page.setBusPayInfoList(busPayInfoOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建采购付款单视图_wmt")
	public ResponseMessage<?> create(@ApiParam(name="采购付款单视图_wmt对象")@RequestBody VmBusPoPayWmtPage vmBusPoPayWmtPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusPoPayWmtPage>> failures = validator.validate(vmBusPoPayWmtPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList =  vmBusPoPayWmtPage.getVmBusPoContractPayWmtList();
		List<BusPayInfoEntity> busPayInfoList =  vmBusPoPayWmtPage.getBusPayInfoList();

		VmBusPoPayWmtEntity vmBusPoPayWmt = new VmBusPoPayWmtEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vmBusPoPayWmtPage,vmBusPoPayWmt);
		}catch(Exception e){
			logger.info(e.getMessage());
			return Result.error("保存采购付款单视图_wmt失败");
		}
		try {
			vmBusPoPayWmtService.addMain(vmBusPoPayWmt, vmBusPoContractPayWmtList,busPayInfoList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Result.success(vmBusPoPayWmt);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新采购付款单视图_wmt",notes="更新采购付款单视图_wmt")
	public ResponseMessage<?> update(@RequestBody VmBusPoPayWmtPage vmBusPoPayWmtPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusPoPayWmtPage>> failures = validator.validate(vmBusPoPayWmtPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VmBusPoContractPayWmtEntity> vmBusPoContractPayWmtList =  vmBusPoPayWmtPage.getVmBusPoContractPayWmtList();
		List<BusPayInfoEntity> busPayInfoList =  vmBusPoPayWmtPage.getBusPayInfoList();

		VmBusPoPayWmtEntity vmBusPoPayWmt = new VmBusPoPayWmtEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vmBusPoPayWmtPage,vmBusPoPayWmt);
		}catch(Exception e){
			logger.info(e.getMessage());
			return Result.error("采购付款单视图_wmt更新失败");
		}
		try {
			vmBusPoPayWmtService.updateMain(vmBusPoPayWmt, vmBusPoContractPayWmtList,busPayInfoList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除采购付款单视图_wmt")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			VmBusPoPayWmtEntity vmBusPoPayWmt = vmBusPoPayWmtService.get(VmBusPoPayWmtEntity.class, id);
			vmBusPoPayWmtService.delMain(vmBusPoPayWmt);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("采购付款单视图_wmt删除失败");
		}

		return Result.success();
	}
	/**
	 * 获取文件附件信息
	 * 
	 * @param id vmBusPoPayWmt主键id
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
