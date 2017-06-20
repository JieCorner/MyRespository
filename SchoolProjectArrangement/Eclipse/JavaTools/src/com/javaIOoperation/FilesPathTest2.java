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
		Path path=Paths.get("G:/迅雷下载");
		//输出目录的访问权限
		System.out.println(Files.isDirectory(path,LinkOption.NOFOLLOW_LINKS));
		//打印目录下的属性
		try
		{
			//获得文件的基础属性
			BasicFileAttributes attribute=Files.readAttributes(path,BasicFileAttributes.class);
			//判断是否是目录
			System.out.println(attribute.isDirectory());
			System.out.println(new Date(attribute.lastModifiedTime().toMillis()).toLocaleString());
			//遍历文件夹下面的文件
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
