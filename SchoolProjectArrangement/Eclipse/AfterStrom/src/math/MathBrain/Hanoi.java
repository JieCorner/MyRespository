package math.MathBrain;

public class Hanoi
{
	void HanoiTest(int n,  char X,  char Y,  char Z)
	{// n表示需要移动盘子的数量，X表示源塔，Y表示借用塔，Z表示目标塔
		if(n==1) // 只有一个盘子时，将其从X塔移动到Z塔
			System.out.println(X+"->"+Z);
		else
		{	
			//①借助Z塔,将前n-1个盘子从X塔移动到Y塔
			HanoiTest(n-1, X, Z, Y); 	
			//②将X塔上剩下的1个盘子移到Z塔
			System.out.println(X+"->"+Z);
			//③借助X塔,将前n-1个盘子从Y塔移动到Z塔
			HanoiTest(n-1, Y, X, Z); 	
		}
	}

	public static void main(String[] args)
	{
		char X='X';
		char Y='y';
		char Z='Z';
		new Hanoi().HanoiTest(3,X, Y, Z);
	}
}
