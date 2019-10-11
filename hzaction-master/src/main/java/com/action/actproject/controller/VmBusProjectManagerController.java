package com.action.actproject.controller;
import com.action.actproject.entity.VmBusProjectManagerEntity;
import com.action.actproject.service.BusProjectManagerServiceI;
import com.action.actproject.service.VmBusProjectManagerServiceI;
import com.action.actproject.page.VmBusProjectManagerPage;
import com.action.actproject.entity.VmBusCollectPlanEntity;
import com.action.actproject.entity.BusCollectPlanEntity;
import com.action.actproject.entity.BusProjectFollowEntity_manager;
import com.action.actproject.entity.BusProjectManagerEntity;

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
import org.hibernate.criterion.Restrictions;
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
 * @Description: 项目管理视图
 * @author onlineGenerator
 * @date 2019-07-26 20:14:13
 * @version V1.0   
 *
 */
@Api(value="VmBusProjectManager",description="项目管理视图",tags="vmBusProjectManagerController")
@Controller
@RequestMapping("/vmBusProjectManagerController")
public class VmBusProjectManagerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VmBusProjectManagerController.class);

	@Autowired
	private VmBusProjectManagerServiceI vmBusProjectManagerService;
	@Autowired
	private BusProjectManagerServiceI busProjectManagerService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 项目管理视图列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actproject/vmBusProjectManager-index");
	}
	
	@RequestMapping(params = "index")
	public ModelAndView index(String bpmStatus, HttpServletRequest request) {
		request.setAttribute("bpmStatus", bpmStatus);
		return new ModelAndView("com/action/actproject/vmBusProjectManagerList");
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
	public void datagrid(VmBusProjectManagerEntity vmBusProjectManager,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VmBusProjectManagerEntity.class, dataGrid);
		//查询条件组装器
		String projName = vmBusProjectManager.getBpmProjName();
		if(projName != null && projName.indexOf("*") == -1) {
			vmBusProjectManager.setBpmProjName("*" + vmBusProjectManager.getBpmProjName() + "*");
		}
		if(vmBusProjectManager.getBpmProjId() != null) {
			vmBusProjectManager.setBpmProjId("*" + vmBusProjectManager.getBpmProjId() + "*");
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusProjectManager, request.getParameterMap());
		try{
			//自定义追加查询条件
			if( vmBusProjectManager.getBpmStatus() != null) {
				String bpmStatus = vmBusProjectManager.getBpmStatus();
				cq.add(Restrictions.eq("bpmStatus", bpmStatus));			
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vmBusProjectManagerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目管理视图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VmBusProjectManagerEntity vmBusProjectManager, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vmBusProjectManager = systemService.getEntity(VmBusProjectManagerEntity.class, vmBusProjectManager.getId());
		String message = "项目管理视图删除成功";
		try{
			
			BusProjectManagerEntity busProjectManagerEntity = new BusProjectManagerEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vmBusProjectManager,busProjectManagerEntity);
			busProjectManagerService.delMain(busProjectManagerEntity);
//			vmBusProjectManagerService.delMain(vmBusProjectManager);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目管理视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除项目管理视图
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "项目管理视图删除成功";
		try{
			for(String id:ids.split(",")){
				VmBusProjectManagerEntity vmBusProjectManager = systemService.getEntity(VmBusProjectManagerEntity.class,
				id
				);
				BusProjectManagerEntity busProjectManagerEntity = new BusProjectManagerEntity();
				MyBeanUtils.copyBeanNotNull2Bean(vmBusProjectManager,busProjectManagerEntity);
				busProjectManagerService.delMain(busProjectManagerEntity);
//				vmBusProjectManagerService.delMain(vmBusProjectManager);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目管理视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加项目管理视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VmBusProjectManagerEntity vmBusProjectManager,VmBusProjectManagerPage vmBusProjectManagerPage, HttpServletRequest request) {
		List<VmBusCollectPlanEntity> vmBusCollectPlanList =  vmBusProjectManagerPage.getVmBusCollectPlanList();
		List<BusProjectFollowEntity_manager> busProjectFollowList =  vmBusProjectManagerPage.getBusProjectFollowList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			BusProjectManagerEntity busProjectManagerEntity = new BusProjectManagerEntity();
			List<BusCollectPlanEntity> busCollectPlanList = new ArrayList<BusCollectPlanEntity>();
			for(int i = 0; i < vmBusCollectPlanList.size(); i++) {
				BusCollectPlanEntity oTemp = new BusCollectPlanEntity();
				VmBusCollectPlanEntity oVmTemp = vmBusCollectPlanList.get(i);
				MyBeanUtils.copyBeanNotNull2Bean(oVmTemp,oTemp);
				busCollectPlanList.add(oTemp);
			}
			MyBeanUtils.copyBeanNotNull2Bean(vmBusProjectManager,busProjectManagerEntity);
			busProjectManagerService.updateMain(busProjectManagerEntity, busCollectPlanList, busProjectFollowList);
//			vmBusProjectManagerService.addMain(vmBusProjectManager, vmBusCollectPlanList,busProjectFollowList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目管理视图添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新项目管理视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VmBusProjectManagerEntity vmBusProjectManager,VmBusProjectManagerPage vmBusProjectManagerPage, HttpServletRequest request) {
		List<VmBusCollectPlanEntity> vmBusCollectPlanList =  vmBusProjectManagerPage.getVmBusCollectPlanList();
		List<BusProjectFollowEntity_manager> busProjectFollowList =  vmBusProjectManagerPage.getBusProjectFollowList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			BusProjectManagerEntity busProjectManagerEntity = new BusProjectManagerEntity();
			List<BusCollectPlanEntity> busCollectPlanList = new ArrayList<BusCollectPlanEntity>();
			for(int i = 0; i < vmBusCollectPlanList.size(); i++) {
				BusCollectPlanEntity oTemp = new BusCollectPlanEntity();
				VmBusCollectPlanEntity oVmTemp = vmBusCollectPlanList.get(i);
				MyBeanUtils.copyBeanNotNull2Bean(oVmTemp,oTemp);
				busCollectPlanList.add(oTemp);
			}
			MyBeanUtils.copyBeanNotNull2Bean(vmBusProjectManager,busProjectManagerEntity);
			busProjectManagerService.updateMain(busProjectManagerEntity, busCollectPlanList, busProjectFollowList);
			
//			vmBusProjectManagerService.updateMain(vmBusProjectManager, vmBusCollectPlanList,busProjectFollowList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新项目管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目管理视图新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VmBusProjectManagerEntity vmBusProjectManager, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusProjectManager.getId())) {
			vmBusProjectManager = vmBusProjectManagerService.getEntity(VmBusProjectManagerEntity.class, vmBusProjectManager.getId());
			req.setAttribute("vmBusProjectManagerPage", vmBusProjectManager);
		}
		return new ModelAndView("com/action/actproject/vmBusProjectManager-add");
	}
	
	/**
	 * 项目管理视图编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VmBusProjectManagerEntity vmBusProjectManager, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusProjectManager.getId())) {
			vmBusProjectManager = vmBusProjectManagerService.getEntity(VmBusProjectManagerEntity.class, vmBusProjectManager.getId());
			req.setAttribute("vmBusProjectManagerPage", vmBusProjectManager);
		}
		return new ModelAndView("com/action/actproject/vmBusProjectManager-update");
	}
	
	
	/**
	 * 加载明细列表[回款计划]
	 * 
	 * @return
	 */
	@RequestMapping(params = "vmBusCollectPlanList")
	public ModelAndView vmBusCollectPlanList(VmBusProjectManagerEntity vmBusProjectManager, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = vmBusProjectManager.getId();
		//===================================================================================
		//查询-回款计划
	    String hql0 = "from VmBusCollectPlanEntity where 1 = 1 AND fromId = ? order by brpProgressStages";
	    try{
	    	List<VmBusCollectPlanEntity> vmBusCollectPlanEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("vmBusCollectPlanList", vmBusCollectPlanEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actproject/vmBusCollectPlanList");
	}
	/**
	 * 加载明细列表[项目跟进]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busProjectFollowList")
	public ModelAndView busProjectFollowList(VmBusProjectManagerEntity vmBusProjectManager, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = vmBusProjectManager.getId();
		//===================================================================================
		//查询-项目跟进
	    String hql1 = "from BusProjectFollowEntity_manager where 1 = 1 AND fromId = ? order by createDate";
	    try{
	    	List<BusProjectFollowEntity_manager> BusProjectFollowEntity_managerList = systemService.findHql(hql1,id1);
			req.setAttribute("busProjectFollowList", BusProjectFollowEntity_managerList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actproject/busProjectFollowList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(VmBusProjectManagerEntity vmBusProjectManager,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(VmBusProjectManagerEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusProjectManager);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<VmBusProjectManagerEntity> list=this.vmBusProjectManagerService.getListByCriteriaQuery(cq, false);
    	List<VmBusProjectManagerPage> pageList=new ArrayList<VmBusProjectManagerPage>();
        if(list!=null&&list.size()>0){
        	for(VmBusProjectManagerEntity entity:list){
        		try{
        		VmBusProjectManagerPage page=new VmBusProjectManagerPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from VmBusCollectPlanEntity where 1 = 1 AND fromId = ? ";
        	        List<VmBusCollectPlanEntity> vmBusCollectPlanEntityList = systemService.findHql(hql0,id0);
            		page.setVmBusCollectPlanList(vmBusCollectPlanEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from BusProjectFollowEntity_manager where 1 = 1 AND fromId = ? ";
        	        List<BusProjectFollowEntity_manager> BusProjectFollowEntity_managerList = systemService.findHql(hql1,id1);
            		page.setBusProjectFollowList(BusProjectFollowEntity_managerList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"项目管理视图");
        map.put(NormalExcelConstants.CLASS,VmBusProjectManagerPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("项目管理视图列表", "导出人:Jeecg",
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
				List<VmBusProjectManagerPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), VmBusProjectManagerPage.class, params);
				VmBusProjectManagerEntity entity1=null;
				for (VmBusProjectManagerPage page : list) {
					entity1=new VmBusProjectManagerEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            vmBusProjectManagerService.addMain(entity1, page.getVmBusCollectPlanList(),page.getBusProjectFollowList());
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
		map.put(NormalExcelConstants.FILE_NAME,"项目管理视图");
		map.put(NormalExcelConstants.CLASS,VmBusProjectManagerPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("项目管理视图列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "vmBusProjectManagerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-项目确认审核
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdateStatus")
	@ResponseBody
	public AjaxJson doUpdateStatus(VmBusProjectManagerEntity vmBusProjectManager, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "项目确认审核成功";
		VmBusProjectManagerEntity t = vmBusProjectManagerService.get(VmBusProjectManagerEntity.class, vmBusProjectManager.getId());
		try{
			BusProjectManagerEntity busProjectManager = new BusProjectManagerEntity();
			MyBeanUtils.copyBeanNotNull2Bean(t,busProjectManager);
			busProjectManagerService.doUpdateStatusBus(busProjectManager);
//			vmBusProjectManagerService.doUpdateStatusBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目确认审核失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-刷新
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doReload")
	@ResponseBody
	public AjaxJson doReload(VmBusProjectManagerEntity vmBusProjectManager, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "刷新成功";
		VmBusProjectManagerEntity t = vmBusProjectManagerService.get(VmBusProjectManagerEntity.class, vmBusProjectManager.getId());
		try{
			vmBusProjectManagerService.doReloadBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "刷新失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="项目管理视图列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VmBusProjectManagerPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VmBusProjectManagerEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VmBusProjectManagerEntity> list = this.vmBusProjectManagerService.getListByCriteriaQuery(query,true);
    	List<VmBusProjectManagerPage> pageList=new ArrayList<VmBusProjectManagerPage>();
        if(list!=null&&list.size()>0){
        	for(VmBusProjectManagerEntity entity:list){
        		try{
        			VmBusProjectManagerPage page=new VmBusProjectManagerPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from VmBusCollectPlanEntity where 1 = 1 AND fromId = ? ";
	    			List<VmBusCollectPlanEntity> vmBusCollectPlanOldList = this.vmBusProjectManagerService.findHql(hql0,id0);
            		page.setVmBusCollectPlanList(vmBusCollectPlanOldList);
				     String hql1 = "from BusProjectFollowEntity_manager where 1 = 1 AND fromId = ? ";
	    			List<BusProjectFollowEntity_manager> busProjectFollowOldList = this.vmBusProjectManagerService.findHql(hql1,id1);
            		page.setBusProjectFollowList(busProjectFollowOldList);
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
	@ApiOperation(value="根据ID获取项目管理视图信息",notes="根据ID获取项目管理视图信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VmBusProjectManagerEntity task = vmBusProjectManagerService.get(VmBusProjectManagerEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取项目管理视图信息为空");
		}
		VmBusProjectManagerPage page = new VmBusProjectManagerPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from VmBusCollectPlanEntity where 1 = 1 AND fromId = ? ";
			List<VmBusCollectPlanEntity> vmBusCollectPlanOldList = this.vmBusProjectManagerService.findHql(hql0,id0);
    		page.setVmBusCollectPlanList(vmBusCollectPlanOldList);
		    String hql1 = "from BusProjectFollowEntity_manager where 1 = 1 AND fromId = ? ";
			List<BusProjectFollowEntity_manager> busProjectFollowOldList = this.vmBusProjectManagerService.findHql(hql1,id1);
    		page.setBusProjectFollowList(busProjectFollowOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建项目管理视图")
	public ResponseMessage<?> create(@ApiParam(name="项目管理视图对象")@RequestBody VmBusProjectManagerPage vmBusProjectManagerPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusProjectManagerPage>> failures = validator.validate(vmBusProjectManagerPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VmBusCollectPlanEntity> vmBusCollectPlanList =  vmBusProjectManagerPage.getVmBusCollectPlanList();
		List<BusProjectFollowEntity_manager> busProjectFollowList =  vmBusProjectManagerPage.getBusProjectFollowList();
		
		VmBusProjectManagerEntity vmBusProjectManager = new VmBusProjectManagerEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vmBusProjectManagerPage,vmBusProjectManager);
			vmBusProjectManagerService.addMain(vmBusProjectManager, vmBusCollectPlanList,busProjectFollowList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存项目管理视图失败");
        }

		return Result.success(vmBusProjectManager);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新项目管理视图",notes="更新项目管理视图")
	public ResponseMessage<?> update(@RequestBody VmBusProjectManagerPage vmBusProjectManagerPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusProjectManagerPage>> failures = validator.validate(vmBusProjectManagerPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VmBusCollectPlanEntity> vmBusCollectPlanList =  vmBusProjectManagerPage.getVmBusCollectPlanList();
		List<BusProjectFollowEntity_manager> busProjectFollowList =  vmBusProjectManagerPage.getBusProjectFollowList();
		
		VmBusProjectManagerEntity vmBusProjectManager = new VmBusProjectManagerEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vmBusProjectManagerPage,vmBusProjectManager);
			vmBusProjectManagerService.updateMain(vmBusProjectManager, vmBusCollectPlanList,busProjectFollowList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("项目管理视图更新失败");
        }

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除项目管理视图")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			VmBusProjectManagerEntity vmBusProjectManager = vmBusProjectManagerService.get(VmBusProjectManagerEntity.class, id);
			vmBusProjectManagerService.delMain(vmBusProjectManager);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("项目管理视图删除失败");
		}

		return Result.success();
	}
}
