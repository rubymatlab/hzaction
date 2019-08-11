package com.action.actpo.controller;
import com.action.actpo.entity.VmBusPoContractEntity;
import com.action.actpo.service.BusPoContractServiceI;
import com.action.actpo.service.VmBusPoContractServiceI;
import com.action.actpo.page.VmBusPoContractPage;
import com.action.actpo.entity.VmMergeBusPoApplyDetailEntity;
import com.action.actpo.entity.BusPoContractPayEntity;
import com.action.actpo.entity.BusPoApplyDetailConEntity;
import com.action.actpo.entity.BusPoContractDetailEntity;
import com.action.actpo.entity.BusPoContractEntity;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
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
import com.alibaba.fastjson.JSONObject;

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
 * @Description: 采购合同视图
 * @author onlineGenerator
 * @date 2019-07-30 13:14:33
 * @version V1.0   
 *
 */
@Api(value="VmBusPoContract",description="采购合同视图",tags="vmBusPoContractController")
@Controller
@RequestMapping("/vmBusPoContractController")
public class VmBusPoContractController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VmBusPoContractController.class);

	@Autowired
	private VmBusPoContractServiceI vmBusPoContractService;
	@Autowired
	private BusPoContractServiceI busPoContractService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private Validator validator;

	/**
	 * 采购合同视图列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actpo/vmBusPoContractList");
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
	public void datagrid(VmBusPoContractEntity vmBusPoContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VmBusPoContractEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusPoContract, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vmBusPoContractService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
		@RequestMapping(value = "loadSuggestData")
		@ResponseBody
		public Object loadSuggestData(String type, String keyword,HttpServletRequest request) {
			String sql = "";
			if(type.equals("project")) {
				sql = "select bp.bp_proj_id as bpm_proj_id, bp.bp_proj_name as bpm_proj_name from bus_project_manager as bpm, bus_project as bp where bp.id = bpm.from_proj_id"
						+ "	and bp.bp_proj_name like '%" +keyword+"%'";
			}else if(type.equals("supplier")){
				sql = "select bs_name, bs_contact, bs_tel_no from bas_supplier where bs_name like '%"+ keyword +"%'";
			}
	
			return getResultSet(sql);
		}
		
	
	//	获取结果集
		public Object getResultSet(String sql) {
			JSONObject object = new JSONObject();
			object.put("message", "");
			try {
				List<Map<String,Object>> data = this.systemService.findForJdbc(sql);
				for (Map<String, Object> map : data) {
					for (String key : map.keySet()) {
						if(null == map.get(key)){
							map.put(key,"");
						}
					}
				}
	
				net.sf.json.JSONArray array = net.sf.json.JSONArray.fromObject(data);
				object.put("value", array);
				object.put("code", 200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			object.put("redirect", "");
			return object;
		}
		
	
	/**
	 * 删除采购合同视图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VmBusPoContractEntity vmBusPoContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vmBusPoContract = systemService.getEntity(VmBusPoContractEntity.class, vmBusPoContract.getId());
		String message = "采购合同视图删除成功";
		try{
			BusPoContractEntity busPoContract = new BusPoContractEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vmBusPoContract,busPoContract);
			busPoContractService.delMain(busPoContract);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购合同视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除采购合同视图
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "采购合同视图删除成功";
		try{
			for(String id:ids.split(",")){
				VmBusPoContractEntity vmBusPoContract = systemService.getEntity(VmBusPoContractEntity.class,
				id
				);
				BusPoContractEntity busPoContract = new BusPoContractEntity();
				MyBeanUtils.copyBeanNotNull2Bean(vmBusPoContract,busPoContract);
				busPoContractService.delMain(busPoContract);
//				vmBusPoContractService.delMain(vmBusPoContract);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "采购合同视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加采购合同视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VmBusPoContractEntity vmBusPoContract,VmBusPoContractPage vmBusPoContractPage, HttpServletRequest request) {
		List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList =  vmBusPoContractPage.getVmMergeBusPoApplyDetailList();
		List<BusPoContractPayEntity> busPoContractPayList =  vmBusPoContractPage.getBusPoContractPayList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  vmBusPoContractPage.getBusPoContractDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			// 添加流水号	-->   AX-年份-客户简称-三位序列号-CG-001 --> 项目编号+ -CG-001 
			String proj_id = vmBusPoContract.getBpmProjId();// 项目编号
			String sql = "select bpc_po_no, bpm_proj_id from vm_bus_po_contract where bpm_proj_id='"+ proj_id +"' ORDER BY create_date desc limit 1";
			List<Map<String,Object>> data = this.systemService.findForJdbc(sql);
			String snameNo = "001";
			if(data.size() != 0) {
				String[] tempArr = data.get(0).get("bpc_po_no").toString().split("-");
				int cur = Integer.parseInt(tempArr[tempArr.length-1]);
				snameNo = ++cur + "";
				if(snameNo.length() == 1) {
					snameNo = "00"+snameNo;
				}
				if(snameNo.length() == 2){
					snameNo = "0"+snameNo;
				}
			}
			
			int year =Calendar.getInstance().get(Calendar.YEAR);

			String pipeNum = proj_id +"-CG-"+ snameNo;
			
			BusPoContractEntity busPoContract = new BusPoContractEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vmBusPoContract,busPoContract);
			busPoContract.setBpcPoNo(pipeNum);
			List<BusPoApplyDetailConEntity> busPoApplyDetailConList = new ArrayList<BusPoApplyDetailConEntity>();
			BusPoApplyDetailConEntity busPoApplyDetailConEntity = null;
			for(VmMergeBusPoApplyDetailEntity entity : vmMergeBusPoApplyDetailList) {
				busPoApplyDetailConEntity = new BusPoApplyDetailConEntity();
				busPoApplyDetailConEntity.setFromPoApplyDetId(entity.getId());// 采购申请明细
				busPoApplyDetailConList.add(busPoApplyDetailConEntity);
			}
			
			busPoContractService.addMain(busPoContract, busPoContractPayList,busPoApplyDetailConList,busPoContractDetailList);
			vmBusPoContract.setId(busPoContract.getId());
			//vmBusPoContractService.addMain(vmBusPoContract, vmMergeBusPoApplyDetailList,busPoContractPayList,busPoContractDetailList);
			
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购合同视图添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(vmBusPoContract);
		return j;
	}
	
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id busProjectDisfollow主键id
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
	
	/**
	 * 更新采购合同视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VmBusPoContractEntity vmBusPoContract,VmBusPoContractPage vmBusPoContractPage, HttpServletRequest request) {
		List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList =  vmBusPoContractPage.getVmMergeBusPoApplyDetailList();
		List<BusPoContractPayEntity> busPoContractPayList =  vmBusPoContractPage.getBusPoContractPayList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  vmBusPoContractPage.getBusPoContractDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			BusPoContractEntity busPoContract = new BusPoContractEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vmBusPoContract,busPoContract);
			List<BusPoApplyDetailConEntity> busPoApplyDetailConList = new ArrayList<BusPoApplyDetailConEntity>();
			BusPoApplyDetailConEntity busPoApplyDetailConEntity = null;
			for(VmMergeBusPoApplyDetailEntity entity : vmMergeBusPoApplyDetailList) {
				busPoApplyDetailConEntity = new BusPoApplyDetailConEntity();
				busPoApplyDetailConEntity.setFromPoApplyDetId(entity.getId());// 采购申请明细
				busPoApplyDetailConList.add(busPoApplyDetailConEntity);
			}
			busPoContractService.updateMain(busPoContract, busPoContractPayList,busPoApplyDetailConList,busPoContractDetailList);
//			vmBusPoContractService.updateMain(vmBusPoContract, vmMergeBusPoApplyDetailList,busPoContractPayList,busPoContractDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新采购合同视图失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购合同视图新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VmBusPoContractEntity vmBusPoContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusPoContract.getId())) {
			vmBusPoContract = vmBusPoContractService.getEntity(VmBusPoContractEntity.class, vmBusPoContract.getId());
			req.setAttribute("vmBusPoContractPage", vmBusPoContract);
		}
		return new ModelAndView("com/action/actpo/vmBusPoContract-add");
	}
	
	/**
	 * 采购合同视图编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VmBusPoContractEntity vmBusPoContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vmBusPoContract.getId())) {
			vmBusPoContract = vmBusPoContractService.getEntity(VmBusPoContractEntity.class, vmBusPoContract.getId());
			req.setAttribute("vmBusPoContractPage", vmBusPoContract);
		}
		return new ModelAndView("com/action/actpo/vmBusPoContract-update");
	}
	
	
	/**
	 * 加载明细列表[采购申请明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "vmMergeBusPoApplyDetailList")
	public ModelAndView vmMergeBusPoApplyDetailList(VmBusPoContractEntity vmBusPoContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = vmBusPoContract.getId();
		//===================================================================================
		//查询-采购申请明细
	    String hql0 = "from VmMergeBusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("vmMergeBusPoApplyDetailList", vmMergeBusPoApplyDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actpo/vmMergeBusPoApplyDetailList");
	}
	/**
	 * 加载明细列表[采购合同付款明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPoContractPayList")
	public ModelAndView busPoContractPayList(VmBusPoContractEntity vmBusPoContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = vmBusPoContract.getId();
		//===================================================================================
		//查询-采购合同付款明细
	    String hql1 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusPoContractPayEntity> busPoContractPayEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("busPoContractPayList", busPoContractPayEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actpo/busPoContractPayList");
	}
	/**
	 * 加载明细列表[采购合同明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPoContractDetailList")
	public ModelAndView busPoContractDetailList(VmBusPoContractEntity vmBusPoContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = vmBusPoContract.getId();
		//===================================================================================
		//查询-采购合同明细
	    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusPoContractDetailEntity> busPoContractDetailEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("busPoContractDetailList", busPoContractDetailEntityList);
			// 总金额
			req.setAttribute("puredAmount", vmBusPoContract.getAllAmount());
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
    public String exportXls(VmBusPoContractEntity vmBusPoContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(VmBusPoContractEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vmBusPoContract);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<VmBusPoContractEntity> list=this.vmBusPoContractService.getListByCriteriaQuery(cq, false);
    	List<VmBusPoContractPage> pageList=new ArrayList<VmBusPoContractPage>();
        if(list!=null&&list.size()>0){
        	for(VmBusPoContractEntity entity:list){
        		try{
        		VmBusPoContractPage page=new VmBusPoContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from VmMergeBusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
        	        List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailEntityList = systemService.findHql(hql0,id0);
            		page.setVmMergeBusPoApplyDetailList(vmMergeBusPoApplyDetailEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
        	        List<BusPoContractPayEntity> busPoContractPayEntityList = systemService.findHql(hql1,id1);
            		page.setBusPoContractPayList(busPoContractPayEntityList);
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
        map.put(NormalExcelConstants.FILE_NAME,"采购合同视图");
        map.put(NormalExcelConstants.CLASS,VmBusPoContractPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("采购合同视图列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
     * 导入页面跳转（采购合同明细）
	 */
    
	@RequestMapping(params = "uploadContDetail")
	public ModelAndView uploadContDetail(HttpServletRequest req) {
		req.setAttribute("controller_name", "vmBusPoContractController");
		req.setAttribute("method_name", "importContDetailExcel");
		return new ModelAndView("com/action/actpo/con_imp_file");
	}
	/**
	 * 
     *	excel导入采购合同明细
     *	
     *
     * */
	
	@RequestMapping(params = "importContDetailExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importContDetailExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<BusPoContractDetailEntity> listBusPoContractDetailEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BusPoContractDetailEntity.class,params);
				j.setMsg("文件导入成功！");
				System.out.println(listBusPoContractDetailEntitys.get(0).getClass());
				j.setObj(listBusPoContractDetailEntitys);		
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
				List<VmBusPoContractPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), VmBusPoContractPage.class, params);
				VmBusPoContractEntity entity1=null;
				for (VmBusPoContractPage page : list) {
					entity1=new VmBusPoContractEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            vmBusPoContractService.addMain(entity1, page.getVmMergeBusPoApplyDetailList(),page.getBusPoContractPayList(),page.getBusPoContractDetailList());
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
		map.put(NormalExcelConstants.FILE_NAME,"采购合同视图");
		map.put(NormalExcelConstants.CLASS,VmBusPoContractPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("采购合同视图列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "vmBusPoContractController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="采购合同视图列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VmBusPoContractPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VmBusPoContractEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<VmBusPoContractEntity> list = this.vmBusPoContractService.getListByCriteriaQuery(query,true);
    	List<VmBusPoContractPage> pageList=new ArrayList<VmBusPoContractPage>();
        if(list!=null&&list.size()>0){
        	for(VmBusPoContractEntity entity:list){
        		try{
        			VmBusPoContractPage page=new VmBusPoContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
					Object id2 = entity.getId();
				     String hql0 = "from VmMergeBusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
	    			List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailOldList = this.vmBusPoContractService.findHql(hql0,id0);
            		page.setVmMergeBusPoApplyDetailList(vmMergeBusPoApplyDetailOldList);
				     String hql1 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
	    			List<BusPoContractPayEntity> busPoContractPayOldList = this.vmBusPoContractService.findHql(hql1,id1);
            		page.setBusPoContractPayList(busPoContractPayOldList);
				     String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
	    			List<BusPoContractDetailEntity> busPoContractDetailOldList = this.vmBusPoContractService.findHql(hql2,id2);
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
	@ApiOperation(value="根据ID获取采购合同视图信息",notes="根据ID获取采购合同视图信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VmBusPoContractEntity task = vmBusPoContractService.get(VmBusPoContractEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取采购合同视图信息为空");
		}
		VmBusPoContractPage page = new VmBusPoContractPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
		    String hql0 = "from VmMergeBusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
			List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailOldList = this.vmBusPoContractService.findHql(hql0,id0);
    		page.setVmMergeBusPoApplyDetailList(vmMergeBusPoApplyDetailOldList);
		    String hql1 = "from BusPoContractPayEntity where 1 = 1 AND fromId = ? ";
			List<BusPoContractPayEntity> busPoContractPayOldList = this.vmBusPoContractService.findHql(hql1,id1);
    		page.setBusPoContractPayList(busPoContractPayOldList);
		    String hql2 = "from BusPoContractDetailEntity where 1 = 1 AND fromId = ? ";
			List<BusPoContractDetailEntity> busPoContractDetailOldList = this.vmBusPoContractService.findHql(hql2,id2);
    		page.setBusPoContractDetailList(busPoContractDetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建采购合同视图")
	public ResponseMessage<?> create(@ApiParam(name="采购合同视图对象")@RequestBody VmBusPoContractPage vmBusPoContractPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusPoContractPage>> failures = validator.validate(vmBusPoContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList =  vmBusPoContractPage.getVmMergeBusPoApplyDetailList();
		List<BusPoContractPayEntity> busPoContractPayList =  vmBusPoContractPage.getBusPoContractPayList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  vmBusPoContractPage.getBusPoContractDetailList();
		
		VmBusPoContractEntity vmBusPoContract = new VmBusPoContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vmBusPoContractPage,vmBusPoContract);
			vmBusPoContractService.addMain(vmBusPoContract, vmMergeBusPoApplyDetailList,busPoContractPayList,busPoContractDetailList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存采购合同视图失败");
        }

		return Result.success(vmBusPoContract);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新采购合同视图",notes="更新采购合同视图")
	public ResponseMessage<?> update(@RequestBody VmBusPoContractPage vmBusPoContractPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VmBusPoContractPage>> failures = validator.validate(vmBusPoContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<VmMergeBusPoApplyDetailEntity> vmMergeBusPoApplyDetailList =  vmBusPoContractPage.getVmMergeBusPoApplyDetailList();
		List<BusPoContractPayEntity> busPoContractPayList =  vmBusPoContractPage.getBusPoContractPayList();
		List<BusPoContractDetailEntity> busPoContractDetailList =  vmBusPoContractPage.getBusPoContractDetailList();
		
		VmBusPoContractEntity vmBusPoContract = new VmBusPoContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(vmBusPoContractPage,vmBusPoContract);
			vmBusPoContractService.updateMain(vmBusPoContract, vmMergeBusPoApplyDetailList,busPoContractPayList,busPoContractDetailList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("采购合同视图更新失败");
        }

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除采购合同视图")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			VmBusPoContractEntity vmBusPoContract = vmBusPoContractService.get(VmBusPoContractEntity.class, id);
			vmBusPoContractService.delMain(vmBusPoContract);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("采购合同视图删除失败");
		}

		return Result.success();
	}
}
