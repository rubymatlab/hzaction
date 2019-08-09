package com.action.actbase.service;
import com.action.actbase.entity.BasAttachFileEntity;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;

import java.io.Serializable;

public interface BasAttachFileServiceI extends CommonService{
	
 	public void delete(BasAttachFileEntity entity) throws Exception;
 	
 	public Serializable save(BasAttachFileEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BasAttachFileEntity entity) throws Exception;
 	
 	
}
