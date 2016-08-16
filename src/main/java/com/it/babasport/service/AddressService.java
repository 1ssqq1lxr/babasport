package com.it.babasport.service;

import java.util.List;

import com.it.babasport.po.bbs_address;

public interface AddressService {

	void add(bbs_address address);

	void changeStatus();

	List<bbs_address> getAll(String id);

	void deleteById(bbs_address address);

	void setStatus(bbs_address address);
	bbs_address getAddress();
	
}
