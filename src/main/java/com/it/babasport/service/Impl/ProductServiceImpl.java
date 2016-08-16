package com.it.babasport.service.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.it.babasport.dao.ProductDao;
import com.it.babasport.po.bbs_img;
import com.it.babasport.po.bbs_product;
import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.ImgService;
import com.it.babasport.service.ProductService;
import com.it.babasport.service.SkuService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	@Resource(name="imgService")
	ImgService  imgService;
	@Resource(name="skuService")
	SkuService  skuService;


	public List<bbs_product> selectProducts(bbs_product bbs_product, int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		Example example=new Example(bbs_product.class);
		example.setOrderByClause("id desc");
		Criteria criteria= example.createCriteria();
		if(StringUtils.isNotBlank(bbs_product.getName())){
			criteria.andEqualTo("name", bbs_product.getName());
		}
		if(bbs_product.getBrandId()!=null){
			criteria.andEqualTo("brandId", bbs_product.getBrandId());
		}
		if(bbs_product.getIsShow()==null){
			criteria.andEqualTo("isShow", 0);
		}
		else{
			criteria.andEqualTo("isShow", bbs_product.getIsShow());
		}
		
	
		List<bbs_product> list= productDao.selectByExample(example);
		return list;
	}
	public List<bbs_product> selectProductsBys(bbs_product bbs_product, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example=new Example(bbs_product.class);
		Criteria criteria= example.createCriteria();
		example.setOrderByClause("id");
		if(StringUtils.isNotBlank(bbs_product.getFeature())){
			criteria.andLike("feature", "%"+bbs_product.getFeature()+"%");
		}
		if(bbs_product.getBrandId()!=null){
			criteria.andEqualTo("brandId", bbs_product.getBrandId());
		}
		if(bbs_product.getTypeId()!=null){
			criteria.andEqualTo("typeId", bbs_product.getTypeId());
		}
		criteria.andEqualTo("isShow", 1);
		List<bbs_product> list= productDao.selectByExample(example);
		return list;
	}

	public int insertProduct(bbs_product bbs_product) {
		 productDao.insert(bbs_product);
		 return bbs_product.getId();
		
	}


	public void add(bbs_product product, String url) {
		//商品编号
				DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String no = df.format(new Date());
				product.setNo(no);
				//添加时间
//				product.setCheckUserId(123214);
//				product.setC
				product.setCreateTime(new Date());
				//影响到行数   返回商品ID
				//商品保存  
				if(product.getIsNew()==null){
					product.setIsNew(0);
				}
				if(product.getIsHot()==null){
					product.setIsHot((0));
				}
				if(product.getIsCommend()==null){
					product.setIsCommend(0);
				}
				if(product.getIsDel()==null){
					product.setIsDel(1);
				}
				if(product.getIsShow()==null){
					product.setIsShow(0);
				}
				
				productDao.insertUseGeneratedKeys(product);
				Integer i=product.getId();
				//1:商品   图片   sku
				//2:图片
				//1)设置图片商品ID
				bbs_img img=new bbs_img();
				img.setIsDef(1);
				img.setUrl(url);
				img.setProductId(i);
				imgService.insertImg(img);
				//3:保存Sku    9,13,...
				//  S M  ...
				//实例化一个Sku对象
				bbs_sku sku = new bbs_sku();
				//商品ID
				sku.setProductId(i);
				//运费
				sku.setDeliveFee(10.00);
				//售价
				sku.setSkuPrice(0.00);
				//市场价
				sku.setMarketPrice(0.00);
				//库存
				sku.setStockInventory(0);
				//购买限制
				sku.setSkuUpperLimit(0);
				//添加时间
				sku.setCreateTime(new Date());
				//是否最新
				sku.setLastStatus(1);
				//商品
				sku.setSkuType(1);
				//销量
				sku.setSales(0);
				for(String color : product.getColor().split(",")){
					//颜色ID
					sku.setColorId(Integer.parseInt(color));
					
					for(String size : product.getSize().split(",")){
						//尺码
						sku.setSize(size);
						//保存SKu
						skuService.addSku(sku);
					}
					
				}
			
			}


	public void updateProductByKey(bbs_product product) {
		
		 productDao.updateProductBykey(product);
//		productDao.up
	}


	public void delete(int id) {
		Example example=new Example(bbs_product.class);
		example.createCriteria().andEqualTo("id", id);
		productDao.deleteByExample(example);
//		System.out.println(s);
//		productDao.deleteByPrimaryKey(id);
		imgService.deleteByProductId(id);
		skuService.deleteByproductId(id);
	}
	public String getNameById(Integer id) {
		return	productDao.getNameById(id);
	}
	public bbs_product getProductById(int productId) {
	
		return productDao.selectByPrimaryKey(productId);
	}


	

}

		
		
