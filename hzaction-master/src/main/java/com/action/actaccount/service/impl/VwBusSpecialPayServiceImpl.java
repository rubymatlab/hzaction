package com.action.actaccount.service.impl;
import com.action.actaccount.service.VwBusSpecialPayServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actaccount.entity.VwBusSpecialPayEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("vwBusSpecialPayService")
@Transactional
public class VwBusSpecialPayServiceImpl extends CommonServiceImpl implements VwBusSpecialPayServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(VwBusSpecialPayEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(VwBusSpecialPayEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VwBusSpecialPayEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	/**
	 * 自定义按钮-[送审]业务处理
	 * @param id
	 * @return
	 */
	 public void doAccessBus(VwBusSpecialPayEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[支付]业务处理
	 * @param id
	 * @return
	 */
	 public void doPayBus(VwBusSpecialPayEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
}