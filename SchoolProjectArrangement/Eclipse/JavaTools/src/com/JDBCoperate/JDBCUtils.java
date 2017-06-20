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
	// ����ʱע������
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

	// �������connection
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

	// �ر����е�����
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

	// �رմ�������������
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

	// ����̨�����ѯ����
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
				// �޸�������ݵ���
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

	// �������Ĳ�ѯ(ֻ��һ������)
	static public void QueryDatawith(String queryword, String key)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, key); // ��������
			rs = ps.executeQuery();
			while (rs.next())
			{
				// �޸�������ݵ���
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

	// �����ݿ��в�������
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

	// ��������
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

	// ɾ������
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

	// ����ͼƬ���ο�������䣺insert into blob_test(big_bit) values(?);��
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

	// ȡ��ͼƬ���ο���ѯ��䣺select big_bit from blob_test;��photofile:ΪҪ����ͼƬ��λ�ú�����
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
	//�洢��������(MQ_orexist�Ǵ洢�������ƣ����棿�ǲ���)�÷�����Ҫ�޸�
	//�鿴���ݿ�μ�
	static public void saveprocess()
	{
			Connection conn_MQ = JDBCUtils.getConn();
			PreparedStatement Mstate_MQ;
			//���ò���ֵ
			String str_MQ=null;     
			CallableStatement cs ;
			try
			{
				cs= conn_MQ.prepareCall("{call MQ_orexist(?,?)}");
				//���ò���ֵ
				cs.setString(1,str_MQ); 
				cs.registerOutParameter(2,Types.INTEGER);
				
				cs.execute();
				
				int row_MQ=cs.getInt(2);      //��÷���ֵ
				
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
	}
}
