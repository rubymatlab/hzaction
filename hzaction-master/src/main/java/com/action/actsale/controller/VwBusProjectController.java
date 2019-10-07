package com.action.actsale.controller;
import com.action.actsale.entity.VwBusProjectEntity;
import com.action.actsale.service.BusProjectServiceI;
import com.action.actsale.service.VwBusProjectServiceI;
import com.action.actsale.page.VwBusProjectPage;
import com.action.actsale.entity.BusProjectFeeDetailEntity;
import com.action.actsale.entity.BusProjectDisfollowEntity;
import com.action.actsale.entity.BusProjectEntity;
import com.action.actsale.entity.BusProjPartnerEntity;
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


/**   
 * @Title: Controller
 * @Description: 项目立项
 * @author onlineGenerator
 * @date 2019-08-14 22:03:22
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vwBusProjectController")
public class VwBusProjectController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwBusProjectController.class);

	@Autowired
	private VwBusProjectServiceI vwBusProjectService;
	@Autowired
	private BusProjectServiceI busProjectService;
	@Autowired
	private SystemService systemService;

	/**
	 * 项目立项列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actsale/vwBusProjectList");
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
	public void datagrid(VwBusProjectEntity vwBusProject,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwBusProjectEntity.class, dataGrid);
		// 模糊查询
		
		if(StringUtil.isNotEmpty(vwBusProject.getBpManager())){
			vwBusProject.setBpManager("*"+vwBusProject.getBpManager()+"*");
		}
		if(StringUtil.isNotEmpty(vwBusProject.getBpProjName())){
			vwBusProject.setBpProjName("*"+vwBusProject.getBpProjName()+"*");
		}
		if(StringUtil.isNotEmpty(vwBusProject.getBpProjId())){
			vwBusProject.setBpProjId("*"+vwBusProject.getBpProjId()+"*");
		}
//		跟进结果
		if(StringUtil.isNotEmpty(vwBusProject.getBpFollowResults())){
			vwBusProject.setBpFollowResults("*"+vwBusProject.getBpFollowResults()+"*");
		}
		
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusProject, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vwBusProjectService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目立项
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//vwBusProject = systemService.getEntity(VwBusProjectEntity.class, vwBusProject.getId());
		BusProjectEntity busProject=systemService.getEntity(BusProjectEntity.class, vwBusProject.getId());
		String message = "项目立项删除成功";
		try{
			busProjectService.delMain(busProject);
			//vwBusProjectService.delMain(vwBusProject);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目立项删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除项目立项
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "项目立项删除成功";
		try{
			for(String id:ids.split(",")){
				/*
				 * VwBusProjectEntity vwBusProject =
				 * systemService.getEntity(VwBusProjectEntity.class, id );
				 */
				BusProjectEntity busProject=systemService.getEntity(BusProjectEntity.class, id);
				if(busProject.getBpmStatus().equals("1"))
					busProjectService.delMain(busProject);
				else
				{
					message="项目在处理、或已完成，不能删除";
					break;
				}
				//vwBusProjectService.delMain(vwBusProject);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目立项删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加项目立项
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwBusProjectEntity vwBusProject,VwBusProjectPage vwBusProjectPage, HttpServletRequest request) {
		List<BusProjectFeeDetailEntity> busProjectFeeDetailList =  vwBusProjectPage.getBusProjectFeeDetailList();
		List<BusProjectDisfollowEntity> busProjectDisfollowList =  vwBusProjectPage.getBusProjectDisfollowList();
		List<BusProjPartnerEntity> busProjPartnerList =  vwBusProjectPage.getBusProjPartnerList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			BusProjectEntity busProject=new BusProjectEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vwBusProject,busProject);
			busProjectService.addMain(busProject, busProjectFeeDetailList,busProjectDisfollowList,busProjPartnerList);
			//vwBusProjectService.addMain(vwBusProject, busProjectFeeDetailList,busProjectDisfollowList,busProjPartnerList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目立项添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新项目立项
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwBusProjectEntity vwBusProject,VwBusProjectPage vwBusProjectPage, HttpServletRequest request) {
		List<BusProjectFeeDetailEntity> busProjectFeeDetailList =  vwBusProjectPage.getBusProjectFeeDetailList();
		List<BusProjectDisfollowEntity> busProjectDisfollowList =  vwBusProjectPage.getBusProjectDisfollowList();
		List<BusProjPartnerEntity> busProjPartnerList =  vwBusProjectPage.getBusProjPartnerList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			BusProjectEntity busProject=busProjectService.getEntity(BusProjectEntity.class, vwBusProject.getId());
			MyBeanUtils.copyBeanNotNull2Bean(vwBusProject,busProject);
			busProjectService.updateMain(busProject, busProjectFeeDetailList,busProjectDisfollowList,busProjPartnerList);
			//vwBusProjectService.updateMain(vwBusProject, busProjectFeeDetailList,busProjectDisfollowList,busProjPartnerList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新项目立项失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目立项新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwBusProjectEntity vwBusProject, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusProject.getId())) {
			vwBusProject = vwBusProjectService.getEntity(VwBusProjectEntity.class, vwBusProject.getId());
			req.setAttribute("vwBusProjectPage", vwBusProject);
		}
		return new ModelAndView("com/action/actsale/vwBusProject-add");
	}
	
	/**
	 * 项目立项编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwBusProjectEntity vwBusProject, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusProject.getId())) {
			vwBusProject = vwBusProjectService.getEntity(VwBusProjectEntity.class, vwBusProject.getId());
			req.setAttribute("vwBusProjectPage", vwBusProject);
		}
		return new ModelAndView("com/action/actsale/vwBusProject-update");
	}
	
	
	/**
	 * 加载明细列表[项目立项费用明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busProjectFeeDetailList")
	public ModelAndView busProjectFeeDetailList(VwBusProjectEntity vwBusProject, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = vwBusProject.getId();
		//===================================================================================
		//查询-项目立项费用明细
	    String hql0 = "from BusProjectFeeDetailEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusProjectFeeDetailEntity> busProjectFeeDetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("busProjectFeeDetailList", busProjectFeeDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busProjectFeeDetailList");
	}
	/**
	 * 加载明细列表[分配跟进明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busProjectDisfollowList")
	public ModelAndView busProjectDisfollowList(VwBusProjectEntity vwBusProject, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = vwBusProject.getId();
		//===================================================================================
		//查询-分配跟进明细
	    String hql1 = "from BusProjectDisfollowEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusProjectDisfollowEntity> busProjectDisfollowEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("busProjectDisfollowList", busProjectDisfollowEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busProjectDisfollowList");
	}
	/**
	 * 加载明细列表[立项合作伙伴资料]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busProjPartnerList")
	public ModelAndView busProjPartnerList(VwBusProjectEntity vwBusProject, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = vwBusProject.getId();
		//===================================================================================
		//查询-立项合作伙伴资料
	    String hql2 = "from BusProjPartnerEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusProjPartnerEntity> busProjPartnerEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("busProjPartnerList", busProjPartnerEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busProjPartnerList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(VwBusProjectEntity vwBusProject,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(VwBusProjectEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusProject);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<VwBusProjectEntity> list=this.vwBusProjectService.getListByCriteriaQuery(cq, false);
    	List<VwBusProjectPage> pageList=new ArrayList<VwBusProjectPage>();
        if(list!=null&&list.size()>0){
        	for(VwBusProjectEntity entity:list){
        		try{
        		VwBusProjectPage page=new VwBusProjectPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BusProjectFeeDetailEntity where 1 = 1 AND fromId = ? ";
        	        List<BusProjectFeeDetailEntity> busProjectFeeDetailEntityList = systemService.findHql(hql0,id0);
            		page.setBusProjectFeeDetailList(busProjectFeeDetailEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from BusProjectDisfollowEntity where 1 = 1 AND fromId = ? ";
        	        List<BusProjectDisfollowEntity> busProjectDisfollowEntityList = systemService.findHql(hql1,id1);
            		page.setBusProjectDisfollowList(busProjectDisfollowEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from BusProjPartnerEntity where 1 = 1 AND fromId = ? ";
        	        List<BusProjPartnerEntity> busProjPartnerEntityList = systemService.findHql(hql2,id2);
            		page.setBusProjPartnerList(busProjPartnerEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"项目立项");
        map.put(NormalExcelConstants.CLASS,VwBusProjectPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("项目立项列表", "导出人:Jeecg",
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
				List<VwBusProjectPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), VwBusProjectPage.class, params);
				VwBusProjectEntity entity1=null;
				for (VwBusProjectPage page : list) {
					entity1=new VwBusProjectEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
					
					BusProjectEntity busProject=new BusProjectEntity();
					MyBeanUtils.copyBeanNotNull2Bean(entity1,busProject);
					busProjectService.addMain(busProject, page.getBusProjectFeeDetailList(),page.getBusProjectDisfollowList(),page.getBusProjPartnerList());
		            //vwBusProjectService.addMain(entity1, page.getBusProjectFeeDetailList(),page.getBusProjectDisfollowList(),page.getBusProjPartnerList());
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
		map.put(NormalExcelConstants.FILE_NAME,"项目立项");
		map.put(NormalExcelConstants.CLASS,VwBusProjectPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("项目立项列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "vwBusProjectController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-立项转投标
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doBid")
	@ResponseBody
	public AjaxJson doBid(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "立项转投标成功";
		VwBusProjectEntity t = vwBusProjectService.get(VwBusProjectEntity.class, vwBusProject.getId());
		try{
			//vwBusProjectService.doBidSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "立项转投标失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 自定义按钮-sql增强-转投已失败
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doFail")
	@ResponseBody
	public AjaxJson doFail(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "转已失败成功";
		//VwBusProjectEntity t = vwBusProjectService.get(VwBusProjectEntity.class, vwBusProject.getId())
		BusProjectEntity b=vwBusProjectService.getEntity(BusProjectEntity.class, vwBusProject.getId());
		try{
			b.setBpmStatus("4");
			systemService.saveOrUpdate(b);
			//vwBusProjectService.doBidSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "转已失败失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-立项转合同
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doContract")
	@ResponseBody
	public AjaxJson doContract(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "立项转合同成功";
		VwBusProjectEntity t = vwBusProjectService.get(VwBusProjectEntity.class, vwBusProject.getId());
		try{
			//vwBusProjectService.doContractSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "立项转合同失败";
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doCreateProjectId")
	@ResponseBody
	public AjaxJson doCreateProjectId(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "产生项目编号成功";
		//VwBusProjectEntity t = vwBusProjectService.get(VwBusProjectEntity.class, vwBusProject.getId());
		try{
			String hql="from VwBusProjectEntity as vw where vw.bpProjId like ?";
			List<VwBusProjectEntity> listVw=vwBusProjectService.findHql(hql, "%-"+vwBusProject.getId()+"-%");
			if(listVw.size()>1000)
				message=String.valueOf(listVw.size()+1);
			else
			{
				message=String.valueOf(listVw.size()+1);
				if(message.length()==1)
					message="00"+message;
				else if(message.length()==2)
					message="0"+message;
				else
					message=message;
			}
			//vwBusProjectService.doBidSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "产生项目编号失败";
		}
		j.setMsg(message);
		return j;
	}
 	
}
