package WS0129;

import java.util.ArrayList;
import java.util.Scanner;

class Pos {
	int direct;
	int jump;

	Pos(int direct, int jump) {
		this.direct = direct;
		this.jump = jump;
	}
}

public class 미로도착지점 {
	static int[][] dir = { 
			{ 0, 0 }, 
			{ -1, 0 }, // 위
			{ 0, 1 }, // 오른쪽
			{ 1, 0 }, // 아래
			{ 0, -1 }, // 왼쪽
	};

	static boolean inside(int y, int x, int N) {
		return (y >= 0 && y < N) && (x >= 0 && x < N);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		ArrayList<Pos> list = new ArrayList<>();
		for (int t = 1; t <= testcase; ++t) 
		{
			int N=scan.nextInt(); //배열크기
			int[][] arr = new int[N][N];
			int y = scan.nextInt(); //y좌표
			int x = scan.nextInt(); //x좌표
			--y; --x;
			int numOfjumper = scan.nextInt(); //점퍼의 개수
			
			//점퍼 위치 받기
			for(int k=0; k<numOfjumper; ++k)
			{
				int i = scan.nextInt();
				int j = scan.nextInt();
				--i; --j;
				arr[i][j] = -1;
			}
			
			//이동지시 개수
			int numOfdirect = scan.nextInt();
			for(int k =0; k<numOfdirect; ++k)
			{
				int direct = scan.nextInt();
				int jump = scan.nextInt();
				list.add(new Pos(direct, jump));
			}
			
			for(int k=0; k<list.size(); ++k)
			{
				if(y == -1 && x == -1) break;
				
				int direct = list.get(k).direct;
				int jump = list.get(k).jump;
				
				for(int j = 1; j<=jump; ++j)
				{
					y = y + dir[direct][0];
					x = x + dir[direct][1];
					if(!inside(y, x, N) || arr[y][x] == -1)
					{
						y=-1; x=-1;
						break;
					}
				}
			}
			++y; ++x;
			System.out.println("#"+t+" "+y+" "+x);
		}
	}
}