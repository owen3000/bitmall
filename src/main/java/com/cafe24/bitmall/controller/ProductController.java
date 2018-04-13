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
	
/*	@Auth
	@RequestMapping(value = {"/blog/update"},method=RequestMethod.POST)
	public String update(@AuthUser UserVO authUser,
			@RequestParam(value="title",required=true,defaultValue="")String title,
			@RequestParam(value="logo-file",required=true,defaultValue="")MultipartFile mf) {
		
		BlogVO vo = blogService.getBlog(authUser.getNo());
		//title 없을시 기본값 셋팅, Query때문에..
		if("".equals(title)) {
			title = vo.getTitle();
		}
		long no = vo.getNo();
		String url = "";
		if( !(mf.isEmpty()) ) {
			url = fileUploadService.restore(mf);
		}
		if( !(blogService.updateBlog(mf,title,url,no)) ) {
			System.out.println("[BlogController.update] "
					+ "if( !(blogService.updateBlog(mf,title,url)) )");
			return "redirect:/"+authUser.getId();
		}
		return "redirect:/"+authUser.getId();
	}*/
}
