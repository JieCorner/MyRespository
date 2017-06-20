package com.conversation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

//�ͻ���ͨ�ŷ�����
class ClientSvr extends Thread {
	Socket sc;// ����sc�������������������ͨ��

	BufferedReader in;// ���������������������ڴ洢��������������Ϣ

	PrintWriter out;// ������ӡ�������������Ϣ�ķ���

	ClientUI ui;

	public ClientSvr(String ip, int port, ClientUI ui) {// ��ʼ��ClientSvr��
		this.ui = ui;
		try {
			sc = new Socket(ip, port); // ����sc, �÷�����ip�Ͷ˿�������
			System.out.println("��˳�����ӵ���������");
			out = new PrintWriter(sc.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		} catch (Exception e) {
			System.out.println(e);
		}
		start();
	}

	public void run() { // ���ڼ����������˷���������Ϣ
		String msg = "";
		while (true) {
			try {
				msg = in.readLine();// �ӻ���������һ���ַ�����msg
			} catch (SocketException ex) {
				System.out.println(ex);
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			if (msg != null && msg.trim() != "") {// ��msg��Ϣ��Ϊ��
				System.out.println(">>" + msg);
				ui.mainArea.append(msg + "\n");// ��msg��Ϣ��ӵ��ͻ��˵��ı�������
			}
		}
	}

	public void sendMsg(String msg) {// ���ڷ�����Ϣ
		try {
			out.println("���ͻ��ˡ�" + msg);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

