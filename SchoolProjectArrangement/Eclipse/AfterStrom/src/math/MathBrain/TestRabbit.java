package math.MathBrain;

import java.util.Scanner;

public class TestRabbit
{
	// �ŵ����⣺��һ�����ӣ��ӳ������3������
	// ÿ���¶���һ�����ӣ�С���ӳ����������º�ÿ
	// ��������һ�����ӣ��������Ӷ���������ÿ����
	// ����������Ϊ���٣�
	public static void main(String[] args)
	{
		System.out.println("������������");
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		int n = Integer.valueOf(str);
		System.out.print("���Ӷ���Ϊ");
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
