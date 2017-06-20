package com.log4;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

public class log4jDemo2
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(log4jDemo2.class.getName());//获取日志记录器，这个记录器将负责控制日志信息
		  try {
			  logger.debug("非法操作");//使用Logger对象的debug、info方法输出日志信息
			 
		  } 
		  catch (IllegalArgumentException ex)
		  {
			  logger.info(ex.getMessage());//使用Logger对象的debug、info方法输出日志信息
		   }
	}
}
