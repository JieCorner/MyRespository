package com.javaIOoperation;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesPathTest3
{
	public static void main(String[] args)
	{
		Path path=Paths.get("G:/Ѹ�� ����");
		try
		{
			//�����ļ���
			if(Files.notExists(path))
			{
				Files.createDirectories(path);
				System.out.println("create dir");
			}else
			{
				System.out.println("dir exists");
			}
			//�ڴ������ļ����½�����txt�ļ�
			//�����ļ���������ļ�
			DirectoryStream<Path> paths=Files.newDirectoryStream(path);
			for(Path p:paths)
			{
				System.out.println(p.getFileName());
			}
			System.out.println();
			//����һ�����й������������ļ�����java��txt��bat��β���ļ�
			DirectoryStream <Path> pathsFilter =Files.newDirectoryStream(path,"*.{java,txt,bat}");
			for(Path p:pathsFilter)
			{
				System.out.println(p.getFileName());
			}
 		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
