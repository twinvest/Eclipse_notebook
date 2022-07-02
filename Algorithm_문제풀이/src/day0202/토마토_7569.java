package day0202;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	int z;
	int y;
	int x;
	Pos(int z, int y, int x)
	{
		this.z = z;
		this.y = y;
		this.x = x;
	}
}

public class 토마토_7569 {
	static boolean inside(int y1, int x1, int z1)
	{
		return (y1 < Y && y1 >= 0) && (x1 < X && x1 >= 0) && (z1 < Z && z1 >= 0);
	}
	static int day = 1;
	static int check = 0;
	static int X, Y, Z;
	static int[][][] arr= new int[100][100][100];
	static int[][] dir = { {0,1,0},{0,-1,0},{1,0,0},{-1,0,0},{0,0,1},{0,0,-1} };
	static Queue<Pos> q;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		q = new LinkedList<>();
		X =scan.nextInt();
		Y =scan.nextInt();
		Z =scan.nextInt();

		for (int k = Z - 1; k >= 0; --k)
		{
			for (int i = 0; i < Y; i++) //�Է�
			{
				for (int j = 0; j < X; j++)
				{
					arr[k][i][j] = scan.nextInt();
					if (arr[k][i][j] == 1)
					{
						q.offer(new Pos(k,i,j));
					}
				}
			}
		}

		do
		{
			check = 0;
			bfs(day);
			day++;
		} while (check != 0 ? true : false);

		for (int z = 0; z < Z; z++)
			for (int y = 0; y < Y; y++)
				for (int x = 0; x < X; x++)
					if (arr[z][y][x] == 0)
						day = 1;

		System.out.println(day-2);
	}

	static void bfs(int day)
	{
		int size = q.size();
		for (int i = 0; i < size; i++)
		{
			int y1, x1, z1;
			y1 = q.peek().y;
			x1 = q.peek().x;
			z1 = q.peek().z;
			q.poll();

			for (int d = 0; d < 6; ++d)
			{
				int ny, nx, nz;
				nz = z1 + dir[d][2];
				ny = y1 + dir[d][0];
				nx = x1 + dir[d][1];

				//�������̸鼭 �湮�Ұ��� 0�̸�
				if (inside(ny, nx, nz) && arr[nz][ny][nx] == 0)
				{
					arr[nz][ny][nx] = day + 1;//�湮
					q.offer(new Pos(nz,ny,nx));
					check++;
				}
			}
		}
	}
}