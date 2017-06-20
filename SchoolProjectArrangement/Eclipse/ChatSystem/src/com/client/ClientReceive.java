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
 * @time:2015��12��22��
 */
public class ClientReceive extends Thread
{
	ChatClient chatclient;
	Socket sc;             		// ����sc�������������������ͨ��
	BufferedReader in;     		// ���������������������ڴ洢��������������Ϣ
	PrintWriter out;       		// ������ӡ�������������Ϣ�ķ���
	int port_server;
	String ip_server;
	ArrayList<String> Mstr_cli=new ArrayList<String>();
	public ClientReceive(ChatClient chatclient,String port_server,String ip_server)
	{
		this.chatclient=chatclient;
		this.ip_server=ip_server;
		this.port_server= Integer.parseInt(port_server);
		try {
			sc = new Socket(ip_server,this.port_server); // ����sc, �÷�����ip�Ͷ˿�������
			System.out.println("��˳�����ӵ�������");
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
				msg_cli = in.readLine();        // �ӻ���������һ���ַ�����msg
			} catch (SocketException ex) {
				JOptionPane.showMessageDialog(null,"���󣡿��ܷ������رջ��û�ע��");
				ex.printStackTrace();
				break;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (msg_cli != null && msg_cli.trim() != "") {                // ��msg��Ϣ��Ϊ��
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
				this.chatclient.getTextArea().append(msg_cli + "\n");// ��msg��Ϣ��ӵ��ͻ��˵��ı�������
				}
			}
		}
	}
	public void sendMsg(String msg,String sentuser) {         // ���ڷ�����Ϣ
		try {
			if("����".equals(sentuser))
			{
				out.println("�û�"+chatclient.UserName_cli+"��" + msg+":%"+sentuser);
			}
			else{
				if(chatclient.getCheckBox().isSelected()){
				out.println("��˽�ġ��û�"+chatclient.UserName_cli+"��" + msg+":%"+sentuser);
				}else{
				out.println("�û�"+chatclient.UserName_cli+"��" + msg+":%"+sentuser);
				}
			}
			if("����".equals(sentuser))
			{
			}else if(sentuser.equals(chatclient.UserName_cli)){
			}else{
				this.chatclient.getTextArea().append("�û�"+chatclient.UserName_cli+"��" + msg+"\n");
			}
			this.chatclient.getTextField().setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendname(String msg) {         // ���ڷ�����Ϣ
		try {
			out.println("**@" + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ע��
	public void sendQuit(String str) {         //���ڷ�����Ϣ
		try {
			out.println(":&"+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
