package com.it.babasport.realms;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.it.babasport.po.bbs_address;
import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_cart;
import com.it.babasport.po.bbs_cart_info;
import com.it.babasport.po.bbs_product;
import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.AddressService;
import com.it.babasport.service.BuyerService;
import com.it.babasport.service.CartInfoService;
import com.it.babasport.service.CartService;
import com.it.babasport.service.ColorService;
import com.it.babasport.service.ImgService;
import com.it.babasport.service.ProductService;
import com.it.babasport.service.SkuService;
import com.it.babasport.utils.MD5;



public class CustomRealm extends AuthorizingRealm{

	public void setName(String name) {
		
		super.setName("customRealm");
	}	
	@Resource(name="buyerService")
	BuyerService buyerService;
	@Resource(name="cartService")
	CartService cartService; 
	@Resource(name="cartInfoService")
	CartInfoService cartInfoService; 
	@Resource(name="imgService")
	ImgService  imgService;
	@Resource(name="colorService")
	ColorService  colorService;
	@Resource(name="skuService")
	SkuService  skuService;
	@Resource(name="productService")
	ProductService productService;
	@Resource(name="addressService")
	AddressService addressService;

	//授权	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		
		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
//		ActiveUser activeUser =  (ActiveUser) principalCollection.getPrimaryPrincipal();
//		String userid=activeUser.getUserid();
//		List<SysPermission> list=null;
//		try {
//			list=sysService.findPermissionByUserid(userid);
//		} catch (Exception e) {
//			// 
//			e.printStackTrace();
//		}
//		List<String> permissions = new ArrayList<String>();
//		if(list!=null&&list.size()>0){
//		for(SysPermission permission:list){
//			permissions.add(permission.getPercode());//用户的创建
//		}
//		}
		//根据身份信息获取权限信息
		//连接数据库...
		//模拟从数据库获取到数据
//
//		permissions.add("item:query");//商品添加权限
		//....
		
		
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
//		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;

	}

//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)  {
		

	
		String username = (String) authenticationToken.getPrincipal();

	
		bbs_buyer buyer=null;
		
			try {
				buyer=buyerService.findBuyerByUsername(username);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(buyer==null){
				return null;
			}
//			加载默认收获人
			bbs_address address=addressService.getAddress();
			buyer.setAddress(address);
//			通过buyerId加载其购物车
			String buyerId=buyer.getId();
			bbs_cart bbs_cart= cartService.getCartByBuyerID(buyerId);
			if(bbs_cart!=null){
//				购车不为空将其保存到buyer中
				buyer.setCart(bbs_cart);
//				得到购物车id
				int cartId=bbs_cart.getId();
//				通过购物车cartId加载购物车子表信息
				List<bbs_cart_info> cart_infos=cartInfoService.getCartInfoByCartId(cartId);
				if(cart_infos!=null&&cart_infos.size()>0){
					for(int i=0;i<cart_infos.size();i++){
						bbs_cart_info info=cart_infos.get(i);
//						加载颜色
						int colorId=info.getColorId();
						String colorName=colorService.getColorNameById(colorId);
						info.setColorName(colorName);
//						加载商品
						int productId=info.getProductId();
						bbs_product product=productService.getProductById(productId);
						info.setProduct(product);
//						加载sku
						int skuId=info.getSkuId();
						bbs_sku sku=skuService.getSkuById(skuId);
						info.setSku(sku);
//						加载图片url
						String url=imgService.getUrl(productId);
						info.setImgUrl(url);
						
					}
					buyer.setCart_infos(cart_infos);
				}
			}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				buyer,buyer.getPassword(), this.getName());
//		,ByteSource.Util.bytes(sysUser.getSalt()) 
		return simpleAuthenticationInfo;
	}
	//清除缓存  使用在service层注入调用此方法
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}


}
