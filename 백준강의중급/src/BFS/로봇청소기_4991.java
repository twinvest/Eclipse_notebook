package BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 로봇청소기_4991 {
	static boolean next_permutation(int[] a) {
		int i = a.length-1;
		while (i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		if (i <= 0) {
			return false;
		}
		int j = a.length-1;
		while (a[j] <= a[i-1]) {
			j -= 1;
		}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		j = a.length-1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}


	static class Pair {
		int first;
		int second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};

	static int[][] bfs(String[] a, int sx, int sy) {
		int n = a.length;
		int m = a[0].length();
		int[][] dist = new int[n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				dist[i][j] = -1;
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(sx,sy));
		dist[sx][sy] = 0;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.first;
			int y = p.second;
			for (int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (dist[nx][ny] == -1 && a[nx].charAt(ny) != 'x') {
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		return dist;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if (n == 0 && m == 0)
				break;

			String[] a = new String[n];
			for (int i=0; i<n; i++) {
				a[i] = sc.next();
			}

			ArrayList<Pair> b = new ArrayList<>(); //모든 더러운 칸에 순열을 만들기 위해 번호를 메긴다.
			                                       //b.get(i) : i번 더러운칸의 위치
			b.add(new Pair(0,0));                  //더미로 하나 넣어줌.
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					char x = a[i].charAt(j);
					if (x == 'o') {
						b.set(0, new Pair(i,j)); //set함수는 원하는 자리에 넣을 수 있다. 즉, 옆 코드에서 0번째에 넣을 수 있다는말.
					} else if (x == '*') {
						b.add(new Pair(i,j));
					}
				}
			}

			int l = b.size();
			int[][] d = new int[l][l]; //d[i][j] : i번 더러운 칸에서 j번 더러운 칸으로 가는 거리
			boolean ok = true;
			for (int i=0; i<l; i++) {
				//(0,0)부터 로봇청소기위치, 더러운곳의 위치 순차적으로 dist를 구함.
				int[][] dist = bfs(a, b.get(i).first, b.get(i).second);
				//print(dist);
				for (int j=0; j<l; j++) {
					d[i][j] = dist[b.get(j).first][b.get(j).second];
					//print(d);
					if (d[i][j] == -1) {
						ok = false;
					}
				}
			}

			if (ok == false) {
				System.out.println(-1);
				continue;
			}

			//l이 4라고 가정하면
			int[] p = new int[l-1];
			for (int i=0; i<l-1; i++) {
				p[i] = i+1; //1, 2, 3
			}

			int ans = -1;
			do {
				int now = d[0][p[0]]; //로봇청소기위치에서 ==> p[0]으로
				for (int i=0; i<l-2; i++) {
					now += d[p[i]][p[i+1]]; //p[0]에서 p[1]로
					                        //p[1]에서 p[2]로
				}
				if (ans == -1 || ans > now) {
					ans = now;
				}
			} while(next_permutation(p)); //순열로 위치 바꿔보고
			System.out.println(ans);
		}
	}

	static void print(int[][] map) {
		for(int i=0; i<map.length; ++i) {
			for(int j=0; j<map[0].length; ++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}