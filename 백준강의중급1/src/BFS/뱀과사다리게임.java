package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 뱀과사다리게임 {
	static int N,M, ans;
	static boolean[] visit = new boolean[101];
	static class TrickCard{
		int x;
		int y;
		int kind; //1은 사다리, 2는 뱀
		TrickCard(int x, int y){
			this.x=x;
			this.y=y;
			kind = x < y ? 1 : 2;
		}
	}

	static class Pos{
		int location;
		int cnt;
		Pos(int location, int cnt){
			this.location = location;
			this.cnt = cnt;
		}
	}
	static ArrayList<TrickCard> trickList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		for(int i=0; i<N+M; ++i) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			trickList.add(new TrickCard(x,y));
		}

		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(1,0));
		visit[1] = true;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.location == 100) {
				ans = cur.cnt;
				return;
			}

			for(int d=1; d<=6; ++d) {
				int nextLocation = cur.location + d;

				//범위를 벗어났으면 continue
				if(nextLocation > 100)
					continue;

				//방문했으면 continue
				if(visit[nextLocation])
					continue;


				//사다리인지 뱀인지 한번 훑고 해당하면 nextLocation 재설정
				for(int i =0; i<trickList.size(); ++i) {
					if(nextLocation == trickList.get(i).x) {
						visit[nextLocation] = true;
						nextLocation = trickList.get(i).y;
						break;
					}
				}

				visit[nextLocation] = true;
				q.add(new Pos(nextLocation, cur.cnt+1));
			}
		}
	}
}