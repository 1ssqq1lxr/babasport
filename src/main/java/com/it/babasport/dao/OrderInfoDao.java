package com.it.babasport.dao;

import com.it.babasport.po.bbs_order_info;
import com.it.babasport.po.bbs_orders;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface OrderInfoDao extends Mapper<bbs_order_info>,ConditionMapper<bbs_order_info>,InsertUseGeneratedKeysMapper<bbs_order_info> {

}
