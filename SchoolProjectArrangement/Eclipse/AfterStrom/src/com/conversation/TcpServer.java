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
		System.out.println("�������������ȴ��ͻ�������");
        int i=0;//���Ӽ���
		try {
			// 1) ����������ServerSocket,��6688�˿ڼ�����������
			ServerSocket ss = new ServerSocket(6688);
			while (true) {
				// 3�����������ܿͻ��˵����󣬻�ñ�����Socket
				Socket sc = ss.accept();
				//4)��������ͻ��˷�����Ϣ
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
						sc.getOutputStream()));
				out.write("������˵����ã���ӭ���ʷ�������");
				// PrintStream out=new PrintStream(sc.getOutputStream());
				// out.println("������˵����ÿͻ���"+i+"����ӭ���ʷ�������");
				i++;
               if(i>=3){
            	   break;
               }
               //6)�ر�socket
               out.close();
               sc.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
