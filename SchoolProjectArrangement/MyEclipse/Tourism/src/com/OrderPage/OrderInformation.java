package com.OrderPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tourism.DataBase.GetProductsInfo;
import com.Tourism.DataBase.JDBCUtils;
import com.javabean.ProductInfo;

public class OrderInformation extends HttpServlet {

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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ID=request.getParameter("odernumberid");
		ProductInfo Info=GetProductsInfo.getproductinfo(ID);
		String username=(String) request.getSession().getAttribute("USERNAME");
		Boolean admin=JDBCUtils.IsAdminor(username);
		if(Info!=null){
			float p=(float)Info.getPraise();
			float b=(float)Info.getBad();
			int result=(int)(p/(p+b)*100);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(admin){
				out.print("{\"sORf\":\"true\",\"cost\":\""+Info.getCost()+"\",\"place\":\""+Info.getPlace()+
						"\",\"evaluate\":\""+result+"\",\"admin\":\""+admin+"\"}");
			}else{
				out.print("{\"sORf\":\"true\",\"cost\":\""+Info.getCost()+"\",\"place\":\""+Info.getPlace()+
						"\",\"evaluate\":\""+result+"\",\"admin\":\""+admin+"\"}");
			}
		}else{
			out.print("{\"sORf\":\"false\"}");
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
		
	}

}
