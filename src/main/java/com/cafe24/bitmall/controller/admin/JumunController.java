package com.cafe24.bitmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminJumunController")
@RequestMapping(value= {"/admin"})
public class JumunController {

	@RequestMapping(value= {"/jumun"})
	public String jumun() {
		
		return "admin/jumun";
	}
}
