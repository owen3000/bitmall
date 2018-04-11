package com.cafe24.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class WebUtil {
	
	public static String checkParameter(String value,String defaultValue) {
		
		
		return null;
	}
	
	public static Long checkParameter(String value,Long defaultValue) {
		// match 써서 뉴메릭 아닌경우 잡으면
		/*String num = request.getParameter("num");
		System.out.println("name:"+ name);
		System.out.println("num:"+ num);
		// 밑에서 익셉션 남
		Long lNum = Long.parseLong(num);*/
		boolean flag = false; 
		if(value!=null)
			flag = java.util.regex.Pattern.matches("^[0-9]*$", value);
		if(!flag) {
			return defaultValue;
		}
		return Long.parseLong(value);
	}

	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) 
			throws ServletException, IOException {
		response.sendRedirect(url);
	}
	
	public static void forword(HttpServletRequest request, HttpServletResponse response, String path) 
			throws ServletException, IOException {
		RequestDispatcher rd=
				request.getRequestDispatcher(path);
		//forwrd
		rd.forward(request, response);
	}
	
	public static boolean CheckBindingResult(BindingResult result) {
		boolean flag = false;
		if(result.hasErrors()) {
			//에러출력
			List<ObjectError> list = result.getAllErrors();
			/*for(ObjectError e: list)
				System.out.println("ObjectError: "+e);*/
			flag = true;
		}
		return flag;
	}
}
