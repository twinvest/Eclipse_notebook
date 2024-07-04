package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 벽부수고이동하기4 {
	static StringBuilder sb;
	static class Pos{
		int y;
		int x;

		Pos(int y, int x){
			this.y=y;
			this.x=x;
		}
	}

	static boolean inside(int y, int x){
		return (y>=0 && y<N) && (x>=0 && x<M);
	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0},
	};

	static class Element{
		int groupNum;
		int count;
		Element(int groupNum, int count){
			this.groupNum = groupNum;
			this.count = count;
		}
	}

	static int N,M, cnt, group;
	static char[][] map;
	static int[][] visit;
	static ArrayList<Element> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];

		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j =0; j<M; ++j) {
				map[i][j] = str.charAt(j);
			}
		}

		group = 0;
		for(int i=0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				if(map[i][j] == '0' && visit[i][j] == 0) {
					++group;
					bfs(i,j);
					list.add(new Element(group, cnt));
				}
			}
		}

		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				if(map[i][j] == '1') {
					set = new HashSet<Integer>();

					for(int d=0; d<4; ++d) {
						int ny = i + dir[d][0];
						int nx = j + dir[d][1];

						if(!inside(ny, nx))
							continue;
						if(map[ny][nx] == '1')
							continue;

						if(visit[ny][nx] != 0) {
							set.add(visit[ny][nx]);
						}
					}

					Iterator<Integer> iterSet = set.iterator();
					int sum = 1;
					while(iterSet.hasNext()) {
						int group = iterSet.next();
						sum += list.get(group-1).count;
					}
					sb.append(sum%10);

				}else if(map[i][j] == '0') {
					sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int i, int j) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(i,j));
		visit[i][j] = group;
		cnt = 1;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for(int d=0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				if(!inside(ny, nx))
					continue;

				if(visit[ny][nx] != 0)
					continue;

				if(map[ny][nx] == '1')
					continue;

				q.add(new Pos(ny,nx));
				visit[ny][nx] = group;
				++cnt;
			}
		}
	}
}
