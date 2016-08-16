package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.CityDao;
import com.it.babasport.dao.ProvinceDao;
import com.it.babasport.po.bbs_province;
import com.it.babasport.service.ProvinceService;
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService{
	@Autowired
	ProvinceDao provinceDao;
	public List<bbs_province> findAll(){
		return provinceDao.select(null);
	}
	}
