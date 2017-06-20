package com.OrderPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Tourism.DataBase.CommentCount;
import com.Tourism.DataBase.JDBCUtils;
import com.javabean.Comcontext;

public class ProductCom extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		String OrdernumID=request.getParameter("odernumberid");
		int num=CommentCount.getComCount(OrdernumID);
		out.print(num);
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
		PrintWriter out = response.getWriter();
		String num=request.getParameter("pagenum");
		String OrdernumID=request.getParameter("odernumberid");
		int pagenum=Integer.parseInt(num);
		int datanum=CommentCount.getComCount(OrdernumID);
		int page=0;
		int start=0;int length=0;
		if(datanum%10!=0){
			page=datanum/10+1;
		}else{
			page=datanum/10;
		}
		if(pagenum<page){
			start=0+10*(pagenum-1);
			length=10;
		}else if(pagenum==page){
			start=0+10*(pagenum-1);
			if(datanum%10==0){
				length=10;
			}else{
				length=datanum%10;
			}
		}
		ArrayList comlist;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comlist=JDBCUtils.QueryProductCom("select * from tourism_comment where productsID=? limit ?,?", OrdernumID,start,length);
		for(int i=0;i<comlist.size();i++){
			out.print("<div style='width: 1000px; background: white; margin-top: -5px;border-radius:5px; padding-top: 4px; padding-bottom: -5px'>");
			out.print("<img src='../UserUploadPhoto/"+((Comcontext)comlist.get(i)).getUsername()+".jpg' style='float: left' height='80px' width='80px' alt='headpicture' class='img-rounded'>");
			out.print("<h4>&nbsp;&nbsp;"+((Comcontext)comlist.get(i)).getUsername()+"</h4>");
			out.print("<p style='margin-left: 150px'>"+((Comcontext)comlist.get(i)).getContext()+"</p>");
			out.print("<p style='margin-left: 800px'>"+((Comcontext)comlist.get(i)).getPublishdate()+"</p></div>");
		}
		out.flush();
		out.close();
	}

}
