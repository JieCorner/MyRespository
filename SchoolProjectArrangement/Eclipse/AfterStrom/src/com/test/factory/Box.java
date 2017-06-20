package com.test.factory;

public class Box
{
	private int goods;

	public int getGoods()
	{
		return goods;
	}

	public synchronized void addGoods(int i)
	{
			if (this.goods > 0)
			{
				try
				{
					wait();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
			{
				goods++;
				System.out.println("������Ʒ��" + i);
				notifyAll();
			}
	}

	public synchronized void consumeGoods(int i)
	{
			if (this.goods <= 0)
			{
				try
				{
					wait();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
			{
				goods--;
				System.out.println("������Ʒ��" + i);
				notifyAll();

			}
	}

}
