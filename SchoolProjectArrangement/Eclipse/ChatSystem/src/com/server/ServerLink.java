package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * @author jie
 * @action:
 * @time:2015年12月22日
 */
public class ServerLink extends Thread
{
	ChatServer chatserver;
	ArrayList<String> Mstr=new ArrayList<String>();
	int port;
	Socket sc;
	ServerSocket ss;
	UserLinkList userlinklist=new UserLinkList();
	
	public ServerLink(int port,ChatServer chatserver) { // 初始化ServerReceive类
		this.port=port;
		this.chatserver=chatserver;
		Mstr.add("所有");
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		try
		{
			ss = new ServerSocket(port);
			System.out.println("启动服务器成功");
			this.chatserver.getButton().setEnabled(false);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			try {
				sc = ss.accept();     								// 当客户机请求连接时，创建一条链接
				
				System.out.println("连接成功！来自" + sc.toString());
				//存入list
				
//				JOptionPane.showMessageDialog(null,"加入");
				
				userlinklist.getUserlinklist().add(sc);
				
				new ServerReceive(this,sc).start();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
}
