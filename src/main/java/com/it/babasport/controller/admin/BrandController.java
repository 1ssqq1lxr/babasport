package com.it.babasport.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.it.babasport.po.bbs_brand;
import com.it.babasport.service.BrandService;

@Controller
public class BrandController {
	@Resource(name="brandService")
	BrandService brandService;
	@RequestMapping(value="/brand/list.do")
	public String findBrandWithPage(Model model, bbs_brand brand,@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,
			@RequestParam(value="pageSize",required=false,defaultValue="5")int pageSize
			){
		List<bbs_brand> list=brandService.findBrandbyExampleWithPage(brand, pageNum, pageSize);
		PageInfo pageInfo=new PageInfo(list);
		StringBuilder stb=new StringBuilder();
		if(StringUtils.isNotBlank(brand.getName())){
			stb.append("/brand/list.do?name=").append(brand.getName()).append("&is_display=").append(brand.getIs_display());
		}
		else{
			stb.append("/brand/list.do?is_display=").append(brand.getIs_display());
		};
		
		model.addAttribute("page",pageInfo);
		model.addAttribute("list", list);
		model.addAttribute("name", brand.getName());
		model.addAttribute("is_display", brand.getIs_display());
		model.addAttribute("url", stb.toString());
		return "back_page/brand/list";
		
	}
	//跳转添加页面
	@RequestMapping(value="/brand/toAdd.do")
	public String toAdd(){
			return "back_page/brand/add";
	}
	//添加
	@RequestMapping(value="/brand/add.do")
	public String add(bbs_brand brand){
			brandService.insert(brand);
			return "redirect:list.do";
	}
	//删除
		@RequestMapping(value="	/brand/delete.do")
	public String delete(Model model,int id,String name,String is_display,int pageNum){
			 brandService.delete(id);
			 if(StringUtils.isNotBlank(name)){
				 model.addAttribute("name", name);
				};
			 model.addAttribute("pageNum", pageNum);
			 model.addAttribute("is_display", is_display);
			return "redirect:list.do";
	}
		//批量删除
		@RequestMapping(value="	/brand/deleteAll.do")
	public String deleteAll(Model model,Integer[] ids,String name,String is_display,int pageNum){
			 brandService.deleteAll(ids);
			 if(StringUtils.isNotBlank(name)){
				 model.addAttribute("name", name);
				};
			
			 model.addAttribute("pageNum", pageNum);
			 model.addAttribute("is_display", is_display);
			return "redirect:list.do";
	}
		//跳转更新页面并回显
		@RequestMapping(value="	/brand/update.do")
	public String update(Model model,int id,String name,String is_display,int pageNum){
			bbs_brand brand=brandService.findBrandById(id);	
			model.addAttribute("brand", brand);
			model.addAttribute("pageNum1", pageNum);
			if(StringUtils.isNotBlank(name)){
				model.addAttribute("name1", name);
			};
			model.addAttribute("is_display1", is_display);
			return "back_page/brand/edit";
	}
		//跟新
		@RequestMapping(value="	/brand/save.do")
		public String save(Model model,bbs_brand brand,String name1,String is_display1,int pageNum1){
				brandService.update(brand);
				if(StringUtils.isNotBlank(name1)){
					model.addAttribute("name", name1);
				};
				model.addAttribute("pageNum", pageNum1);
				model.addAttribute("is_display", is_display1);
				return "redirect:list.do";
		}
}
