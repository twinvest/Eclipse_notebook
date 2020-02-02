package day0202;

import java.util.Scanner;

public class NQueent_2차원배열로 {
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
			//2차원 배열로 퀸이 놓여있는 곳은 true로 체크한다.
			arr = new boolean[size][size];
			back_tracking(0);
			System.out.println("#"+t+" "+ans);
		}
	}
	
	public static void back_tracking(int row)
	{
		//row와 size가 같은 상태. 즉, 끝까지 온거임.
		if(row == size) ++ans;
		else 
		{
			//이제 퀸을 놀건데 현재 row행에서 j열에 놓을 수 있는지 전부 검사할거야
			for(int j =0; j<size; ++j)
			{
				//row행의 j열에 퀸을 넣어봐
				arr[row][j] = true;
				//만약에 row행의 j열에 퀸을 놓을 수 있으면
				if(isPossible(row, j))
					back_tracking(row+1); //집어넣고 다음행을 검사하러 가보자.
				arr[row][j] = false; //다시 false로
			}
		}
	}
	
	public static boolean isPossible(int i, int j)
	{
		//수업시간때 배운 8방탐색
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
		//위의 경우를 제외하면 놓을 수 있음.
		return true;
	}
}
