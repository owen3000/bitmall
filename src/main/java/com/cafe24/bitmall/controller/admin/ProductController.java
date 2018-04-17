package com.cafe24.bitmall.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.bitmall.service.admin.CategoryService;
import com.cafe24.bitmall.service.admin.EventService;
import com.cafe24.bitmall.service.admin.ImageService;
import com.cafe24.bitmall.service.admin.OptService;
import com.cafe24.bitmall.service.admin.ProductService;
import com.cafe24.bitmall.service.admin.SalesStatusService;
import com.cafe24.bitmall.vo.CategoryVO;
import com.cafe24.bitmall.vo.EventVO;
import com.cafe24.bitmall.vo.ImageVO;
import com.cafe24.bitmall.vo.OptVO;
import com.cafe24.bitmall.vo.ProductVO;
import com.cafe24.bitmall.vo.SalesStatusVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.util.PagingBean;
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
	private ImageService imageService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value= {"/product"})
	public String product(Model model, @ModelAttribute("readLists")Map<String,Object> map,
			@RequestParam(value="nowPage",required=true,defaultValue="1") String nowPage,
			@RequestParam(value="status",required=true,defaultValue="") String status,
			@RequestParam(value="event",required=true,defaultValue="") String event,
			@RequestParam(value="category",required=true,defaultValue="") String category,
			@RequestParam(value="keyword",required=true,defaultValue="") String keyword,
			@RequestParam(value="option",required=true,defaultValue="") String option) {
		
		// nowPage url로 한글 입력시 error 방지처리.
		Long lNowPage = WebUtil.checkParameter(nowPage, 1L);
		System.out.println("nowPage:"+nowPage);
		Map<String, String> opts = new HashMap<String,String>();
		opts.put("option", option);
		opts.put("keyword", keyword);
		opts.put("status", status);
		opts.put("event", event);
		opts.put("category", category);
		System.out.println(opts);
		Long totalCount = productService.getTotalCount(opts);
		System.out.println(totalCount);
		PagingBean pb = new PagingBean(totalCount, lNowPage, 2, 3,opts);
		
		
		List<HashMap<String, String>> list = 
				productService.getList(pb);
		if( list == null) {
			list = new ArrayList<HashMap<String, String>>();
		}
	
		//	model.addAttribute("readLists", map);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("productList", list);
		model.addAttribute("pb", pb);
		return "admin/product";
	}
	
	@RequestMapping(value= {"/product_new"},method=RequestMethod.GET)
	public String productNew(Model model, @ModelAttribute("readLists")Map<String,Object> map) {
		
		// 와... 드이어 해결...
		//System.out.println(model.containsAttribute("productVO"));// true
		if(!model.containsAttribute("productVO")) {
			model.addAttribute("productVO", new ProductVO());
		}
		@SuppressWarnings("unchecked")
		List<OptVO> oList = (List<OptVO>) map.get("optList");
		if( oList.isEmpty() ) {
			return "redirect:/admin/opt";
		}
		//model.addAttribute("readLists", map);
		return "admin/product_new";
	}
	
	@ModelAttribute("readLists")
	public Map<String, Object> readList(){
		List<CategoryVO> cList = new ArrayList<CategoryVO>();
		cList = categoryService.getList();
		WebUtil.checkListEmptyOrNull(cList, "[ProductController:productNew] cList ") ;

		List<OptVO> oList = new ArrayList<OptVO>();
		oList = optService.getList();
		WebUtil.checkListEmptyOrNull(oList, "[ProductController:productNew] oList ");

		List<SalesStatusVO> sList = new ArrayList<SalesStatusVO>();
		sList = salesStatusService.getList();
		WebUtil.checkListEmptyOrNull(sList, "[ProductController:productNew] sList ");

		List<EventVO> eList =  new ArrayList<EventVO>();
		eList =	eventService.getList();
		WebUtil.checkListEmptyOrNull(eList, "[ProductController:productNew] eList ");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryList", cList);
		map.put("optList", oList);
		map.put("salesStatusList", sList);
		map.put("eventList", eList);
		return map;
	}
	
	@RequestMapping(value= {"/product_new"},method=RequestMethod.POST)
	public String productNew(@RequestParam(value="file") MultipartFile[] mpf,
			@ModelAttribute("productVO") @Valid ProductVO productVO, BindingResult result,
			@RequestParam(value="opt",required=true,defaultValue="none")String[] opt,
			@RequestParam(value="event",required=true,defaultValue="none")String[] event,
			@RequestParam(value="discount",required=true,defaultValue="0")String discount,
			RedirectAttributes reattr) {

		// vo 값 @vaild
		if( result.hasErrors() ) {
			System.out.println("[ProductController:productNew] BindingResult error!");
			reattr.addFlashAttribute("org.springframework.validation.BindingResult.productVO", result);
			reattr.addFlashAttribute("productVO", productVO);
			return "redirect:/admin/product_new";
		} 
		
		//상품 insert
		productService.insert(productVO,event,mpf,opt);
			 
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value= {"/product_delete"})
	public String productDelete(@RequestParam(value="no",required=true,defaultValue="")String no) {
		
		Long lNo = WebUtil.checkParameter(no.trim(), -1L);
		if( lNo == -1L || "".equals(no.trim()) ) {
			System.out.println("[ProductController:productDelete] if( lNo == -1L || \"\".equals(no) ) ");
			return "redirect:/admin/opt";
		}
		
		if( !productService.delete(lNo) ) {
			System.out.println("[ProductController:productDelete] if( !productService.delete(lNo) ) ");
		}
		
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value= {"/product_edit"})
	public String productEdit(@RequestParam(value="no",required=true,defaultValue="")String no,
			 @ModelAttribute("readLists")Map<String,Object> map, Model model) {
		
		Long lNo = WebUtil.checkParameter(no.trim(), -1L);
		if( lNo == -1L || "".equals(no.trim()) ) {
			System.out.println("[ProductController:productEdit] if( lNo == -1L || \"\".equals(no) ) ");
			return "redirect:/admin/opt";
		}
		
		ProductVO result = productService.get(lNo);
		if( result == null ) {
			System.out.println("[ProductController:productEdit] if( result == null ) ");
			return "redirect:/admin/product";			
		}
		
		List<ImageVO> imageList = imageService.getByNo(result.getNo());
		if( imageList == null ) {
			System.out.println("[ProductController:productEdit] if( imageVO == null ) ");
			return "redirect:/admin/product";			
		}	
		
		model.addAttribute("productVO", result);
		model.addAttribute("imageList", imageList);
		return "admin/product_edit";
	}
}
