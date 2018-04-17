package com.cafe24.bitmall.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.bitmall.exception.URLEncordingException;
import com.cafe24.bitmall.service.admin.JumunService;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.util.PagingBean;
import com.cafe24.util.WebUtil;

@Controller("adminJumunController")
@RequestMapping(value= {"/admin"})
@Auth(role=Role.ADMIN)
public class JumunController {

	@Autowired
	private JumunService jumunService;
		
	@RequestMapping(value= {"/jumun"})
	public String jumun(Model model,
			@RequestParam(value="nowPage",required=true,defaultValue="1") String nowPage,
			@RequestParam(value="day1",required=true,defaultValue="") String day1,
			@RequestParam(value="day2",required=true,defaultValue="") String day2,
			@RequestParam(value="sel1",required=true,defaultValue="") String sel1,
			@RequestParam(value="sel2",required=true,defaultValue="") String sel2,
			@RequestParam(value="keyword",required=true,defaultValue="") String keyword) {
		
		// nowPage url로 한글 입력시 error 방지처리.
		Long lNowPage = WebUtil.checkParameter(nowPage, 1L);

		Map<String, String> opts = new HashMap<String,String>();
		opts.put("day1", day1.trim());
		opts.put("day2", day2.trim());
		opts.put("sel1", sel1.trim());
		opts.put("sel2", sel2.trim());
		opts.put("keyword", keyword);

		Long totalCount = jumunService.getTotalCount(opts);
		PagingBean pb = new PagingBean(totalCount, lNowPage, 2, 3,opts);		
		
		
		List<HashMap<String, Object>> jumunList =
									jumunService.getList(pb);
		
		model.addAttribute("jumunList", jumunList);
		model.addAttribute("pb", pb);
		model.addAttribute("totalCount", totalCount);
		return "admin/jumun";
	}
	
	@RequestMapping(value= {"/jumun/modify_state"})
	public String modifyState(Model model,
			@RequestParam(value="nowPage",required=true,defaultValue="1") String nowPage,
			@RequestParam(value="jumun-no",required=true,defaultValue="") String orderNo,
			@RequestParam(value="jumun-state",required=true,defaultValue="") String jumunState,
			@RequestParam(value="day1",required=true,defaultValue="") String day1,
			@RequestParam(value="day2",required=true,defaultValue="") String day2,
			@RequestParam(value="sel1",required=true,defaultValue="") String sel1,
			@RequestParam(value="sel2",required=true,defaultValue="") String sel2,
			@RequestParam(value="keyword",required=true,defaultValue="") String keyword
			) {
		
		Long lOrderNo = WebUtil.checkParameter(orderNo.trim(), 1L);
		
		if( !jumunService.updateState(lOrderNo, jumunState) ) {
			System.out.println("[JumunController:modifyState] update State fail! ");
			return "redirect:/admin/jumun";
		}
		
		String queryString = "nowPage="+nowPage+"&day1="+day1+"&day2="+day2+
				"&sel1="+sel1+"&sel2="+sel2+"&keyword="+keyword;

		System.out.println(queryString);
		return "redirect:/admin/jumun?"+queryString;
		
	}
	
	@RequestMapping(value= {"/jumun/delete"})
	public String deleteOrder(Model model,
			@RequestParam(value="nowPage",required=true,defaultValue="1") String nowPage,
			@RequestParam(value="jumun-no",required=true,defaultValue="") String orderNo,
			@RequestParam(value="day1",required=true,defaultValue="") String day1,
			@RequestParam(value="day2",required=true,defaultValue="") String day2,
			@RequestParam(value="sel1",required=true,defaultValue="") String sel1,
			@RequestParam(value="sel2",required=true,defaultValue="") String sel2,
			@RequestParam(value="keyword",required=true,defaultValue="") String keyword
			) {
		
		Long lOrderNo = WebUtil.checkParameter(orderNo.trim(), 1L);
		
		if( !jumunService.deleteOrder(lOrderNo) ) {
			System.out.println("[JumunController:deleteOrder] delete order fail! ");
			return "redirect:/admin/jumun";
		}
		
		String queryString = "nowPage="+nowPage+"&day1="+day1+"&day2="+day2+
				"&sel1="+sel1+"&sel2="+sel2+"&keyword="+keyword;

		return "redirect:/admin/jumun?"+queryString;
		
	}
}
