package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("µ˜”√¡À");
		HttpServletRequest r=(HttpServletRequest)arg0;
		String requestURL=r.getRequestURI();
		if(requestURL.endsWith("EmailLogin.jsp")){
			arg2.doFilter(arg0, arg1);
			return;
		}
		HttpSession session=r.getSession();
		System.out.println(session.getId());
		System.out.println(session.getAttribute("username"));
		if(null!=session.getAttribute("username")){
			((HttpServletResponse)arg1).sendRedirect("EmailLogin.jsp");
			return;
			
		}else{
			arg2.doFilter(arg0, arg1);	
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter started!");
	}

}
