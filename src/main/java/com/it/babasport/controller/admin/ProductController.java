package com.it.babasport.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.babasport.po.BrandLoad;
import com.it.babasport.po.Color;
import com.it.babasport.po.ColorLoad;
import com.it.babasport.po.FeatureLoad;
import com.it.babasport.po.TypeLoad;
import com.it.babasport.po.bbs_brand;
import com.it.babasport.po.bbs_product;
import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.BrandService;
import com.it.babasport.service.ColorService;
import com.it.babasport.service.FeatureService;
import com.it.babasport.service.FreeMarkerService;
import com.it.babasport.service.ImgService;
import com.it.babasport.service.ProductService;
import com.it.babasport.service.SkuService;
import com.it.babasport.service.TypeService;
@Controller
public class ProductController {
	@Resource(name="productService")
	ProductService productService;
	@Resource(name="skuService")
	SkuService  skuService;
	@Resource(name="typeService")
	TypeService typeService;
	@Resource(name="featureService")
	FeatureService featureService;
	@Resource(name="brandService")
	BrandService  brandService;
	@Resource(name="imgService")
	ImgService  imgService;
	@Resource(name="colorService")
	ColorService  colorService;
	@Resource(name="freeMarkerService")
	FreeMarkerService freeMarkerService;
	@RequestMapping(value="/product/list.do")
	public String list(Model model,bbs_product bbs_product,@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,
			@RequestParam(value="pageSize",required=false,defaultValue="5")int pageSize){
		//		 @RequestParam(value="isShow",required=true,defaultValue="0")int isShow,String name,int brandId
		List<bbs_product> products= productService.selectProducts(bbs_product,pageNum,pageSize);
		for(int i=0;i<products.size();i++){
			bbs_product product= products.get(i);
			String url=imgService.getUrl(product.getId());
			product.setUrl(url);
		}
		List<BrandLoad> list= brandService.loadBrand();
		PageInfo pageInfo=new PageInfo(products);
		model.addAttribute("page", pageInfo);
		if(StringUtils.isNotBlank(bbs_product.getName())){
			model.addAttribute("name",bbs_product.getName());
		}
		if(StringUtils.isNotBlank(bbs_product.getBrandId()+"")){
			model.addAttribute("brandId",bbs_product.getBrandId());
		}
		model.addAttribute("isShow",bbs_product.getIsShow());
		model.addAttribute("list", products);
		model.addAttribute("brands", list);
		return "back_page/product/list";
	}
	@RequestMapping(value="/product/loadBrand.do")
	public void loadBrand(HttpServletResponse response) throws IOException{
		List<BrandLoad> list= brandService.loadBrand();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("list",list);
		String str=jsonObject.toString();
		response.setContentType("text/html;charset=UTF-8"); 
		response.getWriter().write(str);

	}
	@RequestMapping(value="/product/add.do")
	public String loadBrand(Model model,HttpServletRequest request) throws IOException{

		List<ColorLoad> colorLoads=colorService.load();
		List<TypeLoad> typeLoads=typeService.load();
		List<FeatureLoad> featureLoads=featureService.load();

		request.setAttribute("color", colorLoads);
		request.setAttribute("type", typeLoads);
		model.addAttribute("feature", featureLoads);
		return "back_page/product/add";

	}
	@RequestMapping(value="/product/addAll.do")
	public String andAll(Model model,bbs_product product,String url) throws IOException{
		productService.add(product,url);
		model.addAttribute("isShow", 0);
		return "redirect:list.do";

	}
	@RequestMapping(value="/product/upShow.do")
	public String upShow(Model model,int[] ids,@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,bbs_product product) throws IOException{
		//上架
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("name",product.getName());
		model.addAttribute("brandId",product.getBrandId());
		model.addAttribute("isShow",product.getIsShow());
		bbs_product product1=new bbs_product();
		for(Integer id:ids){
			Map<String,Object> maps=new HashMap<String, Object>();
			product1.setId(id);
			product1.setIsShow(1);
			productService.updateProductByKey(product1);
			//页面静态化
			List<bbs_sku> skus=skuService.getSkusExe(id);
			String productName=productService.getNameById(id);
			List<Color> colors=new ArrayList<Color>();
			if(skus!=null&&skus.size()>0){
				for(bbs_sku sku:skus){
					Color color=new Color();
					String name=colorService.getColorNameById(sku.getColorId());
					sku.setColor(name);
					color.setColorId(sku.getColorId());
					color.setColorName(name);
					if(!colors.contains(color)){
						colors.add(color);
					}
				}
			}
			String url=imgService.getUrl(id);
			maps.put("url", url);
			maps.put("skus", skus);
			maps.put("colors", colors); 
			maps.put("productName", productName);
			freeMarkerService.productStatic(maps, id);
		}
		
		
		return "redirect:list.do";
	}
	@RequestMapping(value="/product/delete.do")
	public String delete(Model model,int id,@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,bbs_product product) throws IOException{
		//删除
		productService.delete(id);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("name",product.getName());
		model.addAttribute("brandId",product.getBrandId());
		model.addAttribute("isShow",product.getIsShow());
		return "redirect:list.do";
	}
//	freemarker返回其视图
//	@RequestMapping(value="/product/freeMarker.do")
//	public String freeMarker(Model model,@RequestParam(value="id",required=false,defaultValue="30")int id) throws IOException{
//		//删除
//		List<bbs_sku> skus=skuService.getSkusExe(id);
//		String productName=productService.getNameById(id);
//		List<Color> colors=new ArrayList<Color>();
//		if(skus!=null&&skus.size()>0){
//			for(bbs_sku sku:skus){
//				Color color=new Color();
//				String name=colorService.getColorNameById(sku.getColorId());
//				sku.setColor(name);
//				color.setColorId(sku.getColorId());
//				color.setColorName(name);
//				if(!colors.contains(color)){
//					colors.add(color);
//				}
//			}
//		}
//		String url=imgService.getUrl(id);
//		model.addAttribute("url", url);
//		model.addAttribute("skus", skus);
//		model.addAttribute("colors", colors);
//		model.addAttribute("productName", productName);
//		return "productDetail.ftl";
//	}
	
	@RequestMapping(value="/product/downShow.do")
	public String downShow(Model model,int[] ids,@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,bbs_product product) throws IOException{
		//上架
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("name",product.getName());
		model.addAttribute("brandId",product.getBrandId());
		model.addAttribute("isShow",product.getIsShow());
		bbs_product product1=new bbs_product();
		for(Integer id:ids){
			Map<String,Object> maps=new HashMap<String, Object>();
			product1.setId(id);
			product1.setIsShow(0);
			productService.updateProductByKey(product1);
			//页面静态化
		}	
		return "redirect:list.do";
	}
}
