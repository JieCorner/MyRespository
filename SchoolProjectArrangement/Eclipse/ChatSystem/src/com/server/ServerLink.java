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
 * @time:2015��12��22��
 */
public class ServerLink extends Thread
{
	ChatServer chatserver;
	ArrayList<String> Mstr=new ArrayList<String>();
	int port;
	Socket sc;
	ServerSocket ss;
	UserLinkList userlinklist=new UserLinkList();
	
	public ServerLink(int port,ChatServer chatserver) { // ��ʼ��ServerReceive��
		this.port=port;
		this.chatserver=chatserver;
		Mstr.add("����");
	}
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		try
		{
			ss = new ServerSocket(port);
			System.out.println("�����������ɹ�");
			this.chatserver.getButton().setEnabled(false);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			try {
				sc = ss.accept();     								// ���ͻ�����������ʱ������һ������
				
				System.out.println("���ӳɹ�������" + sc.toString());
				//����list
				
//				JOptionPane.showMessageDialog(null,"����");
				
				userlinklist.getUserlinklist().add(sc);
				
				new ServerReceive(this,sc).start();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
}
