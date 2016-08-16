package com.it.babasport.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.babasport.po.bbs_sku;
import com.it.babasport.service.ColorService;
import com.it.babasport.service.SkuService;

@Controller
public class SkuController {
	@Resource(name="skuService")
	SkuService  skuService;
	@Resource(name="colorService")
	ColorService  colorService;
		@RequestMapping(value="/sku/list.shtml")
		public String list(Model model,int productId,String pno){
			List<bbs_sku> skus=skuService.getSkus(productId);
			if(skus!=null&&skus.size()>0){
				for(bbs_sku sku:skus){
					String name=colorService.getColorNameById(sku.getColorId());
					sku.setColor(name);
				}
			}
			model.addAttribute("skus", skus);
			model.addAttribute("pno", pno);
			return "back_page/sku/list";
		}
		@RequestMapping(value="/sku/updateSku.shtml")
		public void list(bbs_sku sku,HttpServletResponse response) throws IOException{
			skuService.updateSku(sku);
			org.json.JSONObject jsonObject=new org.json.JSONObject();
			jsonObject.put("message", "保存成功");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonObject.toString());
			
		}

}
