package com.it.babasport.service;

import java.util.List;

import com.it.babasport.po.bbs_sku;

public interface SkuService {

	void addSku(bbs_sku sku);

	void deleteByproductId(int id);

	List<bbs_sku> getSkus(int productId);

	void updateSku(bbs_sku sku);

	List<bbs_sku> getSkusExe(int productId);

	bbs_sku getSkuById(int skuId);

}
