package com.OrderPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Tourism.DataBase.JDBCUtils;
import com.javabean.Comcontext;
import com.javabean.Problem;

public class UserProblem extends HttpServlet {

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
		Boolean insertanswer;
		String username=request.getParameter("username");
		String answer=new String(request.getParameter("answer").getBytes("iso-8859-1"),"UTF-8");
		String ProductID=request.getParameter("productID");
		insertanswer=JDBCUtils.insertAnswer(username,ProductID,answer);
		if(insertanswer){
			if(JDBCUtils.Problemremind(username, ProductID, 1)){
				out.print("success");
			}else{
				out.print("fail");
			}
		}else{
			out.print("fail");
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String OrdernumID=request.getParameter("odernumberid");
		String username=request.getParameter("username");
		String islogin=request.getParameter("islogin");
		Boolean isadminor=JDBCUtils.IsAdminor(username);
		if("true".equals(islogin)&&isadminor){
			ArrayList prolist=new ArrayList<Problem>();
			prolist=JDBCUtils.QueryProblem("select * from tourism_problems where productID=?",OrdernumID,0);
			for(int i=0;i<prolist.size();i++){
				out.print("<div style='width: 1000px;background: white;margin-top: 5px;padding-top:4px;padding-bottom: 5px'>");
				out.print("<h4 style='margin-left: 10px'>[User:<span>"+((Problem)prolist.get(i)).getUsername()+"</span>]<br>Problem:&nbsp;&nbsp;"+((Problem)prolist.get(i)).getProblem()+"</h4>");
				out.print("<div class='replyblock'><hr>&nbsp;&nbsp;&nbsp;<b>Answer：</b> <br><br>");
				out.print("<textarea class='form-control' rows='3' cols='10' style='margin-left: 50px;max-width: 800px;max-height: 100px'></textarea>");
				out.print("<button type='button' class='btn btn-default submitanswer' style='margin-top:-100px;margin-left: 850px'>Submit</button>");
				out.print("</div></div>");
			}
		}else{
			ArrayList prolist=new ArrayList<Problem>();
			prolist=JDBCUtils.QueryProblem("select * from tourism_problems where productID=?",OrdernumID,1);
			for(int i=0;i<prolist.size();i++){
				out.print("<div style='width: 1000px;background: white;margin-top: 5px;padding-top:4px;padding-bottom: 5px'>");
				out.print("<h4 style='margin-left: 10px'>"+((Problem)prolist.get(i)).getProblem()+"</h4>");
				out.print(" <p style='margin-left: 30px'>"+((Problem)prolist.get(i)).getAnswer()+"</p>");
				out.print(" </div>");
			}
		}
		out.flush();
		out.close();
	}

}
