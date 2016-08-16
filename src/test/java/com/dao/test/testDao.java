package com.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.it.babasport.po.User;
import com.it.babasport.po.bbs_brand;
import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_img;
import com.it.babasport.po.bbs_orders;
import com.it.babasport.po.bbs_product;
import com.it.babasport.po.bbs_province;
import com.it.babasport.po.bbs_type;
import com.it.babasport.service.BrandService;
import com.it.babasport.service.BuyerService;
import com.it.babasport.service.ImgService;
import com.it.babasport.service.OrdersService;
import com.it.babasport.service.ProductService;
import com.it.babasport.service.ProvinceService;
import com.it.babasport.service.TypeService;
import com.it.babasport.service.UserService;
import com.it.babasport.service.Impl.BrandServiceimpl;

public class testDao {

@Test
	public void testAdd() throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		OrdersService ordersService=(OrdersService) applicationContext.getBean("ordersService");
		bbs_orders orders=new bbs_orders();
		orders.setIsConfirm(0);
		List<bbs_orders> list=ordersService.seletcByOrders(orders);
		System.out.println(list.size());
	}

@Test
	public void testPage() throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		BrandService brandService=(BrandService) applicationContext.getBean("brandService");
		brandService.delete(123);
		
	}
@Test
public void testCri() throws Exception {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	ImgService imgService=(ImgService) applicationContext.getBean("imgService");
	bbs_img  img=new bbs_img();
	img.setUrl("123");
	imgService.insertImg(img);
	
//	List<bbs_brand> list=brandService.test(brand);
//	System.out.println(list.size());
}
@Test
public void testproduct() throws Exception {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	ProductService	productService=(ProductService) applicationContext.getBean("productService");
	bbs_product bbs_product=new bbs_product();	
	bbs_product.setFeature("1");
	
	productService.insertProduct(bbs_product);

//	int s=productService.updateProductByKey(bbs_product);
//	System.out.println(s);
}
@Test
public void testproduct1()  {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	ProductService	productService=(ProductService) applicationContext.getBean("productService");
	productService.delete(33);
//	productService.update(bbs_product);
}
@Test
public void testtype() throws Exception {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	ProductService productService=(ProductService) applicationContext.getBean("productService");
	productService.delete(66);
}


}
