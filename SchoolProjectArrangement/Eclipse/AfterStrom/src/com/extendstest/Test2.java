package com.extendstest;

public class Test2
{
	public static void main(String[] args)
	{
		A a1=new A();
		A a2=new B();
		B b=new B();
		C c=new C();
		D d=new D();
		System.out.println(b.show(b));   //a2��A���ͣ����ԣ�ֻ�ܣ�����������дA�ķ���
		//B and A��a2.show(b)��a2.show(a2),b.show(a2)
		//B and B: b.show(b)
		
	}
}
class A{
	public String show(A obj)        //��������
	{
		return "A and A";
	}
	public String show(D obj)        //��������
	{
		return "A and D";
	}
}
class B extends A
{
	public String show(B obj)
	{
		return "B and B";
	}
	public String show(A obj)    //��д����A��show��A������
	{
		return "B and A";
	}
}