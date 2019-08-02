package com.action.actsale.service.impl;
import com.action.actsale.service.BusProjectFeeDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.action.actsale.entity.BusProjectFeeDetailEntity;
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

@Service("busProjectFeeDetailService")
@Transactional
public class BusProjectFeeDetailServiceImpl extends CommonServiceImpl implements BusProjectFeeDetailServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(BusProjectFeeDetailEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(BusProjectFeeDetailEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(BusProjectFeeDetailEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}