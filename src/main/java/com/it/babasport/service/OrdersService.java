package com.it.babasport.service;

import java.util.List;

import com.it.babasport.po.bbs_orders;

public interface OrdersService {

	int insert(bbs_orders info);

	List<bbs_orders> getAllOrders(String id);

	List<bbs_orders> getAllOrdersMain();
	List<bbs_orders> seletcByOrders(bbs_orders orders);
 }
