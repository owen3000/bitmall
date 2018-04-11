package com.cafe24.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.service.admin.UserService;
import com.cafe24.bitmall.vo.UserVO;

public class AuthAdminLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String id =request.getParameter("adminid");
		String password =request.getParameter("adminpw");
		
		WebApplicationContext wac =
		WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		UserService userService =
				wac.getBean(UserService.class);
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserVO authUser = userService.login(vo);
		if( authUser == null ) {
			System.out.println("[AuthLoginInterceptor:preHandle] / if(authUser==null)");
			response.sendRedirect(request.getContextPath());
			return false;
		}
		// admin 테이블과 조인
		Long adminNo = userService.confirmAuth(authUser);
		if( adminNo == null ) {
			System.out.println("[AuthLoginInterceptor:preHandle] / if(adminNo == null)");
			response.sendRedirect(request.getContextPath());
			return false;
		}
		authUser.setNo(adminNo);
		
		// admin login 확인 완료
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		response.sendRedirect(request.getContextPath()+"/admin/product"); 

		return false;
	}
	
}
