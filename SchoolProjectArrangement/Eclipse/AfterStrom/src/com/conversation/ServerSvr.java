package com.conversation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.Socket;


//������ͨ�ŷ�����
class ServerSvr extends Thread {
	Socket sc;
	ServerSocket ss;
	BufferedReader in;
	PrintWriter out;
	ServerUI ui;

	public ServerSvr(ServerUI ui) { // ��ʼ��SvrCom��
		this.ui = ui;
		ui.setServer(this);
		try {
			ss = new ServerSocket(2345);
			System.out.println("�����������ɹ����ȴ��˿ںţ�2345");
			sc = ss.accept();// ���ͻ�����������ʱ������һ������
			System.out.println("���ӳɹ�������" + sc.toString());

			in = new BufferedReader(new InputStreamReader(sc
					.getInputStream()));
			out = new PrintWriter(sc.getOutputStream(), true);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		start();
	}

	public void run() {// ���ڼ����ͻ��˷���������Ϣ
		String msg = "";
		while (true) {
			try {
				msg = in.readLine();
			} catch (SocketException ex) {
				System.out.println(ex);
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			if (msg != null && msg.trim() != "") {
				System.out.println(">>" + msg);
				ui.mainArea.append(msg + "\n");
			}
		}
	}

	public void sendMsg(String msg) {// ���ڷ�����Ϣ
		try {
			out.println("����������" + msg);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

