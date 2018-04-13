package com.cafe24.bitmall.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.service.admin.CategoryService;
import com.cafe24.bitmall.service.admin.EventService;
import com.cafe24.bitmall.service.admin.OptService;
import com.cafe24.bitmall.service.admin.ProductService;
import com.cafe24.bitmall.service.admin.SalesStatusService;
import com.cafe24.bitmall.vo.CategoryVO;
import com.cafe24.bitmall.vo.EventVO;
import com.cafe24.bitmall.vo.OptVO;
import com.cafe24.bitmall.vo.ProductVO;
import com.cafe24.bitmall.vo.SalesStatusVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.util.WebUtil;

@Controller("adminProductController")
@Auth(role=Role.ADMIN)
@RequestMapping(value= {"/admin"})
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OptService optService;
	
	@Autowired
	private SalesStatusService salesStatusService;

	@Autowired
	private EventService eventService;

	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value= {"/product"})
	public String product() {
		
		return "admin/product";
	}
	
	@RequestMapping(value= {"/product_new"})
	public String productNew(Model model) {
		
		List<CategoryVO> cList = categoryService.getList();
		if( WebUtil.checkListEmptyOrNull(cList, "[ProductController:productNew] cList ") )
			return "redirect:/admin/opt";
		
		List<OptVO> oList = optService.getList();
		if( WebUtil.checkListEmptyOrNull(oList, "[ProductController:productNew] oList ") )
			return "redirect:/admin/opt";
		
		List<SalesStatusVO> sList = salesStatusService.getList();
		if( WebUtil.checkListEmptyOrNull(sList, "[ProductController:productNew] sList ") )
			return "redirect:/admin/opt";
		
		List<EventVO> eList = eventService.getList();
		if( WebUtil.checkListEmptyOrNull(eList, "[ProductController:productNew] eList ") )
			return "redirect:/admin/opt";
		
		model.addAttribute("categoryList", cList);
		model.addAttribute("optList", oList);
		model.addAttribute("salesStatusList", sList);
		model.addAttribute("eventList", eList);
		return "admin/product_new";
	}
	
	@RequestMapping(value= {"/product_new"},method=RequestMethod.POST)
	public String productNew(@RequestParam(value="file") MultipartFile[] mpf,
			@RequestParam(value="category",required=true,defaultValue="")String category,
			@ModelAttribute ProductVO pvo, 
			@RequestParam(value="opt",required=true,defaultValue="none")String[] opt,
			@RequestParam(value="status",required=true,defaultValue="")String status,
			@RequestParam(value="event",required=true,defaultValue="none")String[] event,
			@RequestParam(value="discount",required=true,defaultValue="0")String discount) {

		// vo 값 @vaild
		/*if( result.hasErrors() ) {
			System.out.println("[ProductController:productNew] BindingResult error!");
			return "redirect:/admin/product_new";
		}*/ 
		
		if( "0".equals(category) ) {
			System.out.println("[ProductController:productNew] 상품 카테고리 미지정!");
			return "redirect:/admin/product_new";
		}
		
		
		Long lCategoryNo = WebUtil.checkParameter(category, -1L);
		Long lStatus = WebUtil.checkParameter(status, -1L);

		if( lCategoryNo == -1L || lStatus == -1L ) {
			System.out.println("[ProductController:productNew] 카테고리,판매상태 번호 -1L !");
			return "redirect:/admin/product";
		}
		
		//상품 insert
		pvo.setCategoryNo(lCategoryNo);
		pvo.setSalesStatusNo(lStatus);
		productService.insert(pvo,event,mpf,opt);
			
		return "redirect:/admin/product";
	}
	
/*	public boolean updateBlog(MultipartFile mf, String title, String url,long no) {
		String originFilename = "";
		String saveFilename = "";
		BlogVO vo = new BlogVO();
		vo.setNo(no);
		vo.setTitle(title);
		if( mf != null) {
			originFilename  = mf.getOriginalFilename();
			vo.setOriginalName(originFilename);
		}
		if( !("".equals(url)) ) {
			saveFilename = 
					url.substring(url.lastIndexOf("/")+1,url.length());
			vo.setSaveName(saveFilename);
		}
		return blogDAO.update(vo);
	}*/
}
