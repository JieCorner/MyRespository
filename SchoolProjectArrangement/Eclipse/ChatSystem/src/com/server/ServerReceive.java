package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


/**
 * @author jie
 * @action:
 * @time:2015年12月22日
 */
public class ServerReceive extends Thread
{
	private ServerLink serverlink;
	BufferedReader in;
	PrintWriter out;
	Socket socket;
	public ServerReceive(ServerLink serverlink,Socket socket)
	{
		this.socket=socket;
		this.serverlink=serverlink;
		
	}
	@Override
	public void run()
	{
		String msg = "";
		try
		{
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		while (true) {
			try {
				msg =in.readLine();
			} catch (SocketException ex) {
				System.out.println(ex);
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			if (msg != null && msg.trim() != "") {
				Socket ss=null;
				if(msg.startsWith(":&"))
				{
					for(Socket s:serverlink.userlinklist.getUserlinklist())
					{
						if(s==this.socket)
						{
							ss=s;
						}
					}
					serverlink.userlinklist.getUserlinklist().remove(ss);
					serverlink.Mstr.remove(msg.substring(2));
					serverlink.chatserver.getComboBox().setModel(new DefaultComboBoxModel(serverlink.Mstr.toArray()));
					String alluser=new String();
					for(String s:serverlink.Mstr)
					{
						alluser=alluser+":@"+s;
					}
					for(Socket socket:serverlink.userlinklist.getUserlinklist())
					{
							try
							{
								new PrintWriter(socket.getOutputStream(), true).println(alluser);
							} catch (IOException e1)
							{
								e1.printStackTrace();
							};
					}
				}else if(msg.startsWith("**@"))
				{
					serverlink.Mstr.add(msg.substring(3));
					serverlink.chatserver.getComboBox().setModel(new DefaultComboBoxModel(serverlink.Mstr.toArray()));
					//用户名发送给所有客户
					String alluser=new String();
					for(String s:serverlink.Mstr)
					{
						alluser=alluser+":@"+s;
					}
					for(Socket socket:serverlink.userlinklist.getUserlinklist())
					{
							try
							{
								new PrintWriter(socket.getOutputStream(), true).println(alluser);
							} catch (IOException e1)
							{
								e1.printStackTrace();
							};
					}
				}
				else{
					//收到客户端的消息后向其他客户端发送
					System.out.println(">>" + msg);
					//
					Pattern pa=Pattern.compile(":%");
					String[] user_msg=pa.split(msg);
					String msg_get;
					String use_get;
					if(user_msg.length!=2)
					{
						msg_get=user_msg[0];
						use_get="";
					}
					else{
						msg_get=user_msg[0];
						use_get=user_msg[1];
					}
					if("".equals(use_get)||"所有".equals(use_get))
					{
						serverlink.chatserver.getTextArea().append(msg_get+ "\n");
						for(Socket node1:serverlink.userlinklist.getUserlinklist())
						{
							try
							{
								new PrintWriter(node1.getOutputStream(), true).println(msg_get);
							} catch (IOException e)
							{
								e.printStackTrace();
							}
						}
					}
					else{
						int position=serverlink.Mstr.indexOf(use_get);
						System.out.println(position);
						Socket socket_get=serverlink.userlinklist.getUserlinklist().get(position-1);
						try
						{
							new PrintWriter(socket_get.getOutputStream(), true).println(msg_get);
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
				
			}
		}
	}
}
