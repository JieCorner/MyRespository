package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.User;
import com.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("hello")
	public String sayHello(){
		return "hello world";
	}
	
	@RequestMapping("maps")
	public Map getmaps(){
		HashMap maps=new HashMap();
		maps.put("name", "张三");
		maps.put("age", 13);
		return maps;
	}
	@RequestMapping("ssm")
	public List<User> findAll(){
		List<User> list=userService.findAll();
		return  list;
	}
}
