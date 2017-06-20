package com.JDBCoperate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
//		JDBCUtils.QueryData("select * from BookLended");
//		JDBCUtils.QueryDatawith("select * from BookLended where Readerid=?","1000003333");
//		System.out.println(JDBCUtils.insertData("insert into BookLended values('7-89494-083-6-1','1000008888','2010-9-9','2015-9-9')"));
//		JDBCUtils.deleteData("delete from BookLended where Readerid=1000008888");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn =DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=LittleLibrary"
				,"sa", "0818");
		
		Statement ss=conn.createStatement();
		ResultSet rs=ss.executeQuery("select * from Reader");
		
		while(rs.next())
		{
			System.out.println(rs.getObject(1));
		}
		ss.close();
		rs.close();
		conn.close();
	}
}
