package com.cafe24.bitmall.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.exception.URLEncordingException;
import com.cafe24.bitmall.service.admin.OptService;
import com.cafe24.bitmall.vo.OptVO;
import com.cafe24.interceptor.Auth;
import com.cafe24.interceptor.Auth.Role;
import com.cafe24.util.WebUtil;

@Controller
@RequestMapping(value= {"/admin"})
@Auth(role=Role.ADMIN)
public class OptionController {
	
	@Autowired
	private OptService optService;

	@RequestMapping(value= {"/opt"})
	public String option(Model model) {
		
		List<OptVO> list = optService.getList();
		if( list == null ) {
			list = new ArrayList<OptVO>();
		}
		
		model.addAttribute("optList", list);
		return "admin/opt";
	}
	
	@RequestMapping(value= {"/opts"})
	public String opts(
			@RequestParam(value="name",required=true,defaultValue="")String name,
			Model model) {
		System.out.println("opts");
		if( "".equals(name.trim()) ) {
			System.out.println("[OptionController:opts] if( \"\".equals(name) ) ");
			return "redirect:/admin/opt";
		}
		
		List<OptVO> list = optService.getOptsList(name.trim());
		if( list == null ) {
			System.out.println("[OptionController:opts] if( list == null ) ");
			list = new ArrayList<OptVO>();
		}
		
		model.addAttribute("optsList", list);
		return "admin/opts";
	}
	
	@RequestMapping(value= {"/opt_new"})
	public String optNew() {
		
		return "admin/opt_new";
	}
	
	@RequestMapping(value= {"/opts_new"},method=RequestMethod.GET)
	public String optsNew() {

		return "admin/opts_new";
	}
	
	@RequestMapping(value= {"/opt_edit"})
	public String optEdit() {
		
		return "admin/opt_edit";
	}
	
	@RequestMapping(value= {"/opts_edit"})
	public String optsEdit() {
		
		return "admin/opts_edit";
	}
	
	@RequestMapping(value= {"/opt_new"},method=RequestMethod.POST)
	public String optNew(
			@RequestParam(value="name",required=true,defaultValue="")String name) {
		if( "".equals(name.trim()) ) {
			return "redirect:/admin/opt";
		}
		
		if( !optService.insert(name.trim()) ) {
			System.out.println("[OptionController:optNew] if( !optService.insert(name) )");
		}
		
		return "redirect:/admin/opt";
	}
	
	@RequestMapping(value= {"/opts_new"},method=RequestMethod.POST)
	public String optsNew(
			@RequestParam(value="name",required=true,defaultValue="")String name,
			@RequestParam(value="value",required=true,defaultValue="")String value) {
		if( "".equals(name.trim()) || "".equals(value.trim())) {
			System.out.println("[OptionController:optNew] if( \"\".equals(name) || \"\".equals(value))");
			return "redirect:/admin/opts";
		}
		
		OptVO vo = new OptVO();
		vo.setName(name.trim());
		vo.setValue(value.trim());
		
		if( !optService.insertOpts(vo) ) {
			System.out.println("[OptionController:optNew] if( !optService.insert(vo) )");
		}
		String temp =  name.toString().trim();
		try {
			temp = URLEncoder.encode(temp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new URLEncordingException("[URLEndcoder Exception] optsNew 에서 발생");
		}
		return "redirect:/admin/opts?name="+temp ;
	}
	
	@RequestMapping(value= {"/opts_delete"})
	public String optsDelete(
			@RequestParam(value="no",required=true,defaultValue="")String no,
			@RequestParam(value="name",required=true,defaultValue="")String name) {
		Long lNo = WebUtil.checkParameter(no.trim(), -1L);
		if( lNo == -1L || "".equals(name.trim()) ) {
			System.out.println("[OptionController:optsDelete] if( lNo == -1L || \"\".equals(name) ) ");
			return "redirect:/admin/opt";
		}
		
		if( !optService.deleteOpts(lNo) ) {
			System.out.println("[OptionController:optsDelete] if( !optService.delete(lNo) ) ");
			return "redirect:/admin/opt";
		}
		
		String temp =  name.toString().trim();
		try {
			temp = URLEncoder.encode(temp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new URLEncordingException("[URLEndcoder Exception] optsDelete 에서 발생");
		}
		return "redirect:/admin/opts?name="+temp ;
	}
	
	@RequestMapping(value= {"/opts_update"})
	public String optsUpdate(
			@RequestParam(value="no",required=true,defaultValue="")String no,
			@RequestParam(value="name",required=true,defaultValue="")String name,
			@RequestParam(value="value",required=true,defaultValue="")String value) {
		Long lNo = WebUtil.checkParameter(no.trim(), -1L);
		if( lNo == -1L || "".equals(name.trim()) || "".equals(value.trim()) ) {
			System.out.println("[OptionController:optsUpdate] if( lNo == -1L || \"\".equals(name) || \"\".equals(value) ) ");
			return "redirect:/admin/opt";
		}
		OptVO vo = new OptVO();
		vo.setNo(lNo);
		vo.setValue(value.trim());
		
		if( !optService.updateOpts(vo) ) {
			System.out.println("[OptionController:optsUpdate] if( !optService.delete(lNo) ) ");
			return "redirect:/admin/opt";
		}
		
		String temp =  name.toString().trim();
		try {
			temp = URLEncoder.encode(temp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new URLEncordingException("[URLEndcoder Exception] optsUpdate 에서 발생");
		}
		return "redirect:/admin/opts?name="+temp ;
	}
	
	@RequestMapping(value= {"/opt_delete"})
	public String optDelete(
			@RequestParam(value="name",required=true,defaultValue="")String name) {

		if( "".equals(name.trim()) ) {
			System.out.println("[OptionController:optDelete] if( \"\".equals(name.trim()) ) ");
		}
		
		if( !optService.deleteOpt(name.trim()) ) {
			System.out.println("[OptionController:optDelete] if( !optService.deleteOpt(name.trim()) ) ");
		}

		return "redirect:/admin/opt";
	}
	
	@RequestMapping(value= {"/opt_update"})
	public String optUpdate(
			@RequestParam(value="select-name",required=true,defaultValue="")String selectName,
			@RequestParam(value="update-name",required=true,defaultValue="")String updateName) {

		if( "".equals(selectName.trim()) || "".equals(updateName.trim()) ) {
			System.out.println("[OptionController:optUpdate] if( \"\".equals(selectName.trim()) || \"\".equals(updateName.trim()) ) ");
			return "redirect:/admin/opt";
		}
		
		if( !optService.updateOpt(selectName, updateName) ) {
			System.out.println("[OptionController:optUpdate] if( !optService.updateOpt(selectName, updateName) ) ");
			return "redirect:/admin/opt";
		}
		
		return "redirect:/admin/opts";
	}
}
