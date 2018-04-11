package com.cafe24.bitmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminFAQController")
@RequestMapping(value= {"/admin"})
public class FAQController {

	@RequestMapping(value= {"/faq"})
	public String faq() {
		
		return "admin/faq";
	}
	
	@RequestMapping(value= {"/faq/new"})
	public String faqNew() {
		
		return "admin/faq_new";
	}
}
