package com.cafe24.bitmall.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		System.out.println(nowPage);
		System.out.println(day1);
		System.out.println(day2);
		System.out.println(sel1);
		System.out.println(sel2);
		System.out.println(keyword);
		
		// nowPage url로 한글 입력시 error 방지처리.
		Long lNowPage = WebUtil.checkParameter(nowPage, 1L);

		Map<String, String> opts = new HashMap<String,String>();
		opts.put("day1", day1.trim());
		opts.put("day2", day2.trim());
		opts.put("sel1", sel1.trim());
		opts.put("sel2", sel2.trim());
		opts.put("keyword", keyword);
		System.out.println(opts);
		Long totalCount = jumunService.getTotalCount(opts);
		System.out.println(totalCount);
		System.out.println(lNowPage);
		
		
		PagingBean pb = new PagingBean(totalCount, lNowPage, 2, 3,opts);		
		
		
		List<HashMap<String, Object>> jumunList =
									jumunService.getList(pb);
		System.out.println(pb.getStartCount() + ": "+pb.getCountList());
		System.out.println(jumunList);
		System.out.println(jumunList.size());
		
		model.addAttribute("jumunList", jumunList);
		model.addAttribute("pb", pb);
		model.addAttribute("totalCount", totalCount);
		return "admin/jumun";
	}
	
	@RequestMapping(value= {"/jumun/modify_state"})
	public String modifyState(Model model,
			@RequestParam(value="nowPage",required=true,defaultValue="1") String nowPage) {
		
		
		// nowPage url로 한글 입력시 error 방지처리.
		Long lNowPage = WebUtil.checkParameter(nowPage, 1L);
		System.out.println("nowPage:"+nowPage);
		Map<String, String> opts = new HashMap<String,String>();
		System.out.println(opts);
		Long totalCount = jumunService.getTotalCount(opts);
		System.out.println(totalCount);
		PagingBean pb = new PagingBean(totalCount, lNowPage, 2, 3,opts);		
		
		
		List<HashMap<String, Object>> jumunList =
									jumunService.getList(pb);
		
		
		model.addAttribute("jumunList", jumunList);
		model.addAttribute("pb", pb);
		model.addAttribute("totalCount", totalCount);
		return "admin/jumun";
	}
}
