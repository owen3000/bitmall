package com.cafe24.bitmall.controller.api.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.bitmall.dto.JSONResult;
import com.cafe24.bitmall.service.admin.UserService;

@Controller("apiAdminUserController")
@RequestMapping(value= {"/api/admin"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/member/delete"})
	@ResponseBody
	public JSONResult delete(
			@RequestBody Map<Object, Object> map) {
		
		Integer no = (Integer) map.get("no");
		Long lNo = new Long(no);
		
		if( !userService.delete(lNo) ) {
			return JSONResult.success("fail");
		}
		
		return JSONResult.success("success");
	}
}
