package com.apache.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet invoked");
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost invoked");
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		resp.setContentType("text/html"); // 设置响应的内容形式
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Login Result</title></head>");
		out.println("<body>username:" + username + "<br>");
		out.println("password:" + password + "</body></html>");
		out.flush();
	}
}
