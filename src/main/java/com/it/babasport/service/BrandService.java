package com.it.babasport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.it.babasport.dao.BrandDao;
import com.it.babasport.po.BrandLoad;
import com.it.babasport.po.bbs_brand;

public interface BrandService {
	public List<bbs_brand> findBrandbyExampleWithPage(bbs_brand brand,int pageNum,int pageSize);
	public void insert(bbs_brand brand);
	public void delete(int id);
	public void deleteAll(Integer[] ids);
//	public List<bbs_brand> test(bbs_brand brand);
//	public List<bbs_brand> test1(bbs_brand brand);
	public bbs_brand findBrandById(int id);
	public void update(bbs_brand brand);
	public List<BrandLoad> loadBrand();
}

