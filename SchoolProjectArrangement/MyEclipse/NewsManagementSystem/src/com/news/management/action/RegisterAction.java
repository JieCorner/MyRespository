package com.news.management.action;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.User;
import com.news.management.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	
	private UserService userService;
	private String username;
	private String password;
	private String repassword;
	private String email;
	private int age;
	
	@Autowired
	public void setUserService(@Qualifier("userService")UserService userService) {
		this.userService = userService;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
		User registeruser=new User();
		boolean haven=userService.getUserByName(username);
		if(haven){
			registeruser.setUsername(username);
			registeruser.setAge(age);
			registeruser.setEmail(email);
			registeruser.setPassword(password);
			registeruser.setManager(false);
			this.userService.add(registeruser);
			//复制用户图片
			try {
				String filePath=ServletActionContext.getRequest().getRealPath("/uploadAvatar")+"\\userAvatar.jpg";
				BufferedImage bufferedImage;
			    bufferedImage = ImageIO.read(new File(filePath));
			    BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
			    bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			    newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
			    ImageIO.write(newBufferedImage, "jpg", new File("E:/NewsUpdateAvatar"+"\\"+username+".jpg"));
			  } catch (Exception e) {
			      e.printStackTrace();
			    }
			return SUCCESS;
		}else{
			addFieldError("username", "此用户名已被注册,请重新输入");
			return INPUT;
		}
		
	}
}
