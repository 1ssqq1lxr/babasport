package com.it.babasport.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.babasport.po.bbs_address;
import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_city;
import com.it.babasport.po.bbs_orders;
import com.it.babasport.po.bbs_province;
import com.it.babasport.service.AddressService;
import com.it.babasport.service.BuyerService;
import com.it.babasport.service.CityService;
import com.it.babasport.service.OrderInfoService;
import com.it.babasport.service.OrdersService;
import com.it.babasport.service.ProvinceService;


@Controller
public class BuyerController {
	@Resource(name="ordersService")
	OrdersService ordersService; 
	@Resource(name="orderInfoService")
	OrderInfoService orderInfoService; 
	@Resource(name="provinceService")
	ProvinceService provinceService;
	@Resource(name="cityService")
	CityService cityService;
	@Resource(name="buyerService")
	BuyerService buyerService;
	@Resource(name="addressService")
	AddressService addressService;
	@RequestMapping("/buyer/login.shtml")
	public String login(HttpServletRequest request,Model model ){
		//未验证成功跳转页面
		
		String shiroLoginFailure=(String) request.getAttribute("shiroLoginFailure");
		if(shiroLoginFailure!=null){
			if (UnknownAccountException.class.getName().equals(shiroLoginFailure)) {
				//最终会抛给异常处理器
				model.addAttribute("error", "账户不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					shiroLoginFailure)) {
				model.addAttribute("error", "用户或密码有误");
			}
			else if("randomCodeError".equals(shiroLoginFailure)){
				model.addAttribute("error", "验证码错误 ");
			}
			
		}
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		if(buyer!=null){
			model.addAttribute("buyer", buyer);
		}
		
		return "front_page/buyer/login";
	}
	@RequestMapping("/buyer/cart.shtml")
	public void cart(HttpSession session,Model model ){
				
	}
	@RequestMapping("/logout/logout.shtml")
	public void logout(HttpSession session,Model model ){

	
	}
//	前台查询订单页面
	@RequestMapping("/buyer/myOrder.shtml")
	public String myOrder(Model model ){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		List<bbs_orders> list=ordersService.getAllOrders(buyer.getId());
		model.addAttribute("orders", list);
		model.addAttribute("buyer", buyer);
		return "front_page/buyer/orders";
	}
//	前台查询收货人页面
	@RequestMapping("/buyer/deliver_address.shtml")
	public String deliver_address(Model model,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		model.addAttribute("buyer", buyer);
		List<bbs_address> addresses=addressService.getAll(buyer.getId());	
		request.setAttribute("addresses", addresses);
		return "front_page/buyer/deliver_address";
	}
//	前台修改密码页面
	@RequestMapping("/buyer/change_password.shtml")
	public String change_password(Model model ){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		model.addAttribute("buyer", buyer);
		return "front_page/buyer/change_password";
	}
//	前台查询个人资料页面
	@RequestMapping("/buyer/myProfile.shtml")
	public String myProfile(Model model ){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		model.addAttribute("buyer", buyer);
		
		return "front_page/buyer/profile";
	}
	@RequestMapping("/auth.shtml")
	public void auth(HttpServletResponse response ) throws IOException{
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		JSONObject object=new JSONObject();
		if(buyer!=null){
			object.put("name", buyer.getRealName());
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(object.toString());
		}
	}
	@RequestMapping("/buyer/loadProvince.shtml")
	public void loadProvince(Model model ,HttpServletResponse response) throws IOException{
		List<bbs_province> provinces=provinceService.findAll();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("list", provinces);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(jsonObject.toString());
	}
	@RequestMapping("/buyer/loadCiry.shtml")
	public void loadCiry(int pid ,HttpServletResponse response) throws IOException{
		List<bbs_city> list=cityService.findCitysByProvince(pid);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("citys", list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(jsonObject.toString());
	}
	@RequestMapping("/buyer/profile.shtml")
	public String profile(bbs_buyer buyer ,Model model ) throws IOException{
			buyerService.save(buyer);
			Subject subject=SecurityUtils.getSubject();
			bbs_buyer buyer1=(bbs_buyer) subject.getPrincipal();
			buyer1.setRealName(buyer.getRealName());
			bbs_buyer bbs_buyer=buyerService.selectById(buyer.getId());
			model.addAttribute("buyer", bbs_buyer);
			return "front_page/buyer/profile";
	}
//	增加收货地址
	@RequestMapping(value="/buyer/addAddress.shtml")
	public String addAddress(bbs_address bbs_address){
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		bbs_address.setBuyerId(buyer.getId());
		addressService.add(bbs_address);
		return "redirect:/buyer/deliver_address.shtml";
	}
//	删除收货地址
	@RequestMapping(value="/buyer/deleteAddress.shtml")
	public String deleteAddress(bbs_address address,Model model){
		address.setIsDef(1);
		address.setStatusAddr(0);
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		model.addAttribute("buyer", buyer);
		addressService.deleteById(address);
		return "redirect:/buyer/deliver_address.shtml";
	}
//	设置默认收获地址
	@RequestMapping(value="/buyer/setStatus.shtml")
	public String setStatus(bbs_address address,Model model){
		address.setStatusAddr(1);
		Subject subject=SecurityUtils.getSubject();
		bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
		addressService.setStatus(address);
//		重新设置主体中的默认地址
		bbs_address address2=buyer.getAddress();
		address2=addressService.getAddress();
		buyer.setAddress(address2);
		model.addAttribute("buyer", buyer);
		
		return "redirect:/buyer/deliver_address.shtml";
	}
}
