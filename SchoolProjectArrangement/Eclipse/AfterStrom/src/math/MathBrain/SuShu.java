package math.MathBrain;

public class SuShu
{
	public static void main(String[] args)
	{
		//300~500
		int n=517;
		int i;
		for(i=2;i<=n-i;i++)
		{
			if(n%i==0)
				break;
		}
		if(i<n){
			System.out.println("��������");
//				return 0;
		}
		else{
			System.out.println("������");
		}
	}
}
