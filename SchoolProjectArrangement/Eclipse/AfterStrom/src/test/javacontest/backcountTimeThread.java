package test.javacontest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class backcountTimeThread extends Thread
{
	@Override
	public void run()
	{
			for(int i=3;i>=0;i--)
			{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
					System.out.println(i);
			}
	}
	
}
