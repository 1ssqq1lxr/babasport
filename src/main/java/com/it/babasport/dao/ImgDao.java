package com.it.babasport.dao;

import com.it.babasport.po.bbs_img;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

public interface ImgDao extends Mapper<bbs_img> ,ConditionMapper<bbs_img>{
		public String getUrl(Integer id);
}
