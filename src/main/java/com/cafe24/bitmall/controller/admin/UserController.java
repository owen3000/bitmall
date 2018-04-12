package com.cafe24.bitmall.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.admin.UserService;
import com.cafe24.bitmall.vo.UserVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.util.PagingBean;
import com.cafe24.util.WebUtil;

@Controller("adminUserController")
@RequestMapping(value= {"/admin"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/admin_login"},method=RequestMethod.GET)
	public String login() {
		
		return "admin/login";
	}
	
	@Auth(role= Role.ADMIN)
	@RequestMapping(value= {"/member"})
	public String member(Model model, 
			@RequestParam(value="nowPage",required=true,defaultValue="1") String nowPage,
		@RequestParam(value="option",required=true,defaultValue="") String option,
		@RequestParam(value="keyword",required=true,defaultValue="") String keyword) {
		
		// nowPage url로 한글 입력시 error 방지처리.
		Long lNowPage = WebUtil.checkParameter(nowPage, 1L);
		
		Long totalCount = userService.getTotalCount(option,keyword);
		PagingBean pb = new PagingBean(totalCount, lNowPage, 3, 3,keyword,option);
		
		List<UserVO> list = userService.getList(pb);
		if( list == null) {
			list = new ArrayList<UserVO>();
		}
		
		model.addAttribute("memberList", list);
		model.addAttribute("pb", pb);
		return "admin/member";
	}
	
	
}
