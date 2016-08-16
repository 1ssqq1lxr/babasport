package com.it.babasport.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.babasport.po.bbs_orders;
import com.it.babasport.service.OrderInfoService;
import com.it.babasport.service.OrdersService;

@Controller
public class OrderMainController {
	@Resource(name="ordersService")
	OrdersService ordersService; 
	@Resource(name="orderInfoService")
	OrderInfoService orderInfoService; 
	@RequestMapping(value="frame/order_main.do")
	public String order_main(){
		return "back_page/frame/order_main";
	}
	@RequestMapping(value="/order/order_left.do")
	public String order_left(){
		return "back_page/frame/order_left";
	}
//	加载所有订单
	@RequestMapping(value="/order/list.do")
	public String list(Model model,
			@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,
			@RequestParam(value="pageSize",required=false,defaultValue="8")int pageSize ){
		PageHelper.startPage(pageNum, pageSize);
		List<bbs_orders> list=ordersService.getAllOrdersMain();
		PageInfo pageInfo=new PageInfo(list);
		model.addAttribute("orders", list);
		model.addAttribute("page", pageInfo);
		return "back_page/order/list";
	}
//	查看订单详情
	@RequestMapping(value="/order/view.do")
	public String view(Model model ){
		return "back_page/order/view";
	}
}
