package com.action.actsale.controller;
import java.io.IOException;
import java.util.ArrayList;
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
import org.jeecgframework.core.common.dao.impl.CommonDao;
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

import com.action.actsale.entity.BusConQuotedPriceEntity;
import com.action.actsale.entity.BusContractEntity;
import com.action.actsale.entity.BusContractPaymentEntity;
import com.action.actsale.entity.BusCostBudgetingEntity;
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
 * @date 2019-07-18 23:54:48
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
	/*@Autowired
	private BusContractMiniDao busContractMiniDao;*/
	
	private CommonDao commomDao = new CommonDao();
	
	
	/**
	 * 测试数据库操作接口
	 * @return
	 */
	/*@RequestMapping(params="getList")
	@ResponseBody
	public List<BusContractEntity> getList(){
		busContractService.getList();	//使用jeecg的JDBC模板
		return busContractDao.getList();	//使用miniDao注解
	}*/
	
	
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
	public ModelAndView list1(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/busContractList1");
	}
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/busContractList2");
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
	public void datagrid(BusContractEntity busContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String contractState = request.getParameter("contractState");
		logger.info("-- 合同完成状态（1未完成，2已完成） --"+contractState);
		
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
		List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		List<BusConQuotedPriceEntity> busConQuotedPriceList = busContractPage.getBusConQuotedPriceList();

		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			busContractService.addMain(busContract, busCostBudgetingList,busContractPaymentList,busConQuotedPriceList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "合同管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
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
		List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		List<BusConQuotedPriceEntity> busConQuotedPriceList = busContractPage.getBusConQuotedPriceList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			logger.info("-- 更新合同管理-成本预算 --"+busCostBudgetingList.size());
			logger.info("-- 更新合同管理-约定收款 --"+busContractPaymentList.size());
			logger.info("-- 更新合同管理-合同管理id --"+busContract.getId());

			
			busContractService.updateMain(busContract, busCostBudgetingList,busContractPaymentList,busConQuotedPriceList);
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
		if (StringUtil.isNotEmpty(busContract.getId())) {
			busContract = busContractService.getEntity(BusContractEntity.class, busContract.getId());
			req.setAttribute("busContractPage", busContract);
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
	 * 加载明细列表[1]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busCostBudgetingList")
	public ModelAndView busCostBudgetingList(BusContractEntity busContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = busContract.getId();
		//===================================================================================
		//查询-1
	    String hql0 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
	    try{
	    	List<BusCostBudgetingEntity> busCostBudgetingEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("busCostBudgetingList", busCostBudgetingEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busCostBudgetingList");
	}
	/**
	 * 加载明细列表[2]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busContractPaymentList")
	public ModelAndView busContractPaymentList(BusContractEntity busContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = busContract.getId();
		//===================================================================================
		//查询-2
	    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? order by bcpProgrePayment asc";
	    try{
	    	List<BusContractPaymentEntity> busContractPaymentEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("busContractPaymentList", busContractPaymentEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busContractPaymentList");
	}
	/**
	 * 加载明细列表[3]
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
		}catch(Exception e){
			logger.info(e.getMessage());
		}
	    req.setAttribute("id", id0+"");
		return new ModelAndView("com/action/actsale/busConQuotedPriceList");
	}
	

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(BusContractEntity busContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	//???
    	/*logger.info("-- 导出excel ---");
    	logger.info("BusContractEntity："+busContract.toString());
    	logger.info("DataGrid："+dataGrid.toString());
    	Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
    	while(iterator.hasNext()) {
    		Entry<String, Object> entry = iterator.next();
    		logger.info("key:"+entry.getKey()+"\t value:"+entry.getValue());
    	}*/
    	
    	
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
				    String hql0 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
        	        List<BusCostBudgetingEntity> busCostBudgetingEntityList = systemService.findHql(hql0,id0);
            		page.setBusCostBudgetingList(busCostBudgetingEntityList);
            		
            	    Object id1 = entity.getId();
				    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
        	        List<BusContractPaymentEntity> busContractPaymentEntityList = systemService.findHql(hql1,id1);
            		page.setBusContractPaymentList(busContractPaymentEntityList);
            		
            		Object id2 = entity.getId();
            		String hql2 = "from BusConQuotedPriceEntity where 1 = 1 AND busContractId = ? ";
            		List<BusConQuotedPriceEntity> busConQuotedPriceEntityList = systemService.findHql(hql2,id2);
            		page.setBusConQuotedPriceList(busConQuotedPriceEntityList);

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
		logger.info("-- 通过excel导入数据 --");
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
		            busContractService.addMain(entity1, page.getBusCostBudgetingList(),page.getBusContractPaymentList(),page.getBusConQuotedPriceList());
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
	 * 通过excel导入【明细报价附表】数据
	 * @param request
	 * @param	id:主表的id
	 * @return
	 */
	@RequestMapping(params = "importExcelDetail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcelDetail(String id,HttpServletRequest request, HttpServletResponse response) {
		logger.info("-- 通过excel导入【明细报价附表】 合同管理外键:{}--",id);
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			logger.info("-- 文件名称:{}--",file.getOriginalFilename());
			
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setHeadRows(0);
			params.setNeedSave(true);
			try {
				List<BusConQuotedPriceEntity> list =  ExcelImportUtil.importExcel(file.getInputStream(), BusConQuotedPriceEntity.class, params);
				for (BusConQuotedPriceEntity busConQuotedPriceEntity : list) {
					busConQuotedPriceEntity.setBusContractId(id);
					System.out.println(busConQuotedPriceEntity);
					busContractService.save(busConQuotedPriceEntity);
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
		req.setAttribute("controller_name", "busContractController");
		if("1".equals(req.getParameter("detail"))) {
			req.setAttribute("method_name", "importExcelDetail");
			req.setAttribute("id", req.getParameter("id"));
		}
		return new ModelAndView("common/upload/pub_excel_upload");
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
				     String hql0 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
	    			List<BusCostBudgetingEntity> busCostBudgetingOldList = this.busContractService.findHql(hql0,id0);
            		page.setBusCostBudgetingList(busCostBudgetingOldList);
				     String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
	    			List<BusContractPaymentEntity> busContractPaymentOldList = this.busContractService.findHql(hql1,id1);
            		page.setBusContractPaymentList(busContractPaymentOldList);
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
		    String hql0 = "from BusCostBudgetingEntity where 1 = 1 AND busContractId = ? ";
			List<BusCostBudgetingEntity> busCostBudgetingOldList = this.busContractService.findHql(hql0,id0);
    		page.setBusCostBudgetingList(busCostBudgetingOldList);
		    String hql1 = "from BusContractPaymentEntity where 1 = 1 AND busContractId = ? ";
			List<BusContractPaymentEntity> busContractPaymentOldList = this.busContractService.findHql(hql1,id1);
    		page.setBusContractPaymentList(busContractPaymentOldList);
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
		List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		List<BusConQuotedPriceEntity> busConQuotedPriceList = busContractPage.getBusConQuotedPriceList();
		
		BusContractEntity busContract = new BusContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(busContractPage,busContract);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存合同管理失败");
        }
		try {
			busContractService.addMain(busContract, busCostBudgetingList,busContractPaymentList,busConQuotedPriceList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		List<BusCostBudgetingEntity> busCostBudgetingList =  busContractPage.getBusCostBudgetingList();
		List<BusContractPaymentEntity> busContractPaymentList =  busContractPage.getBusContractPaymentList();
		List<BusConQuotedPriceEntity> busConQuotedPriceList = busContractPage.getBusConQuotedPriceList();
		
		BusContractEntity busContract = new BusContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(busContractPage,busContract);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("合同管理更新失败");
        }
		try {
			busContractService.updateMain(busContract, busCostBudgetingList,busContractPaymentList,busConQuotedPriceList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	
}
