package com.action.actpo.controller;

import com.action.actpo.entity.VwBusPoApplyEntity;
import com.action.actpo.service.BusPoApplyServiceI;
import com.action.actpo.service.VwBusPoApplyServiceI;

import com.action.actpo.page.VwBusPoApplyPage;
import com.action.actbase.entity.BasAttachFileEntity;
import com.action.actbase.service.impl.BasAttachFileServiceImpl;
import com.action.actpo.entity.BusPoApplyDetailEntity;
import com.action.actpo.entity.BusPoApplyEntity;
import com.action.actpo.entity.ExcelBusPoApplyDetailEntity;

import java.util.ArrayList;
import java.util.Date;
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
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.swftools.SwfToolsUtil;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.FileUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import org.jeecgframework.web.cgform.service.upload.CgUploadServiceI;
import org.jeecgframework.web.system.pojo.base.TSAttachment;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.PinyinUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import com.jeecg.demo.entity.JeecgDemoExcelEntity;

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
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import java.sql.Timestamp;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;

/**
 * @Title: Controller
 * @Description: 采购申请视图
 * @author onlineGenerator
 * @date 2019-07-30 14:44:12
 * @version V1.0
 *
 */
@Api(value = "VwBusPoApply", description = "采购申请视图", tags = "vwBusPoApplyController")
@Controller
@RequestMapping("/vwBusPoApplyController")
public class VwBusPoApplyController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VwBusPoApplyController.class);

	@Autowired
	private VwBusPoApplyServiceI vwBusPoApplyService;
	@Autowired
	private BusPoApplyServiceI busBusPoApplyService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	JdbcDao jdbcDao;

	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private CgUploadServiceI cgUploadService;

	/**
	 * 采购申请视图列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "startPage")
	public ModelAndView startPage(HttpServletRequest request) {
		return new ModelAndView("com/action/actpo/tabsBusPoApply");
	}

	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String bpmStatus = request.getParameter("bpmStatus");
		ModelAndView mav = null;
		switch (bpmStatus) {
		case "0":
			mav = new ModelAndView("com/action/actpo/vwBusPoApplyList_Making");
			break;
		case "1":
			mav = new ModelAndView("com/action/actpo/vwBusPoApplyList_WaitReview");
			break;
		case "2":
			mav = new ModelAndView("com/action/actpo/vwBusPoApplyList_FinishReview");
			break;
		}
		return mav;
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
	public void datagrid(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VwBusPoApplyEntity.class, dataGrid);
		String state = request.getParameter("state");

		// String BpaState = null;

		switch (state) {
		case "0":
			// BpaState="0";
			cq.add(Restrictions.eq("bpaState", "0"));
			break;
		case "1":
			// BpaState="2";
			cq.add(Restrictions.eq("bpaState", "1"));
			break;
		case "2":
			// BpaState="6";
			cq.add(Restrictions.eq("bpaState", "2"));
			break;

		}

		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusPoApply,
				request.getParameterMap());
		try {
			// 自定义追加查询条件
			// cq.add(Restrictions.eq("bpaState", "0"));
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

		this.vwBusPoApplyService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除采购申请视图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		vwBusPoApply = systemService.getEntity(VwBusPoApplyEntity.class, vwBusPoApply.getId());
		String message = "采购申请视图删除成功";
		try {
			BusPoApplyEntity busPoApply = new BusPoApplyEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vwBusPoApply, busPoApply);
			busBusPoApplyService.delMain(busPoApply);
			// vwBusPoApplyService.delMain(vwBusPoApply);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "采购申请视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除采购申请视图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "采购申请视图删除成功";
		try {
			for (String id : ids.split(",")) {
				VwBusPoApplyEntity vwBusPoApply = systemService.getEntity(VwBusPoApplyEntity.class, id);
				vwBusPoApplyService.delMain(vwBusPoApply);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "采购申请视图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加采购申请视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VwBusPoApplyEntity vwBusPoApply, VwBusPoApplyPage vwBusPoApplyPage,
			HttpServletRequest request) {
		List<BusPoApplyDetailEntity> busPoApplyDetailList = vwBusPoApplyPage.getBusPoApplyDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";

		try {
			BusPoApplyEntity busPoApply = new BusPoApplyEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vwBusPoApply, busPoApply);
			busPoApply.setBpaState("0");
			busBusPoApplyService.addMain(busPoApply, busPoApplyDetailList);
			// vwBusPoApplyService.addMain(vwBusPoApply, busPoApplyDetailList);
			vwBusPoApply.setId(busPoApply.getId());
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "采购申请视图添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(vwBusPoApply);
		return j;
	}

	/**
	 * 更新采购申请视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VwBusPoApplyEntity vwBusPoApply, VwBusPoApplyPage vwBusPoApplyPage,
			HttpServletRequest request) {
		List<BusPoApplyDetailEntity> busPoApplyDetailList = vwBusPoApplyPage.getBusPoApplyDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try {
			BusPoApplyEntity busPoApply = new BusPoApplyEntity();
			MyBeanUtils.copyBeanNotNull2Bean(vwBusPoApply, busPoApply);
			busBusPoApplyService.updateMain(busPoApply, busPoApplyDetailList);
			// vwBusPoApplyService.updateMain(vwBusPoApply,
			// busPoApplyDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新采购申请视图失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购申请视图新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusPoApply.getId())) {
			vwBusPoApply = vwBusPoApplyService.getEntity(VwBusPoApplyEntity.class, vwBusPoApply.getId());
			req.setAttribute("vwBusPoApplyPage", vwBusPoApply);
		}
		return new ModelAndView("com/action/actpo/vwBusPoApply-add");
	}

	/**
	 * 采购申请视图编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vwBusPoApply.getId())) {
			vwBusPoApply = vwBusPoApplyService.getEntity(VwBusPoApplyEntity.class, vwBusPoApply.getId());
			req.setAttribute("vwBusPoApplyPage", vwBusPoApply);
		}
		return new ModelAndView("com/action/actpo/vwBusPoApply-update");
	}

	/**
	 * 加载明细列表[采购申请明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "busPoApplyDetailList")
	public ModelAndView busPoApplyDetailList(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest req) {

		// ===================================================================================
		// 获取参数
		Object id0 = vwBusPoApply.getId();
		// =========================================================
		// 查询-是否采购
		String sql = "select  case  WHEN vw_from_po_apply_det_id.from_po_apply_det_id IS NULL THEN '未采购'  ELSE '已采购'  END AS purchase_or_not from bus_po_apply_detail  left join  vw_from_po_apply_det_id on bus_po_apply_detail.id = vw_from_po_apply_det_id.from_po_apply_det_id where bus_po_apply_detail.from_id='"
				+ vwBusPoApply.getId() + "'";

		JSONObject object = new JSONObject();
		List<Map<String, Object>> data = this.systemService.findForJdbc(sql);
		net.sf.json.JSONArray array = net.sf.json.JSONArray.fromObject(data);
		// ===================================================================================
		// 查询-采购申请明细
		String hql0 = "from BusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
		try {
			List<BusPoApplyDetailEntity> busPoApplyDetailEntityList = systemService.findHql(hql0, id0);
			req.setAttribute("busPoApplyDetailList", busPoApplyDetailEntityList);
			req.setAttribute("purchase_or_not", array);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/action/actpo/busPoApplyDetailList");
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid, ModelMap map) {
		CriteriaQuery cq = new CriteriaQuery(VwBusPoApplyEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vwBusPoApply);
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		List<VwBusPoApplyEntity> list = this.vwBusPoApplyService.getListByCriteriaQuery(cq, false);
		List<VwBusPoApplyPage> pageList = new ArrayList<VwBusPoApplyPage>();
		if (list != null && list.size() > 0) {
			for (VwBusPoApplyEntity entity : list) {
				try {
					VwBusPoApplyPage page = new VwBusPoApplyPage();
					MyBeanUtils.copyBeanNotNull2Bean(entity, page);
					Object id0 = entity.getId();
					String hql0 = "from BusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
					List<BusPoApplyDetailEntity> busPoApplyDetailEntityList = systemService.findHql(hql0, id0);
					page.setBusPoApplyDetailList(busPoApplyDetailEntityList);
					pageList.add(page);
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
			}
		}
		map.put(NormalExcelConstants.FILE_NAME, "采购申请视图");
		map.put(NormalExcelConstants.CLASS, VwBusPoApplyPage.class);
		map.put(NormalExcelConstants.PARAMS, new ExportParams("采购申请视图列表", "导出人:Jeecg", "导出信息"));
		map.put(NormalExcelConstants.DATA_LIST, pageList);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	/**
	 * 通过excel导入数据
	 * 
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
				List<VwBusPoApplyPage> list = ExcelImportUtil.importExcel(file.getInputStream(), VwBusPoApplyPage.class,
						params);
				VwBusPoApplyEntity entity1 = null;
				for (VwBusPoApplyPage page : list) {
					entity1 = new VwBusPoApplyEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page, entity1);
					vwBusPoApplyService.addMain(entity1, page.getBusPoApplyDetailList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			} finally {
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
	 * excel导入功能跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "vwBusPoApplyController");
		req.setAttribute("method_name", "importContDetailExcel");
		return new ModelAndView("com/action/actpo/excel_import");
	}

	/**
	 * 自定义按钮-sql增强-审核完成
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doBtn_shwc")
	@ResponseBody

	public AjaxJson doBtn_shwc(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "审核完成成功";
		VwBusPoApplyEntity t = vwBusPoApplyService.get(VwBusPoApplyEntity.class, vwBusPoApply.getId());
		// BusPoApplyEntity t = busBusPoApplyService.get(BusPoApplyEntity.class,
		// vwBusPoApply.getId());
		String sql = "update bus_po_apply set bpa_state='2' where id='" + vwBusPoApply.getId() + "'";

		// int i=this.systemService.updateBySqlString(sql);
		boolean IfSuccess = false;

		try {
			int i = jdbcDao.executeSql(sql);
			if (i > 0) {
				IfSuccess = true;
			}
			// vwBusPoApplyService.doBtn_shwcSql(t);
			// busBusPoApplyService.doBtn_sswcBus(t);
			// systemService.addLog(message, Globals.Log_Type_UPDATE,
			// Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "审核完成失败";
		}
		j.setSuccess(IfSuccess);
		j.setMsg(message);
		return j;
	}

	@RequestMapping(params = "doBtn_SendBack")
	@ResponseBody
	public AjaxJson doBtn_SendBack(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "驳回成功";
		boolean IfSuccess = false;
		String sql = "update bus_po_apply set bpa_state='0' where id='" + vwBusPoApply.getId() + "'";
		// VwBusPoApplyEntity t =
		// vwBusPoApplyService.get(VwBusPoApplyEntity.class,
		// vwBusPoApply.getId());
		// BusPoApplyEntity t = busBusPoApplyService.get(BusPoApplyEntity.class,
		// vwBusPoApply.getId());
		try {
			int i = jdbcDao.executeSql(sql);
			if (i > 0) {
				IfSuccess = true;
			}
			// vwBusPoApplyService.doBtn_submitSql(t);
			// systemService.addLog(message, Globals.Log_Type_UPDATE,
			// Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "驳回失败";
		}
		j.setSuccess(IfSuccess);
		j.setMsg(message);
		return j;
	}

	/**
	 * 自定义按钮-sql增强-送审
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doBtn_submit")
	@ResponseBody
	public AjaxJson doBtn_submit(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "送审成功";
		boolean IfSuccess = false;
		String sql = "update bus_po_apply set bpa_state='1' where id='" + vwBusPoApply.getId() + "'";
		// VwBusPoApplyEntity t =
		// vwBusPoApplyService.get(VwBusPoApplyEntity.class,
		// vwBusPoApply.getId());
		// BusPoApplyEntity t = busBusPoApplyService.get(BusPoApplyEntity.class,
		// vwBusPoApply.getId());
		try {
			int i = jdbcDao.executeSql(sql);
			if (i > 0) {
				IfSuccess = true;
			}
			// vwBusPoApplyService.doBtn_submitSql(t);
			// systemService.addLog(message, Globals.Log_Type_UPDATE,
			// Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "送审失败";
		}
		j.setSuccess(IfSuccess);
		j.setMsg(message);
		return j;
	}

	@RequestMapping(value = "/list/{pageNo}/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "采购申请视图列表信息", produces = "application/json", httpMethod = "GET")
	public ResponseMessage<List<VwBusPoApplyPage>> list(@PathVariable("pageNo") int pageNo,
			@PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		if (pageSize > Globals.MAX_PAGESIZE) {
			return Result.error("每页请求不能超过" + Globals.MAX_PAGESIZE + "条");
		}
		CriteriaQuery query = new CriteriaQuery(VwBusPoApplyEntity.class);
		query.setCurPage(pageNo <= 0 ? 1 : pageNo);
		query.setPageSize(pageSize < 1 ? 1 : pageSize);
		List<VwBusPoApplyEntity> list = this.vwBusPoApplyService.getListByCriteriaQuery(query, true);
		List<VwBusPoApplyPage> pageList = new ArrayList<VwBusPoApplyPage>();
		if (list != null && list.size() > 0) {
			for (VwBusPoApplyEntity entity : list) {
				try {
					VwBusPoApplyPage page = new VwBusPoApplyPage();
					MyBeanUtils.copyBeanNotNull2Bean(entity, page);
					Object id0 = entity.getId();
					String hql0 = "from BusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
					List<BusPoApplyDetailEntity> busPoApplyDetailOldList = this.vwBusPoApplyService.findHql(hql0, id0);
					page.setBusPoApplyDetailList(busPoApplyDetailOldList);
					pageList.add(page);
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
			}
		}
		return Result.success(pageList);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据ID获取采购申请视图信息", notes = "根据ID获取采购申请视图信息", httpMethod = "GET", produces = "application/json")
	public ResponseMessage<?> get(@ApiParam(required = true, name = "id", value = "ID") @PathVariable("id") String id) {
		VwBusPoApplyEntity task = vwBusPoApplyService.get(VwBusPoApplyEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取采购申请视图信息为空");
		}
		VwBusPoApplyPage page = new VwBusPoApplyPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
			Object id0 = task.getId();
			String hql0 = "from BusPoApplyDetailEntity where 1 = 1 AND fromId = ? ";
			List<BusPoApplyDetailEntity> busPoApplyDetailOldList = this.vwBusPoApplyService.findHql(hql0, id0);
			page.setBusPoApplyDetailList(busPoApplyDetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "创建采购申请视图")
	public ResponseMessage<?> create(@ApiParam(name = "采购申请视图对象") @RequestBody VwBusPoApplyPage vwBusPoApplyPage,
			UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwBusPoApplyPage>> failures = validator.validate(vwBusPoApplyPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		// 保存
		List<BusPoApplyDetailEntity> busPoApplyDetailList = vwBusPoApplyPage.getBusPoApplyDetailList();

		VwBusPoApplyEntity vwBusPoApply = new VwBusPoApplyEntity();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vwBusPoApplyPage, vwBusPoApply);
			vwBusPoApplyService.addMain(vwBusPoApply, busPoApplyDetailList);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return Result.error("保存采购申请视图失败");
		}

		return Result.success(vwBusPoApply);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "更新采购申请视图", notes = "更新采购申请视图")
	public ResponseMessage<?> update(@RequestBody VwBusPoApplyPage vwBusPoApplyPage) {
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VwBusPoApplyPage>> failures = validator.validate(vwBusPoApplyPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		// 保存
		List<BusPoApplyDetailEntity> busPoApplyDetailList = vwBusPoApplyPage.getBusPoApplyDetailList();

		VwBusPoApplyEntity vwBusPoApply = new VwBusPoApplyEntity();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vwBusPoApplyPage, vwBusPoApply);
			vwBusPoApplyService.updateMain(vwBusPoApply, busPoApplyDetailList);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return Result.error("采购申请视图更新失败");
		}

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "删除采购申请视图")
	public ResponseMessage<?> delete(
			@ApiParam(name = "id", value = "ID", required = true) @PathVariable("id") String id) {
		logger.info("delete[{}]", id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			VwBusPoApplyEntity vwBusPoApply = vwBusPoApplyService.get(VwBusPoApplyEntity.class, id);
			vwBusPoApplyService.delMain(vwBusPoApply);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("采购申请视图删除失败");
		}

		return Result.success();
	}

	// 下拉列表的数据值
	@RequestMapping(value = "loadSuggestData")
	@ResponseBody
	public Object loadSuggestData(String keyword, HttpServletRequest request) {

		String sql = "select a.id as id,a.bpm_name as bpm_name, b.bp_proj_id as bp_proj_id from bus_project_manager as a  left join bus_project as b on  a.from_proj_id=b.id where a.bpm_name like'%"
				+ keyword + "%'";
		// String sql = "select bp.bp_proj_id as bpm_proj_id, bp.bp_proj_name as
		// bpm_proj_name from bus_project_manager as bpm, bus_project as bp
		// where bp.id = bpm.from_proj_id"
		// + " and bp.bp_proj_name like '%" +keyword+"%'";
		JSONObject object = new JSONObject();
		object.put("message", "");
		try {
			List<Map<String, Object>> data = this.systemService.findForJdbc(sql);
			for (Map<String, Object> map : data) {
				for (String key : map.keySet()) {
					if (null == map.get(key)) {
						map.put(key, "");
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

	// 根据前端选取项目编号查询采购申请号情况并返回前端
	@RequestMapping(value = "creatBpProjId")
	@ResponseBody
	public Object creatBpProjId(String BpProjId, HttpServletRequest request) {

		String sql = "select bpa_apply_no from bus_po_apply  where bpa_apply_no like '" + BpProjId
				+ "%' order by bpa_apply_no DESC  LIMIT 1";

		JSONObject object = new JSONObject();
		object.put("message", "");
		try {
			List<Map<String, Object>> data = this.systemService.findForJdbc(sql);
			for (Map<String, Object> map : data) {
				for (String key : map.keySet()) {
					if (null == map.get(key)) {
						map.put(key, "");
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

	// 导放excel文件
	@RequestMapping(params = "importContDetailExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importContDetailExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(0);// excel文件的标题行数
			params.setHeadRows(1);// excel文件中的表头行数
			params.setNeedSave(true);
			try {
				List<BusPoApplyDetailEntity> list = ExcelImportUtil.importExcel(file.getInputStream(),
						BusPoApplyDetailEntity.class, params);
				j.setObj(list);
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			} finally {
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
	 * 保存文件
	 * 
	 * @param request
	 * @param response
	 * @param cgUploadEntity
	 *            智能表单文件上传实体
	 * @return
	 * 
	 */

	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, CgUploadEntity cgUploadEntity) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String id = oConvertUtils.getString(request.getParameter("cgFormId"));// 动态表主键ID
		String tableName = oConvertUtils.getString(request.getParameter("cgFormName"));// 动态表名
		String cgField = oConvertUtils.getString(request.getParameter("cgFormField"));// 动态表上传控件字段
		logger.info("--cgUploadController--saveFiles--上传文件-----" + "{id:" + id + "}  {tableName：" + tableName
				+ "}  {cgField:" + cgField + "}");
		if (!StringUtil.isEmpty(id)) {
			cgUploadEntity.setCgformId(id);
			cgUploadEntity.setCgformName(tableName);
			cgUploadEntity.setCgformField(cgField);
		}
		if (StringUtil.isNotEmpty(fileKey)) {
			cgUploadEntity.setId(fileKey);
			cgUploadEntity = systemService.getEntity(CgUploadEntity.class, fileKey);
		}
		UploadFile uploadFile = new UploadFile(request, cgUploadEntity);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);// 不存二进制内容
		cgUploadEntity = systemService.uploadFile(uploadFile);
		logger.info("--cgUploadController--saveFiles--上传文件----数据库保存转换成功-----");

		String realPath = cgUploadEntity.getRealpath();
		realPath = realPath.replace(File.separator, "/");
		cgUploadService.writeBack(id, tableName, cgField, fileKey, realPath);
		logger.info("--cgUploadController--saveFiles--上传文件----回写业务数据表字段文件路径-----");

		attributes.put("url", realPath);
		attributes.put("name", cgUploadEntity.getAttachmenttitle());
		attributes.put("fileKey", cgUploadEntity.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + cgUploadEntity.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + cgUploadEntity.getId());
		j.setMsg("操作成功");
		j.setAttributes(attributes);
		logger.info("--cgUploadController--saveFiles--上传文件----操作成功-----");
		BasAttachFileEntity basAttachFileEntity = new BasAttachFileEntity();
		basAttachFileEntity.setId(cgUploadEntity.getId());
		basAttachFileEntity.setBafAttachClass(2 + "");
		basAttachFileEntity.setBafBusId(id);
		basAttachFileEntity.setBafFilename(request.getParameter("fileName").toString());
		basAttachFileEntity.setBafPath(realPath);
		// basAttachFileEntity.setId("4028b8816c7a58b2016c7a58b2aa0000");
		// basAttachFileEntity.setBafAttachClass(2+"");
		// basAttachFileEntity.setBafBusId("4028b8816c7a58b2016c7a58b2aa0320");
		// basAttachFileEntity.setBafFilename("kk");
		// basAttachFileEntity.setBafPath("dsfsdfsdf");
		try {
			systemService.save(basAttachFileEntity);
			logger.info("操作成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("操作不成功");
			e.printStackTrace();
		}
		// logger.info("--cgUploadController--saveFiles--上传文件----操作成功-----");
		return j;
	}

	/**
	 * 获取文件附件信息
	 * 
	 * @param id
	 *            vwBusPoApply主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id) {
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>(0);
		for (CgUploadEntity b : uploadBeans) {
			String title = b.getAttachmenttitle();// 附件名
			String fileKey = b.getId();// 附件主键
			String path = b.getRealpath();// 附件路径
			String field = b.getCgformField();// 表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field == null ? "" : field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}

	// 根据前端选取项目编号查询采购申请号情况并返回前端
	@RequestMapping(value = "dropdownItem")
	@ResponseBody
	public String dropdownItem(HttpServletRequest request, HttpServletResponse response) {

		String sql = "select id,bpmName as  from bus_project";
		String test = "{\"total\":2,\"rows\":[{\"id\":1,\"bpmName\":\"圆珠笔\"},{\"id\":2,\"bpmName\":\"铅笔\"}";

		try {
			List<Map<String, Object>> data = this.systemService.findForJdbc(sql);

			String json = JSONArray.toJSONString(data);

			response.getWriter().write(test);
			// net.sf.json.JSONArray array =
			// net.sf.json.JSONArray.fromObject(data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;

	}

	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VwBusPoApplyEntity vwBusPoApply, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid, ModelMap modelMap) {
		modelMap.put(NormalExcelConstants.FILE_NAME, "选择增加excel模板");
		modelMap.put(NormalExcelConstants.CLASS, ExcelBusPoApplyDetailEntity.class);
	//modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("采购申请视图列表", "导出人:" + ResourceUtil.etSessionUser().getRealName(), "导出信息"));
	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("模板使用说明：第一步：启用excel编辑功能，删除模板使用说明行（即第一行），第二步：按照表头输入数据，第三步： 利用excel导入功能导入本模板数据", ""));
		modelMap.put(NormalExcelConstants.DATA_LIST, new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	
} 
