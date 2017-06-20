package com.conversation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("服务器启动，等待客户端连接");
        int i=0;//连接计数
		try {
			// 1) 服务器创建ServerSocket,打开6688端口监听连接请求
			ServerSocket ss = new ServerSocket(6688);
			while (true) {
				// 3）服务器接受客户端的请求，获得本方的Socket
				Socket sc = ss.accept();
				//4)服务器向客户端发送信息
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
						sc.getOutputStream()));
				out.write("服务器说：你好，欢迎访问服务器！");
				// PrintStream out=new PrintStream(sc.getOutputStream());
				// out.println("服务器说：你好客户端"+i+"，欢迎访问服务器！");
				i++;
               if(i>=3){
            	   break;
               }
               //6)关闭socket
               out.close();
               sc.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
