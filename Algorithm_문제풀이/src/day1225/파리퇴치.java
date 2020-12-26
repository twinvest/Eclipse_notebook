package day1225;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 파리퇴치 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for(int t = 1; t<=tc; ++t) {
			ArrayList<Integer> list = new ArrayList<>();
			int N = scan.nextInt();
			int M = scan.nextInt();
			int[][] map = new int[N][N];
			for(int i = 0; i<N; i+=1) {
				for(int j = 0; j<N; j+=1) {
					map[i][j] = scan.nextInt();
				}
			}

			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					int sum = 0;
					for(int k = i; k < i+M; ++k) {
						for(int l = j; l < j+M; ++l) {
							if(k < N && l < N)
								sum += map[k][l];
						}
					}
					list.add(sum);
				}
			}
			Collections.sort(list);
			System.out.println("#"+t+" "+list.get(list.size()-1));
		}
	}
}
