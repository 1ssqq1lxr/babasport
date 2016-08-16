package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.CartDao;
import com.it.babasport.po.bbs_cart;
import com.it.babasport.service.CartService;

import tk.mybatis.mapper.entity.Example;
@Service("cartService")
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;

	public bbs_cart getCartByBuyerID(String buyerId) {
		Example example=new Example(bbs_cart.class);
		example.createCriteria().andEqualTo("buyerId", buyerId);
		List<bbs_cart> list=cartDao.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public int add(bbs_cart cart) {
		cartDao.insertUseGeneratedKeys(cart);
		return cart.getId();
	}

	public void update(bbs_cart cart) {
		cartDao.updateByPrimaryKeySelective(cart);
	}
}
