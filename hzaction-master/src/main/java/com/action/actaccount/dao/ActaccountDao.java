package com.action.actaccount.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

@Repository
public interface ActaccountDao {

	@Sql("delete from bus_po_pay where id=:id")
	@Arguments({"id"})
	public void deleteBusPoPayWmtEntity(String id);
	
	@Sql("update bus_po_pay set bpp_inv_type=:bppInvType, bpp_inv_amount=:bppInvAmount , bpp_tax_rate=:bppTaxRate ,"+
			" bpp_pay_date=:bppPayDate , bpp_state=:bppState ,bpp_money=:bppMoney , "+
			" from_projm_id=:fromProjmId , from_supp_id=:fromSuppId ,bpp_accessory=:bppAccessory " + 
			" where id=:id")
	@Arguments({"id","bppInvType","bppInvAmount","bppTaxRate","bppPayDate","bppState",
		"bppMoney","fromProjmId","fromSuppId","bppAccessory"})
	int updateBusPoPayWmtEntity(String id,String bppInvType,BigDecimal bppInvAmount,
			String bppTaxRate,Date bppPayDate,String bppState,
			BigDecimal bppMoney,String fromProjmId,String fromSuppId,String bppAccessory);
	
	@Sql("update bus_po_contract_pay set pay_amount=:payAmount,bpcp_remark=:bpcpRemark "
			+ " where id=:bpcpId")
	@Arguments({"bpcpId","payAmount","bpcpRemark"})
	int updateBusPoContractPayWmtEntity(String bpcpId,BigDecimal payAmount,String bpcpRemark);
	
	
	@Sql("select bpp.bpp_pay_id from bus_po_pay bpp ORDER BY bpp.create_date DESC LIMIT 1 ")
	Map<String, String> getNowByBppPayId();
	
	@Sql("update bus_po_pay set bpp_state=:bppState where id=:id")
	@Arguments({"bppState","id"})
	int updateBusPoPayWmtEntityBppState(String bppState,String id);
	
}