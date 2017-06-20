package com.springmvc.service;

import com.mybaits.po.MybaitsUser;

public interface MybaitsUserService {
	public MybaitsUser findUserById(int id) throws Exception;
}
