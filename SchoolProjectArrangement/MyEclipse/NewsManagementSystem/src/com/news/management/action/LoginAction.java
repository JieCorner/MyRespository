package com.news.management.action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.news.management.bean.User;
import com.news.management.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	public Map responseJson;
	private String username;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(@Qualifier("userService")UserService userService) {
		this.userService = userService;
	}

	public Map getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}

	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		//进行校验
		Map<String, String> map = new HashMap<String, String>();
		User user=userService.LoginOfUserExist(username, password);
		if(userService.getUserByName(username)){
			//用户不存在
			map.put("requestResult", "fail");
		}else if(user!=null){
			//用户存在(判断是否为管理员)
//			System.out.println(user.getManager());
			//判断密码
			//设置session
			HttpSession session=ServletActionContext. getRequest().getSession();
			session.setAttribute("USERNAME", username);
			session.setAttribute("USERID", user.getId());
			if(user.getManager()){
				session.setAttribute("MANAGER", user.getManager());
				//管理员的话转到管理页面return
			}
			map.put("requestResult", "success");
		}else{
			map.put("requestResult", "fail");
		}
		this.setResponseJson(map);  
		return SUCCESS;
	}
	
	public String UserExit() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		HttpSession session=ServletActionContext. getRequest().getSession();
		session.removeAttribute("USERNAME");
		session.setAttribute("USERID", 0);
		session.invalidate();
		map.put("requestResult", "success");
		this.setResponseJson(map);  
		return SUCCESS;
	}
	
}
