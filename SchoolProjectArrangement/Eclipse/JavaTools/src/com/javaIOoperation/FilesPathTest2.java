package com.javaIOoperation;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class FilesPathTest2
{
	public static void main(String[] args)
	{
		Path path=Paths.get("G:/Ѹ������");
		//���Ŀ¼�ķ���Ȩ��
		System.out.println(Files.isDirectory(path,LinkOption.NOFOLLOW_LINKS));
		//��ӡĿ¼�µ�����
		try
		{
			//����ļ��Ļ�������
			BasicFileAttributes attribute=Files.readAttributes(path,BasicFileAttributes.class);
			//�ж��Ƿ���Ŀ¼
			System.out.println(attribute.isDirectory());
			System.out.println(new Date(attribute.lastModifiedTime().toMillis()).toLocaleString());
			//�����ļ���������ļ�
			DirectoryStream<Path> paths=Files.newDirectoryStream(path);
			for(Path p:paths)
			{
				System.out.println(p.getFileName());
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
