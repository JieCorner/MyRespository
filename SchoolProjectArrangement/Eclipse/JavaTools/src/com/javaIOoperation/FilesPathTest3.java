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
		Path path=Paths.get("G:/迅雷 下载");
		try
		{
			//创建文件夹
			if(Files.notExists(path))
			{
				Files.createDirectories(path);
				System.out.println("create dir");
			}else
			{
				System.out.println("dir exists");
			}
			//在创建的文件夹下建几个txt文件
			//遍历文件夹下面的文件
			DirectoryStream<Path> paths=Files.newDirectoryStream(path);
			for(Path p:paths)
			{
				System.out.println(p.getFileName());
			}
			System.out.println();
			//创建一个带有过滤器，过滤文件名以java，txt，bat结尾的文件
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
