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
		System.out.println(b.show(b));   //a2是A类型，可以（只能）调用子类重写A的方法
		//B and A：a2.show(b)，a2.show(a2),b.show(a2)
		//B and B: b.show(b)
		
	}
}
class A{
	public String show(A obj)        //函数重载
	{
		return "A and A";
	}
	public String show(D obj)        //函数重载
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
	public String show(A obj)    //重写上面A的show（A）方法
	{
		return "B and A";
	}
}