package com.JDBCoperate;

import java.awt.event.MouseEvent;
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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JDBCUtils
{
	// 构造时注册驱动
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

	// 获得连接connection
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

	// 关闭所有的连接
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

	// 关闭带参数语句的连接
	public static void close(CallableStatement cs, Connection conn)
	{
		try
		{
			if (cs != null)
			{
				cs.close();
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

	// 控制台输出查询数据
	static public void QueryData(String queryword)
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			st = conn.createStatement();
			rs = st.executeQuery(queryword);
			while (rs.next())
			{
				// 修改输出内容的列
				System.out.println(rs.getObject("Bookid") + "\t"
						+ rs.getObject("Readerid") + "\t"
						+ rs.getObject("Lendtime"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, st, conn);
		}
	}

	// 带参数的查询(只带一个参数)
	static public void QueryDatawith(String queryword, String key)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, key); // 参数设置
			rs = ps.executeQuery();
			while (rs.next())
			{
				// 修改输出内容的列
				System.out.println(rs.getObject("Bookid") + "\t"
						+ rs.getObject("Readerid") + "\t"
						+ rs.getObject("Lendtime"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	// 向数据库中插入数据
	static public int insertData(String insertword)
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			st = conn.createStatement();
			i = st.executeUpdate(insertword);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, st, conn);
		}
		return i;
	}

	// 更新数据
	static public int updateData(String updateword)
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			st = conn.createStatement();
			i = st.executeUpdate(updateword);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, st, conn);
		}
		return i;
	}

	// 删除数据
	static public int deleteData(String deleteword)
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			st = conn.createStatement();
			i = st.executeUpdate(deleteword);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, st, conn);
		}
		return i;
	}

	// 存入图片（参考插入语句：insert into blob_test(big_bit) values(?);）
	static public void insertpicture(String queryword, String photofile)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			File file = new File(photofile);
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			ps.setBinaryStream(1, in, (int) file.length());
			i = ps.executeUpdate();
			in.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	// 取出图片（参考查询语句：select big_bit from blob_test;）photofile:为要生成图片的位置和名字
	static public void getphoto(String queryword, String photofile)
	{
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.createStatement();
			rs = ps.executeQuery(queryword);
			while (rs.next())
			{
				InputStream in = rs.getBinaryStream(1);
				File file = new File(photofile);
				OutputStream out = new BufferedOutputStream(
						new FileOutputStream(file));
				byte[] buff = new byte[1024];
				for (int i = 0; (i = in.read(buff)) > 0;)
				{
					out.write(buff, 0, i);
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	//存储过程命令(MQ_orexist是存储过程名称，后面？是参数)该方法需要修改
	//查看数据库课件
	static public void saveprocess()
	{
			Connection conn_MQ = JDBCUtils.getConn();
			PreparedStatement Mstate_MQ;
			//设置参数值
			String str_MQ=null;     
			CallableStatement cs ;
			try
			{
				cs= conn_MQ.prepareCall("{call MQ_orexist(?,?)}");
				//设置参数值
				cs.setString(1,str_MQ); 
				cs.registerOutParameter(2,Types.INTEGER);
				
				cs.execute();
				
				int row_MQ=cs.getInt(2);      //获得返回值
				
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
	}
}
