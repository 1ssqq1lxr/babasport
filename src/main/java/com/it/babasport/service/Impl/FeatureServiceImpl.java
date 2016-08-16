package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.FeatureDao;
import com.it.babasport.po.FeatureLoad;
import com.it.babasport.service.FeatureService;
@Service("featureService")
public class FeatureServiceImpl implements FeatureService{
	@Autowired
	FeatureDao featureDao;
	public List<FeatureLoad> load() {
		// TODO Auto-generated method stub
		return featureDao.load();
	}
		
}
