package com.it.babasport.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.ImgDao;
import com.it.babasport.po.bbs_img;
import com.it.babasport.service.ImgService;

import tk.mybatis.mapper.entity.Example;
@Service("imgService")
public class ImgServiceImpl implements ImgService {
	@Autowired
	ImgDao imgDao;
	public void insertImg(bbs_img img) {
		imgDao.insertSelective(img);
	}
	public String getUrl(Integer id) {
		
		return imgDao.getUrl(id);
	}
	public void deleteByProductId(int id) {
		Example example=new Example(bbs_img.class);
		example.createCriteria().andEqualTo("productId", id);
		imgDao.deleteByExample(example);
//		imgDao.deleteByPrimaryKey(id);
	}

}
