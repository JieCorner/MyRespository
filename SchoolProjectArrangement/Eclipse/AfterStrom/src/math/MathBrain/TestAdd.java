package math.MathBrain;

import java.util.Scanner;

public class TestAdd
{
//	��s=a+aa+aaa+aaaa+aa...a��ֵ������a��һ������
//	����2+22+222+2222+22222(��ʱ����5�������)��
//	����������м��̿��ơ�
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
		System.out.println("�����������");
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		int n = Integer.valueOf(str);
		System.out.print("����ֵΪ");
		System.out.println(new TestAdd().add(n));
	}
}
