package com.action.actbase.service.impl;
import java.io.Serializable;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.action.actbase.entity.BasAttachFileEntity;
import com.action.actbase.service.BasAttachFileServiceI;

@Service("basAttachFileService")
@Transactional
public class BasAttachFileServiceImpl extends CommonServiceImpl implements BasAttachFileServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(BasAttachFileEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(BasAttachFileEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(BasAttachFileEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}