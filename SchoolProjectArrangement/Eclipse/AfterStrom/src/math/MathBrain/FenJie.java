package math.MathBrain;

import java.util.Scanner;

public class FenJie
{
//	��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int num;
//		try
//		{
//			num=Integer.parseInt(s);
//		} catch (NumberFormatException e)
//		{
//			num=-1;
//		}
//		if(num<1){
//			System.out.print("input number is wrong");
//			return;
//		}
		num=Integer.parseInt(s);
		StringBuffer sb=new StringBuffer();
		sb.append(num+"=");
		while(true)
		{
			if(num<2)break;
			boolean flag=false;
			for(int i=2;i<num;i++)
			{
				if(num%i==0)
				{
					sb.append(i+"*");
					flag=true;
					num=num/i;
					break;
				}
			}
			if(!flag)break;
		}
		sb.append(num);
		System.out.println(sb.toString());
	}
}
