package com.Tourism.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CutPhotoServlet extends HttpServlet {

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
		String username=request.getParameter("username");
		int dataX=Integer.parseInt(request.getParameter("dataX"));
		int dataY=Integer.parseInt(request.getParameter("dataY"));
		int dataWidth=Integer.parseInt(request.getParameter("dataWidth"));
		int dataHeight=Integer.parseInt(request.getParameter("dataHeight"));
		PrintWriter out = response.getWriter();
		//StartCut
		 String name = "D:\\apache-tomcat-7.0.59\\webapps\\Tourism\\UserUploadPhoto\\"+username+".jpg";  
	     CutPicture o = new CutPicture(dataX, dataY, dataWidth, dataHeight);  
	     o.setSrcpath(name);  
	     o.setSubpath(name);  
	     o.cut(); 
	     //EndCut
	    out.print("cutSuccess");
		out.flush();
		out.close();
	}

}
