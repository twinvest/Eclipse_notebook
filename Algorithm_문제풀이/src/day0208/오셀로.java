package day0208;

import java.util.ArrayList;
import java.util.Scanner;
class Position
{
	int y;
	int x;
	char bw;
	Position(int y,int x, char bw)
	{
		this.y = y;
		this.x = x;
		this.bw = bw;
	}
}

public class 오셀로 {
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}}; //오른쪽 왼쪽 아래 위
	static boolean inside(int y, int x, int Size)
	{
		return (y>=0 && y<Size) && (x>=0 && x<Size);
	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			ArrayList<Position> list = new ArrayList<>();
			int Size = scan.nextInt();
			char[][] map = new char[Size][Size];
			for(int i=0; i<Size; ++i)
				for(int j=0; j<Size; ++j)
					map[i][j] = '0';

			//초기맵세팅
			map[Size / 2 - 1][Size / 2 - 1] = 'W';
            map[Size / 2 - 1][Size / 2] = 'B';
            map[Size / 2][Size / 2 - 1] = 'B';
            map[Size / 2][Size / 2] = 'W';

            //list에 돌을 둘 곳의 위치를 기억해둠.
            int term = scan.nextInt();
            for(int i=0; i<term; ++i)
			{
				int x = scan.nextInt();
				int y = scan.nextInt();
				int bw = scan.nextInt();
				char bw2;
				--y; --x;
				if(bw == 1) bw2 = 'B';
				else bw2 ='W';
				list.add(new Position(y,x,bw2));
			}

			//list의 사이즈만큼. 즉 term만큼.
			for(int i = 0; i<term; ++i)
			{
				int y = list.get(i).y;
				int x = list.get(i).x;
				map[y][x] = list.get(i).bw; //한번 두는거임.
				//8방으로 탐색할거임.
				for(int d=0; d<8; ++d)
				{
					int cnt = 1;
					boolean flag = false; //이게 true가 되면 사이에 있는돌을 모두 바꾼다.
					//근데 최대 길이만큼 탐색할거임
					out : for(int l = 1; l<=Size; ++l)
					{
						int nexty = y + dir[d][0]*l;
						int nextx = x + dir[d][1]*l;
						//범위를 벗어나거나 아직 돌이 없는 곳을 보면 다음 방향을 확인하러 가즈아.
						if(!inside(nexty, nextx, Size) || map[nexty][nextx] == '0')
						{
							break out;
						}
						++cnt;
						//일직선으로 쭉 가다가 처음으로 자신의 돌을 발견한곳. 위치 기억하고 바로 탈출하자.
						if(map[nexty][nextx] == map[y][x])
						{
							flag = true;
							break out;
						}
					}
					//flag가 true일때만 작동한다. 여기서는 changey, changex까지 전부 바꿔버린다.
					if(flag)
					{
						for(int k=0; k<cnt; ++k)
						{
							int nexty = y + dir[d][0]*k;
							int nextx = x + dir[d][1]*k;
							if(!inside(nexty, nextx, Size))
									continue;
							map[nexty][nextx] = map[y][x];
						}
						flag = false;
					}
				}
			}
			int wcount=0;
			int bcount=0;
			for(int i=0; i<Size; ++i)
			{
				for(int j=0; j<Size; ++j)
				{
					if(map[i][j] =='W')
						++wcount;
					else if(map[i][j] =='B')
						++bcount;
				}
			}
			System.out.println("#"+t+" "+bcount+" "+wcount);
		}
	}
}