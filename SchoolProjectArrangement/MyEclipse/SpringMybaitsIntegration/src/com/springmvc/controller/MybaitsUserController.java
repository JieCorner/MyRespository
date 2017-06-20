package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybaits.po.MybaitsUser;
import com.springmvc.service.MybaitsUserService;

@Controller
public class MybaitsUserController {
	
	@Autowired
	private MybaitsUserService mybaitsUserservice;
	
	@RequestMapping("/QueryUser")
	public ModelAndView findUserById() throws Exception{
		MybaitsUser user=mybaitsUserservice.findUserById(1);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("MybaitsUser",user);
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
}
