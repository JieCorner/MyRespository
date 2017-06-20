package com.client;

import java.io.BufferedReader;
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
public class ClientReceive extends Thread
{
	ChatClient chatclient;
	Socket sc;             		// 对象sc，用来处理与服务器的通信
	BufferedReader in;     		// 声明输入流缓冲区，用于存储服务器发来的信息
	PrintWriter out;       		// 声明打印输出流，用于信息的发送
	int port_server;
	String ip_server;
	ArrayList<String> Mstr_cli=new ArrayList<String>();
	public ClientReceive(ChatClient chatclient,String port_server,String ip_server)
	{
		this.chatclient=chatclient;
		this.ip_server=ip_server;
		this.port_server= Integer.parseInt(port_server);
		try {
			sc = new Socket(ip_server,this.port_server); // 创建sc, 用服务器ip和端口作参数
			System.out.println("已顺利联接到服务器");
			out = new PrintWriter(sc.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public void run()
	{
		String msg_cli ="";
		while (true) {
			try {
				msg_cli = in.readLine();        // 从缓冲区读入一行字符存于msg
			} catch (SocketException ex) {
				JOptionPane.showMessageDialog(null,"错误！可能服务器关闭或用户注销");
				ex.printStackTrace();
				break;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (msg_cli != null && msg_cli.trim() != "") {                // 若msg信息不为空
				if(msg_cli.startsWith(":@"))
				{
					Mstr_cli.clear();
					Pattern pa=Pattern.compile(":@");
					String[] ss=pa.split(msg_cli);
					System.out.println(msg_cli);
					for(String s:ss)
					{
						if(!"".equals(s))
						{
							Mstr_cli.add(s);
						}
					}
					chatclient.getComboBox().setModel(new DefaultComboBoxModel(Mstr_cli.toArray()));
				}
				else{
				this.chatclient.getTextArea().append(msg_cli + "\n");// 把msg信息添加到客户端的文本区域内
				}
			}
		}
	}
	public void sendMsg(String msg,String sentuser) {         // 用于发送信息
		try {
			if("所有".equals(sentuser))
			{
				out.println("用户"+chatclient.UserName_cli+"：" + msg+":%"+sentuser);
			}
			else{
				if(chatclient.getCheckBox().isSelected()){
				out.println("【私聊】用户"+chatclient.UserName_cli+"：" + msg+":%"+sentuser);
				}else{
				out.println("用户"+chatclient.UserName_cli+"：" + msg+":%"+sentuser);
				}
			}
			if("所有".equals(sentuser))
			{
			}else if(sentuser.equals(chatclient.UserName_cli)){
			}else{
				this.chatclient.getTextArea().append("用户"+chatclient.UserName_cli+"：" + msg+"\n");
			}
			this.chatclient.getTextField().setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendname(String msg) {         // 用于发送信息
		try {
			out.println("**@" + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//注销
	public void sendQuit(String str) {         //用于发送信息
		try {
			out.println(":&"+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
