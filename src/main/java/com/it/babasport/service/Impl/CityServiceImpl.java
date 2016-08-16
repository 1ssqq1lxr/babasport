package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.CityDao;
import com.it.babasport.po.bbs_city;
import com.it.babasport.service.CityService;

import tk.mybatis.mapper.entity.Example;
@Service("cityService")
public class CityServiceImpl implements CityService{
	@Autowired
	CityDao cityDao;

	public List<bbs_city> findCitysByProvince(int pid) {
		Example example=new Example(bbs_city.class);
		example.createCriteria().andEqualTo("pid", pid);
		return cityDao.selectByExample(example);
	}
}
