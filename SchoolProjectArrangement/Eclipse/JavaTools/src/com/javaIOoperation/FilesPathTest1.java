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
		//新API的写法允许使用多个字符串参数组成，如：BBB/test1.txt
		Path pathFrom=Paths.get("G:","1.txt");
		//其中BBB/test2.txt文件可以不存在，如果存在会被替换掉
		Path pathto=pathFrom.getParent().resolve("G:/图/2.txt");
		try
		{
			//文件的大小bytes
			System.out.println("文件大小"+Files.size(pathFrom));
			//调用文件移动方法
			Files.move(pathFrom,pathto,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("成功移动文件"+pathFrom+"到"+pathto);
		} catch (IOException e)
		{
			System.out.println("移动文件错误"+e.getMessage());
		}
		
	}
}
