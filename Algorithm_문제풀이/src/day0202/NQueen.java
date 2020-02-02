package day0202;

import java.util.Scanner;

public class NQueen {
	static int size, ans;
	static int[] cols;
	public static boolean isPossible(int row)
	{
		for(int j=0; j<row; ++j)
		{
			//ù��° ���� : cols[row]�� cols[j]�� ���ٴ� ���� �������� ���� �����Ѵٴ°���.
			//�ι�° ���� : ���� �밢���� �����Ѵٴ°���.
			if(cols[row] == cols[j] || Math.abs(row-j) == Math.abs(cols[row]-cols[j]))
			{
				return false;
			}
		}
		//���� ��츦 �����ϸ� ���� �� ����.
		return true;
	}
	
	public static void back_tracking(int row)
	{
		//row�� size�� ���� ����. ��, ������ �°���.
		if(row == size) ++ans;
		else 
		{
			//���� ���� ��ǵ� ���� row�࿡�� j���� ���� �� �ִ��� ���� �˻��Ұž�
			for(int j =0; j<size; ++j)
			{
				//row���� j���� ���� �־��
				cols[row] = j;
				//���࿡ row���� j���� ���� ���� �� ������
				if(isPossible(row))
				{
					back_tracking(row+1); //����ְ� �������� �˻��Ϸ� ������.
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		for(int t=1; t<=testcase; ++t)
		{
			size = scan.nextInt();
			ans = 0;
			// i�࿡ �� ���� ��ǥ. ��, index(0,1,2, ...)�� ���� �ǹ��ϰ� �迭�� ���� ���� ���� j�� ��ġ�� �ǹ���.
			cols = new int[size];
			back_tracking(0);
			System.out.println("#"+t+" "+ans);
		}
	}
}
