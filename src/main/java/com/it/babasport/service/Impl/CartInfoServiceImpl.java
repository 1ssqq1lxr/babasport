package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.CartInfoDao;
import com.it.babasport.po.bbs_cart_info;
import com.it.babasport.service.CartInfoService;

import tk.mybatis.mapper.entity.Example;
@Service("cartInfoService")
public class CartInfoServiceImpl implements CartInfoService{
	@Autowired
	CartInfoDao cartInfoDao;
	
	public bbs_cart_info add(bbs_cart_info bbs_cart_info) {
		cartInfoDao.insertUseGeneratedKeys(bbs_cart_info);
		return bbs_cart_info;
	}

	public List<bbs_cart_info> getCartInfoByCartId(int cartId) {
		Example example=new Example(bbs_cart_info.class);
		example.createCriteria().andEqualTo("cartId", cartId);
		return cartInfoDao.selectByExample(example);
	}

	public void deleteById(int id) {
		cartInfoDao.deleteByPrimaryKey(id);
	}

}
