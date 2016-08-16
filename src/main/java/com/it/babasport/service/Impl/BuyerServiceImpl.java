package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.BuyerDao;
import com.it.babasport.po.bbs_buyer;
import com.it.babasport.service.BuyerService;

import tk.mybatis.mapper.entity.Example;
@Service("buyerService")
public class BuyerServiceImpl implements BuyerService{
	@Autowired
	BuyerDao buyerDao;

	public bbs_buyer findBuyerByUsername(String username) {
		Example example=new Example(bbs_buyer.class);
		example.createCriteria().andEqualTo("username", username);
		List<bbs_buyer> list=buyerDao.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void save(bbs_buyer buyer) {
		buyerDao.updateByPrimaryKeySelective(buyer);
	}

	public bbs_buyer selectById(String id) {
		
		return buyerDao.selectByPrimaryKey(id);
	}
	
	
}
