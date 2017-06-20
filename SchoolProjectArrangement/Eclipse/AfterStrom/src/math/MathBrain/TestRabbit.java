package math.MathBrain;

import java.util.Scanner;

public class TestRabbit
{
	// 古典问题：有一对兔子，从出生后第3个月起
	// 每个月都生一对兔子，小兔子长到第三个月后每
	// 个月又生一对兔子，假如兔子都不死，问每个月
	// 的兔子总数为多少？
	public static void main(String[] args)
	{
		System.out.println("请输入月数：");
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		int n = Integer.valueOf(str);
		System.out.print("兔子对数为");
		int b = 1;
		int y = 1;
		int s = 1;

		if (n == 1 || n == 2)
		{
			System.out.println(1);
		} else
		{
			for (int i = 0; i < n-2; i++)
			{
				s = b + y;
				b = y;
				y = s;
			}
			System.out.println(s);
		}
	}
}
