package math.MathBrain;

public class Fibonacci
{
	public int compute(int n)
	{
		if(1==n||2==n)
		{
			return 1;
		}
		else{
			return compute(n-1)+compute(n-2);
		}
	}
	public static void main(String[] args)
	{
		System.out.println(new Fibonacci().compute(6));
	}
}
