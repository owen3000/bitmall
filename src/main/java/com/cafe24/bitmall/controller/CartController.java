package com.cafe24.bitmall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.vo.CartVO;
import com.cafe24.bitmall.vo.UserVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.AuthUser;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.util.WebUtil;

@Controller
@Auth(role=Role.USER)
public class CartController {
	
	@Autowired
	private CartService cartService; 

	@ModelAttribute("cartList")
	public List<HashMap<String, Object>> cartList(@AuthUser UserVO authUser,Model model) {
		
		List<HashMap<String, Object>> cartList =
				cartService.getList(authUser.getNo());
		
		return cartList;
	}
	
	@RequestMapping(value= {"/cart"})
	public String order(@AuthUser UserVO authUser, Model model,
			@ModelAttribute("cartList")List<HashMap<String, Object>> cartList) {
		
		//total price 계산 
		Long totalPrice = 0L;
		for (int i = 0; i < cartList.size(); i++) {
			totalPrice +=   (long) ((Integer)(cartList.get(i).get("price")) * 
					(Integer)(cartList.get(i).get("amount")));
		}
		
		model.addAttribute("totalPrice", totalPrice);
		return "cart";
	}
	
	@RequestMapping(value= {"/cart/insert"})
	public String insert(@AuthUser UserVO authUser,
			@RequestParam(value="product-no",required=true,defaultValue="")String productNo,
			@RequestParam(value="num",required=true,defaultValue="")String amount,
			@RequestParam(value="color",required=true,defaultValue="")String colorNo,
			@RequestParam(value="size",required=true,defaultValue="")String sizeNo,
			@RequestParam(value="discount-price",required=true,defaultValue="")String price) {
		System.out.println(price);
		if( "".equals(productNo.trim()) || "".equals(amount.trim())  ) {
			System.out.println("[CartController:insert] param data '' ");
			return "redirect:/admin/opt";
		}
		
		//cart에 데이터 넣기 전 체크
		Long lProductNo = WebUtil.checkParameter(productNo.trim(), -1L);
		Long lAmount = WebUtil.checkParameter(amount.trim(), -1L);
		Long lColorNo = WebUtil.checkParameter(colorNo.trim(), -1L);
		Long lSizeNo = WebUtil.checkParameter(sizeNo.trim(), -1L);
		Long lPrice = WebUtil.checkParameter(price.trim(), -1L);
		if( lProductNo == -1L  || lAmount == -1L || lPrice == -1L) {
			System.out.println("[CartController:insert] data == -1L");
			return "redirect:/admin/opt";
		}
		
		CartVO vo = new CartVO();
		vo.setUserNo(authUser.getNo());
		vo.setProductNo(lProductNo);
		vo.setAmount(lAmount);
		vo.setPrice(lPrice);
		List<Long> optNoList = new ArrayList<Long>();
		optNoList.add(lSizeNo);
		optNoList.add(lColorNo);
		if( !cartService.insertProduct(vo,optNoList) ) {
			System.out.println("[CartController:insert] if( !cartService.insertProduct(vo) )");
			return "redirect:/";
		}
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value= {"/cart/delete"})
	public String delete(@AuthUser UserVO authUser, Model model,
			@ModelAttribute("cartList")List<HashMap<String, Object>> cartList) {
		
		if( !cartService.deleteCart(authUser.getNo())) {
			System.out.println("[CartController:delete] 카트 삭제 실패!");
		}
		
		return "redirect:/cart";
	}

}
