package com.it.babasport.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_cart;
import com.it.babasport.po.bbs_cart_info;
import com.it.babasport.po.bbs_product;
import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.BuyerService;
import com.it.babasport.service.CartInfoService;
import com.it.babasport.service.CartService;
import com.it.babasport.service.ColorService;
import com.it.babasport.service.ImgService;
import com.it.babasport.service.ProductService;
import com.it.babasport.service.SkuService;

@Controller
public class CartController {
 
	@Resource(name="cartInfoService")
	CartInfoService cartInfoService; 
	@Resource(name="buyerService")
	BuyerService buyerService;
	@Resource(name="cartService")
	CartService cartService; 
 
	@Resource(name="imgService")
	ImgService  imgService;
	@Resource(name="colorService")
	ColorService  colorService;
	@Resource(name="skuService")
	SkuService  skuService;
	@Resource(name="productService")
	ProductService productService;
	//加入购物车
	@RequestMapping(value="/buyer/Addcart.shtml")
	public void add(bbs_cart_info bbs_cart_info,HttpServletResponse response){
		//从shiro的得到主体再得到buyer
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		bbs_cart cart=buyer.getCart();
		List<bbs_cart_info> cart_infos=buyer.getCart_infos();
		int cartId;
		if(cart==null){
//			如果为空 则新建一个购物车  返回cartId
			cart=new bbs_cart();
			cart.setBuyerId(buyer.getId());
			cart.setDd_time(new Date());
			cart.setTotal_quantity(0);
			cartId=cartService.add(cart);
			buyer.setCart(cart);
		}else{
			cartId=cart.getId();
		}
//		在购物车子表添加购物车carId
		bbs_cart_info.setCartId(cartId);
//		增加物品到购物车总数量加1
		cart.setTotal_quantity(cart.getTotal_quantity()+1);
		cartService.update(cart);
//		插入购物车子表数据后返回信息（含有主键）
		bbs_cart_info info=cartInfoService.add(bbs_cart_info);
//		更新主体中的购物车与购无车子表信息
		if(cart_infos!=null&&cart_infos.size()>0){
//			加载颜色
			int colorId=info.getColorId();
			String colorName=colorService.getColorNameById(colorId);
			info.setColorName(colorName);
//			加载商品
			int productId=info.getProductId();
			bbs_product product=productService.getProductById(productId);
			info.setProduct(product);
//			加载sku
			int skuId=info.getSkuId();
			bbs_sku sku=skuService.getSkuById(skuId);
			info.setSku(sku);
//			加载图片url
			String url=imgService.getUrl(productId);
			info.setImgUrl(url);
			cart_infos.add(info);
		}else{
			cart_infos=new ArrayList<bbs_cart_info>();
//			加载颜色
			int colorId=info.getColorId();
			String colorName=colorService.getColorNameById(colorId);
			info.setColorName(colorName);
//			加载商品
			int productId=info.getProductId();
			bbs_product product=productService.getProductById(productId);
			info.setProduct(product);
//			加载sku
			int skuId=info.getSkuId();
			bbs_sku sku=skuService.getSkuById(skuId);
			info.setSku(sku);
//			加载图片url
			String url=imgService.getUrl(productId);
			info.setImgUrl(url);
			cart_infos.add(info);
			buyer.setCart_infos(cart_infos);
		}
	}
//	从购物车删除sku
	@RequestMapping("/buyer/deleteCart.shtml")
	public void delete(int id){
		//从shiro的得到主体再得到buyer
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		bbs_cart cart=buyer.getCart();
		List<bbs_cart_info> cart_infos=buyer.getCart_infos();
		cartInfoService.deleteById(id);
//		减少物品到购物车总数量减1
		cart.setTotal_quantity(cart.getTotal_quantity()-1);
		cartService.update(cart);
		for(int i=0;i<cart_infos.size();i++){
			if(cart_infos.get(i).getId()==id){
				cart_infos.remove(i);
			}
		}
	}
	@RequestMapping(value="/buyer/myCart.shtml")
	public String myCart(Model model){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		model.addAttribute("buyer", buyer);
		return "front_page/product/cart";
	}
//	从购物车页面删除物品后重定向到该页面
	@RequestMapping("/buyer/deleteCart2.shtml")
	public String delete1(int cartInfoId,Model model){
		//从shiro的得到主体再得到buyer
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		bbs_cart cart=buyer.getCart();
		List<bbs_cart_info> cart_infos=buyer.getCart_infos();
		cartInfoService.deleteById(cartInfoId);
//		减少物品到购物车总数量减1
		cart.setTotal_quantity(cart.getTotal_quantity()-1);
		cartService.update(cart);
		for(int i=0;i<cart_infos.size();i++){
			if(cart_infos.get(i).getId()==cartInfoId){
				cart_infos.remove(i);
			}
		}	
		model.addAttribute("buyer", buyer);
		return "front_page/product/cart";
	}
	@RequestMapping(value="/buyer/clearCart.shtml")
	public String clearCart(){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		bbs_cart cart=buyer.getCart();
		cart.setTotal_quantity(0);
		cartService.update(cart);
		if(buyer!=null){
			List<bbs_cart_info> bbs_cart_infos=buyer.getCart_infos();
			if(bbs_cart_infos!=null&&bbs_cart_infos.size()>0){
				for(int i=0;i<bbs_cart_infos.size();i++){
					bbs_cart_info info=bbs_cart_infos.get(i);
					cartInfoService.deleteById(info.getId());
				}
			}
			bbs_cart_infos=new ArrayList<bbs_cart_info>();
			buyer.setCart_infos(bbs_cart_infos);
			
		}
		return "redirect:/product/display/list.shtml";
	}
}
