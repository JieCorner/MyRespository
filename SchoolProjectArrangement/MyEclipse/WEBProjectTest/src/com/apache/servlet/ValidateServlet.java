package com.apache.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		List<String> list=new ArrayList<String>();
		if(null==username||"".equals(username)){
			list.add("username can't be blank!");
		}if(password==null||password.length()<6||password.length()>10){
			list.add("length of password should be between 6 and 10");
		}if(repassword==null||repassword.length()<6||repassword.length()>10){
			list.add("length of repassword should be between 6 and 10");
		}if(password!=null&&repassword!=null&&!password.equals(repassword)){
			list.add("password and repassword not the same");
		}
		if(list.isEmpty()){
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			request.setAttribute("error", list);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("Ïú»Ù£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("³õÊ¼»¯£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
	}

}
