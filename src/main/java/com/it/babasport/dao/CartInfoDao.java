package com.it.babasport.dao;

import com.it.babasport.po.bbs_cart;
import com.it.babasport.po.bbs_cart_info;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface CartInfoDao extends  Mapper<bbs_cart_info>,ConditionMapper<bbs_cart_info>,InsertUseGeneratedKeysMapper<bbs_cart_info> {

}
