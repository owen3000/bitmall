package com.cafe24.bitmall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.ProductService;
import com.cafe24.util.WebUtil;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value= {"/product"})
	public String product() {

		
		
		
		return "product";
	}
	
	@RequestMapping(value= {"/product/detail"})
	public String productDetail(@RequestParam(value="no",required=true,defaultValue="")String no,
			Model model) {
		Long lNo = WebUtil.checkParameter(no.trim(), -1L);
		if( lNo == -1L || "".equals(no.trim()) ) {
			System.out.println("[ProductController:productDetail] if( lNo == -1L || \"\".equals(no) ) ");
			return "redirect:/admin/opt";
		}
		
		Map<String, Object> map = 
					productService.getDetail(lNo);
		
		model.addAttribute("map", map);
		return "product_detail";
	}

}
