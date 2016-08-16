package com.it.babasport.dao;

import java.util.List;

import javax.persistence.Table;

import com.it.babasport.po.BrandLoad;
import com.it.babasport.po.bbs_brand;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

public interface BrandDao extends Mapper<bbs_brand>,ConditionMapper<bbs_brand>{
	public List<BrandLoad> loadBrand();
}
