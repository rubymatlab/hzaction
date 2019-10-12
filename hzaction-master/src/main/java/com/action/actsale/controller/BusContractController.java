package com.action.actsale.controller;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.action.actbase.entity.BasCustomerEntity;
import com.action.actsale.entity.BusConQuotedPriceEntity;
import com.action.actsale.entity.BusContractEntity;
import com.action.actsale.entity.BusContractPaymentEntity;
import com.action.actsale.entity.BusCostBudgetingEntity;
import com.action.actsale.entity.BusProjectEntity;
import com.action.actsale.page.BusContractPage;
import com.action.actsale.service.BusContractServiceI;
import com.alibaba.fastjson.JSONArray;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**   
 * @Title: Controller
 * @Description: 合同管理
 * @author onlineGenerator
 * @date 2019-08-07 14:26:12
 * @version V1.0   
 *
 */
@Api(value="BusContract",description="合同管理",tags="busContractController")
@Controller
@RequestMapping("/busContractController")
public class BusContractController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BusContractController.class);

	@Autowired
	private BusContractServiceI busContractService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	
	
	/**
	 * 自定义按钮-sql增强-测试button
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "affirmButton")
	@ResponseBody
	public AjaxJson affirmButton(BusContractEntity busContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "合同确定成功";
		BusContractEntity t = busContractService.get(BusContractEntity.class, busContract.getId());
		try{
			//自定义sql增强按钮
			busContractService.affirmButton(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "合同确定失败";
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 合同管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/busContractList");
	}
	@RequestMapping(params = "list1")
	public ModelAndView list0(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/busContractList1");
	}
	@RequestMapping(params = "list2")
	public ModelAndView list1(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/busContractList2");
	}
	/**
	 * easyui AJAX请求数据
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BusContractEntity busContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String contractState = request.getParameter("contractState");
		
		logger.info("-- 合同完成状态（0制作中，1已审核） --"+contractState);
		
		CriteriaQuery cq = new CriteriaQuery(BusContractEntity.class, dataGrid);
		//查询条件组装器
		busContract.setBcContractState(contractState);
		//模糊查询-客户名称
		if(busContract.getFromProjName()!=null) {
			busContract.setFromProjName("*"+busContract.getFromProjName()+"*");
		}
		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, busContract, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.busContractService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除合同管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BusContractEntity busContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		busContract = systemService.getEntity(BusContractEntity.class, busContract.getId());
		String message = "合同管理删除成功";
		try{
			busContractService.delMain(busContract);
			BusProjectEntity o=systemService.getEntity(BusProjectEntity.class,busContract.getFromProjId());
			o.setBpmStatus("1");
			busContractService.saveOrUpdate(o);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "合同管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除合同管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "合同管理删除成功";
		try{
			for(String id:ids.split(",")){
				BusContractEntity busContract = systemService.getEntity(BusContractEntity.class,
				id
				);
				busContractService.delMain(busContract);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "合同管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加合同管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BusContractEntity busContract,BusContractPage busContractPage, HttpServletRequest request) {
		//List<BusConQuotedPriceEntity> busConQuotedPriceList =  busContractPage.getBusConQuotedPriceList();
		//List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		//List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		BusContractEntity t=new BusContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(busContract, t);
			t.setBcContractState("0");
			busContractService.save(t);
			
			BusProjectEntity o=systemService.getEntity(BusProjectEntity.class,t.getFromProjId());
			o.setBpmStatus("2");
			busContractService.saveOrUpdate(o);
			//busContractService.addMain(busContract, busConQuotedPriceList,busContractPaymentList,busCostBudgetingList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "合同管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(t);
		return j;
	}
	/**
	 * 更新合同管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BusContractEntity busContract,BusContractPage busContractPage, HttpServletRequest request) {
		List<BusConQuotedPriceEntity> busConQuotedPriceList =  busContractPage.getBusConQuotedPriceList();
		List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			busContractService.updateMain(busContract, busConQuotedPriceList,busContractPaymentList,busCostBudgetingList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新合同管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 合同管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BusContractEntity busContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(busContract.getFromProjId())) {
			BusProjectEntity busProject=busContractService.getEntity(BusProjectEntity.class, busContract.getFromProjId());
			BusContractEntity o=new BusContractEntity();
			o.setFromCustId(busProject.getFromCustId());
			o.setFromProjId(busProject.getId());
			o.setFromProjName(busProject.getBpProjName());
			o.setBcProjectCode(busProject.getBpProjId());
			
			BasCustomerEntity basCustomer=busContractService.getEntity(BasCustomerEntity.class, busProject.getFromCustId());
			if(basCustomer!=null)
			{
				o.setBcCustomerCode(basCustomer.getBcId());
				o.setBcCustomerName(basCustomer.getBcName());
			}
			o.setBcContractState("0");
			//busContract = busContractService.getEntity(BusContractEntity.class, busContract.getId());
			req.setAttribute("busContractPage", o);
		}
		return new ModelAndView("com/action/actsale/busContract-add");
	}
	
	/**
	 * 合同管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BusContractEntity busContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(busContract.getId())) {
			busContract = busContractService.getEntity(BusContractEntity.class, busContract.getId());
			req.setAttribute("busContractPage", busContract);
		}
		return new ModelAndView("com/action/actsale/busContract-update");
	}
	
	
	/**
	 * 加载明细列表[合同明细报价附表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busConQuotedPriceList")
	public ModelAndView busConQuotedPriceList(BusContractEntity busContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = busContract.getId();
		//===================================================================================
		//查询-合同明细报价附表
	    String hql0 = "from BusConQuotedPriceEntity where 1 = 1 AND busContractId = ? ";
	    try{
	    	List<BusConQuotedPriceEntity> busConQuotedPriceEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("busConQuotedPriceList", busConQuotedPriceEntityList);
			logger.info("-- 查询-合同明细报价附表:{} --",busConQuotedPriceEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busConQuotedPriceList");
	}
	/**
	 * 加载明细列表[合同约定收款附表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busContractPaymentList")
	public ModelAndView busContractPaymentList(BusContractEntity busContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = busContract.getId();
		//===================================================================================
		//查询-合同约定收款附表
	    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? order by bcpProgrePayment asc ";
	    try{
	    	List<BusContractPaymentEntity> busContractPaymentEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("busContractPaymentList", busContractPaymentEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busContractPaymentList");
	}
	/**
	 * 加载明细列表[成本预算附表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busCostBudgetingList")
	public ModelAndView busCostBudgetingList(BusContractEntity busContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = busContract.getId();
		//===================================================================================
		//查询-成本预算附表
	    String hql2 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
	    try{
	    	List<BusCostBudgetingEntity> busCostBudgetingEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("busCostBudgetingList", busCostBudgetingEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busCostBudgetingList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(@RequestParam String contractState, BusContractEntity busContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	
    	logger.info("导出excel:{}",contractState.equals("0")?"制作中":"已审核");
    	busContract.setBcContractState(contractState);
    	
    	CriteriaQuery cq = new CriteriaQuery(BusContractEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, busContract);
    	try{
    	//自定义追加查询条件
    		
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<BusContractEntity> list=this.busContractService.getListByCriteriaQuery(cq, false);
    	List<BusContractPage> pageList=new ArrayList<BusContractPage>();
        if(list!=null&&list.size()>0){
        	for(BusContractEntity entity:list){
        		try{
        		BusContractPage page=new BusContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BusConQuotedPriceEntity where 1 = 1 AND busContractId = ? ";
        	        List<BusConQuotedPriceEntity> busConQuotedPriceEntityList = systemService.findHql(hql0,id0);
            		page.setBusConQuotedPriceList(busConQuotedPriceEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
        	        List<BusContractPaymentEntity> busContractPaymentEntityList = systemService.findHql(hql1,id1);
            		page.setBusContractPaymentList(busContractPaymentEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
        	        List<BusCostBudgetingEntity> busCostBudgetingEntityList = systemService.findHql(hql2,id2);
            		page.setBusCostBudgetingList(busCostBudgetingEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"合同管理");
        map.put(NormalExcelConstants.CLASS,BusContractPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("合同管理列表", "导出人:安信",
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
				List<BusContractPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), BusContractPage.class, params);
				BusContractEntity entity1=null;
				for (BusContractPage page : list) {
					entity1=new BusContractEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            busContractService.addMain(entity1, page.getBusConQuotedPriceList(),page.getBusContractPaymentList(),page.getBusCostBudgetingList());
				}
				logger.info("-- 文件导入成功! --");
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				logger.info("-- 文件导入失败! --");
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
	 * 通过excel导入【合同明细报价附表】数据
	 * @param request
	 * @param	id:主表的id
	 * @return
	 */
	@RequestMapping(params="importExcelDetail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcelDetail(String contractId,HttpServletRequest request, HttpServletResponse response) {
		logger.info("-- 通过excel导入【合同明细报价附表】 合同管理外键:{}--",contractId);
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			logger.info("-- 文件名称:{}--",file.getOriginalFilename());
			
			ImportParams params = new ImportParams();
			params.setTitleRows(2);//excel文件的标题行数
			params.setHeadRows(2);//excel文件中表头行数
			params.setNeedSave(true);
			try {
				List<BusConQuotedPriceEntity> list =  ExcelImportUtil.importExcel(file.getInputStream(), BusConQuotedPriceEntity.class, params);
				for (BusConQuotedPriceEntity busConQuotedPriceEntity : list) {
					logger.info("-- 通过excel导入附表数据:{} --",busConQuotedPriceEntity);
					BusConQuotedPriceEntity newBusConQuotedPriceEntity = new BusConQuotedPriceEntity();
					newBusConQuotedPriceEntity.setBcqpName(busConQuotedPriceEntity.getBcqpName());
					newBusConQuotedPriceEntity.setBcqpBrand(busConQuotedPriceEntity.getBcqpBrand());
					newBusConQuotedPriceEntity.setBcqpModel(busConQuotedPriceEntity.getBcqpModel());
					newBusConQuotedPriceEntity.setBcqpQty(busConQuotedPriceEntity.getBcqpQty());
					newBusConQuotedPriceEntity.setBcqpPrice(busConQuotedPriceEntity.getBcqpPrice());
					newBusConQuotedPriceEntity.setBcqpAmount(busConQuotedPriceEntity.getBcqpAmount());
					newBusConQuotedPriceEntity.setBusContractId(contractId);
					logger.info("-- 数据库保存该对象:{} --",newBusConQuotedPriceEntity);
					busContractService.save(newBusConQuotedPriceEntity);
				}
				logger.info("-- 文件导入成功! --");
				j.setObj(list);
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.info("-- 文件导入失败! --");
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
	* excel模板下载 使模板【合同明细报价附表】
	*/
	@RequestMapping(params = "exportXlsByT2")
	public String exportXlsByT2(ModelMap map) {
		System.out.println("--- excel模板下载 使模板【合同明细报价附表】 ---");
		map.put(NormalExcelConstants.FILE_NAME,"合同明细报价附表");
		map.put(NormalExcelConstants.CLASS,BusConQuotedPriceEntity.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("合同明细报价附表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	/**
	 * 导出excel 使模板【合同管理】
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"合同管理");
		map.put(NormalExcelConstants.CLASS,BusContractPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("合同管理列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		/*req.setAttribute("controller_name", "busContractController");
		String contractId = req.getParameter("contractId");
		if(contractId!=null) {
			req.setAttribute("contractId", contractId);
			return new ModelAndView("com/action/actsale/ax_busContract_pub_excel_upload");
		}
		return new ModelAndView("common/upload/pub_excel_upload");*/
		return new ModelAndView("com/action/actsale/ax_busContract_pub_excel_upload");
	}

 	
 	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="合同管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BusContractPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(BusContractEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<BusContractEntity> list = this.busContractService.getListByCriteriaQuery(query,true);
    	List<BusContractPage> pageList=new ArrayList<BusContractPage>();
        if(list!=null&&list.size()>0){
        	for(BusContractEntity entity:list){
        		try{
        			BusContractPage page=new BusContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
					Object id2 = entity.getId();
				     String hql0 = "from BusConQuotedPriceEntity where 1 = 1 AND busContractId = ? ";
	    			List<BusConQuotedPriceEntity> busConQuotedPriceOldList = this.busContractService.findHql(hql0,id0);
            		page.setBusConQuotedPriceList(busConQuotedPriceOldList);
				     String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
	    			List<BusContractPaymentEntity> busContractPaymentOldList = this.busContractService.findHql(hql1,id1);
            		page.setBusContractPaymentList(busContractPaymentOldList);
				     String hql2 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
	    			List<BusCostBudgetingEntity> busCostBudgetingOldList = this.busContractService.findHql(hql2,id2);
            		page.setBusCostBudgetingList(busCostBudgetingOldList);
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
	@ApiOperation(value="根据ID获取合同管理信息",notes="根据ID获取合同管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BusContractEntity task = busContractService.get(BusContractEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取合同管理信息为空");
		}
		BusContractPage page = new BusContractPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
		    String hql0 = "from BusConQuotedPriceEntity where 1 = 1 AND busContractId = ? ";
			List<BusConQuotedPriceEntity> busConQuotedPriceOldList = this.busContractService.findHql(hql0,id0);
    		page.setBusConQuotedPriceList(busConQuotedPriceOldList);
		    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
			List<BusContractPaymentEntity> busContractPaymentOldList = this.busContractService.findHql(hql1,id1);
    		page.setBusContractPaymentList(busContractPaymentOldList);
		    String hql2 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
			List<BusCostBudgetingEntity> busCostBudgetingOldList = this.busContractService.findHql(hql2,id2);
    		page.setBusCostBudgetingList(busCostBudgetingOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建合同管理")
	public ResponseMessage<?> create(@ApiParam(name="合同管理对象")@RequestBody BusContractPage busContractPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BusContractPage>> failures = validator.validate(busContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BusConQuotedPriceEntity> busConQuotedPriceList =  busContractPage.getBusConQuotedPriceList();
		List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		
		BusContractEntity busContract = new BusContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(busContractPage,busContract);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存合同管理失败");
        }
		try {
			busContractService.addMain(busContract, busConQuotedPriceList,busContractPaymentList,busCostBudgetingList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Result.success(busContract);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新合同管理",notes="更新合同管理")
	public ResponseMessage<?> update(@RequestBody BusContractPage busContractPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BusContractPage>> failures = validator.validate(busContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BusConQuotedPriceEntity> busConQuotedPriceList =  busContractPage.getBusConQuotedPriceList();
		List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		
		BusContractEntity busContract = new BusContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(busContractPage,busContract);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("合同管理更新失败");
        }
		try {
			busContractService.updateMain(busContract, busConQuotedPriceList,busContractPaymentList,busCostBudgetingList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除合同管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			BusContractEntity busContract = busContractService.get(BusContractEntity.class, id);
			busContractService.delMain(busContract);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("合同管理删除失败");
		}

		return Result.success();
	}
	/**
	 * 获取文件附件信息
	 * 
	 * @param id busContract主键id
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
