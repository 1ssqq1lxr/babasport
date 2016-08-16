package com.it.babasport.dao;

import java.util.List;

import com.it.babasport.po.FeatureLoad;
import com.it.babasport.po.bbs_feature;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

public interface FeatureDao extends Mapper<bbs_feature>,ConditionMapper<bbs_feature>{
	public List<FeatureLoad> load();
}
