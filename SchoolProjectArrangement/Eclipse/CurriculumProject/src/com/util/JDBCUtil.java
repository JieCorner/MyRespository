package com.util;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtil {

	static Properties pros = null;
	static{		
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properites"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			return DriverManager.getConnection
					(pros.getProperty("mysqlURL"),pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(ResultSet rs,Statement ps,Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(CallableStatement cs,Connection conn){
		try {
			if(cs != null){
				cs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement ps){
		try {
			if(ps != null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement ps,Connection conn){
		try {
			if(conn != null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
