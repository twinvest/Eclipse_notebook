package day0202;

import java.util.Scanner;

public class NQueen {
	static int size, ans;
	static int[] cols;
	public static boolean isPossible(int row)
	{
		for(int j=0; j<row; ++j)
		{
			//첫번째 조건 : cols[row]와 cols[j]가 같다는 것은 같은열에 퀸이 존재한다는거임.
			//두번째 조건 : 퀸이 대각선에 존재한다는거임.
			if(cols[row] == cols[j] || Math.abs(row-j) == Math.abs(cols[row]-cols[j]))
			{
				return false;
			}
		}
		//위의 경우를 제외하면 놓을 수 있음.
		return true;
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
				cols[row] = j;
				//만약에 row행의 j열에 퀸을 놓을 수 있으면
				if(isPossible(row))
				{
					back_tracking(row+1); //집어넣고 다음행을 검사하러 가보자.
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
			// i행에 들어갈 퀸의 좌표. 즉, index(0,1,2, ...)는 행을 의미하고 배열에 들어가는 값은 퀸의 j열 위치를 의미함.
			cols = new int[size];
			back_tracking(0);
			System.out.println("#"+t+" "+ans);
		}
	}
}
