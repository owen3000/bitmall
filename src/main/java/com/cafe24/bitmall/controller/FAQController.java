package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FAQController {

	@RequestMapping(value= {"/faq"})
	public String faq() {
		
		return "faq";
	}
	
	@RequestMapping(value= {"/faq/read"})
	public String faqRead() {
		
		return "faq_read";
	}
}
