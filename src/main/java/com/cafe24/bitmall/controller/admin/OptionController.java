package com.cafe24.bitmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/admin"})
public class OptionController {

	@RequestMapping(value= {"/option"})
	public String option() {
		
		return "admin/opt";
	}
	
	@RequestMapping(value= {"/options"})
	public String options() {
		
		return "admin/opts";
	}
}
