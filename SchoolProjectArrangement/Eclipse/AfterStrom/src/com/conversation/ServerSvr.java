package com.conversation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.Socket;


//服务器通信服务类
class ServerSvr extends Thread {
	Socket sc;
	ServerSocket ss;
	BufferedReader in;
	PrintWriter out;
	ServerUI ui;

	public ServerSvr(ServerUI ui) { // 初始化SvrCom类
		this.ui = ui;
		ui.setServer(this);
		try {
			ss = new ServerSocket(2345);
			System.out.println("启动服务器成功，等待端口号：2345");
			sc = ss.accept();// 当客户机请求连接时，创建一条链接
			System.out.println("连接成功！来自" + sc.toString());

			in = new BufferedReader(new InputStreamReader(sc
					.getInputStream()));
			out = new PrintWriter(sc.getOutputStream(), true);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		start();
	}

	public void run() {// 用于监听客户端发送来的信息
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

	public void sendMsg(String msg) {// 用于发送信息
		try {
			out.println("【服务器】" + msg);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

