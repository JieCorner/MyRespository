package math.MathBrain;

public class Hanoi
{
	void HanoiTest(int n,  char X,  char Y,  char Z)
	{// n��ʾ��Ҫ�ƶ����ӵ�������X��ʾԴ����Y��ʾ��������Z��ʾĿ����
		if(n==1) // ֻ��һ������ʱ�������X���ƶ���Z��
			System.out.println(X+"->"+Z);
		else
		{	
			//�ٽ���Z��,��ǰn-1�����Ӵ�X���ƶ���Y��
			HanoiTest(n-1, X, Z, Y); 	
			//�ڽ�X����ʣ�µ�1�������Ƶ�Z��
			System.out.println(X+"->"+Z);
			//�۽���X��,��ǰn-1�����Ӵ�Y���ƶ���Z��
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
