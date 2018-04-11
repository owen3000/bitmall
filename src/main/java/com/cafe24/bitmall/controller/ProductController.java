package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	
	@RequestMapping(value= {"/product"})
	public String product() {
		
		return "product";
	}
	
	@RequestMapping(value= {"/product/detail"})
	public String detail() {
		
		return "product_detail";
	}
}
