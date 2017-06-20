package math.MathBrain;

public class FindPrimeNumber
{
	//计算一个数的开平方
	public int sqrt(int i)
	{
		int j = 1;
		for (; j <= (i / 2); j++)
		{
			if (j * j == i)
			{
				return j;
			}
		}
		return sqrt(i + 1);
	}

	// 判断101-200之间有多少个素数，并输出所有素数
	public static void main(String[] args)
	{
		int number=0;
		FindPrimeNumber f = new FindPrimeNumber();
		for (int i = 101; i <= 200; i++)
		{
			for (int j = 2; j <=f.sqrt(i); j++)
			{
				if ((j==f.sqrt(i))&&(i % j != 0))
				{
					System.out.println(i);
					number++;
				}
				if(i%j==0)
				{
					break;
				}
			}
		}
		System.out.println("个数为："+number);
	}
}
