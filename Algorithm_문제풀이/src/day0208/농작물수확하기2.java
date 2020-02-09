package day0208;

import java.util.Scanner;

public class ���۹���Ȯ�ϱ�2 {
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // ������ ���� �Ʒ� ��

	static boolean inside(int y, int x, int Size) {
		return (y >= 0 && y < Size) && (x >= 0 && x < Size);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for (int t = 1; t <= testcase; ++t) {
			int sum = 0;
			int N = scan.nextInt();
			String[] arr = new String[N];
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			for (int i = 0; i < N; ++i)
				arr[i] = scan.next();

			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					map[i][j] = Integer.parseInt(arr[i].charAt(j) + "");

			int y = N / 2;
			int x = N / 2;
			visit[y][x] = true;
			sum += map[y][x];

			// System.out.println(p.y +"," +p.x);
			// 4��Ž��
			for (int d = 0; d < 4; ++d)
			{
				int nexty = y + dir[d][0];
				int nextx = x + dir[d][1];
				while (true)
				{
					if (inside(nexty, nextx, N) && visit[nexty][nextx] == false)
					{
						sum += map[nexty][nextx];
						visit[nexty][nextx] = true;
						if (nexty == 0 || nexty == N - 1 || nextx == 0 || nextx == N - 1)
						{

						}

					}

				}
			}

			System.out.println("#" + t + " " + sum);
		}
	}
}
