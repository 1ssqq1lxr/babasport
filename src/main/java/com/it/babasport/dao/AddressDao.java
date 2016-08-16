package com.it.babasport.dao;

import java.util.List;

import com.it.babasport.po.bbs_address;
import com.it.babasport.po.bbs_orders;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface AddressDao extends Mapper<bbs_address>,ConditionMapper<bbs_address>,InsertUseGeneratedKeysMapper<bbs_address>{
	public void changeStatus();
	public  List<bbs_address> selectAll( String buyerId);
	public bbs_address getAddress();
	public bbs_address getAddressById(int addressId);
}
