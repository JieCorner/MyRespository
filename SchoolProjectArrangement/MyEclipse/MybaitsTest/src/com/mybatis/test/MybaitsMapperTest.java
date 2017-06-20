package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybaits.mapper.MybaitsUserMapper;
import com.mybaits.po.MybaitsUser;

public class MybaitsMapperTest {
private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception{
		String resource="SqlMapConfig.xml";
		
		InputStream inputstream=Resources.getResourceAsStream(resource);
		
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream); 
	}
	
	@Test
	public void findUserByIdTest() throws Exception{
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		MybaitsUserMapper mybaitsusermapper=sqlSession.getMapper(MybaitsUserMapper.class);
		
		MybaitsUser user=mybaitsusermapper.findUserById(1);
		
		System.out.println(user);
		
		sqlSession.close();
	}
	
	@Test
	public void findUserByIdResultMapTest() throws Exception{
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		MybaitsUserMapper mybaitsusermapper=sqlSession.getMapper(MybaitsUserMapper.class);
		
		MybaitsUser user=mybaitsusermapper.findUserByIdResultMap(1);
		
		System.out.println(user);
		
		sqlSession.close();
	}
	
}
