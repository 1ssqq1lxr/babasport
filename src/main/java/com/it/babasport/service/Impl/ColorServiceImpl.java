package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.ColorDao;
import com.it.babasport.po.ColorLoad;
import com.it.babasport.service.ColorService;
@Service("colorService")
public class ColorServiceImpl implements ColorService{
	@Autowired
	ColorDao colorDao;
	public List<ColorLoad> load() {
		return colorDao.load();
	}
	public String getColorNameById(Integer colorId) {
		return colorDao.getColorNameById( colorId);
		
	}

}
