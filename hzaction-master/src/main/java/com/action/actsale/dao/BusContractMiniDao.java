package com.action.actsale.dao;

import java.util.List;

import javax.annotation.Resource;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.action.actsale.entity.BusContractEntity;
import com.action.actsale.entity.BusContractPaymentEntity;

@Repository
public interface BusContractMiniDao {
	
	@Sql("select * from bus_contract")
	public List<BusContractEntity> getList();
	
	@Sql("select * from bus_contract_payment bcp where bcp.bus_contract_id = :bus_contract_id")
	@Arguments({"bus_contract_id"})
	public List<BusContractPaymentEntity> getListContractPayment(String bus_contract_id);
	
}
