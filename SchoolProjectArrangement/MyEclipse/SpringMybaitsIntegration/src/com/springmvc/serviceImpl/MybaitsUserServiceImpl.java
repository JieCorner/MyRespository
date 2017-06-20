package com.springmvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mybaits.mapper.MybaitsUserMapper;
import com.mybaits.po.MybaitsUser;
import com.springmvc.service.MybaitsUserService;

public class MybaitsUserServiceImpl implements MybaitsUserService{
	@Autowired
	private MybaitsUserMapper mybaitsusermapper;
	
	@Override
	public MybaitsUser findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		MybaitsUser user=mybaitsusermapper.findUserById(id);
		return user;
	}

}
