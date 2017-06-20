package com.test.factory;

public class Producer extends Thread
{
	private Box box;
	Object o = new Object();

	public Producer(Box box)
	{
		this.box = box;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int j = 1; j < 10; j++)
		{
			box.addGoods(j);
		}
	}

}
