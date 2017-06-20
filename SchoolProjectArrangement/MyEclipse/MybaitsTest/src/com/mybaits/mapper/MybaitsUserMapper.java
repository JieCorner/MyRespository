package com.mybaits.mapper;

import com.mybaits.po.MybaitsUser;

public interface MybaitsUserMapper {
	//根据id查询用户
	public MybaitsUser findUserById(int id) throws Exception;
	//使用ResultMap
	public MybaitsUser findUserByIdResultMap(int id) throws Exception;
}
