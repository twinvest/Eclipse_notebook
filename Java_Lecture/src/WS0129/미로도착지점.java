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

public class �̷ε������� {
	static int[][] dir = { 
			{ 0, 0 }, 
			{ -1, 0 }, // ��
			{ 0, 1 }, // ������
			{ 1, 0 }, // �Ʒ�
			{ 0, -1 }, // ����
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
			int N=scan.nextInt(); //�迭ũ��
			int[][] arr = new int[N][N];
			int y = scan.nextInt(); //y��ǥ
			int x = scan.nextInt(); //x��ǥ
			--y; --x;
			int numOfjumper = scan.nextInt(); //������ ����
			
			//���� ��ġ �ޱ�
			for(int k=0; k<numOfjumper; ++k)
			{
				int i = scan.nextInt();
				int j = scan.nextInt();
				--i; --j;
				arr[i][j] = -1;
			}
			
			//�̵����� ����
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