package com.it.babasport.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_cart;
import com.it.babasport.po.bbs_cart_info;
import com.it.babasport.po.bbs_order_info;
import com.it.babasport.po.bbs_orders;
import com.it.babasport.po.bbs_product;
import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.CartInfoService;
import com.it.babasport.service.CartService;
import com.it.babasport.service.ColorService;
import com.it.babasport.service.ImgService;
import com.it.babasport.service.OrderInfoService;
import com.it.babasport.service.OrdersService;
import com.it.babasport.service.ProductService;
import com.it.babasport.service.SkuService;


@Controller
public class OrderController {
	@Resource(name="imgService")
	ImgService  imgService;
	@Resource(name="colorService")
	ColorService  colorService;
	@Resource(name="skuService")
	SkuService  skuService;
	@Resource(name="productService")
	ProductService productService;
	@Resource(name="cartService")
	CartService cartService; 
 
	@Resource(name="cartInfoService")
	CartInfoService cartInfoService; 
	@Resource(name="ordersService")
	OrdersService ordersService; 
	@Resource(name="orderInfoService")
	OrderInfoService orderInfoService; 

	@RequestMapping(value="/buyer/productOrder.shtml")
	public String productOrder(Model model){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		model.addAttribute("buyer", buyer);
		return "front_page/product/productOrder";
	}
	@RequestMapping(value="/buyer/confirmOrder.shtml")
	public String confirmOrder(Model model,bbs_orders info){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		if(info.getPaymentWay()!=null){
//		保存order主表信息
		if(info.getPaymentWay()==0){
			info.setIsPaiy(0);
		}else{
			info.setIsPaiy(1);
		}
		info.setAddressId(buyer.getAddress().getId());
		info.setAmount_paid(0);
		info.setAmount_payable(buyer.getTotalPrice());
		info.setBuyerId(buyer.getId());
		info.setCreateDate(new java.util.Date());
		info.setGoTime(new SimpleDateFormat("yyyy年MM月dd日").format(new java.util.Date()));
		info.setDeliverFee(buyer.getTotalFee());
		DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String str=dateFormat.format(new java.util.Date());
		Random random=new Random();
		for(int i=0;i<5;i++){
			str+=random.nextInt(10);
		}
		info.setOid(str);
		info.setState(0);
		info.setTotalPrice(buyer.getTotalPrice()+buyer.getTotalFee());
		int orderId=ordersService.insert(info);
//		插入order表并返回主键
			
		if(buyer!=null){
			List<bbs_cart_info> bbs_cart_infos=buyer.getCart_infos();
			bbs_cart cart=buyer.getCart();
			if(bbs_cart_infos!=null&&bbs_cart_infos.size()>0){
				for(int i=0;i<bbs_cart_infos.size();i++){
				
					bbs_order_info bbs_order_info=new bbs_order_info();

//					保存order子表信息
				
					bbs_cart_info bbs_cart_info=bbs_cart_infos.get(i);
					bbs_order_info.setSkuId(bbs_cart_info.getSkuId());
					bbs_order_info.setAmount(bbs_cart_info.getQuantity());
					bbs_order_info.setColor(bbs_cart_info.getColorName());
					bbs_order_info.setDeFee(bbs_cart_info.getSku().getDeliveFee());
					bbs_order_info.setImgUrl(bbs_cart_info.getImgUrl());;
//					使用返回的主键建立关系
					bbs_order_info.setOrderId(orderId);
					bbs_order_info.setProductId(bbs_cart_info.getProductId());
					bbs_order_info.setProductName(bbs_cart_info.getProduct().getName());
					bbs_order_info.setProductNo(bbs_cart_info.getProduct().getNo());
					bbs_order_info.setSale_price(bbs_cart_info.getSku().getSkuPrice());
					bbs_order_info.setSize(bbs_cart_info.getSku().getSize());
					orderInfoService.insert(bbs_order_info);
					int s=bbs_cart_info.getSku().getStockInventory()-bbs_cart_info.getQuantity();
					bbs_cart_info.getSku().setStockInventory(s);
//					更新sku表中库存量大小
					skuService.updateSku(bbs_cart_info.getSku());
//					删除购物车子表信息
					cartInfoService.deleteById(bbs_cart_info.getId());
//					总数量变成0
					cart.setTotal_quantity(0);
					cartService.update(cart);
				}
			}
//			接下来删除购物车表以及清空主体中购物车信息
			bbs_cart_infos=new ArrayList<bbs_cart_info>();
			buyer.setCart_infos(bbs_cart_infos);
		}
		}
		model.addAttribute("order",info);
		return "front_page/product/confirmOrder";
	}
	@RequestMapping(value="/buyer/buy.shtml")
	public String buy(bbs_cart_info bbs_cart_info,Model model){
//		skuId="+skuId+"&productId="+productId+"&quantity="+num+"&colorId="+colorId_denmo;
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		model.addAttribute("buyer", buyer);
//		加载颜色
		int colorId=bbs_cart_info.getColorId();
		String colorName=colorService.getColorNameById(colorId);
		bbs_cart_info.setColorName(colorName);
//		加载商品
		int productId=bbs_cart_info.getProductId();
		bbs_product product=productService.getProductById(productId);
		bbs_cart_info.setProduct(product);
//		加载sku
		int skuId=bbs_cart_info.getSkuId();
		bbs_sku sku=skuService.getSkuById(skuId);
		bbs_cart_info.setSku(sku);
//		加载图片url
		String url=imgService.getUrl(productId);
		bbs_cart_info.setImgUrl(url);
		model.addAttribute("cart", bbs_cart_info);
		return "front_page/product/productOne";
	}		
	

	@RequestMapping(value="/buyer/confirmMyOrder.shtml")
	public String confirmMyOrder(bbs_orders info,String imgUrl,int quantity,int skuId,int productId,String colorName ,Model model){
		
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		bbs_sku sku=skuService.getSkuById(skuId);
		bbs_product product=productService.getProductById(productId);
		String str=dateFormat.format(new java.util.Date());
		Random random=new Random();
		for(int i=0;i<5;i++){
			str+=random.nextInt(10);
		}
		info.setOid(str);
		info.setAddressId(buyer.getAddress().getId());

		info.setAmount_payable((int)(quantity*sku.getSkuPrice()));
		info.setBuyerId(buyer.getId());
		info.setGoTime(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new java.util.Date()));
		info.setCreateDate(new java.util.Date());
		info.setDeliverFee((int)(sku.getDeliveFee()*quantity));
		info.setTotalPrice((int)(sku.getSkuPrice()*quantity+sku.getDeliveFee()*quantity));
		if(info.getPaymentWay()==0){
			info.setIsPaiy(0);
		}else{
			info.setIsPaiy(1);
		}
		info.setState(0);
		int orderId=ordersService.insert(info);
		bbs_order_info order_info=new bbs_order_info();
		order_info.setAmount(quantity);
		order_info.setColor(colorName);
		order_info.setDeFee(sku.getDeliveFee());
		order_info.setImgUrl(imgUrl);
		order_info.setOrderId(orderId);
		order_info.setProductId(productId);
		order_info.setProductName(product.getName());
		order_info.setProductNo(product.getNo());
		order_info.setSale_price(sku.getSkuPrice());
		order_info.setSize(sku.getSize());
		order_info.setSkuId(skuId);
		orderInfoService.insert(order_info);
//		info.setOrderId(orderId);
//		orderInfoService.insert(info);
		int s=sku.getStockInventory()-order_info.getAmount();
		sku.setStockInventory(s);
//		更新sku表中库存量大小
		skuService.updateSku(sku);
		model.addAttribute("buyer", buyer);
		model.addAttribute("order", info);
		return "front_page/product/confirmOrder";
	
	}
}
