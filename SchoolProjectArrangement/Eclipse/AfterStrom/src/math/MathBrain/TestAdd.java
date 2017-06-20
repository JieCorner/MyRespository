package math.MathBrain;

import java.util.Scanner;

public class TestAdd
{
//	求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字
//	例如2+22+222+2222+22222(此时共有5个数相加)，
//	几个数相加有键盘控制。
	public int zero(int i)
	{
		int r = 1;
		int s = 0;
		if (i == 1)
		{
			return 2;
		} else
		{
			for (int j = 1; j < i; j++)
			{
				r *= 10;
			}
			s += 2 * r + zero(i - 1);
			return s;
		}

	}
	public int add(int n)
	{
		int s=0;
		for (int i = 1; i <= n; i++)
		{
			s+=zero(i);
		}
		return s;
	}
	public static void main(String[] args)
	{
		System.out.println("请输入个数：");
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		int n = Integer.valueOf(str);
		System.out.print("最终值为");
		System.out.println(new TestAdd().add(n));
	}
}
