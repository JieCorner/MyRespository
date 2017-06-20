package math.MathBrain;

import java.util.Scanner;

public class ConditionOperator
{
	public static void main(String[] args)
	{
		System.out.print("请输入分数：");
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		int n = Integer.valueOf(str);
		System.out.print("成绩为：");
		System.out.println((n>=90)?"A":(n>=60)?"B":"C");
	}
}
