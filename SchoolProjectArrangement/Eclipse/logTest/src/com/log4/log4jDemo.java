package com.log4;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;



public class log4jDemo
{
	public static void main(String[] args)
	{
		Logger logger=Logger.getLogger(Test.class);
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = null;
		
		try{
			appender = new FileAppender(layout,"G:/out.txt",false);
		}catch(Exception e){
		}
		logger.addAppender(appender);
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}
}
