package com.it.babasport.dao;

import java.util.List;

import com.it.babasport.po.ColorLoad;
import com.it.babasport.po.bbs_brand;
import com.it.babasport.po.bbs_color;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface ColorDao extends Mapper<bbs_color>,ConditionMapper<bbs_color>,InsertUseGeneratedKeysMapper<bbs_color>{
			public List<ColorLoad> load();

			public String getColorNameById(Integer colorId);
}
