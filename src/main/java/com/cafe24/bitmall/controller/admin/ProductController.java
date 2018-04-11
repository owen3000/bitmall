package com.cafe24.bitmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminProductController")
@RequestMapping(value= {"/admin"})
public class ProductController {
	
	@RequestMapping(value= {"/product"})
	public String product() {
		
		return "admin/product";
	}
	
	@RequestMapping(value= {"/product/new"})
	public String productNew() {
		
		return "admin/product_new";
	}
}
