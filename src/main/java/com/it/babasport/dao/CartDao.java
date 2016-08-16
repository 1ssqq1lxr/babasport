package com.it.babasport.dao;

import com.it.babasport.po.bbs_cart;
import com.it.babasport.po.bbs_product;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface CartDao extends  Mapper<bbs_cart>,ConditionMapper<bbs_cart>,InsertUseGeneratedKeysMapper<bbs_cart>{

}
