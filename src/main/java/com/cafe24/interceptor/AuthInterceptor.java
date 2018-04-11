package com.cafe24.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.vo.UserVO;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(AuthInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		
		//1. default handler 제외
		if( (handler instanceof HandlerMethod) == false) {
			LOG.warn("AuthInterceptor:preHandle / if( (handler instanceof HandlerMethod) == false)");
			return true; //디폴트 라는 얘기죠
		}
		//2. 어노테이션 정보 추출
		HandlerMethod hm = (HandlerMethod) handler;
		Auth auth =
				hm.getMethodAnnotation(Auth.class);
		if(auth == null) {
			return true;
		}
		//3. 어노테이션이 있는상태. 세션체크해야지
		HttpSession session = request.getSession();
		if( session == null ) {
			System.out.println("[AuthInterceptor] if( session == null ) ");
			response.sendRedirect(request.getContextPath()+"/user/loginForm");;
			return false;
		}
		UserVO authUser = (UserVO) session.getAttribute("authUser");
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/user/loginForm");;
			return false;
		}
		LOG.warn("AuthInterceptor: @Auth 허가완료");
		// 해당 @Auth 메소드 접근 허가 완료 true
		return true;
	}

	
}
