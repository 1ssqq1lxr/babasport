package com.it.babasport.dao;

import com.it.babasport.po.bbs_sku;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SkuDao extends Mapper<bbs_sku> ,ConditionMapper<bbs_sku>{
					
}
