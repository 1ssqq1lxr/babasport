package com.it.babasport.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.SkuDao;
import com.it.babasport.po.User;
import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.SkuService;
import com.it.babasport.service.UserService;

import tk.mybatis.mapper.entity.Example;
@Service("skuService")
public class SkuServiceImpl implements SkuService {
	@Autowired
	SkuDao skuDao;
	public void addSku(bbs_sku sku) {
		skuDao.insertSelective(sku); 
	}
	public void deleteByproductId(int id) {
		Example example=new Example(bbs_sku.class);
		example.createCriteria().andEqualTo("productId",id);
		skuDao.deleteByExample(example);
	}
	public List<bbs_sku> getSkus(int productId) {
		Example example=new Example(bbs_sku.class);
		example.createCriteria().andEqualTo("productId", productId);
		return skuDao.selectByExample(example);
	}
	public void updateSku(bbs_sku sku) {
		
		skuDao.updateByPrimaryKeySelective(sku);
	}
	public List<bbs_sku> getSkusExe(int productId) {
		Example example=new Example(bbs_sku.class);
		example.createCriteria().andEqualTo("productId", productId).andGreaterThan("stockInventory", 0);
		return skuDao.selectByExample(example);
	}
	public bbs_sku getSkuById(int skuId) {
		// TODO Auto-generated method stub
		return skuDao.selectByPrimaryKey(skuId);
	}


}
