package com.javaIOoperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesPathTest1
{
	public static void main(String[] args)
	{
		//��API��д������ʹ�ö���ַ���������ɣ��磺BBB/test1.txt
		Path pathFrom=Paths.get("G:","1.txt");
		//����BBB/test2.txt�ļ����Բ����ڣ�������ڻᱻ�滻��
		Path pathto=pathFrom.getParent().resolve("G:/ͼ/2.txt");
		try
		{
			//�ļ��Ĵ�Сbytes
			System.out.println("�ļ���С"+Files.size(pathFrom));
			//�����ļ��ƶ�����
			Files.move(pathFrom,pathto,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("�ɹ��ƶ��ļ�"+pathFrom+"��"+pathto);
		} catch (IOException e)
		{
			System.out.println("�ƶ��ļ�����"+e.getMessage());
		}
		
	}
}
