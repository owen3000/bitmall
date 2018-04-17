package com.cafe24.bitmall.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.bitmall.service.CategoryServie;
import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.CategoryVO;
import com.cafe24.bitmall.vo.UserVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.Auth.Role;

@Controller
@RequestMapping(value= {"/user"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryServie categoryServie;
	
	@ModelAttribute("categoryList")
	public List<CategoryVO> categoryList(){
		List<CategoryVO> categoryList = categoryServie.getList();
		return categoryList;
	}
	
	@RequestMapping(value= {"/join"}, method=RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVO vo, BindingResult result,
			@ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		
		// @Valid Errors시 메인으로.
		if(result.hasErrors()) {
			System.out.println("[UserController:join] if(result.hasErrors())");
			return "redirect:/";
		}
		
		if( !userService.join(vo) ) {
			System.out.println("[UserController:join] if( !userService.join(vo) )");
			return "redirect:/";
		}
		
		return "redirect:/user/member_joined";
	}
	
	
	@RequestMapping(value= {"/member_login"},method=RequestMethod.GET)
	public String login(@ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		
		return "user/member_login";
	}
	
	@RequestMapping(value= {"/member_agree"})
	public String agree(@ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		
		return "user/member_agree";
	}
	
	@RequestMapping(value= {"/member_join"})
	public String join(@ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		
		return "user/member_join";
	}
	
	@RequestMapping(value= {"/member_joined"})
	public String joined(@ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		
		return "user/member_joined";
	}
	
	@Auth(role=Role.USER)
	@RequestMapping(value= {"/member_modify"})
	public String modify(@ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		
		return "user/member_modify";
	}
	
	@Auth(role=Role.USER)
	@RequestMapping(value= {"/member_modifying"}, method=RequestMethod.GET)
	public String modifying(@ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		
		return "user/member_modifying";
	}
	
	@Auth(role=Role.USER)
	@RequestMapping(value= {"/member_modifying"}, method=RequestMethod.POST)
	public String modifying(@ModelAttribute @Valid UserVO vo, BindingResult result,
			ModelAndView modelAndView, @ModelAttribute("categoryList") List<CategoryVO> categoryList) {
		System.out.println(vo);
		// @Valid Errors시 메인으로.
		if(result.hasErrors()) {
			System.out.println("[UserController:modifying] if(result.hasErrors()) )");
			return "redirect:/";
		}		
		
		if( !userService.update(vo) ) {
			System.out.println("[UserController:modifying] if( !userService.update(vo) )");
			return "redirect:/";
		}
		
		UserVO authUser = userService.get(vo.getNo());
		if(authUser == null) {
			System.out.println("[UserController:modifying] if(authUser == null) ");
			return "redirect:/";
		}
		modelAndView.addObject(authUser);
		return "redirect:/user/member_modifying";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
