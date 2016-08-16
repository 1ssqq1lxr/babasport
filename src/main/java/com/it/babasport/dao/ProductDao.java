package com.it.babasport.dao;

import com.it.babasport.po.bbs_product;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface ProductDao extends Mapper<bbs_product>,ConditionMapper<bbs_product>,InsertUseGeneratedKeysMapper<bbs_product> {
		void updateProductBykey(bbs_product product);
		String getNameById(int id);
}
