package math.MathBrain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StChar
{
	// 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
	public static void main(String[] args)
	{
		Set set = new HashSet();
		List list = new ArrayList();
		System.out.println("请输入字符串：");
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

		System.out.println("字符串中英文字母有：" + i0 + "个");
		System.out.println("字符串中空格有：" + i1 + "个");
		System.out.println("字符串中数字有：" + i2 + "个");
		System.out.println("字符串中其他字符有：" + i3 + "个");

	}
}
