package com.it.babasport.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_product;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface BuyerDao extends Mapper<bbs_buyer>,ConditionMapper<bbs_buyer>,InsertUseGeneratedKeysMapper<bbs_buyer>{

	

	

}
