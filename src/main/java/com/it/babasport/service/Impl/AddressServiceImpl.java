package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.AddressDao;
import com.it.babasport.po.bbs_address;
import com.it.babasport.service.AddressService;

import tk.mybatis.mapper.entity.Example;

@Service("addressService")
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressDao addressDao;

	public void add(bbs_address address) {
		if(address.getStatusAddr()==1){
			changeStatus();
		}
		addressDao.insertSelective(address);
	}

	public void changeStatus() {
		addressDao.changeStatus();
	}

	public List<bbs_address> getAll(String id) {
//		Example example=new Example(bbs_address.class);
//		example.setOrderByClause("statusAddr desc");
//		example.createCriteria().andEqualTo("buyerId",id );
		return addressDao.selectAll(id);
	}
//
//	public void deleteById(bbs_address address) {
//		addressDao.updateByPrimaryKeySelective(address);
//	}

	public void deleteById(bbs_address address) {
		addressDao.updateByPrimaryKeySelective(address);
	}

	public void setStatus(bbs_address address) {
//		先取消其他的默认地址
		changeStatus();
//		设置其默认地址
		addressDao.updateByPrimaryKeySelective(address); 
	}

	public bbs_address getAddress() {
		return addressDao.getAddress();
	}


	
}
