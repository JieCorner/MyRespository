package com.Tourism.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tourism.DataBase.JDBCUtils;
import com.Tourism.DataBase.MatchUserPassword;

public class LoginDeal extends HttpServlet {

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Boolean InfoCheck=true;
		PrintWriter out=response.getWriter();
		if(username==""||username.length()<4||username.length()>16){
			InfoCheck=false;
		}
		Pattern pattern1 = Pattern.compile("^[0-9a-zA-Z_]{6,15}$");
		Matcher matcher1 = pattern1.matcher(password);
		if(!matcher1.matches()){
			InfoCheck=false;
		}
		if(!InfoCheck){
			out.print(false);
		}else{
			Boolean Umatch=MatchUserPassword.matchuserpwd(username, password);
			Boolean Ematch=MatchUserPassword.matchemailpwd(username, password);
			if(Umatch||Ematch){
				if(Umatch){
					request.getSession().setAttribute("USERNAME", username);
					int count=JDBCUtils.countShowProblem(username);
					request.getSession().setAttribute("COUNTREPLY",count);
				}
				if(Ematch){
					String queryusername=JDBCUtils.getUserName(email);
					request.getSession().setAttribute("USERNAME", queryusername);
					int count=JDBCUtils.countShowProblem(username);
					request.getSession().setAttribute("COUNTREPLY",count);
				}		
				out.print("{\"sORf\":\"true\"}");
			}else{
				out.print("{\"sORf\":\"false\"}");
			}
		}	
		out.flush();
		out.close();
	}
}
