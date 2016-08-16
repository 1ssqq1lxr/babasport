package com.it.babasport.dao;

import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_orders;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface OrdersDao extends Mapper<bbs_orders>,ConditionMapper<bbs_orders>,InsertUseGeneratedKeysMapper<bbs_orders> {

}
