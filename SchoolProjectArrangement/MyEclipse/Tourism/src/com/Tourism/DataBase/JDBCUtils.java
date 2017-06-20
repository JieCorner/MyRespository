package com.Tourism.DataBase;

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
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.javabean.Comcontext;
import com.javabean.Order;
import com.javabean.Problem;
import com.javabean.ProductInfo;
import com.javabean.UserInfo;
import com.javabean.UserOrderInfo;
import com.javabean.UserProblemInfo;

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
	static public Boolean updateInfo(String username,String email,String phone,String password)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String updateword="update tourism_user set email=?,phone=?,password=? where username=?";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(updateword);
			ps.setString(1, email); 
			ps.setString(2, phone); 
			ps.setString(3, password); 
			ps.setString(4, username); 
			int i = ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
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
	static public UserInfo QueryUserInfo(String queryword, String userName)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if(rs.next()==true){
				return new UserInfo(rs.getString("username"),rs.getString("sex"),rs.getString("email"),rs.getString("phone"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
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
	//获得用户的所有订单
	static public ArrayList<UserOrderInfo> getUserOrderInfo(String username)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserOrderInfo> orderlist=new ArrayList<UserOrderInfo>();
		String sql="select * from tourism_order where username=?";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username); 
			rs = ps.executeQuery();
			while(rs.next())
			{
				String endandtime=JDBCUtils.getendandtime(rs.getString("ProductID"));
				String[] pt=endandtime.split(":");
				String endplace=pt[0];
				String timeconsume=pt[1];
				orderlist.add(new UserOrderInfo(rs.getString("ProductID"),rs.getString("staringplace"),
						endplace,timeconsume,rs.getString("startdate"),rs.getString("Adult"),
						rs.getString("Children"),rs.getString("Cost")));
			}
			return orderlist;
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	//获得用户问题列表
	static public ArrayList<UserProblemInfo> Userproblemlist(String username)
	{
		ArrayList problemlist=new ArrayList<UserProblemInfo>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String queryword="select problem,answer,productID from tourism_problems where username=?";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String noAnswer="<p style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;There is no answer, please wait for the administrator to reply</p>";
				if("".equals(rs.getString("answer"))||rs.getString("answer")==null){
					problemlist.add(new UserProblemInfo(rs.getString("problem"),noAnswer,rs.getString("productID")));
				}else{
					problemlist.add(new UserProblemInfo(rs.getString("problem"),rs.getString("answer"),rs.getString("productID")));
				}
			}
			return problemlist;
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	//获得用户订单的目的和耗时
	static public String getendandtime(String productID)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select EndPlace,Time from tourism_products where orderID=?";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, productID); 
			rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("EndPlace")+":"+rs.getString("Time");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	
	//是否为管理员
	static public Boolean IsAdminor(String username)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String queryword="select jurisdiction from tourism_user where username=?";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, username); // ��������
			rs = ps.executeQuery();
			if(rs.next()==true){
				if("governor".equals(rs.getString("jurisdiction"))){
					return true;
				}else{
					return false;
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return false;
	}
	
	//用户是否提问
	static public Boolean UserIsAsk(String queryword, String username,String productID)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, username); // ��������
			ps.setString(2, productID);
			rs = ps.executeQuery();
			if(rs.next()==true){
				return true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return false;
	}
	//删除订单
	static public Boolean deleteOrder(String deleteword)
	{
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.createStatement();
			i = ps.executeUpdate(deleteword);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		if(i==0){
			return false;
		}else{
			return true;
		}
	}
	//加入订单
	static public Boolean addOrder(String insertword,Order order)
	{
		Boolean insert=true;
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(insertword);
			ps.setString(1, order.getProductID()); // ��������
			ps.setString(2, order.getStaringplace());
			ps.setDate(3, order.getStartdate());
			ps.setString(4, order.getUsername());
			ps.setString(5, order.getPhone());
			ps.setString(6, order.getRemark());
			ps.setString(7, order.getAdult());
			ps.setString(8, order.getChildren());
			ps.setString(9, order.getCost());
			ps.execute();
		} catch (SQLException e)
		{
			insert=false;
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return insert;
		}
	}
	// ����̨�����ѯ���
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
	//用户看完后，设置用户问题为1的全部为0
	static public Boolean afterwatch(String username)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String updateword="update tourism_problems set ifsovle=0 where username=?";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(updateword);
			ps.setString(1, username); 
			int i = ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	//用户打开时，统计指定用户的应该显示问题个数
	static public int countShowProblem(String username)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String updateword="select count(*) from tourism_problems where username=? and ifsovle=1";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(updateword);
			ps.setString(1, username); 
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	//管理员回答完问题后，设置对应的问题为1
	static public Boolean Problemremind(String username,String ProductID,int or)
	{
		Boolean update=true;
		Connection conn = null;
		PreparedStatement ps = null;
		String updateword="update tourism_problems set ifsovle=? where username=? and ProductID=?";
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(updateword);
			ps.setInt(1, or);
			ps.setString(2, username); 
			ps.setString(3, ProductID);
			ps.execute();
		} catch (SQLException e)
		{
			update=false;
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return update;
		}
	}
	//管理员回答问题
	static public Boolean insertAnswer(String username,String ProductID,String answer)
	{
		Boolean update=true;
		Connection conn = null;
		PreparedStatement ps = null;
		String updateword="update tourism_problems set answer=? where username=? and ProductID=?";
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(updateword);
			ps.setString(1, answer);
			ps.setString(2, username); 
			ps.setString(3, ProductID);
			ps.execute();
		} catch (SQLException e)
		{
			update=false;
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return update;
		}
	}
	static public String getUserName(String email)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select * from tourism_user where email=?";
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email); 
			rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("username");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	static public Boolean insertComment(String insertword,String comment,String username,String productID,String date)
	{
		Boolean insert=true;
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(insertword);
			ps.setString(1, productID); 
			ps.setString(2, username);
			ps.setString(3, comment);
			ps.setString(4, date);
			ps.execute();
		} catch (SQLException e)
		{
			insert=false;
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return insert;
		}
	}
	//��������
	static public ArrayList<Problem> QueryProblem(String queryword, String productID,int i)
	{
		ArrayList prolist=new ArrayList<Problem>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, productID);
			rs = ps.executeQuery();
			if(i==0){
				while(rs.next())
				{
					if(("".equals(rs.getString("answer"))||rs.getString("answer")==null)){
						prolist.add(new Problem(rs.getString("problem"),rs.getString("answer"),rs.getString("username")));
					}
				}
			}else{
				while(rs.next())
				{
					if(!("".equals(rs.getString("answer"))||rs.getString("answer")==null)){
						prolist.add(new Problem(rs.getString("problem"),rs.getString("answer"),""));
					}
				}
			}
			return prolist;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	//��������
	static public Boolean insertProblem(String insertword,String problem,String username,String productID)
	{
		Boolean insert=true;
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(insertword);
			ps.setString(1, problem); // ��������
			ps.setString(2, username);
			ps.setString(3, productID);
			ps.execute();
		} catch (SQLException e)
		{
			insert=false;
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return insert;
		}
	}
	//��ò�Ʒ��Ϣ
	static public ProductInfo QueryOrder(String queryword, String key)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductInfo pro=new ProductInfo();
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, key); // ��������
			rs = ps.executeQuery();
			if(rs.next()==true){
				pro.setCost(rs.getInt("cost"));
				pro.setPlace(rs.getString("StaringPlace"));
				pro.setPraise(rs.getInt("Praise"));
				pro.setBad(rs.getInt("Bad"));
			}
			return pro;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	//��ѯ�û���ƥ�������
	static public String QueryMatchPassword(String queryword, String key)
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
			if(rs.next()==true){
				return rs.getString("password");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	// �����Ĳ�ѯ(ֻ��һ������)
	static public Boolean QueryDataExist(String queryword, String key)
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
			if(rs.next()==true){
				return true;       //���ڷ�����
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return false;
	}
	
	//��������
	static public ArrayList<Comcontext> QueryProductCom(String queryword, String key,int start,int end)
	{
		ArrayList comlist=new ArrayList<Comcontext>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(queryword);
			ps.setString(1, key); // ��������
			ps.setInt(2, start);
			ps.setInt(3,end);
			rs = ps.executeQuery();
			while(rs.next())
			{
				comlist.add(new Comcontext(rs.getString("username"),rs.getString("context"),rs.getString("date")));
			}
			return comlist;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}
	
	//������۵�����
	static public int GetProductCount(String queryword, String key)
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
			int num=0;
			if(rs.next()==true){
				num=rs.getInt(1);
			}
			return num;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			JDBCUtils.close(rs, ps, conn);
		}
		return 0;
	}
	
	// ����ݿ��в������
	@SuppressWarnings("finally")
	static public Boolean insertData(String insertword,String username,String sex,String email,String password,String phone)
	{
		Boolean insert=true;
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(insertword);
			ps.setString(1, username); // ��������
			ps.setString(2, sex);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, phone);
			ps.execute();
		} catch (SQLException e)
		{
			insert=false;
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return insert;
		}
	}

	// �������
	@SuppressWarnings("finally")
	static public Boolean updateData(String updateword,String username)
	{
		Boolean update=true;
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		try
		{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(updateword);
			ps.setString(1, username); // ��������
			ps.execute();
		} catch (SQLException e)
		{
			update=false;
			e.printStackTrace();
		} finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return update;
		}
	}

	// ɾ�����
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
}
