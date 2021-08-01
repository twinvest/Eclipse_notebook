package day0801;

import java.util.Scanner;

/*
 * 해당 문제의 시간복잡도는 N^3처럼 보이나
 * N^2 + NM에 풀 수 있다.
 * N ^ 3 이면 640억 정도로 풀 수 없으나.
 * N^2 + NM이면 가능하다.
 *
 * */
public class 세친구 {
	static int[][] a = new int[4001][4001];
	static int[] degree = new int[4001];
	static int N,M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		for(int i=0; i<M; ++i) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			a[x][y] = a[y][x] = 1;

			//degree[i] : i의 친구의 수
			degree[x] += 1;
			degree[y] += 1;
		}
		int ans = -1;
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=N; ++j) {

				if(a[i][j] == 1) { //M번만 if문 안으로 진입. 따라서 시간복잡도가 O(N^2+NM)이 된다.
					for(int k=1; k<=N; ++k) {
						//세 사람은 모두 친구여야한다.
						if(a[i][j] == 1 && a[i][k] == 1 && a[j][k] == 1) {
							int sum = degree[i] + degree[j] + degree[k] - 6; //6을 빼는 이유는 A의 친구 수를 계산할 때, B와 C는 빼고 계산한다는 문제의 조건.
							if(ans == -1 || ans > sum ) {
								ans = sum;
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}
