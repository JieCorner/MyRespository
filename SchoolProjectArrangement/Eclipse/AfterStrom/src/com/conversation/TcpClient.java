package com.conversation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
         try {
        	 //2) �ͻ��˴���Socket����������������������
			Socket sc=new Socket("127.0.0.1", 6688);
			//5)�ͻ��˽��շ������˷��͹�������Ϣ
			BufferedReader in=new BufferedReader((new InputStreamReader(sc.getInputStream())));
			String str=in.readLine();
			if(str!=null){
				System.out.println(str);
			}		
		    //6)�ر�socket
			in.close();
            sc.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
