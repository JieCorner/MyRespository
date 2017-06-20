package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybaits.po.MybaitsUser;

public class MybaitsTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception{
		String resource="SqlMapConfig.xml";
		
		InputStream inputstream=Resources.getResourceAsStream(resource);
		
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream); 
	}
	
	
	@Test
	public void findUserByIdTest() throws IOException{
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		MybaitsUser user=sqlSession.selectOne("test.findUserById",1);
		
		System.out.println(user.getAddress());
	
		sqlSession.close();
	}
	
	@Test
	public void findUserByNameTest() throws IOException{ 
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		List<MybaitsUser> userlist=sqlSession.selectList("test.findUserByName","张%");
		
		System.out.println(userlist);
	
		sqlSession.close();
	}
	
	@Test
	public void InsertUserTest() throws IOException{
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		MybaitsUser user=new MybaitsUser();
		user.setName("哈哈");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("广东");
		
		sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId());
		
		sqlSession.close();
	}
	
	@Test
	public void deleteUserByIdTest() throws IOException{
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUserById",2);
		
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	@Test
	public void updateUserTest() throws IOException{
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		MybaitsUser user=new MybaitsUser();
		
		user.setId(5);
		user.setName("哈哈wen");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("广南");
		sqlSession.update("test.updateUser",user);
		
		sqlSession.commit();
		
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	
}
