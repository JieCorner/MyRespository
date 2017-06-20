package com.test.factory;

public class Customer extends Thread
{
	private Box box;
	Object o = new Object();

	public Customer(Box box)
	{
		super();
		this.box = box;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int j = 1; j < 10; j++)
		{
			box.consumeGoods(j);
		}
	}

}
