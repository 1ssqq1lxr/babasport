package com.it.babasport.service;

import com.it.babasport.po.bbs_cart;

public interface CartService {

	com.it.babasport.po.bbs_cart getCartByBuyerID(String buyerId);

	int add(bbs_cart cart);

	void update(bbs_cart cart);
		
}
