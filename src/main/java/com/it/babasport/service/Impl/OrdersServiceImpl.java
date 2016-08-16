package com.it.babasport.service.Impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.AddressDao;
import com.it.babasport.dao.OrdersDao;
import com.it.babasport.po.bbs_address;
import com.it.babasport.po.bbs_orders;
import com.it.babasport.service.OrdersService;

import tk.mybatis.mapper.entity.Example;
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private AddressDao addressDao;

	public int insert(bbs_orders info) {
		ordersDao.insertUseGeneratedKeys(info);	
		return info.getId();
	}

	public List<bbs_orders> getAllOrders(String id) {
		Example example=new Example(bbs_orders.class);
		example.createCriteria().andEqualTo("buyerId", id);
		List<bbs_orders> list=ordersDao.selectByExample(example);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				int addressId=list.get(i).getAddressId();
				bbs_address address=addressDao.getAddressById(addressId);
				list.get(i).setGoTime(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(list.get(i).getCreateDate()));
				list.get(i).setAddress(address);
			}
		}
		return list;
		
	}
	public List<bbs_orders> getAllOrdersMain() {
		Example example=new Example(bbs_orders.class);
		example.setOrderByClause("createDate desc");
		List<bbs_orders> list=ordersDao.selectByExample(example);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				int addressId=list.get(i).getAddressId();
				bbs_address address=addressDao.getAddressById(addressId);
				list.get(i).setGoTime(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(list.get(i).getCreateDate()));
				list.get(i).setAddress(address);
			}
		}
		return list;

	}

	public List<bbs_orders> seletcByOrders(bbs_orders orders) {
		
		return ordersDao.select(orders);
	}
}
