package math.MathBrain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StChar
{
	// ����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
	public static void main(String[] args)
	{
		Set set = new HashSet();
		List list = new ArrayList();
		System.out.println("�������ַ�����");
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		char[] c1 = str.toCharArray();
		int i0 = 0, i1 = 0, i2 = 0, i3 = 0;
		for (int i = 0; i < c1.length; i++)
		{
			if (c1[i] >= 'A' && c1[i] <= 'z')
			{
				i0++;
			} else if (c1[i] == ' ')
			{
				i1++;
			} else if (c1[i] >= '0' && c1[i] < '9')
			{
				i2++;
			} else
			{
				i3++;
			}
		}

		System.out.println("�ַ�����Ӣ����ĸ�У�" + i0 + "��");
		System.out.println("�ַ����пո��У�" + i1 + "��");
		System.out.println("�ַ����������У�" + i2 + "��");
		System.out.println("�ַ����������ַ��У�" + i3 + "��");

	}
}
