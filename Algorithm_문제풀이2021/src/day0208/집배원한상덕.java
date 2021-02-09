package day0208;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class 집배원한상덕 {
	static String[][] map;
	static int[][] heightMap;
	static boolean[][] visit;
	static int maxHeight = -987654231;
	static int minHeight = 987654321;
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
			,{-1,-1}
			,{-1,1}
			,{1,-1}
			,{1,1}
	};
	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		int piro;

		Pos(int y, int x, int piro){
			this.y =y;
			this.x =x;
			this.piro = piro;
		}
		@Override
		public boolean equals(Object obj) {
			Pos comp = (Pos)obj;
			if(this.x == comp.x && this.y == comp.y && this.piro == comp.piro) {
				return true;
			}
			else return false;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.piro, o.piro);
		};
	}
	static boolean inside(int y, int x) {
		return (y>=0 && y<size) && (x>=0 && x<size);
	}
	static int size;
	//static int numOfHome = 0;
	//static int ans = 987654321;
	static ArrayList<Pos> list = new ArrayList<>();
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		map = new String[size][size];
		heightMap = new int[size][size];
		visit = new boolean[size][size];
		int startY = -1;
		int startX = -1;
		for(int i=0; i<size; ++i) {
			String str = scan.next();
			for(int j =0; j<str.length(); ++j) {
				map[i][j] = str.charAt(j)+"";
				if(map[i][j].equals("P")) {
					startY = i;
					startX = j;
				}
				if(map[i][j].equals("K")) {
					list.add(new Pos(i,j,-1));
				}
			}
		}

		for(int i =0; i<size; ++i) {
			for(int j =0; j<size; ++j) {
				heightMap[i][j] = scan.nextInt();
			}
		}
		bfs(startY, startX);
		System.out.println(minHeight);
		System.out.println(maxHeight);
		System.out.println(Math.abs(minHeight-maxHeight));
		//System.out.println(ans);
	}
	static void bfs(int y, int x) {
		PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
		pq.add(new Pos(y, x, 0)); //맨처음에는 피로 0 넣어줌.
		int home = 0;
		while(!pq.isEmpty()) {
			Pos pos = pq.poll();

			if(pos.piro < Math.abs(heightMap[pos.y][pos.x] - minHeight)) {
				pq.add(new Pos(pos.y,pos.x,Math.abs(heightMap[pos.y][pos.x] - minHeight)));
				continue;
			}

			visit[pos.y][pos.x] = true;
			if(heightMap[pos.y][pos.x] < minHeight) minHeight = heightMap[pos.y][pos.x];
			if(heightMap[pos.y][pos.x] > maxHeight) maxHeight = heightMap[pos.y][pos.x];

			if(map[pos.y][pos.x].equals("K") && list.contains(new Pos(pos.y, pos.x,-1))) {
				//ans = Math.min(ans, pos.piro);
				list.remove(new Pos(pos.y, pos.x,-1));
			}

			if(list.size() == 0) return;


			for ( int d = 0; d < 8; ++d ) {
				int ny = pos.y +dir[d][0];
				int nx = pos.x +dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx]) {
					int tempMinHeight = -1;
					int tempMaxHeight = -1;
					if(minHeight > heightMap[ny][nx])
						tempMinHeight = heightMap[ny][nx];
					else tempMinHeight = minHeight;

					if(maxHeight < heightMap[ny][nx])
						tempMaxHeight = heightMap[ny][nx];
					else tempMaxHeight = maxHeight;
					int diff = Math.abs(tempMinHeight-tempMaxHeight);
					pq.add(new Pos(ny,nx,diff));
				}

			}
		}
	}
}
