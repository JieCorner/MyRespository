package com.conversation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

//客户端通信服务类
class ClientSvr extends Thread {
	Socket sc;// 对象sc，用来处理与服务器的通信

	BufferedReader in;// 声明输入流缓冲区，用于存储服务器发来的信息

	PrintWriter out;// 声明打印输出流，用于信息的发送

	ClientUI ui;

	public ClientSvr(String ip, int port, ClientUI ui) {// 初始化ClientSvr类
		this.ui = ui;
		try {
			sc = new Socket(ip, port); // 创建sc, 用服务器ip和端口作参数
			System.out.println("已顺利联接到服务器。");
			out = new PrintWriter(sc.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		} catch (Exception e) {
			System.out.println(e);
		}
		start();
	}

	public void run() { // 用于监听服务器端发送来的信息
		String msg = "";
		while (true) {
			try {
				msg = in.readLine();// 从缓冲区读入一行字符存于msg
			} catch (SocketException ex) {
				System.out.println(ex);
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			if (msg != null && msg.trim() != "") {// 若msg信息不为空
				System.out.println(">>" + msg);
				ui.mainArea.append(msg + "\n");// 把msg信息添加到客户端的文本区域内
			}
		}
	}

	public void sendMsg(String msg) {// 用于发送信息
		try {
			out.println("【客户端】" + msg);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

