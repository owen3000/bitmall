package com.cafe24.bitmall.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping( "" )
	public String index(Model model) {
		
		List<HashMap<String, Object>> list =
							productService.getList();
		
		
		model.addAttribute("productList", list);
		
		return "main/index";
	}
}
