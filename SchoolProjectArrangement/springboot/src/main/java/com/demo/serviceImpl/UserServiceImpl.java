package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> list=userMapper.findAll();
		System.out.println(list);
		return list;
	}
	
}
