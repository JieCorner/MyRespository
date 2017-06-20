package com.easyui.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;




public class JDBCUtils
{
	static Properties pros = null;
	static
	{
		pros = new Properties();
		try
		{
			pros.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("database.properites"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConn()
	{
		try
		{
			Class.forName(pros.getProperty("Driver"));
			return DriverManager.getConnection(pros.getProperty("URL"),
					pros.getProperty("User"), pros.getProperty("Password"));
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static void close(ResultSet rs, Statement ps, Connection conn)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if (conn != null)
			{
				ps.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs, Connection conn)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
