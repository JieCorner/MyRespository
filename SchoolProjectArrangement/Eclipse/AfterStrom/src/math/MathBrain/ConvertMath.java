package math.MathBrain;

import java.util.ArrayList;
import java.util.Scanner;

public class ConvertMath
{
	public static void main(String[] args)
	{
		Scanner c = new Scanner(System.in);
		System.out.print("请输入十进制数字：");
		String str = c.next();
		int num = Integer.valueOf(str);
		System.out.print("请输入转化的进制：");
		str=c.next();
		int d= Integer.valueOf(str);
		int r=0;
		ArrayList arraylist=new ArrayList();
		char ch[]="0123456789ABCDEF".toCharArray(); 
		System.out.print("将"+num+"转化为"+d+"进制结果为：");
		while(num!=0){
			r=num%d;       //取余数r
			arraylist.add(ch[r]);  //余数入栈
			num=num/d;   //利用商进行下一次运算
		}
		for(int j=arraylist.size()-1;j>=0;j--)
		{
			System.out.print(arraylist.get(j));
		}
	}
}
