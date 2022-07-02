package day0608;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 *
 * 이 코드 이거 통과한다...
 *  6 7
	0 0 0 0 0 0 0
	0 0 0 1 0 0 0
	0 0 0 0 0 0 0
	0 0 0 0 0 0 1
	0 0 1 0 0 0 0
	0 0 0 0 0 0 0
	2 3 1 1 1 2
 *
 *
 * */
public class 직사각형탈출 {
	public static class Info {
		int y, x, cnt;

		public Info(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static int N, M, answer;
	public static int H, W, Sr, Sc, Fr, Fc;

	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};

	public static boolean[][] visited;
	public static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		board = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken()) - 1;
		Sc = Integer.parseInt(st.nextToken()) - 1;
		Fr = Integer.parseInt(st.nextToken()) - 1;
		Fc = Integer.parseInt(st.nextToken()) - 1;

		answer = -1;
		bfs();

		System.out.println(answer);
	}

	public static void bfs() {
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(Sr, Sc, 0));
		visited[Sr][Sc] = true;

		while (!q.isEmpty()) {
			Info info = q.poll();

			for (int i = 0; i < 4; ++i) {
				int ny = info.y + dy[i];
				int nx = info.x + dx[i];

				//범위체크
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}

				//방문 체크 및 벽인지 확인
				if (!visited[ny][nx] && board[ny][nx] == 0) {
					//사각형내에 벽이 있는지 확인
					if (!check(ny, nx)) {
						continue;
					}

					//목적지면 바로 끝내고
					if (ny == Fr && nx == Fc) {
						answer = info.cnt + 1;
						return;
					}
					//목적지가 아니면 q에 삽입
					q.offer(new Info(ny, nx, info.cnt + 1));
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static boolean check(int y, int x) {
		int nx = x + W;
		int ny = y + H;

		if (ny - 1 >= N || nx - 1 >= M) {
			return false;
		}

		for (int i = y; i < ny; ++i) {
			for (int j = x; j < nx; ++j) {
				if (board[i][j] == 1) {
					return false;
				}
			}
		}

		return true;
	}
}