package com.action.actaccount.controller;
import com.action.actaccount.entity.VwRpCostAccountEntity;
import com.action.actaccount.service.VwRpCostAccountServiceI;
import com.action.actaccount.page.VwRpCostAccountPage;
import com.action.actaccount.entity.VwBusPoContractPayEntity;
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
 * @Description: vw_rp_cost_account
 * @author onlineGenerator
 * @date 2019-09-01 10:48:56
 * @version V1.0   
 *
 */
@Api(value="VwRpCostAccount",description="vw_rp_cost_account",tags="vwRpCostAccountController")
@Controller
@RequestMapping("/vwRpCostAccountController")
public class VwRpCostAccountController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwRpCostAccountController.class);

	@Autowired
	private VwRpCostAccountServiceI vwRpCostAccountService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * vw_rp_cost_account列表 页面跳转
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
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwRpCostAccount, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwRpCostAccountService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除vw_rp_cost_account
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwRpCostAccountEntity vwRpCostAccount, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vwRpCostAccount = systemService.getEntity(VwRpCostAccountEntity.class, vwRpCostAccount.getId());
		String message = "vw_rp_cost_account删除成功";
		try{
			vwRpCostAccountService.delMain(vwRpCostAccount);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "vw_rp_cost_account删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除vw_rp_cost_account
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "vw_rp_cost_account删除成功";
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
			message = "vw_rp_cost_account删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加vw_rp_cost_account
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwRpCostAccountEntity vwRpCostAccount,VwRpCostAccountPage vwRpCostAccountPage, HttpServletRequest request) {
		List<VwBusPoContractPayEntity> vwBusPoContractPayList =  vwRpCostAccountPage.getVwBusPoContractPayList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			vwRpCostAccountService.addMain(vwRpCostAccount, vwBusPoContractPayList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "vw_rp_cost_account添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新vw_rp_cost_account
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwRpCostAccountEntity vwRpCostAccount,VwRpCostAccountPage vwRpCostAccountPage, HttpServletRequest request) {
		List<VwBusPoContractPayEntity> vwBusPoContractPayList =  vwRpCostAccountPage.getVwBusPoContractPayList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			vwRpCostAccountService.updateMain(vwRpCostAccount, vwBusPoContractPayList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新vw_rp_cost_account失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * vw_rp_cost_account新增页面跳转
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
	 * vw_rp_cost_account编辑页面跳转
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
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"vw_rp_cost_account");
        map.put(NormalExcelConstants.CLASS,VwRpCostAccountPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("vw_rp_cost_account列表", "导出人:Jeecg",
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
				List<VwRpCostAccountPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), VwRpCostAccountPage.class, params);
				VwRpCostAccountEntity entity1=null;
				for (VwRpCostAccountPage page : list) {
					entity1=new VwRpCostAccountEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            vwRpCostAccountService.addMain(entity1, page.getVwBusPoContractPayList());
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
		map.put(NormalExcelConstants.FILE_NAME,"vw_rp_cost_account");
		map.put(NormalExcelConstants.CLASS,VwRpCostAccountPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("vw_rp_cost_account列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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

 	
 	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="vw_rp_cost_account列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VwRpCostAccountPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VwRpCostAccountEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VwRpCostAccountEntity> list = this.vwRpCostAccountService.getListByCriteriaQuery(query,true);
    	List<VwRpCostAccountPage> pageList=new ArrayList<VwRpCostAccountPage>();
        if(list!=null&&list.size()>0){
        	for(VwRpCostAccountEntity entity:list){
        		try{
        			VwRpCostAccountPage page=new VwRpCostAccountPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from VwBusPoContractPayEntity where 1 = 1 AND formCostAccountId = ? ";
	    			List<VwBusPoContractPayEntity> vwBusPoContractPayOldList = this.vwRpCostAccountService.findHql(hql0,id0);
            		page.setVwBusPoContractPayList(vwBusPoContractPayOldList);
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
	@ApiOperation(value="根据ID获取vw_rp_cost_account信息",notes="根据ID获取vw_rp_cost_account信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VwRpCostAccountEntity task = vwRpCostAccountService.get(VwRpCostAccountEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取vw_rp_cost_account信息为空");
		}
		VwRpCostAccountPage page = new VwRpCostAccountPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from VwBusPoContractPayEntity where 1 = 1 AND formCostAccountId = ? ";
			List<VwBusPoContractPayEntity> vwBusPoContractPayOldList = this.vwRpCostAccountService.findHql(hql0,id0);
    		page.setVwBusPoContractPayList(vwBusPoContractPayOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建vw_rp_cost_account")
	public ResponseMessage<?> create(@ApiParam(name="vw_rp_cost_account对象")@RequestBody VwRpCostAccountPage vwRpCostAccountPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwRpCostAccountPage>> failures = validator.validate(vwRpCostAccountPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VwBusPoContractPayEntity> vwBusPoContractPayList =  vwRpCostAccountPage.getVwBusPoContractPayList();
		
		VwRpCostAccountEntity vwRpCostAccount = new VwRpCostAccountEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vwRpCostAccountPage,vwRpCostAccount);
			vwRpCostAccountService.addMain(vwRpCostAccount, vwBusPoContractPayList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存vw_rp_cost_account失败");
        }

		return Result.success(vwRpCostAccount);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新vw_rp_cost_account",notes="更新vw_rp_cost_account")
	public ResponseMessage<?> update(@RequestBody VwRpCostAccountPage vwRpCostAccountPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwRpCostAccountPage>> failures = validator.validate(vwRpCostAccountPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VwBusPoContractPayEntity> vwBusPoContractPayList =  vwRpCostAccountPage.getVwBusPoContractPayList();
		
		VwRpCostAccountEntity vwRpCostAccount = new VwRpCostAccountEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vwRpCostAccountPage,vwRpCostAccount);
			vwRpCostAccountService.updateMain(vwRpCostAccount, vwBusPoContractPayList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("vw_rp_cost_account更新失败");
        }

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除vw_rp_cost_account")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			VwRpCostAccountEntity vwRpCostAccount = vwRpCostAccountService.get(VwRpCostAccountEntity.class, id);
			vwRpCostAccountService.delMain(vwRpCostAccount);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("vw_rp_cost_account删除失败");
		}

		return Result.success();
	}
}
