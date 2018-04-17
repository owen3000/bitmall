package com.cafe24.bitmall.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.CategoryServie;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.CategoryVO;
import com.cafe24.util.WebUtil;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryServie categoryServie;
	
	@ModelAttribute("categoryList")
	public List<CategoryVO> categoryList(){
		List<CategoryVO> categoryList = categoryServie.getList();
		return categoryList;
	}
	
	@RequestMapping( "" )
	public String index(Model model, @ModelAttribute("categoryList") List<CategoryVO> categoryList,
			@RequestParam(value="category-no",required=true,defaultValue="")String categoryNo) {
		
		Long lCategoryNo = WebUtil.checkParameter(categoryNo.trim(), -1L);
		
		List<HashMap<String, Object>> productList =
							productService.getList(lCategoryNo);
		
		
		
		
		model.addAttribute("productList", productList);
		
		return "main/index";
	}
	
	@RequestMapping( "/product_search" )
	public String productSearch(Model model, @ModelAttribute("categoryList") List<CategoryVO> categoryList,
			@RequestParam(value="findtext",required=true,defaultValue="")String findtext) {
		
		
		List<HashMap<String, Object>> productList =
							productService.getSearchList(findtext);
		
		model.addAttribute("productList", productList);
		
		return "main/index";
	}
}
