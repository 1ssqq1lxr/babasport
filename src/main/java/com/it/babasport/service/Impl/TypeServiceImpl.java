package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.TypeDao;
import com.it.babasport.po.TypeLoad;
import com.it.babasport.po.bbs_type;
import com.it.babasport.service.TypeService;
@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeDao typeDao ;
	public List<TypeLoad> load() {
		return typeDao.load();
	}

}
