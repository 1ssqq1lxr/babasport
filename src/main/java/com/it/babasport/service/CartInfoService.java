package com.it.babasport.service;

import java.util.List;

import com.it.babasport.po.bbs_cart_info;

public interface CartInfoService {

	bbs_cart_info add(bbs_cart_info bbs_cart_info);

	List<bbs_cart_info>  getCartInfoByCartId(int cartId);

	void deleteById(int id);

}
