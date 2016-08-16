package com.it.babasport.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/control")
public class PageController {
	@RequestMapping(value="/index.do")
	public String index(){
		return "back_page/index";
	}
	@RequestMapping(value="/top.do")
	public String top(){
		return "back_page/top";
	}
	@RequestMapping(value="/main.do")
	public String main(){
		return "back_page/main";
	}
	@RequestMapping(value="/left.do")
	public String left(){
		return "back_page/left";
	}
	@RequestMapping(value="/right.do")
	public String right(){
		return "back_page/right";
	}
	@RequestMapping(value="frame/product_main.do")
	public String product_main(){
		return "back_page/frame/product_main";
	}
	@RequestMapping(value="/frame/order_main.do")
	public String order_main(){
		return "back_page/frame/order_main";
	}
	@RequestMapping(value="/frame/product_left.do")
	public String product_left(){
		return "back_page/frame/product_left";
	}
	@RequestMapping(value="/frame/order_left.do")
	public String order_left(){
		return "back_page/frame/order_left";
	}
}
