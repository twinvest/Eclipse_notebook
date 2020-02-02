package day0202;

import java.util.Scanner;

public class NQueent_2�����迭�� {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
	static boolean inside(int y, int x)
	{
		return (y<size && y>=0) && (x<size && x>=0);
	}
	static int size, ans;
	static boolean[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		for(int t=1; t<=testcase; ++t)
		{
			size = scan.nextInt();
			ans = 0;
			//2���� �迭�� ���� �����ִ� ���� true�� üũ�Ѵ�.
			arr = new boolean[size][size];
			back_tracking(0);
			System.out.println("#"+t+" "+ans);
		}
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
				arr[row][j] = true;
				//���࿡ row���� j���� ���� ���� �� ������
				if(isPossible(row, j))
					back_tracking(row+1); //����ְ� �������� �˻��Ϸ� ������.
				arr[row][j] = false; //�ٽ� false��
			}
		}
	}
	
	public static boolean isPossible(int i, int j)
	{
		//�����ð��� ��� 8��Ž��
		for(int d = 0; d<8; ++d)
		{
			for(int jump =1; jump<10; ++jump)
			{
				int nexty = i + dir[d][0]*jump;
				int nextx = j + dir[d][1]*jump;
				if(!inside(nexty, nextx)) break;
				if(arr[nexty][nextx] == true) return false;						
			}
		}
		//���� ��츦 �����ϸ� ���� �� ����.
		return true;
	}
}
