package com.cafe24.bitmall.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.vo.DeliverySiteVO;
import com.cafe24.bitmall.vo.OrderVO;
import com.cafe24.bitmall.vo.UserVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.interceptor.AuthUser;

@Controller
@Auth(role=Role.USER)
public class OrderController {
	
	@Autowired
	private CartService cartService; 
	
	@Autowired
	private OrderService orderService; 
	
	@ModelAttribute("cartList")
	public List<HashMap<String, Object>> cartList(@AuthUser UserVO authUser,Model model) {
		
		List<HashMap<String, Object>> cartList =
				cartService.getList(authUser.getNo());
		
		return cartList;
	}

	@RequestMapping(value= {"/order"})
	public String order( @ModelAttribute("cartList")List<HashMap<String, Object>> cartList,
			Model model, @ModelAttribute("deliverySiteVO") DeliverySiteVO vo) {
		
		//total price 계산 
		Long totalPrice = 0L;
		for (int i = 0; i < cartList.size(); i++) {
			totalPrice +=   (long) ((Integer)(cartList.get(i).get("price")) * 
					(Integer)(cartList.get(i).get("amount")));
		}
		
		model.addAttribute("totalPrice", totalPrice);
		return "order";
	}
	
	@RequestMapping(value= {"/order/pay"})
	public String orderPay(@ModelAttribute("cartList")List<HashMap<String, Object>> cartList,
			Model model, @ModelAttribute("deliverySiteVO") DeliverySiteVO vo) {
		
		//total price 계산 
		Long totalPrice = 0L;
		for (int i = 0; i < cartList.size(); i++) {
			totalPrice +=   (long) ((Integer)(cartList.get(i).get("price")) * 
					(Integer)(cartList.get(i).get("amount")));
		}
		
		model.addAttribute("totalPrice", totalPrice);
		return "order_pay";
	}
	
	@RequestMapping(value= {"/order/ok"})
	public String orderOk(
			Model model, @ModelAttribute("deliverySiteVO") DeliverySiteVO deliverySiteVO,
			@ModelAttribute("cartList")List<HashMap<String, Object>> cartList,
			@ModelAttribute OrderVO orderVO ) {
		
		if( !orderService.insertOrder(deliverySiteVO, orderVO, cartList)) {
			System.out.println("[OrderController:orderOk] 주문 실패!");
			return "redirect:/";
		}
		
		return "redirect:/order/order_ok";
	}
	
	@RequestMapping(value= {"/order/order_ok"})
	public String orderOk() {
		

		return "order_ok";
	}
	

}
