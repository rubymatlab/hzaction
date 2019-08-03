package com.action.actpo.controller;
import com.action.actpo.entity.BusPoContractEntity;
import com.action.actpo.service.BusPoContractServiceI;
import com.action.actpo.page.BusPoContractPage;
import com.action.actpo.entity.BusPoContractPayEntity;
import com.action.actpo.entity.BusPoApplyDetailConEntity;
import com.action.actpo.entity.BusPoContractDetailEntity;
import java.util.ArrayList;
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
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller
 * @Description: 采购合同
 * @author onlineGenerator
 * @date 2019-08-01 18:12:42
 * @version V1.0   
 *
 */
@Api(value="BusPoContract",description="采购合同",tags="busPoContractController")
@Controller
@RequestMapping("/busPoContractController")
public class BusPoContractController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BusPoContractController.class);

	@Autowired
	private BusPoContractServiceI busPoContractService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 采购合同列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actpo/busPoContractList");
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
	public void datagrid(BusPoContractEntity busPoContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BusPoContractEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, busPoContract, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.busPoContractService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除采购合同
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BusPoContractEntity busPoContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		busPoContract = systemService.getEntity(BusPoContractEntity.class, busPoContract.getId());
		String message = "采购合同删除成功";
		try{
			busPoContractService.delMain(busPoContract);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购合同删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除采购合同
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "采购合同删除成功";
		try{
			for(String id:ids.split(",")){
				BusPoContractEntity busPoContract = systemService.getEntity(BusPoContractEntity.class,
				id
				);
				busPoContractService.delMain(busPoContract);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "采购合同删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加采购合同
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BusPoContractEntity busPoContract,BusPoContractPage busPoContractPage, HttpServletRequest request) {
		List<BusPoContractPayEntity> busPoContractPayList =  busPoContractPage.getBusPoContractPayList();
		List<BusPoApplyDetailConEntity> busPoApplyDetailConList =  busPoContractPage.getBusPoApplyDetailConList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  busPoContractPage.getBusPoContractDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			busPoContractService.addMain(busPoContract, busPoContractPayList,busPoApplyDetailConList,busPoContractDetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购合同添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新采购合同
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BusPoContractEntity busPoContract,BusPoContractPage busPoContractPage, HttpServletRequest request) {
		List<BusPoContractPayEntity> busPoContractPayList =  busPoContractPage.getBusPoContractPayList();
		List<BusPoApplyDetailConEntity> busPoApplyDetailConList =  busPoContractPage.getBusPoApplyDetailConList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  busPoContractPage.getBusPoContractDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			busPoContractService.updateMain(busPoContract, busPoContractPayList,busPoApplyDetailConList,busPoContractDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新采购合同失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购合同新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BusPoContractEntity busPoContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(busPoContract.getId())) {
			busPoContract = busPoContractService.getEntity(BusPoContractEntity.class, busPoContract.getId());
			req.setAttribute("busPoContractPage", busPoContract);
		}
		return new ModelAndView("com/action/actpo/busPoContract-add");
	}
	
	/**
	 * 采购合同编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BusPoContractEntity busPoContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(busPoContract.getId())) {
			busPoContract = busPoContractService.getEntity(BusPoContractEntity.class, busPoContract.getId());
			req.setAttribute("busPoContractPage", busPoContract);
		}
		return new ModelAndView("com/action/actpo/busPoContract-update");
	}
	
	
	/**
	 * 加载明细列表[采购合同付款明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPoContractPayList")
	public ModelAndView busPoContractPayList(BusPoContractEntity busPoContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = busPoContract.getId();
		//===================================================================================
		//查询-采购合同付款明细
	    String hql0 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusPoContractPayEntity> busPoContractPayEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("busPoContractPayList", busPoContractPayEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actpo/busPoContractPayList");
	}
	/**
	 * 加载明细列表[采购申请明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPoApplyDetailConList")
	public ModelAndView busPoApplyDetailConList(BusPoContractEntity busPoContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = busPoContract.getId();
		//===================================================================================
		//查询-采购申请明细
	    String hql1 = "from BusPoApplyDetailConEntity where 1 = 1 AND fromPoApplyDetId = ? ";
	    try{
	    	List<BusPoApplyDetailConEntity> busPoApplyDetailConEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("busPoApplyDetailConList", busPoApplyDetailConEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actpo/busPoApplyDetailConList");
	}
	/**
	 * 加载明细列表[采购合同明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPoContractDetailList")
	public ModelAndView busPoContractDetailList(BusPoContractEntity busPoContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = busPoContract.getId();
		//===================================================================================
		//查询-采购合同明细
	    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusPoContractDetailEntity> busPoContractDetailEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("busPoContractDetailList", busPoContractDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actpo/busPoContractDetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(BusPoContractEntity busPoContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(BusPoContractEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, busPoContract);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<BusPoContractEntity> list=this.busPoContractService.getListByCriteriaQuery(cq, false);
    	List<BusPoContractPage> pageList=new ArrayList<BusPoContractPage>();
        if(list!=null&&list.size()>0){
        	for(BusPoContractEntity entity:list){
        		try{
        		BusPoContractPage page=new BusPoContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
        	        List<BusPoContractPayEntity> busPoContractPayEntityList = systemService.findHql(hql0,id0);
            		page.setBusPoContractPayList(busPoContractPayEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from BusPoApplyDetailConEntity where 1 = 1 AND fromPoApplyDetId = ? ";
        	        List<BusPoApplyDetailConEntity> busPoApplyDetailConEntityList = systemService.findHql(hql1,id1);
            		page.setBusPoApplyDetailConList(busPoApplyDetailConEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
        	        List<BusPoContractDetailEntity> busPoContractDetailEntityList = systemService.findHql(hql2,id2);
            		page.setBusPoContractDetailList(busPoContractDetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"采购合同");
        map.put(NormalExcelConstants.CLASS,BusPoContractPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("采购合同列表", "导出人:Jeecg",
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
				List<BusPoContractPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), BusPoContractPage.class, params);
				BusPoContractEntity entity1=null;
				for (BusPoContractPage page : list) {
					entity1=new BusPoContractEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            busPoContractService.addMain(entity1, page.getBusPoContractPayList(),page.getBusPoApplyDetailConList(),page.getBusPoContractDetailList());
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
		map.put(NormalExcelConstants.FILE_NAME,"采购合同");
		map.put(NormalExcelConstants.CLASS,BusPoContractPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("采购合同列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "busPoContractController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="采购合同列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BusPoContractPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(BusPoContractEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<BusPoContractEntity> list = this.busPoContractService.getListByCriteriaQuery(query,true);
    	List<BusPoContractPage> pageList=new ArrayList<BusPoContractPage>();
        if(list!=null&&list.size()>0){
        	for(BusPoContractEntity entity:list){
        		try{
        			BusPoContractPage page=new BusPoContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
					Object id2 = entity.getId();
				     String hql0 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    			List<BusPoContractPayEntity> busPoContractPayOldList = this.busPoContractService.findHql(hql0,id0);
            		page.setBusPoContractPayList(busPoContractPayOldList);
				     String hql1 = "from BusPoApplyDetailConEntity where 1 = 1 AND fromPoApplyDetId = ? ";
	    			List<BusPoApplyDetailConEntity> busPoApplyDetailConOldList = this.busPoContractService.findHql(hql1,id1);
            		page.setBusPoApplyDetailConList(busPoApplyDetailConOldList);
				     String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
	    			List<BusPoContractDetailEntity> busPoContractDetailOldList = this.busPoContractService.findHql(hql2,id2);
            		page.setBusPoContractDetailList(busPoContractDetailOldList);
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
	@ApiOperation(value="根据ID获取采购合同信息",notes="根据ID获取采购合同信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BusPoContractEntity task = busPoContractService.get(BusPoContractEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取采购合同信息为空");
		}
		BusPoContractPage page = new BusPoContractPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
		    String hql0 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
			List<BusPoContractPayEntity> busPoContractPayOldList = this.busPoContractService.findHql(hql0,id0);
    		page.setBusPoContractPayList(busPoContractPayOldList);
		    String hql1 = "from BusPoApplyDetailConEntity where 1 = 1 AND fromPoApplyDetId = ? ";
			List<BusPoApplyDetailConEntity> busPoApplyDetailConOldList = this.busPoContractService.findHql(hql1,id1);
    		page.setBusPoApplyDetailConList(busPoApplyDetailConOldList);
		    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
			List<BusPoContractDetailEntity> busPoContractDetailOldList = this.busPoContractService.findHql(hql2,id2);
    		page.setBusPoContractDetailList(busPoContractDetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建采购合同")
	public ResponseMessage<?> create(@ApiParam(name="采购合同对象")@RequestBody BusPoContractPage busPoContractPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BusPoContractPage>> failures = validator.validate(busPoContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BusPoContractPayEntity> busPoContractPayList =  busPoContractPage.getBusPoContractPayList();
		List<BusPoApplyDetailConEntity> busPoApplyDetailConList =  busPoContractPage.getBusPoApplyDetailConList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  busPoContractPage.getBusPoContractDetailList();
		
		BusPoContractEntity busPoContract = new BusPoContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(busPoContractPage,busPoContract);
			busPoContractService.addMain(busPoContract, busPoContractPayList,busPoApplyDetailConList,busPoContractDetailList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存采购合同失败");
        }

		return Result.success(busPoContract);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新采购合同",notes="更新采购合同")
	public ResponseMessage<?> update(@RequestBody BusPoContractPage busPoContractPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BusPoContractPage>> failures = validator.validate(busPoContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BusPoContractPayEntity> busPoContractPayList =  busPoContractPage.getBusPoContractPayList();
		List<BusPoApplyDetailConEntity> busPoApplyDetailConList =  busPoContractPage.getBusPoApplyDetailConList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  busPoContractPage.getBusPoContractDetailList();
		
		BusPoContractEntity busPoContract = new BusPoContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(busPoContractPage,busPoContract);
			busPoContractService.updateMain(busPoContract, busPoContractPayList,busPoApplyDetailConList,busPoContractDetailList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("采购合同更新失败");
        }
		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除采购合同")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			BusPoContractEntity busPoContract = busPoContractService.get(BusPoContractEntity.class, id);
			busPoContractService.delMain(busPoContract);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("采购合同删除失败");
		}

		return Result.success();
	}
}
