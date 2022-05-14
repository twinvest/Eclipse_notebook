package day0512;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 마법사상어와파이어볼 {
	static int[][] dir = {
			//{r,c}
			{-1,0},
			{-1,1},
			{0,1},
			{1,1},
			{1,0},
			{1,-1},
			{0,-1},
			{-1,-1}
	};
	static class Pair implements Comparable<Pair>{
		int y; int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
		@Override
		public int compareTo(Pair o) {
			if(y == o.y) {
				return Integer.compare(x, o.x);
			}
			return Integer.compare(y, o.y);
		}
	}
	static class Pos implements Comparable<Pos>{
		int r, c, m, s,d,k;
		Pos(int r, int c, int m, int s, int d, int k){
			this.r=r;
			this.c=c;
			this.m=m;
			this.s=s;
			this.d=d;
			this.k=k;
		}

		@Override
		public int compareTo(Pos comp) {
			if(r == comp.r) {
				return Integer.compare(c,comp.c);
			}
			return Integer.compare(r, comp.r);
		}


	}
	static int N, numOfFireball, K;
	static int[][] map;
	static Queue<Pos> q = new LinkedList<>();
	static ArrayList<Pos> tempMoveList;
	static ArrayList<Pair> searchList;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		numOfFireball=scan.nextInt();
		K=scan.nextInt();

		for(int i =0; i<numOfFireball; ++i) {
			q.add(new Pos(scan.nextInt()-1, scan.nextInt()-1, scan.nextInt(), scan.nextInt(), scan.nextInt(), K));
		}


		for(int k=K; k>0; --k) {
			map  = new int[N][N];
			searchList = new ArrayList<>();
			tempMoveList = new ArrayList<>();
			while(!q.isEmpty()) {
				if(k != q.peek().k) {
					break;
				}

				Pos cur = q.poll();
				int ny = cur.r + (dir[cur.d][0] * cur.s);
				int nx = cur.c + (dir[cur.d][1] * cur.s);
				if(ny<0) {
					int remain = Math.abs(ny)%N;
					ny = (N-remain)%N;
				}else {
					ny = ny%N;
				}
				if(nx<0) {
					int remain = Math.abs(nx)%N;
					nx = (N-remain)%N;
				}else {
					nx = nx%N;
				}

				map[ny][nx]++;
				//만약 2이상인것들은 좌표를 따로 저장
				if(map[ny][nx]>=2) {
					searchList.add(new Pair(ny,nx));
				}
				//이동한 모습의 Pos를 전부저장
				tempMoveList.add(new Pos(ny,nx,cur.m,cur.s,cur.d, cur.k));
			}

			//2이상인 것들이 없을때 진입
			if(searchList.size() == 0) {
				for(int i =0; i<tempMoveList.size(); ++i) {
					Pos cur  = tempMoveList.get(i);
					if(cur.m != 0) {
						cur.k = cur.k -1;
						q.add(cur);
					}
					tempMoveList.remove(i);
					--i;
				}
			}

			//2이상인 것들이 있을때 처리 로직
			for(Pair p : searchList) {
				int cnt = 0;
				int m = 0;
				int s = 0;
				int numOfEven = 0;
				for(int i =0; i<tempMoveList.size(); ++i) {
					Pos cur  = tempMoveList.get(i);
					if(p.y == cur.r && p.x == cur.c) {
						++cnt;
						m+=cur.m;
						s+=cur.s;
						if(cur.d % 2 == 0)
							++numOfEven;

						tempMoveList.remove(i);
						--i;
					}
				}

				if(numOfEven == 0 || numOfEven ==cnt) {
					if(m/5 != 0) {
						q.add(new Pos(p.y,p.x,m/5,s/cnt,0,k-1));
						q.add(new Pos(p.y,p.x,m/5,s/cnt,2,k-1));
						q.add(new Pos(p.y,p.x,m/5,s/cnt,4,k-1));
						q.add(new Pos(p.y,p.x,m/5,s/cnt,6,k-1));
					}
				} else {
					if(m/5 != 0) {
						q.add(new Pos(p.y,p.x,m/5,s/cnt,1,k-1));
						q.add(new Pos(p.y,p.x,m/5,s/cnt,3,k-1));
						q.add(new Pos(p.y,p.x,m/5,s/cnt,5,k-1));
						q.add(new Pos(p.y,p.x,m/5,s/cnt,7,k-1));
					}
				}
			}

			//위에 로직 타고나면 2이상인 것들은 전부 처리 됐고 tempMoveList에 1개인 것들만 남아있을거임. 1개인것들은 다시큐에 넣어준다.
			for(int i =0; i<tempMoveList.size(); ++i) {
				Pos cur  = tempMoveList.get(i);
				if(cur.m != 0) {
					cur.k = cur.k -1;
					q.add(cur);
				}
				tempMoveList.remove(i);
				--i;
			}

		}

		int ans = 0 ;

		//마지막으로 q에 남아있는 것들의 질량의 합을 출력해준다.
		while(!q.isEmpty()) {
			ans += q.poll().m;
		}
		System.out.println(ans);


	}

}
