package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumunController {

	@RequestMapping(value= {"/jumun"})
	public String jumun() {
		
		return "jumun";
	}
}
