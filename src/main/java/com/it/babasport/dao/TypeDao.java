package com.it.babasport.dao;

import java.util.List;

import com.it.babasport.po.TypeLoad;
import com.it.babasport.po.bbs_type;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

public interface TypeDao extends Mapper<bbs_type>,ConditionMapper<bbs_type>{
		public List<TypeLoad> load();
}
