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

public class ������ {
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}}; //������ ���� �Ʒ� ��
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

			//�ʱ�ʼ���
			map[Size / 2 - 1][Size / 2 - 1] = 'W';
            map[Size / 2 - 1][Size / 2] = 'B';
            map[Size / 2][Size / 2 - 1] = 'B';
            map[Size / 2][Size / 2] = 'W';

            //list�� ���� �� ���� ��ġ�� ����ص�.
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

			//list�� �����ŭ. �� term��ŭ.
			for(int i = 0; i<term; ++i)
			{
				int y = list.get(i).y;
				int x = list.get(i).x;
				map[y][x] = list.get(i).bw; //�ѹ� �δ°���.
				//8������ Ž���Ұ���.
				for(int d=0; d<8; ++d)
				{
					int cnt = 1;
					boolean flag = false; //�̰� true�� �Ǹ� ���̿� �ִµ��� ��� �ٲ۴�.
					//�ٵ� �ִ� ���̸�ŭ Ž���Ұ���
					out : for(int l = 1; l<=Size; ++l)
					{
						int nexty = y + dir[d][0]*l;
						int nextx = x + dir[d][1]*l;
						//������ ����ų� ���� ���� ���� ���� ���� ���� ������ Ȯ���Ϸ� �����.
						if(!inside(nexty, nextx, Size) || map[nexty][nextx] == '0')
						{
							break out;
						}
						++cnt;
						//���������� �� ���ٰ� ó������ �ڽ��� ���� �߰��Ѱ�. ��ġ ����ϰ� �ٷ� Ż������.
						if(map[nexty][nextx] == map[y][x])
						{
							flag = true;
							break out;
						}
					}
					//flag�� true�϶��� �۵��Ѵ�. ���⼭�� changey, changex���� ���� �ٲ������.
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