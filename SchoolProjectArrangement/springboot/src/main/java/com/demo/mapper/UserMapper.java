package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.bean.User;

@Mapper
public interface UserMapper {
	//这里的@Mapper注解是让spring自动生成对象,才能注入service
	public List<User> findAll();
}
