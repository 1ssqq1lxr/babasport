package com.it.babasport.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.OrderInfoDao;
import com.it.babasport.po.bbs_order_info;
import com.it.babasport.service.OrderInfoService;
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService{
	@Autowired
	private OrderInfoDao orderInfoDao;

	public void insert(bbs_order_info bbs_order_info) {
		orderInfoDao.insert(bbs_order_info);
	}
}
