package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	@RequestMapping(value= {"/order"})
	public String order() {
		
		return "order";
	}
	
	@RequestMapping(value= {"/order/pay"})
	public String ok() {
		
		return "order_pay";
	}
	

}
