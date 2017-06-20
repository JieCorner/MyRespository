package com.javaIOoperation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author jie
 * @action:
 * @time:2015年12月25日
 */
public class FileOperate
{
	//选择文件获得他的路径 （参数可以是"JPG & GIF Images"）
	static public String choosefiledirectory(String filetype)
	{
		JFileChooser jfilechooser=new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		filetype, "jpg", "gif");             //后面的"jpg", "gif"表示值显示这类文件
		jfilechooser.setFileFilter(filter);
		int returnVal=jfilechooser.showOpenDialog(null);	//打开文件对话框	
		if (returnVal==JFileChooser.APPROVE_OPTION)
		{
			return jfilechooser.getSelectedFile().getPath();       //返回路径
		}
		else {
			return null;		
		}
	}
	// 实现复制文件（图片，视频，文件） copyfile会自动生成（只需给出要生成的路径和文件名）
	static public void copyallfile(String sourcefile, String copyfile)
			throws IOException
	{
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(
				sourcefile));
		BufferedOutputStream bo = new BufferedOutputStream(
				new FileOutputStream(copyfile));
		byte[] bff = new byte[1024];
		while (-1 != bi.read(bff))
		{
			bo.write(bff, 0, bff.length);
		}
		bi.close();
		bo.close();
	}
	//

	// 将内容添加到文件内容后面
	static public void writefileatlate(String filename, String addText)
			throws IOException
	{
		OutputStream os = new FileOutputStream(filename, true); // true表示添加到文本内容后面
		byte[] buffer = addText.getBytes();
		os.write(buffer);
		os.close();
	}
	//删除一个文件夹包括里面的全部内容
	static public void deleteFile(File file)
	{
		 if(file.isFile()||file.list().length==0)    //判断是不是具体文件或空文件夹
			 //当路径File最后是具体文件（如：1.txt）（不是文件夹）时，file.isFile()才为真
		 {
			file.delete();
		 }
		 else
		 {
			 File[] file2=file.listFiles();
			 for(File file3:file2)
			 {
				 deleteFile(file3);
				 file3.delete();
			 }
		file.delete();
		 }
	}
	
	// 创建文件
	static public void creatfile(String filename) throws IOException
	{
		File file = new File(filename);
		file.createNewFile();
	}

	// 创建路径（只创建最后一个）
	static public void creatdirectory(String filedirectory) throws IOException
	{
		File file = new File(filedirectory);
		file.mkdir();
	}

	// 删除文件或目录
	static public void deletefile(String filename) throws IOException
	{
		File file = new File(filename);
		file.delete();
	}

	// 获得目录下的全部文件名数组
	static public String[] getallfilename(String filedirectory)
			throws IOException
	{
		File file1 = new File(filedirectory);
		return file1.list();
	}

	// 将内容写入文件
	static public void writeintofile(String filedirectory, String writetext)
			throws IOException
	{
		OutputStream os = new FileOutputStream(filedirectory);
		byte[] buffer = writetext.getBytes();
		os.write(buffer);
		os.close();
	}

	// 将内容从文件读出（输出文件内容）（输出）
	static public void readfromfile(String filedirectory, String writetext)
			throws IOException
	{
		int length;
		InputStream is = new FileInputStream(filedirectory);
		byte[] buffer = new byte[200];
		while (-1 != (length = is.read(buffer, 0, 200))) // 53时循环一次，重新从0开始存，超过53时不用循环，一次性存入buffer
		{
			String str = new String(buffer, 0, length);
			System.out.println(str); // 输出文件中的内容
		}
		is.close();
	}

	// (字符流)将内容写入文件
	static public void Stringwritetofile(String filedirectory, String text)
			throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filedirectory); // 创建文件流（字节流）
		OutputStreamWriter osw = new OutputStreamWriter(fos); // 字符流
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(text);
		bw.close();
	}
	//(字符流)将内容从文件读出(输出)
	static public void Filewritetofile(String filename,String text) throws IOException
	{
		char[] buffer = new char[text.length()];
		text.getChars(0, text.length(), buffer, 0);
		FileWriter f = new FileWriter(filename);     // 直接是字符流
		for (int i = 0; i < buffer.length; i++)
		{
			f.write(buffer[i]);
		}
		f.close();
	}
	
	// (字符流)将内容从文件读出(输出)
	static public void Stringreadfile(String filedirectory) throws IOException
	{
		FileInputStream fis = new FileInputStream(filedirectory); // 字节流
		InputStreamReader isr = new InputStreamReader(fis); // 字符流
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		while (null != str)
		{
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
	}

	// FileReader将内容从文件读出(输出)
	static public void Filereadfile(String filename) throws IOException
	{
		FileReader fr = new FileReader(filename); // 直接是字符流
		BufferedReader br = new BufferedReader(fr);
		String str;
		while (null != (str = br.readLine()))
		{
			System.out.println(str);
		}
		br.close();
	}
	//随机访问文件类（RandomAccessFile）
	static public void RandomFile(String filename,String roworw) throws IOException
	{
		RandomAccessFile raf=new RandomAccessFile(filename,roworw);
		//raf.write();
		
		//raf.seek(0);//回到原始位置
		
		//raf.read();
	}
}
