package math.MathBrain;

import java.util.ArrayList;
import java.util.Scanner;

public class ConvertMath
{
	public static void main(String[] args)
	{
		Scanner c = new Scanner(System.in);
		System.out.print("������ʮ�������֣�");
		String str = c.next();
		int num = Integer.valueOf(str);
		System.out.print("������ת���Ľ��ƣ�");
		str=c.next();
		int d= Integer.valueOf(str);
		int r=0;
		ArrayList arraylist=new ArrayList();
		char ch[]="0123456789ABCDEF".toCharArray(); 
		System.out.print("��"+num+"ת��Ϊ"+d+"���ƽ��Ϊ��");
		while(num!=0){
			r=num%d;       //ȡ����r
			arraylist.add(ch[r]);  //������ջ
			num=num/d;   //�����̽�����һ������
		}
		for(int j=arraylist.size()-1;j>=0;j--)
		{
			System.out.print(arraylist.get(j));
		}
	}
}
