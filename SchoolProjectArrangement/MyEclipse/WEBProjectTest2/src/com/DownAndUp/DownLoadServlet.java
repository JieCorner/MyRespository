package com.DownAndUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// req.setCharacterEncoding("utf-8");
		// resp.setCharacterEncoding("utf-8");
		// resp.setContentType("text/html;charset=utf-8");
		// resp.setContentType("text/html;charset=UTF-8");
		// resp.setContentType("text/plain");
		// 进行编码的转换，因为不能识别中文
		response.setHeader("content-type", "text/html;charset=UTF-8");
		String path = getServletContext().getRealPath("/") ;//当前webroot的目录
		String fileName = request.getParameter("filename");
		String filename = null;
		filename = new String(fileName.getBytes("8859_1"), "utf-8");
		// filename = new String(filename.getBytes("8859_1"),"uft-8");
		System.out.println("路径：" + path + "文件名：" + filename);
		File file = new File(path + filename);
		if (file.exists()) {
			// 由于下载的时候与浏览器的编码不符，浏览器不能识别中文编码，这里要进行转换
			String value = new String(filename.getBytes("utf-8"), "ISO-8859-1");
			
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=\""
					+ value + "\"");
			
			InputStream inputStream = new FileInputStream(file);
			ServletOutputStream outputStream = response.getOutputStream();
			byte b[] = new byte[1024];
			int n;
			while ((n = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, n);
			}
			outputStream.close();
			inputStream.close();
		} else {
//			request.setAttribute("errorResult", "文件不存在下载失败！！");
//			response.sendRedirect("luntan.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
