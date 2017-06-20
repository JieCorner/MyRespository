package com.easyui.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SelectTest {
	public static void main(String[] args) {
		String sql="select * from student";
		Connection conn = null;
		Statement sm=null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			sm=conn.createStatement();
			rs=sm.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("chinese"));
				System.out.println(rs.getString("math"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, conn);
		}
		
	}
}
