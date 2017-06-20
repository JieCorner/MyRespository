package com.myJNDI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.Hashtable;
import java.util.ResourceBundle;


/**
 * @author:ZhengGengJie
 * @description:
 * @package:com.myJNDI
 * @time:2016-12-20 下午03:50:22
 */
public class JNDITest {
	public static void main(String[] args) {
		DataSource ds = null;
		Context ctx = null;
		Connection myConn = null;
		Hashtable ht = new Hashtable();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,
				"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
		try {
			ctx = new InitialContext(ht);
			ds = (javax.sql.DataSource) ctx.lookup("Week3Test");// test为JNDI名
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ds == null) {
			System.out.println("error");
		} else {
			System.out.println("Connection OK!");
		}
		Statement mystatement = null;
		ResultSet myset = null;
		try {
			myConn = ds.getConnection();
			mystatement = myConn.createStatement();
			myset = mystatement.executeQuery("select * from users");
			while (myset.next()) {
				System.out.println(myset.getString("name") + "    "
						+ myset.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DataSource ds = null;
	// Context ctx = null;
	// Connection myConn = null;
	// Hashtable ht = new Hashtable();
	// ht.put(Context.INITIAL_CONTEXT_FACTORY,
	// "weblogic.jndi.WLInitialContextFactory");
	// ht.put(Context.PROVIDER_URL , "t3://localhost:7001");
	// try{
	// ctx = new InitialContext(ht);
	// ds = (javax.sql.DataSource) ctx.lookup("Week3Test");//test为JNDI名
	// }catch(Exception e){
	// e.printStackTrace();
	// }
	// if(ds==null){
	// System.out.println("error");
	// }
	// else{
	// System.out.println("Connection OK!");
	// }
	// }
}