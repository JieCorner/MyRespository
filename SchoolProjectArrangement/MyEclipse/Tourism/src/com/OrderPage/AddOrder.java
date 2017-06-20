package com.OrderPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tourism.DataBase.JDBCUtils;
import com.javabean.Order;

public class AddOrder extends HttpServlet {

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
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String ProductID=request.getParameter("ProductID");
		String username=request.getParameter("username");
		Boolean add;
		add=JDBCUtils.UserIsAsk("select * from tourism_order where username=? and ProductID=?", username, ProductID);
		out.print(add);
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
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String ProductID=request.getParameter("ProductID");
		String username=request.getParameter("username");
		String staringplace=request.getParameter("staringplace");
		String phone=request.getParameter("phone");
		String startdate=request.getParameter("startdate");
		String Adult=request.getParameter("Adult");
		String Children=request.getParameter("Children");
		String Remark=request.getParameter("Remark");
		String Cost=request.getParameter("Cost");
		Boolean add;
		Order order=new Order(ProductID,username,staringplace,phone,startdate,Adult,Children,Remark,Cost);
		add=JDBCUtils.addOrder("insert into tourism_order(ProductID,staringplace,startdate,username,phone,Remark,Adult,Children,Cost) " +
				"values(?,?,?,?,?,?,?,?,?)", order);
		out.print(add);
		out.flush();
		out.close();
	}

}
