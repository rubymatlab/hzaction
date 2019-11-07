package com.action.actaccount.controller;
import com.action.actaccount.entity.BsSubmitEntity;
import com.action.actaccount.service.BsSubmitServiceI;
import com.action.actaccount.service.VmBusPoPayWmtServiceI;
import com.action.actaccount.service.impl.VmBusPoPayWmtServiceImpl;
import com.action.actaccount.page.BsSubmitPage;
import com.action.actaccount.entity.BusSubmitDetailEntity;
import com.action.actaccount.entity.BusPayInfoEntity;
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
import org.jeecgframework.core.util.LogUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.util.ExpiredFiles;
import org.jeecgframework.web.system.util.HashMapDataTableUtil;
import org.jeecgframework.web.system.util.LicenseUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;

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

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller
 * @Description: 费用报销
 * @author onlineGenerator
 * @date 2019-09-22 16:05:41
 * @version V1.0   
 *
 */
@Api(value="BsSubmit",description="费用报销",tags="bsSubmitController")
@Controller
@RequestMapping("/bsSubmitController")
public class BsSubmitController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BsSubmitController.class);

	@Autowired
	private BsSubmitServiceI bsSubmitService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private VmBusPoPayWmtServiceI vmBusPoPayWmtService;

	/**
	 * 费用报销列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/bsSubmitList");
	}
	
	/**
	 * 费用报销列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list0")
	public ModelAndView list0(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/bsSubmitList0");
	}
	/**
	 * 费用报销列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list1")
	public ModelAndView list1(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/bsSubmitList1");
	}
	/**
	 * 费用报销列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		return new ModelAndView("com/action/actaccount/bsSubmitList2");
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
	public void datagrid(BsSubmitEntity bsSubmit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BsSubmitEntity.class, dataGrid);
		String bsState = request.getParameter("bsstate");
		bsSubmit.setBsState(bsState);
		//模糊查询-客户名称
		if(bsSubmit.getProjectName()!=null) {
			bsSubmit.setProjectName("*"+bsSubmit.getProjectName()+"*");
		}
		if(bsSubmit.getBsSubmiter()!=null) {
			bsSubmit.setBsSubmiter("*"+bsSubmit.getBsSubmiter()+"*");
		}
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bsSubmit, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.bsSubmitService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除费用报销
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BsSubmitEntity bsSubmit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bsSubmit = systemService.getEntity(BsSubmitEntity.class, bsSubmit.getId());
		String message = "费用报销删除成功";
		try{
			bsSubmitService.delMain(bsSubmit);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用报销删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 驳回费用报销
	 * 
	 * @return
	 */
	@RequestMapping(params = "doReturn")
	@ResponseBody
	public AjaxJson doReturn(BsSubmitEntity bsSubmit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bsSubmit = systemService.getEntity(BsSubmitEntity.class, bsSubmit.getId());
		String message = "驳回成功";
		try{
			bsSubmit.setBsState("0");
			bsSubmitService.saveOrUpdate(bsSubmit);
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
	 * 批量删除费用报销
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "费用报销删除成功";
		try{
			for(String id:ids.split(",")){
				BsSubmitEntity bsSubmit = systemService.getEntity(BsSubmitEntity.class,
				id
				);
				bsSubmitService.delMain(bsSubmit);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "费用报销删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加费用报销
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BsSubmitEntity bsSubmit,BsSubmitPage bsSubmitPage, HttpServletRequest request) {
		List<BusSubmitDetailEntity> busSubmitDetailList =  bsSubmitPage.getBusSubmitDetailList();
		List<BusPayInfoEntity> busPayInfoList =  bsSubmitPage.getBusPayInfoList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			bsSubmitService.addMain(bsSubmit, busSubmitDetailList,busPayInfoList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用报销添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(bsSubmit);
		return j;
	}
	/**
	 * 更新费用报销
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BsSubmitEntity bsSubmit,BsSubmitPage bsSubmitPage, HttpServletRequest request) {
		List<BusSubmitDetailEntity> busSubmitDetailList =  bsSubmitPage.getBusSubmitDetailList();
		List<BusPayInfoEntity> busPayInfoList =  bsSubmitPage.getBusPayInfoList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			bsSubmitService.updateMain(bsSubmit, busSubmitDetailList,busPayInfoList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新费用报销失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 费用报销新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BsSubmitEntity bsSubmit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bsSubmit.getId())) {
			bsSubmit = bsSubmitService.getEntity(BsSubmitEntity.class, bsSubmit.getId());
			req.setAttribute("bsSubmitPage", bsSubmit);
		}
		return new ModelAndView("com/action/actaccount/bsSubmit-add");
	}
	
	/**
	 * 费用报销编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BsSubmitEntity bsSubmit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bsSubmit.getId())) {
			bsSubmit = bsSubmitService.getEntity(BsSubmitEntity.class, bsSubmit.getId());
			req.setAttribute("bsSubmitPage", bsSubmit);
		}
		return new ModelAndView("com/action/actaccount/bsSubmit-update");
	}
	
	/**
	 * 支付页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate1")
	public ModelAndView goUpdate1(BsSubmitEntity bsSubmit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bsSubmit.getId())) {
			bsSubmit = bsSubmitService.getEntity(BsSubmitEntity.class, bsSubmit.getId());
			req.setAttribute("bsSubmitPage", bsSubmit);
		}
		return new ModelAndView("com/action/actaccount/bsSubmit-update1");
	}
	
	/**
	 * 加载明细列表[费用报销明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busSubmitDetailList")
	public ModelAndView busSubmitDetailList(BsSubmitEntity bsSubmit, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = bsSubmit.getId();
		//===================================================================================
		//查询-费用报销明细
	    String hql0 = "from BusSubmitDetailEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusSubmitDetailEntity> busSubmitDetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("busSubmitDetailList", busSubmitDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actaccount/busSubmitDetailList");
	}
	/**
	 * 加载明细列表[支付信息]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPayInfoList")
	public ModelAndView busPayInfoList(BsSubmitEntity bsSubmit, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = bsSubmit.getId();
		//===================================================================================
		//查询-支付信息
	    String hql1 = "from BusPayInfoEntity where 1 = 1 AND fromId = ? ";
	    try{
	    	List<BusPayInfoEntity> busPayInfoEntityList = systemService.findHql(hql1,id1);
	    	if(busPayInfoEntityList.size()==0)
	    		busPayInfoEntityList.add(new BusPayInfoEntity());
	    	for(BusPayInfoEntity o:busPayInfoEntityList)
	    	{
	    		o.setBpiClass("1");
	    		if(!StringUtil.isNotEmpty(o.getBpiVoucherno()))
	    		{
	    			String createBpiVoucherno = vmBusPoPayWmtService.getBpiVoucherno();
	    			o.setBpiVoucherno(createBpiVoucherno);
	    		}
	    	}
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
    public String exportXls(BsSubmitEntity bsSubmit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(BsSubmitEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bsSubmit);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<BsSubmitEntity> list=this.bsSubmitService.getListByCriteriaQuery(cq, false);
    	List<BsSubmitPage> pageList=new ArrayList<BsSubmitPage>();
        if(list!=null&&list.size()>0){
        	for(BsSubmitEntity entity:list){
        		try{
        		BsSubmitPage page=new BsSubmitPage();
        		   
        		MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BusSubmitDetailEntity where 1 = 1 AND fromId = ? ";
        	        List<BusSubmitDetailEntity> busSubmitDetailEntityList = systemService.findHql(hql0,id0);
        	        page.setBusSubmitDetailList(busSubmitDetailEntityList);
        	        
            	    Object id1 = entity.getId();
				    String hql1 = "from BusPayInfoEntity where 1 = 1 AND fromId = ? ";
        	        List<BusPayInfoEntity> busPayInfoEntityList = systemService.findHql(hql1,id1);
            		page.setBusPayInfoList(busPayInfoEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"费用报销");
        map.put(NormalExcelConstants.CLASS,BsSubmitPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("费用报销列表", "导出人:Jeecg",
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
				List<BsSubmitPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), BsSubmitPage.class, params);
				BsSubmitEntity entity1=null;
				for (BsSubmitPage page : list) {
					entity1=new BsSubmitEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            bsSubmitService.addMain(entity1, page.getBusSubmitDetailList(),page.getBusPayInfoList());
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
		map.put(NormalExcelConstants.FILE_NAME,"费用报销");
		map.put(NormalExcelConstants.CLASS,BsSubmitPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("费用报销列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "bsSubmitController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-送审
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUnaudited")
	@ResponseBody
	public AjaxJson doUnaudited(BsSubmitEntity bsSubmit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "送审成功";
		BsSubmitEntity t = bsSubmitService.get(BsSubmitEntity.class, bsSubmit.getId());
		try{
			t.setBsState("1");
			bsSubmitService.saveOrUpdate(t);
			//bsSubmitService.doUnauditedSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "送审失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-审核完成
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAudited")
	@ResponseBody
	public AjaxJson doAudited(BsSubmitEntity bsSubmit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "审核完成成功";
		BsSubmitEntity t = bsSubmitService.get(BsSubmitEntity.class, bsSubmit.getId());
		try{
			t.setBsState("2");
			bsSubmitService.saveOrUpdate(t);
			//bsSubmitService.doAuditedSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核完成失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-支付
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doPay")
	@ResponseBody
	public AjaxJson doPay(BsSubmitEntity bsSubmit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "支付成功";
		BsSubmitEntity t = bsSubmitService.get(BsSubmitEntity.class, bsSubmit.getId());
		try{
			//bsSubmitService.doPaySql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "支付失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-打印
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doPrint")
	@ResponseBody
	public AjaxJson doPrint(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "打印成功";
		
		try{
			if (!LicenseUtil.getLicense()) {
				LogUtil.info("获取License失败");
				j.setMsg("获取License失败");
				return j;
			}
			/*修改的部分*/
			String oldfilename="报销单.xlsx";
			String newfilename="报销单.pdf";
			/*end修改的部分*/	
			long old = System.currentTimeMillis();
			String templateFilePath = request.getServletContext().getRealPath("/")+"export\\template\\"+oldfilename;
			System.out.println(templateFilePath);
			Workbook wb = new Workbook(templateFilePath);// 原始excel路径
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);
			
			
			/*修改的部分*/
			String[] arrayId=ids.split(",");
			List<BsSubmitEntity> listBs=new ArrayList<BsSubmitEntity>();
			BsSubmitEntity bse=new BsSubmitEntity();
			List<BusSubmitDetailEntity> listB=new ArrayList<BusSubmitDetailEntity>();
			String str="";
			for(String id:arrayId)
			{
				//申请人、申请部门
				List<BsSubmitEntity> listO = bsSubmitService.findByProperty(BsSubmitEntity.class,"id", id);
				for(BsSubmitEntity o :listO)
				{
					if(bse.getBsSubmiter()==null)
						bse.setBsSubmiter(o.getBsSubmiter());
					else
						bse.setBsSubmiter(bse.getBsSubmiter()+","+o.getBsSubmiter());
					if(bse.getBsDept()==null)
						bse.setBsDept(o.getBsDept());
					else
						bse.setBsDept(bse.getBsDept()+","+o.getBsDept());
					//报销明细
					List<BusSubmitDetailEntity> listM=bsSubmitService.findByProperty(BusSubmitDetailEntity.class, "fromId", o.getId());
					double sum=0;
					for(BusSubmitDetailEntity m:listM)
					{
						BusSubmitDetailEntity temp=new BusSubmitDetailEntity();
						MyBeanUtils.copyBeanNotNull2Bean(m,temp);
						temp.setUpdateBy(o.getProjectName());
						sum+=m.getBsdAmount();
						listB.add(temp);
					}
					//项目汇总
					str+=o.getProjectName()+":"+sum+"元。";
				}
			}
			listBs.add(bse);
			// 绑定数据源
			designer.setDataSource("bsSubmit",listBs);
			designer.setDataSource("busSubmitDetail",listB);
			designer.setDataSource("str",str);
			designer.setCalculateFormula(true);
			// 执行
			designer.process(true);
			// 生成PDF
			String localTemp=request.getServletContext().getRealPath("/")+"temp\\";
			String exportPDF = localTemp+newfilename;
			File pdfFile = new File(exportPDF);// 输出路径
			FileOutputStream fileOS = new FileOutputStream(pdfFile);
			wb.save(fileOS, SaveFormat.PDF);
			fileOS.close();
			wb.dispose();
			/*end修改的部分*/
			//过期文件删除
			ExpiredFiles.Delete(localTemp);
			long now = System.currentTimeMillis();
			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
			String tempUrl=request.getRequestURL().toString();
			message=tempUrl.substring(0,tempUrl.lastIndexOf("/")+1)+"temp/"+newfilename;
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "打印失败";
		}
		
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(value="/list/{pageNo}/{pageSize}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="费用报销列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BsSubmitPage>> list(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if(pageSize>Globals.MAX_PAGESIZE){
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(BsSubmitEntity.class);
		query.setCurPage(pageNo<=0?1:pageNo);
		query.setPageSize(pageSize<1?1:pageSize);
		List<BsSubmitEntity> list = this.bsSubmitService.getListByCriteriaQuery(query,true);
    	List<BsSubmitPage> pageList=new ArrayList<BsSubmitPage>();
        if(list!=null&&list.size()>0){
        	for(BsSubmitEntity entity:list){
        		try{
        			BsSubmitPage page=new BsSubmitPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from BusSubmitDetailEntity where 1 = 1 AND fromId = ? ";
	    			List<BusSubmitDetailEntity> busSubmitDetailOldList = this.bsSubmitService.findHql(hql0,id0);
            		page.setBusSubmitDetailList(busSubmitDetailOldList);
				     String hql1 = "from BusPayInfoEntity where 1 = 1 AND fromId = ? ";
	    			List<BusPayInfoEntity> busPayInfoOldList = this.bsSubmitService.findHql(hql1,id1);
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
	@ApiOperation(value="根据ID获取费用报销信息",notes="根据ID获取费用报销信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BsSubmitEntity task = bsSubmitService.get(BsSubmitEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取费用报销信息为空");
		}
		BsSubmitPage page = new BsSubmitPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from BusSubmitDetailEntity where 1 = 1 AND fromId = ? ";
			List<BusSubmitDetailEntity> busSubmitDetailOldList = this.bsSubmitService.findHql(hql0,id0);
    		page.setBusSubmitDetailList(busSubmitDetailOldList);
		    String hql1 = "from BusPayInfoEntity where 1 = 1 AND fromId = ? ";
			List<BusPayInfoEntity> busPayInfoOldList = this.bsSubmitService.findHql(hql1,id1);
    		page.setBusPayInfoList(busPayInfoOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建费用报销")
	public ResponseMessage<?> create(@ApiParam(name="费用报销对象")@RequestBody BsSubmitPage bsSubmitPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BsSubmitPage>> failures = validator.validate(bsSubmitPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BusSubmitDetailEntity> busSubmitDetailList =  bsSubmitPage.getBusSubmitDetailList();
		List<BusPayInfoEntity> busPayInfoList =  bsSubmitPage.getBusPayInfoList();
		
		BsSubmitEntity bsSubmit = new BsSubmitEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(bsSubmitPage,bsSubmit);
			bsSubmitService.addMain(bsSubmit, busSubmitDetailList,busPayInfoList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存费用报销失败");
        }

		return Result.success(bsSubmit);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新费用报销",notes="更新费用报销")
	public ResponseMessage<?> update(@RequestBody BsSubmitPage bsSubmitPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BsSubmitPage>> failures = validator.validate(bsSubmitPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BusSubmitDetailEntity> busSubmitDetailList =  bsSubmitPage.getBusSubmitDetailList();
		List<BusPayInfoEntity> busPayInfoList =  bsSubmitPage.getBusPayInfoList();
		
		BsSubmitEntity bsSubmit = new BsSubmitEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(bsSubmitPage,bsSubmit);
			bsSubmitService.updateMain(bsSubmit, busSubmitDetailList,busPayInfoList);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("费用报销更新失败");
        }

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除费用报销")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			BsSubmitEntity bsSubmit = bsSubmitService.get(BsSubmitEntity.class, id);
			bsSubmitService.delMain(bsSubmit);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("费用报销删除失败");
		}

		return Result.success();
	}
	/**
	 * 获取文件附件信息
	 * 
	 * @param id bsSubmit主键id
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
	
	@RequestMapping(params = "doBsSubmitId")
	@ResponseBody
	public AjaxJson doBsSubmitId(String bpProjId, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "产生报销单号成功";
		try{
			String bsSubmitId=bsSubmitService.getBsSubmitId(bpProjId);
			int number=Integer.parseInt(bsSubmitId);
			if(number>1000)
				message=String.valueOf(number);
			else
			{
				message=String.valueOf(number);
				if(message.length()==1)
					message="00"+message;
				else if(message.length()==2)
					message="0"+message;
				else
					message=message;
			}
			message=bpProjId+"-BX-"+message;
		}catch(Exception e){
			e.printStackTrace();
			message = "产生报销单号失败";
		}
		j.setMsg(message);
		return j;
	}
}
