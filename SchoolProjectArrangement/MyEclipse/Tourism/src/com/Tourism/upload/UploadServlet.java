package com.Tourism.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("USERNAME");
		GetFileWriteInServlet(request,username);
		response.sendRedirect("UploadPicture/modify.jsp");
	}
	public void GetFileWriteInServlet(HttpServletRequest request,String username) throws ServletException, IOException{
		InputStream fileSource = request.getInputStream();
//		D:\\apache-tomcat-7.0.59\\webapps\\Tourism\\Temporary\\tem.txt
		String tempFileName = "D:\\apache-tomcat-7.0.59\\webapps\\Tourism\\Temporary\\tem.txt";
		File tempFile = new File(tempFileName);
		FileOutputStream outputStream = new FileOutputStream(tempFile);
		byte b[] = new byte[1024];
		int n;
		while ((n = fileSource.read(b)) != -1) {
			outputStream.write(b, 0, n);
		}
		outputStream.close();
		fileSource.close();
		RandomAccessFile randomFile = new RandomAccessFile(tempFile, "r");
		String str2 = randomFile.readLine();
		str2 = new String(str2.getBytes("8859_1"), "utf-8");
		String str = randomFile.readLine();
		str = new String(str.getBytes("8859_1"), "utf-8");
		int beginIndex = str.lastIndexOf("=") + 2;
		int endIndex = str.lastIndexOf("\"");
		String filename1 = str.substring(beginIndex, endIndex);
		String filename =username+".jpg"; // 自己指定的名字
		randomFile.seek(0);
		long startPosition = 0;
		int i = 1;
		while ((n = randomFile.readByte()) != -1 && i <= 4) {
			if (n == '\n') {
				startPosition = randomFile.getFilePointer();
				i++;
			}
		}
		startPosition = randomFile.getFilePointer() - 1;
		randomFile.seek(randomFile.length());
		long endPosition = randomFile.getFilePointer();
		int j = 1;
		while (endPosition >= 0 && j <= 2) {
			endPosition--;
			randomFile.seek(endPosition);
			if (randomFile.readByte() == '\n') {
				j++;
			}
		}
		endPosition = endPosition - 1;
//		D:\\apache-tomcat-7.0.59\\webapps\\Tourism\\UserUploadPhoto
		String realPath = "D:\\apache-tomcat-7.0.59\\webapps\\Tourism\\UserUploadPhoto";
		File fileupload = new File(realPath);
		if (!fileupload.exists()) {
			fileupload.mkdir();
		}
		File saveFile = new File(realPath, filename);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
		randomFile.seek(startPosition);
		while (startPosition < endPosition) {
			randomAccessFile.write(randomFile.readByte());
			startPosition = randomFile.getFilePointer();
		}
		
		randomAccessFile.close();
		randomFile.close();
		tempFile.delete();
	}
}
