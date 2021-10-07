package 브루트포스;

import java.util.Scanner;

public class 등차수열변환 {
	static int N;
	static int[] a;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		a = new int[N];
		for(int i = 0; i<N; ++i) {
			a[i] = scan.nextInt();
		}
		//수가 1개일 때 이는 등차수열임. 이때, 사용하는 연산의 개수는 0개.
		if(N == 1) {
			System.out.println(0);
			return;
		}

		int ans = -1;
		for(int d1 = -1; d1<=1; ++d1) { //첫항에 주는 차이
			for(int d2 = -1; d2<=1; ++d2) { //두번째 항에 주는 차이
				int change = 0; //연산의 횟수
				//d1과 d2가 0이 아니면 연산을 사용한 것임.
				if(d1 != 0) change +=1;
				if(d2 != 0) change +=1;

				int a0 = a[0] + d1;
				int diff = (a[1]+d2) -a0; //공차임.
				boolean ok = true;

				int an = a0 + diff; //a1이 구해짐.
				//a2부터 비교시작.
				for(int i =2; i<N; ++i) {
					an += diff;
					if(a[i] == an) continue;
					if(a[i]-1 == an) {
						change +=1;
					} else if(a[i]+1 == an) {
						change +=1;
					}else {
						ok = false;
						break;
					}
				}
				if(ok) {
					if(ans == -1 || ans > change) {
						ans = change;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
