package com.it.babasport.service;

import com.it.babasport.po.bbs_buyer;

public interface BuyerService {

	bbs_buyer findBuyerByUsername(String username);

	void save(bbs_buyer buyer);

	com.it.babasport.po.bbs_buyer selectById(String id);

}
