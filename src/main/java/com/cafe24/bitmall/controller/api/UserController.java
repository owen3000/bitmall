package com.cafe24.bitmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.bitmall.dto.JSONResult;
import com.cafe24.bitmall.service.UserService;

@Controller("apiUserController")
@RequestMapping(value= {"/api/user"})
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/checkId")
	@ResponseBody
	public JSONResult chekcId(
			@RequestParam(value="id",required=true,defaultValue="")String id) {
		if( "".equals(id) ) {
			return JSONResult.success("none");
		}
		
		if( userService.checkId(id) ) {
			return JSONResult.success("exist");
		}
		return JSONResult.success("none");
	}
}
