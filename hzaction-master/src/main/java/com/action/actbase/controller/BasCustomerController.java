package com.action.actbase.controller;
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

import com.action.actbase.entity.BasCustomerContactsEntity;
import com.action.actbase.entity.BasCustomerEntity;
import com.action.actbase.page.BasCustomerPage;
import com.action.actbase.service.BasCustomerServiceI;
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
 * @Description: 客户资料
 * @author onlineGenerator
 * @date 2019-07-18 23:41:34
 * @version V1.0   
 *
 */
@Api(value="BasCustomer",description="客户资料",tags="basCustomerController")
@Controller
@RequestMapping("/basCustomerController")
public class BasCustomerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BasCustomerController.class);

	@Autowired
	private BasCustomerServiceI basCustomerService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 客户资料列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actbase/basCustomerList");
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
	public void datagrid(BasCustomerEntity basCustomer,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BasCustomerEntity.class, dataGrid);
		
		// 模糊查询
		if(StringUtil.isNotEmpty(basCustomer.getBcName())){
			basCustomer.setBcName("*"+basCustomer.getBcName()+"*");
		}
		if(StringUtil.isNotEmpty(basCustomer.getBcBankAcc())){
			basCustomer.setBcBankAcc("*"+basCustomer.getBcBankAcc()+"*");
		}
		if(StringUtil.isNotEmpty(basCustomer.getBcBankId())){
			basCustomer.setBcBankId("*"+basCustomer.getBcBankId()+"*");
		}
		if(StringUtil.isNotEmpty(basCustomer.getBcSname())){
			basCustomer.setBcSname("*"+basCustomer.getBcSname()+"*");
		}
		
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, basCustomer, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.basCustomerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除客户资料
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BasCustomerEntity basCustomer, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		basCustomer = systemService.getEntity(BasCustomerEntity.class, basCustomer.getId());
		String message = "客户资料删除成功";
		try{
			basCustomerService.delMain(basCustomer);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户资料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除客户资料
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "客户资料删除成功";
		try{
			for(String id:ids.split(",")){
				BasCustomerEntity basCustomer = systemService.getEntity(BasCustomerEntity.class,
				id
				);
				basCustomerService.delMain(basCustomer);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客户资料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加客户资料
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BasCustomerEntity basCustomer,BasCustomerPage basCustomerPage, HttpServletRequest request) {
		List<BasCustomerContactsEntity> basCustomerContactsList =  basCustomerPage.getBasCustomerContactsList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			basCustomerService.addMain(basCustomer, basCustomerContactsList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户资料添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新客户资料
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BasCustomerEntity basCustomer,BasCustomerPage basCustomerPage, HttpServletRequest request) {
		List<BasCustomerContactsEntity> basCustomerContactsList =  basCustomerPage.getBasCustomerContactsList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			basCustomerService.updateMain(basCustomer, basCustomerContactsList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新客户资料失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 客户资料新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BasCustomerEntity basCustomer, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(basCustomer.getId())) {
			basCustomer = basCustomerService.getEntity(BasCustomerEntity.class, basCustomer.getId());
			req.setAttribute("basCustomerPage", basCustomer);
		}
		return new ModelAndView("com/action/actbase/basCustomer-add");
	}
	
	/**
	 * 客户资料编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BasCustomerEntity basCustomer, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(basCustomer.getId())) {
			basCustomer = basCustomerService.getEntity(BasCustomerEntity.class, basCustomer.getId());
			req.setAttribute("basCustomerPage", basCustomer);
		}
		return new ModelAndView("com/action/actbase/basCustomer-update");
	}
	
	
	/**
	 * 加载明细列表[客户资料明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "basCustomerContactsList")
	public ModelAndView basCustomerContactsList(BasCustomerEntity basCustomer, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = basCustomer.getId();
		//===================================================================================
		//查询-客户资料明细
	    String hql0 = "from BasCustomerContactsEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BasCustomerContactsEntity> basCustomerContactsEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("basCustomerContactsList", basCustomerContactsEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actbase/basCustomerContactsList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(BasCustomerEntity basCustomer,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(BasCustomerEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, basCustomer);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<BasCustomerEntity> list=this.basCustomerService.getListByCriteriaQuery(cq, false);
    	List<BasCustomerPage> pageList=new ArrayList<BasCustomerPage>();
        if(list!=null&&list.size()>0){
        	for(BasCustomerEntity entity:list){
        		try{
        		BasCustomerPage page=new BasCustomerPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BasCustomerContactsEntity where 1 = 1 AND fromId = ? ";
        	        List<BasCustomerContactsEntity> basCustomerContactsEntityList = systemService.findHql(hql0,id0);
            		page.setBasCustomerContactsList(basCustomerContactsEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"客户资料");
        map.put(NormalExcelConstants.CLASS,BasCustomerPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("客户资料列表", "导出人:Jeecg",
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
				List<BasCustomerPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), BasCustomerPage.class, params);
				BasCustomerEntity entity1=null;
				for (BasCustomerPage page : list) {
					entity1=new BasCustomerEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            basCustomerService.addMain(entity1, page.getBasCustomerContactsList());
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
		map.put(NormalExcelConstants.FILE_NAME,"客户资料");
		map.put(NormalExcelConstants.CLASS,BasCustomerPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("客户资料列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "basCustomerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="客户资料列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BasCustomerPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(BasCustomerEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<BasCustomerEntity> list = this.basCustomerService.getListByCriteriaQuery(query,true);
    	List<BasCustomerPage> pageList=new ArrayList<BasCustomerPage>();
        if(list!=null&&list.size()>0){
        	for(BasCustomerEntity entity:list){
        		try{
        			BasCustomerPage page=new BasCustomerPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from BasCustomerContactsEntity where 1 = 1 AND fromId = ? ";
	    			List<BasCustomerContactsEntity> basCustomerContactsOldList = this.basCustomerService.findHql(hql0,id0);
            		page.setBasCustomerContactsList(basCustomerContactsOldList);
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
	@ApiOperation(value="根据ID获取客户资料信息",notes="根据ID获取客户资料信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BasCustomerEntity task = basCustomerService.get(BasCustomerEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取客户资料信息为空");
		}
		BasCustomerPage page = new BasCustomerPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from BasCustomerContactsEntity where 1 = 1 AND fromId = ? ";
			List<BasCustomerContactsEntity> basCustomerContactsOldList = this.basCustomerService.findHql(hql0,id0);
    		page.setBasCustomerContactsList(basCustomerContactsOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建客户资料")
	public ResponseMessage<?> create(@ApiParam(name="客户资料对象")@RequestBody BasCustomerPage basCustomerPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BasCustomerPage>> failures = validator.validate(basCustomerPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BasCustomerContactsEntity> basCustomerContactsList =  basCustomerPage.getBasCustomerContactsList();
		
		BasCustomerEntity basCustomer = new BasCustomerEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(basCustomerPage,basCustomer);
			basCustomerService.addMain(basCustomer, basCustomerContactsList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存客户资料失败");
        }

		return Result.success(basCustomer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新客户资料",notes="更新客户资料")
	public ResponseMessage<?> update(@RequestBody BasCustomerPage basCustomerPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BasCustomerPage>> failures = validator.validate(basCustomerPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BasCustomerContactsEntity> basCustomerContactsList =  basCustomerPage.getBasCustomerContactsList();
		
		BasCustomerEntity basCustomer = new BasCustomerEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(basCustomerPage,basCustomer);
			basCustomerService.updateMain(basCustomer, basCustomerContactsList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("客户资料更新失败");
        }

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除客户资料")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			BasCustomerEntity basCustomer = basCustomerService.get(BasCustomerEntity.class, id);
			basCustomerService.delMain(basCustomer);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("客户资料删除失败");
		}

		return Result.success();
	}
}
