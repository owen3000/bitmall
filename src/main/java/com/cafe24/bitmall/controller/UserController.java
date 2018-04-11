package com.cafe24.bitmall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.UserVO;

@Controller
@RequestMapping(value= {"/user"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/member_login"},method=RequestMethod.GET)
	public String login() {
		
		return "user/member_login";
	}
	
	@RequestMapping(value= {"/member_agree"})
	public String agree() {
		
		return "user/member_agree";
	}
	
	@RequestMapping(value= {"/member_join"})
	public String join() {
		
		return "user/member_join";
	}
	
	@RequestMapping(value= {"/member_joined"})
	public String joined() {
		
		return "user/member_joined";
	}
	
	@RequestMapping(value= {"/join"}, method=RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVO vo, BindingResult result) {
		System.out.println("join!!");
		System.out.println(vo);
		
		if(result.hasErrors()) {
			System.out.println("[UserController:join] if( !userService.join(vo) )");
			return "redirect:/";
		}
		
		if( !userService.join(vo) ) {
			System.out.println("[UserController:join] if( !userService.join(vo) )");
			return "redirect:/";
		}
		
		return "redirect:/user/member_joined";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
