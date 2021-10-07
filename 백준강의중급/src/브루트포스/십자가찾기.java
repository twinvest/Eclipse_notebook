package 브루트포스;

import java.util.ArrayList;
import java.util.Scanner;

public class 십자가찾기 {
	static class Pos{
		int y; int x; int size;
		Pos(int y, int x, int size){
			this.y = y;
			this.x = x;
			this.size = size;
		}
	}

	static int N,M;
	static char[][] map;
	static boolean[][] check;
	static ArrayList<Pos> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new char[N][M];
		check = new boolean[N][M];
		for(int i =0; i<N; ++i) {
			String s = scan.next();
			for(int j =0; j<s.length(); ++j) {
				map[i][j] = s.charAt(j);
			}
		}


		for(int i =0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				//i부터 j까지 돌면서 만약에 (i,j)가 '*'이면
				if(map[i][j] == '*') {
					int l = 0;
					//크기를 확장시켜본다.
					for(int k =1; ; ++k) {
						//범위를 만족하고
						if(i+k<N && i-k>=0 && j+k<M && j-k>=0){
							//크기를 늘려본곳이 십자가인지 확인해본다. 이 if문을 만족하면  l을 k로 갱신.
							if(map[i+k][j] == '*' && map[i-k][j] == '*' && map[i][j+k] == '*' && map[i][j-k] == '*') {
								l = k;
							}else {
								break;
							}
						} else {
							break;
						}
					}
					//l이 0보다 크면
					if(l>0) {
						list.add(new Pos(i+1, j+1, l));
						check[i][j] = true;
						for(int k =1; k<=l; ++k) {
							check[i+k][j] = true;
							check[i-k][j] = true;
							check[i][j+k] = true;
							check[i][j-k] = true;
						}
					}
				}
			}
		}

		for(int i =0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				//'*'이면서 false인 곳은 만들수 없음을 의미한다.
				if(map[i][j] == '*' && check[i][j] == false) {
					System.out.println("-1");
					return;
				}
			}
		}

		System.out.println(list.size());
		for(Pos cur : list) {
			System.out.println(cur.y+" "+cur.x+" "+cur.size);
		}
	}

}
