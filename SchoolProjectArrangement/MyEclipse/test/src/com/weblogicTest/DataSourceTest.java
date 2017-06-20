package com.weblogicTest;

import java.sql.*;
import java.util.Hashtable;
import javax.sql.*;
import javax.naming.*;
import com.mysql.jdbc.Connection;

/** ��Ҫ������������������
 * @author ZhengGengJie
 * @action:
 * @time:2016-4-10
 */
public class DataSourceTest {
	public static void main(String[] args) {
		DataSource ds=null;     //��ȡWebLogic�������е�JNDI����Դ������
		Context ctx=null;       //�⼸������JNDI�ṩ�Ľӿ�javax.naming.*���������
		Connection myConn=null;
		Hashtable ht=new Hashtable();
		//��ʼ����������Ҫ�õ��Ĺ�����
		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		//WebLogic�������ķ��ʵ�ַ
		ht.put(Context.PROVIDER_URL,"t3://localhost:7001");
		try {
			//��ʼ��WebLogic Server��JNDI��������Ϣ
			ctx=new InitialContext(ht);
			//��ȡ����Դ����
			ds=(javax.sql.DataSource)ctx.lookup("Week3Test");   //��������Դ
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ds==null){
			System.out.println("error");
		}else{
			System.out.println("Connection ok");              //���ӳɹ�
			Statement mystatement=null;
			ResultSet myset=null;
			try{
				myConn=(com.mysql.jdbc.Connection)ds.getConnection();     //�������
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
