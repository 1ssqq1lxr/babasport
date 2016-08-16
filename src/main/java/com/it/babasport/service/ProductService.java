package com.it.babasport.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.it.babasport.po.bbs_product;


public interface ProductService {

	List<com.it.babasport.po.bbs_product> selectProducts(bbs_product bbs_product, int pageNum, int pageSize);
	public int insertProduct(bbs_product bbs_product);
	void add(bbs_product product, String url);
	void updateProductByKey(bbs_product product);
	void delete(int id);
	List<com.it.babasport.po.bbs_product> selectProductsBys(bbs_product bbs_product, int pageNum, int pageSize);
	String getNameById(Integer id);
	bbs_product getProductById(int productId);
}
