package day0728;

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
				if(map[i][j] == '*') {
					int l = 0;
					for(int k =1; ; ++k) {
						if(i+k<N && i-k>=0 && j+k<M && j-k>=0){
							if(map[i+k][j] == '*' && map[i-k][j] == '*' && map[i][j+k] == '*' && map[i][j-k] == '*') {
								l = k;
							}else {
								break;
							}
						} else {
							break;
						}
					}
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
