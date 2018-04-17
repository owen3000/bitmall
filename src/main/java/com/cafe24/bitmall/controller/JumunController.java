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

import com.cafe24.bitmall.service.JumunService;
import com.cafe24.bitmall.vo.DeliverySiteVO;
import com.cafe24.bitmall.vo.UserVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.AuthUser;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.util.PagingBean;
import com.cafe24.util.WebUtil;

@Controller
@Auth(role=Role.USER)
public class JumunController {

	@Autowired
	private JumunService jumunService; 
	
	@RequestMapping(value= {"/jumun"})
	public String jumun(@AuthUser UserVO authUser,Model model,
			@RequestParam(value="nowPage",required=true,defaultValue="1") String nowPage) {
		
		// nowPage url로 한글 입력시 error 방지처리.
		Long lNowPage = WebUtil.checkParameter(nowPage.trim(), 1L);
		
		Long totalCount = jumunService.getTotalCount(authUser.getNo());
		PagingBean pb = new PagingBean(totalCount, lNowPage, 3, 3);
		
		List<HashMap<String, Object>> jumunList =
							jumunService.getList(pb,authUser.getNo());
		
		model.addAttribute("jumunList", jumunList);
		model.addAttribute("pb", pb);
		return "jumun";
	}
	
	
	@ModelAttribute("jumunList")
	public List<HashMap<String, Object>> jumunList(@AuthUser UserVO authUser,Model model,
			@RequestParam(value="orderNo",required=true,defaultValue="") String orderNo) {
		
		if("".equals(orderNo.trim())) {
			return null;
		}
		
		Long lOrderNo = WebUtil.checkParameter(orderNo.trim(), 1L);
		if(lOrderNo == -1L) {
			System.out.println("[JumunController:jumunList] orderNo is -1L ");
		}
		
		List<HashMap<String, Object>> jumunList =
				jumunService.getList(authUser.getNo(),lOrderNo);
		
		return jumunList;
	}
	
	@RequestMapping(value= {"/jumun/info"})
	public String jumunInfo(@AuthUser UserVO authUser,Model model,
			@ModelAttribute("jumunList")List<HashMap<String, Object>> jumunList,
			@RequestParam(value="orderNo",required=true,defaultValue="") String orderNo) {

		Long lOrderNo = WebUtil.checkParameter(orderNo.trim(), -1L);
		if(lOrderNo == -1L) {
			System.out.println("[JumunController:jumunList] orderNo is 1L ");
			return "redirect:/";
		}
		
		if(jumunList.isEmpty()) {
			System.out.println("[JumunController:jumunList] jumunList.isEmpty()");
			return "redirect:/";
		}
		
		//total price 계산 
		Long totalPrice = 0L;
		for (int i = 0; i < jumunList.size(); i++) {
			totalPrice +=   (long) ((Integer)(jumunList.get(i).get("price")) * 
					(Integer)(jumunList.get(i).get("amount")));
		}
		
		//배송지 정보
		
		DeliverySiteVO deliverySiteVO = jumunService.getDeliverySite(lOrderNo,authUser.getNo());
		if( deliverySiteVO == null ) {
			System.out.println("[JumunController:jumunInfo] 배송지 정보 없음! ");
			deliverySiteVO = new DeliverySiteVO();
		}

		model.addAttribute("totalPrice", totalPrice);		
		model.addAttribute("deliverySiteVO", deliverySiteVO);		
		return "jumun_info";
	}
}
