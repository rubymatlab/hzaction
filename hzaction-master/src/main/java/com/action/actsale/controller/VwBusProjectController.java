package com.action.actsale.controller;
import com.action.actsale.entity.BusProjectDetailEntity;
import com.action.actsale.entity.BusProjectEntity;
import com.action.actsale.entity.BusProjectFollowEntity;
import com.action.actsale.entity.VwBusProjectEntity;
import com.action.actsale.page.VwBusProjectPage;
import com.action.actsale.service.BusProjectServiceI;
import com.action.actsale.service.VwBusProjectServiceI;

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
 * @Description: 项目立项视图
 * @author onlineGenerator
 * @date 2019-07-25 07:20:01
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
	 * 项目立项视图列表 页面跳转
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
	 * 删除项目立项视图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vwBusProject = systemService.getEntity(VwBusProjectEntity.class, vwBusProject.getId());
		String message = "项目立项视图删除成功";
		try{
			BusProjectEntity busProject=new BusProjectEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vwBusProject,busProject);
			busProjectService.delMain(busProject);
			//vwBusProjectService.delMain(vwBusProject);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目立项视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除项目立项视图
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "项目立项视图删除成功";
		try{
			for(String id:ids.split(",")){
				VwBusProjectEntity vwBusProject = systemService.getEntity(VwBusProjectEntity.class,
				id
				);
				BusProjectEntity busProject=new BusProjectEntity();
				MyBeanUtils.copyBeanNotNull2Bean(vwBusProject,busProject);
				busProjectService.delMain(busProject);
				//vwBusProjectService.delMain(vwBusProject);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目立项视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加项目立项视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwBusProjectEntity vwBusProject,VwBusProjectPage vwBusProjectPage, HttpServletRequest request) {
		List<BusProjectDetailEntity> busProjectDetailList =  vwBusProjectPage.getBusProjectDetailList();
		List<BusProjectFollowEntity> busProjectFollowList =  vwBusProjectPage.getBusProjectFollowList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			BusProjectEntity busProject=new BusProjectEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vwBusProject,busProject);
			busProjectService.addMain(busProject, busProjectFollowList, busProjectDetailList);
			//vwBusProjectService.addMain(vwBusProject, busProjectDetailList,busProjectFollowList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目立项视图添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新项目立项视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwBusProjectEntity vwBusProject,VwBusProjectPage vwBusProjectPage, HttpServletRequest request) {
		List<BusProjectDetailEntity> busProjectDetailList =  vwBusProjectPage.getBusProjectDetailList();
		List<BusProjectFollowEntity> busProjectFollowList =  vwBusProjectPage.getBusProjectFollowList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			BusProjectEntity busProject=new BusProjectEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vwBusProject,busProject);
			busProjectService.updateMain(busProject, busProjectFollowList, busProjectDetailList);
			//vwBusProjectService.updateMain(vwBusProject, busProjectDetailList,busProjectFollowList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新项目立项视图失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目立项视图新增页面跳转
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
	 * 项目立项视图编辑页面跳转
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
	 * 加载明细列表[项目费用明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busProjectDetailList")
	public ModelAndView busProjectDetailList(VwBusProjectEntity vwBusProject, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = vwBusProject.getId();
		//===================================================================================
		//查询-项目费用明细
	    String hql0 = "from BusProjectDetailEntity where 1 = 1 AND fromBpid = ? ";
	    try{
	    	List<BusProjectDetailEntity> busProjectDetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("busProjectDetailList", busProjectDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busProjectDetailList");
	}
	/**
	 * 加载明细列表[项目跟进分配]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busProjectFollowList")
	public ModelAndView busProjectFollowList(VwBusProjectEntity vwBusProject, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = vwBusProject.getId();
		//===================================================================================
		//查询-项目跟进分配
	    String hql1 = "from BusProjectFollowEntity where 1 = 1 AND fromBpid = ? ";
	    try{
	    	List<BusProjectFollowEntity> busProjectFollowEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("busProjectFollowList", busProjectFollowEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actsale/busProjectFollowList");
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
				    String hql0 = "from BusProjectDetailEntity where 1 = 1 AND fromBpid = ? ";
        	        List<BusProjectDetailEntity> busProjectDetailEntityList = systemService.findHql(hql0,id0);
            		page.setBusProjectDetailList(busProjectDetailEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from BusProjectFollowEntity where 1 = 1 AND fromBpid = ? ";
        	        List<BusProjectFollowEntity> busProjectFollowEntityList = systemService.findHql(hql1,id1);
            		page.setBusProjectFollowList(busProjectFollowEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"项目立项视图");
        map.put(NormalExcelConstants.CLASS,VwBusProjectPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("项目立项视图列表", "导出人:Jeecg",
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
		            vwBusProjectService.addMain(entity1, page.getBusProjectDetailList(),page.getBusProjectFollowList());
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
		map.put(NormalExcelConstants.FILE_NAME,"项目立项视图");
		map.put(NormalExcelConstants.CLASS,VwBusProjectPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("项目立项视图列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
	@RequestMapping(params = "doBtnAccess")
	@ResponseBody
	public AjaxJson doBtnAccess(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "立项转投标成功";
		VwBusProjectEntity t = vwBusProjectService.get(VwBusProjectEntity.class, vwBusProject.getId());
		try{
			//vwBusProjectService.doBtnAccessSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "立项转投标失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-立项转合同
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doBtnAccessContent")
	@ResponseBody
	public AjaxJson doBtnAccessContent(VwBusProjectEntity vwBusProject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "立项转合同成功";
		VwBusProjectEntity t = vwBusProjectService.get(VwBusProjectEntity.class, vwBusProject.getId());
		try{
			//vwBusProjectService.doBtnAccessContentSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "立项转合同失败";
		}
		j.setMsg(message);
		return j;
	}
 	
}
