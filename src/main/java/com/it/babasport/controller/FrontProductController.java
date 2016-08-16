package com.it.babasport.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.it.babasport.po.BrandLoad;
import com.it.babasport.po.Color;
import com.it.babasport.po.FeatureLoad;
import com.it.babasport.po.TypeLoad;
import com.it.babasport.po.bbs_buyer;
import com.it.babasport.po.bbs_cart_info;
import com.it.babasport.po.bbs_product;
import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.BrandService;
import com.it.babasport.service.ColorService;
import com.it.babasport.service.FeatureService;
import com.it.babasport.service.ImgService;
import com.it.babasport.service.ProductService;
import com.it.babasport.service.SkuService;
import com.it.babasport.service.TypeService;


@Controller
public class FrontProductController {
	@Resource(name="productService")
	ProductService productService;
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
	@Resource(name="skuService")
	SkuService  skuService;
		@RequestMapping(value="/product/display/list.shtml")
		public String list(Model  model,bbs_product bbs_product,String brandName,String typeName,String featureName,
				@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,
				@RequestParam(value="pageSize",required=false,defaultValue="8")int pageSize){
			List<bbs_product> products= productService.selectProductsBys(bbs_product,pageNum,pageSize);
			for(int i=0;i<products.size();i++){
				bbs_product product= products.get(i);
				String url=imgService.getUrl(product.getId());
				product.setUrl(url);
			};
			PageInfo pageInfo=new PageInfo(products);
			model.addAttribute("products", products);
			model.addAttribute("page", pageInfo);
			List<BrandLoad> list= brandService.loadBrand();
			List<TypeLoad> typeLoads=typeService.load();
			List<FeatureLoad> featureLoads=featureService.load();
			model.addAttribute("types", typeLoads);
			model.addAttribute("features", featureLoads);
			model.addAttribute("brands", list);
//			Map< String, String> map=new LinkedHashMap<String, String>();
			boolean flag=false;
			if(StringUtils.isNotBlank(brandName)){
				model.addAttribute("brandName", brandName);
				model.addAttribute("s1", "品牌");
				flag=true;
//				map.put("品牌", brandName);
			}
			if(StringUtils.isNotBlank(typeName)){
				model.addAttribute("typeName", typeName);
				flag=true;
				model.addAttribute("s2", "类型");
//				map.put("类型", typeName);
			}
			if(StringUtils.isNotBlank(featureName)){
				model.addAttribute("featureName", featureName);
				flag=true;
				model.addAttribute("s3", "材质");
//				map.put("材质", featureName);
			}
			model.addAttribute("flag", flag);
//			model.addAttribute("map", map);
			if(bbs_product.getBrandId()!=null){
				model.addAttribute("brandId",bbs_product.getBrandId());
			}
			if(bbs_product.getTypeId()!=null){
				model.addAttribute("typeId",bbs_product.getTypeId());
			}
			if(StringUtils.isNotBlank(bbs_product.getFeature())){
				model.addAttribute("feature",bbs_product.getFeature());
			}
//			String s=map.get("品牌");
			Subject subject=SecurityUtils.getSubject();
			bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
			model.addAttribute("buyer", buyer);
		
			return "front_page/product/product";
		}
		@RequestMapping(value="/product/detail.shtml")
		public String  detail(Model  model,int productId,String productName){
			List<bbs_sku> skus=skuService.getSkusExe(productId);
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
			String url=imgService.getUrl(productId);
			Subject subject=SecurityUtils.getSubject();
			bbs_buyer buyer=(bbs_buyer) subject.getPrincipal();
			model.addAttribute("buyer", buyer);
//			model.addAttribute("cart", buyer.getCart());
//			model.addAttribute("cartInfos", buyer.getCart_infos());
			model.addAttribute("url", url);
			model.addAttribute("skus", skus);
			model.addAttribute("colors", colors);
			model.addAttribute("productName", productName);
			return "front_page/product/productDetail";
		}
}
