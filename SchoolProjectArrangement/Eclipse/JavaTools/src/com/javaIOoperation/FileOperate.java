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
 * @time:2015��12��25��
 */
public class FileOperate
{
	//ѡ���ļ��������·�� ������������"JPG & GIF Images"��
	static public String choosefiledirectory(String filetype)
	{
		JFileChooser jfilechooser=new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		filetype, "jpg", "gif");             //�����"jpg", "gif"��ʾֵ��ʾ�����ļ�
		jfilechooser.setFileFilter(filter);
		int returnVal=jfilechooser.showOpenDialog(null);	//���ļ��Ի���	
		if (returnVal==JFileChooser.APPROVE_OPTION)
		{
			return jfilechooser.getSelectedFile().getPath();       //����·��
		}
		else {
			return null;		
		}
	}
	// ʵ�ָ����ļ���ͼƬ����Ƶ���ļ��� copyfile���Զ����ɣ�ֻ�����Ҫ���ɵ�·�����ļ�����
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

	// ��������ӵ��ļ����ݺ���
	static public void writefileatlate(String filename, String addText)
			throws IOException
	{
		OutputStream os = new FileOutputStream(filename, true); // true��ʾ��ӵ��ı����ݺ���
		byte[] buffer = addText.getBytes();
		os.write(buffer);
		os.close();
	}
	//ɾ��һ���ļ��а��������ȫ������
	static public void deleteFile(File file)
	{
		 if(file.isFile()||file.list().length==0)    //�ж��ǲ��Ǿ����ļ�����ļ���
			 //��·��File����Ǿ����ļ����磺1.txt���������ļ��У�ʱ��file.isFile()��Ϊ��
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
	
	// �����ļ�
	static public void creatfile(String filename) throws IOException
	{
		File file = new File(filename);
		file.createNewFile();
	}

	// ����·����ֻ�������һ����
	static public void creatdirectory(String filedirectory) throws IOException
	{
		File file = new File(filedirectory);
		file.mkdir();
	}

	// ɾ���ļ���Ŀ¼
	static public void deletefile(String filename) throws IOException
	{
		File file = new File(filename);
		file.delete();
	}

	// ���Ŀ¼�µ�ȫ���ļ�������
	static public String[] getallfilename(String filedirectory)
			throws IOException
	{
		File file1 = new File(filedirectory);
		return file1.list();
	}

	// ������д���ļ�
	static public void writeintofile(String filedirectory, String writetext)
			throws IOException
	{
		OutputStream os = new FileOutputStream(filedirectory);
		byte[] buffer = writetext.getBytes();
		os.write(buffer);
		os.close();
	}

	// �����ݴ��ļ�����������ļ����ݣ��������
	static public void readfromfile(String filedirectory, String writetext)
			throws IOException
	{
		int length;
		InputStream is = new FileInputStream(filedirectory);
		byte[] buffer = new byte[200];
		while (-1 != (length = is.read(buffer, 0, 200))) // 53ʱѭ��һ�Σ����´�0��ʼ�棬����53ʱ����ѭ����һ���Դ���buffer
		{
			String str = new String(buffer, 0, length);
			System.out.println(str); // ����ļ��е�����
		}
		is.close();
	}

	// (�ַ���)������д���ļ�
	static public void Stringwritetofile(String filedirectory, String text)
			throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filedirectory); // �����ļ������ֽ�����
		OutputStreamWriter osw = new OutputStreamWriter(fos); // �ַ���
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(text);
		bw.close();
	}
	//(�ַ���)�����ݴ��ļ�����(���)
	static public void Filewritetofile(String filename,String text) throws IOException
	{
		char[] buffer = new char[text.length()];
		text.getChars(0, text.length(), buffer, 0);
		FileWriter f = new FileWriter(filename);     // ֱ�����ַ���
		for (int i = 0; i < buffer.length; i++)
		{
			f.write(buffer[i]);
		}
		f.close();
	}
	
	// (�ַ���)�����ݴ��ļ�����(���)
	static public void Stringreadfile(String filedirectory) throws IOException
	{
		FileInputStream fis = new FileInputStream(filedirectory); // �ֽ���
		InputStreamReader isr = new InputStreamReader(fis); // �ַ���
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		while (null != str)
		{
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
	}

	// FileReader�����ݴ��ļ�����(���)
	static public void Filereadfile(String filename) throws IOException
	{
		FileReader fr = new FileReader(filename); // ֱ�����ַ���
		BufferedReader br = new BufferedReader(fr);
		String str;
		while (null != (str = br.readLine()))
		{
			System.out.println(str);
		}
		br.close();
	}
	//��������ļ��ࣨRandomAccessFile��
	static public void RandomFile(String filename,String roworw) throws IOException
	{
		RandomAccessFile raf=new RandomAccessFile(filename,roworw);
		//raf.write();
		
		//raf.seek(0);//�ص�ԭʼλ��
		
		//raf.read();
	}
}
