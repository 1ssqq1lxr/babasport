package com.it.babasport.service.Impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.it.babasport.dao.BrandDao;
import com.it.babasport.po.BrandLoad;
import com.it.babasport.po.bbs_brand;
import com.it.babasport.service.BrandService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


@Service("brandService")
public class BrandServiceimpl implements BrandService{
	@Autowired
	private BrandDao brandDao;
	public List<bbs_brand> findBrandbyExampleWithPage(bbs_brand brand,int pageNum,int pageSize){
//		Object arg0, RowBounds arg1)
		//第一种 RowBounds方式的调用
		PageHelper.startPage(pageNum, pageSize);
//		List<bbs_brand> brands=brandDao.select(null);
		Example example=new Example(bbs_brand.class);
		Criteria criteria= example.createCriteria();
		if(StringUtils.isNotBlank(brand.getName())){
			criteria.andEqualTo("name", brand.getName());
		}
		criteria.andEqualTo("is_display", brand.getIs_display());
		example.setOrderByClause("id");
		List<bbs_brand> brands=brandDao.selectByExample(example);
		return brands;
	}

	public void insert(bbs_brand brand) {
		brandDao.insert(brand);
	}

	public void delete(int id) {
		brandDao.deleteByPrimaryKey(id);
	}
	public void deleteAll(Integer[] ids) {
		Condition condition=new Condition(bbs_brand.class);
		List<Criteria> list=condition.getOredCriteria();
		Criteria criteria=null;
		for(int i=0;i<ids.length;i++){
			criteria=condition.createCriteria();
			criteria.andEqualTo("id", ids[i]);
			list.add(criteria);
		}
		brandDao.deleteByCondition(condition);
	}
//
//	public List<bbs_brand> test(bbs_brand brand) {
//		Condition condition=new Condition(bbs_brand.class);
//		List<Criteria> list=condition.getOredCriteria();
//		Criteria	criteria1=condition.createCriteria();
//		criteria1.andEqualTo("name", brand.getName());
//		Criteria	criteria2=condition.createCriteria();
//		criteria2.andEqualTo("is_display", brand.getIs_display());
//		list.add(criteria1);
//		list.add(criteria2);
//		return brandDao.selectByCondition(condition);
//	}
//
//	public List<bbs_brand> test1(bbs_brand brand) {
//		Example example=new Example(bbs_brand.class);
//	
//		Criteria	criteria1=example.createCriteria();
//		criteria1.andEqualTo("name", brand.getName());
//		criteria1.andEqualTo("is_display", brand.getIs_display());
//		return brandDao.selectByExample(example);
//	
//	}

	public bbs_brand findBrandById(int id) {
		return brandDao.selectByPrimaryKey(id);
	}

	public void update(bbs_brand brand) {
		brandDao.updateByPrimaryKeySelective(brand);
		
	}

	public List<BrandLoad> loadBrand() {
	
		return 	brandDao.loadBrand();
	}
}
