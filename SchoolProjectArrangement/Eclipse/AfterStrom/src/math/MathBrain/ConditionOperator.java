package math.MathBrain;

import java.util.Scanner;

public class ConditionOperator
{
	public static void main(String[] args)
	{
		System.out.print("�����������");
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		int n = Integer.valueOf(str);
		System.out.print("�ɼ�Ϊ��");
		System.out.println((n>=90)?"A":(n>=60)?"B":"C");
	}
}
