package com.Tourism.UserInfomation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tourism.DataBase.JDBCUtils;
import com.javabean.UserProblemInfo;


public class InfoProblem extends HttpServlet {

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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		ArrayList<UserProblemInfo> problemlist;
		problemlist=JDBCUtils.Userproblemlist(username);
		out.print("<div class='panel-heading' style='background: black;color: white'>My Problem</div>");
		for(int i=0;i<problemlist.size();i++){
			out.print("<h4>&nbsp;&nbsp;"+problemlist.get(i).getProblem()+"&nbsp;&nbsp;&nbsp;&nbsp;[Related ProductID:"+problemlist.get(i).getProductID()+"]</h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+problemlist.get(i).getAnswer()+"<div style='margin-left: 650px'>");
			out.print("<div class='btn-group' ><button type='buton' class='btn btn-default'>satisfied</button>");
			out.print("<button type='buton' class='btn btn-default'>dissatisfied</button></div></div>");
			out.print("<hr>");
		}
		
		out.flush();
		out.close();
	}

}
