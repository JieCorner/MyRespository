package test.javacontest;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WritefileThread extends Thread
{
	Thread test2;
	public WritefileThread(Thread test2)
	{
		this.test2=test2;
	}
	@Override
	public void run()
	{
		try
		{
			FileOutputStream fos=new FileOutputStream("D:/contest.txt");        //创建文件流（字节流）
			OutputStreamWriter osw=new OutputStreamWriter(fos);                  //字符流
			BufferedWriter bo=new BufferedWriter(osw);
//			FileOutputStream fos1=new FileOutputStream("D:/contest.txt");        //创建文件流（字节流）
//			OutputStreamWriter osw1=new OutputStreamWriter(fos);                  //字符流
//			BufferedWriter bo1=new BufferedWriter(osw);
			String s=null;
//			String s1=null;
			for(int e=0;e<=100;e++)
			{
				s+="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//				s1+="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			}
			test2.start();
			while(test2.isAlive())
			{
				try
				{
					bo.write(s);
					bo.flush();
					
//					bo1.write(s1);
					
//					bo1.flush();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try
			{
				bo.close();
//				bo1.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		WritefileThread t=new WritefileThread(new backcountTimeThread());
		t.start();
	}
}
