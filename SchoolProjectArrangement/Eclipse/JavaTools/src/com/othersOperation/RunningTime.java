package com.othersOperation;

public class RunningTime
{
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		for(int i=0;i<50;i++)
		{
			System.out.println(i);
		}
		long end=System.currentTimeMillis();
		System.out.print("����ʱ�䣺");
		System.out.println(end-start+"ms");
	}
}
