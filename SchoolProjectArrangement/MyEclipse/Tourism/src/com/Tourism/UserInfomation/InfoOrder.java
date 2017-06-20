package com.Tourism.UserInfomation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tourism.DataBase.DeleteOrder;
import com.Tourism.DataBase.JDBCUtils;
import com.javabean.UserOrderInfo;


public class InfoOrder extends HttpServlet {

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
		String username=request.getParameter("username");
		String productID=request.getParameter("productID");
		Boolean i=DeleteOrder.delete(username, productID);
		if(i){
			out.print("true");
		}else{
			out.print("false");
		}
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
		ArrayList<UserOrderInfo> userorderlist;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		userorderlist=JDBCUtils.getUserOrderInfo(username);
		out.print("<div class='panel-heading' style='background: black;color: white'>My Order</div>");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userorderlist.size()==0){
			out.print("<span style='margin-left:250px;font-size: 20px'>You do not have any travel plans!</span>");
		}
		for(int i=0;i<userorderlist.size();i++){
			out.print("<div style='border: 1px solid;margin-top: 2px;border-radius: 5px;overflow: hidden'>");
			out.print("<div class='col-sm-1 ordercolhead' style='width:80px' >ProductID</div>");
			out.print("<div class='col-sm-2 ordercolhead' style='width:120px'>Starting place</div>");
			out.print("<div class='col-sm-2 ordercolhead' style='width:170px'>Destination</div>");
			out.print("<div class='col-sm-2 ordercolhead' style='width:120px'>Starting time</div>");
			out.print("<div class='col-sm-2 ordercolhead'>Time consuming</div>");
			out.print("<div class='col-sm-1 ordercolhead'>Adult</div>");
			out.print("<div class='col-sm-1 ordercolhead' style='width:80px'>Children</div>");
			out.print("<div class='col-sm-1 ordercolhead'>Cost</div>");
			
			out.print("<div class='col-sm-1' style='width:80px;'>"+userorderlist.get(i).getProductID()+"</div>");
			out.print("<div class='col-sm-2' style='width:120px'>"+userorderlist.get(i).getStaringplace()+"</div>");
			out.print("<div class='col-sm-2' style='width:170px'>"+userorderlist.get(i).getEndplace()+"</div>");
			out.print("<div class='col-sm-2' style='width:120px'>"+userorderlist.get(i).getStartdate()+"</div>");
			out.print("<div class='col-sm-2' >"+userorderlist.get(i).getTimeconsume()+"</div>");
			out.print("<div class='col-sm-1' >"+userorderlist.get(i).getAdult()+"</div>");
			out.print("<div class='col-sm-1' style='width:80px'>"+userorderlist.get(i).getChildren()+"</div>");
			out.print("<div class='col-sm-1' >$"+userorderlist.get(i).getCost()+"</div>");
			out.print("<button class='btn btn-default deleteorder'>delete</button>");
			out.print(" <span class='caret ordercom'></span>");
			out.print("<div style='background: white;display:none'><h4 style='margin-left: 10px'>Comment</h4>");
			out.print("<textarea class='form-control' rows='3' cols='10' style='margin-left: 50px;max-width: 700px;max-height: 100px'></textarea>");
			out.print("<button type='button' class='btn btn-default sub_com' style='margin-top:-60px;margin-left: 750px'>Submit</button></div>");
			out.print("</div>");
		}
		out.flush();
		out.close();
	}

}
