package com.weblogicTest;

import java.sql.*;
import java.util.Hashtable;
import javax.sql.*;
import javax.naming.*;
import com.mysql.jdbc.Connection;

/** 需要先启动服务器在运行
 * @author ZhengGengJie
 * @action:
 * @time:2016-4-10
 */
public class DataSourceTest {
	public static void main(String[] args) {
		DataSource ds=null;     //获取WebLogic服务器中的JNDI数据源工具类
		Context ctx=null;       //这几个都是JNDI提供的接口javax.naming.*里面的内容
		Connection myConn=null;
		Hashtable ht=new Hashtable();
		//初始化上下文需要用到的工厂类
		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		//WebLogic服务器的访问地址
		ht.put(Context.PROVIDER_URL,"t3://localhost:7001");
		try {
			//初始化WebLogic Server的JNDI上下文信息
			ctx=new InitialContext(ht);
			//获取数据源对象
			ds=(javax.sql.DataSource)ctx.lookup("Week3Test");   //引用数据源
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ds==null){
			System.out.println("error");
		}else{
			System.out.println("Connection ok");              //连接成功
			Statement mystatement=null;
			ResultSet myset=null;
			try{
				myConn=(com.mysql.jdbc.Connection)ds.getConnection();     //获得连接
				mystatement=myConn.createStatement();
				myset=mystatement.executeQuery("select * from users");
				while(myset.next()){
					System.out.println(myset.getString("name")+" "+myset.getShort("password"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
