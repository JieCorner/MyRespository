package com.Tourism.www;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tourism.DataBase.CheckEmailExist;
import com.Tourism.DataBase.CheckPhoneExist;
import com.Tourism.DataBase.CheckUserExist;
import com.javabean.UserInfo;

public class RegisterDeal extends HttpServlet {

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
				Boolean InfoCheck=true;
				Boolean UserExist=true;
				Boolean EmailExist=true;
				Boolean PhoneExist=true;
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				String username=request.getParameter("username");
				String sex=request.getParameter("sex");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				String repassword=request.getParameter("repassword");
				if(username==""||username.length()<4||username.length()>16){
					InfoCheck=false;
				}else if(CheckUserExist.checkuser(username)){/*�ж��û������*/
					InfoCheck=false;
					UserExist=false;
				}
				Pattern pattern = Pattern.compile("\\w+[@]{1}\\w+[.]\\w+");
				Matcher matcher = pattern.matcher(email);
				if(!matcher.matches()){
					InfoCheck=false;
				}else if(CheckEmailExist.checkuser(email)){/*�ж��������*/
					InfoCheck=false;
					EmailExist=false;
				}
				Pattern pattern2 = Pattern.compile("^1[3|4|5|8] \\d{9}$");
				Matcher matcher2 = pattern2.matcher(phone);
				if(!matcher.matches()){
					InfoCheck=false;
				}else if(CheckPhoneExist.checkuser(phone)){/*�жϵ绰����*/
					InfoCheck=false;
					PhoneExist=false;
				}
				Pattern pattern1 = Pattern.compile("^[0-9a-zA-Z_]{6,15}$");
				Matcher matcher1 = pattern1.matcher(password);
				if(!matcher1.matches()){
					InfoCheck=false;
				}else if(!password.equals(repassword)){
					InfoCheck=false;
				}
				if(!InfoCheck){
					String sent_json="{\"sORf\":\"false\"";
					if(!UserExist){
						sent_json+=",\"UserExist\":\"false\"";
					}else{
						sent_json+=",\"UserExist\":\"true\"";
					}
					if(!PhoneExist){
						sent_json+=",\"PhoneExist\":\"false\"";
					}else{
						sent_json+=",\"PhoneExist\":\"true\"";
					}
					if(!EmailExist){
						sent_json+=",\"EmailExist\":\"false\"}";
					}else{
						sent_json+=",\"EmailExist\":\"true\"}";
					}
					out.print(sent_json);
				}else{
					this.buildphoto(username);
					UserInfo user=new UserInfo();
					user.setUserName(username);
					user.setSex(sex);/*set Sex*/
					user.setEmail(email);
					user.setPassWord(password);
					user.setSex(sex);
					user.setPhone(phone);
					request.getSession().setAttribute("InsertUserData",user);
					request.getSession().setAttribute("USERNAME", username);
					RequestDispatcher rdispatcher=request.getRequestDispatcher("InsertUserDeal");
					rdispatcher.forward(request, response);
				}	
				out.flush();
				out.close();
			}
	public void buildphoto(String username) throws IOException{
		File existfile=new File("D:\\apache-tomcat-7.0.59\\webapps\\Tourism\\UserUploadPhoto\\1.jpg");
		 FileInputStream is=new  FileInputStream(existfile);
		 File copyfile=new File("D:\\apache-tomcat-7.0.59\\webapps\\Tourism\\UserUploadPhoto\\"+username+".jpg");
		 FileOutputStream os=new  FileOutputStream(copyfile);
		 byte[] buf=new byte[1024];
		 while(is.read(buf)!=-1){
			 os.write(buf);
		 }
		 is.close();
		 os.close();
	}
}
