package math.MathBrain;

public class FindDaffodilNumber
{
	//算出i的三次方
	public int threeup(int i)
	{
		return i*i*i;
	}
	public static void main(String[] args)
	{
		FindDaffodilNumber f=new FindDaffodilNumber();
		for(int i=100;i<=999;i++)
		{
			if(i==(f.threeup(i/100)+f.threeup(i/10-i/100*10)+f.threeup(i-i/10*10)))
			{
				System.out.println("数字"+i+"是水仙花数");
			}
		}
//		int i=465;
//		System.out.println(i/100);
//		System.out.println(i/10-i/100*10);
//		System.out.println(i-i/10*10);
	}
}
