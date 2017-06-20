package com.test.factory;

public class Test
{
	public static void main(String[] args)
	{
		Box box = new Box();
		Customer c = new Customer(box);
		Producer p = new Producer(box);
		c.start();
		p.start();
	}

}
