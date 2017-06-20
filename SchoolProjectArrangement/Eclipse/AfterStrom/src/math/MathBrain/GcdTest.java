package math.MathBrain;

public class GcdTest
{
//	输入两个正整数m和n，求其最大公约数和最小公倍数。
	//最大公约数
	public int maxdecrean(int x,int y)
	{
		int max=1;
		if(x>y)
		{
			for(int i=1;i<=y;i++)
			{
				if(x%i==0&&y%i==0)
				{
					if(max<=i)
					{
						max=i;
					}
				}
			}
		}else{
			for(int i=1;i<=x;i++)
			{
				if(x%i==0&&y%i==0)
				{
					if(max<=i)
					{
						max=i;
					}
				}
			}
		}
		return max;
	}
	//最小公倍数
	public int minadd(int x,int y)
	{
		if(x>=y)
		{
			if(x%y==0)
			{
				return x;
			}else{
				for(int i=2;i<y;i++)
				{
					int z=y*i;
					for(int j=1;j<x;j++)
					{
						int v=x*j;
						if(v>z)break;
						if(v==z)return z;
					}
				}
				return x*y;
			}
		}else{
			if(y%x==0)
			{
				return y;
			}else{
				for(int i=2;i<x;i++)
				{
					int z=x*i;
					for(int j=1;j<y;j++)
					{
						int v=y*j;
						if(v>z)break;
						if(v==z)return z;
					}
				}
				return x*y;
			}
		}
	}
	public static void main(String[] args)
	{
		System.out.print("最大公约数：");
		System.out.println(new GcdTest().maxdecrean(45,45));
		System.out.print("最小公倍数：");
		System.out.println(new GcdTest().minadd(45, 45));
	}
}
