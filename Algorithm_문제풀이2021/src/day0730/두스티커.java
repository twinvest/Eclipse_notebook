package day0730;

import java.util.Scanner;

public class 두스티커 {
	static int H,W,N,ans;
	static int[] r,c;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		H = scan.nextInt();
		W = scan.nextInt();
		N = scan.nextInt();
		r = new int[N];
		c = new int[N];
		for(int i =0; i<N; ++i) {
			r[i] = scan.nextInt();
			c[i] = scan.nextInt();
		}
		for(int i =0; i<N; ++i) { //1번스티커
			int r1 = r[i];
			int c1 = c[i];

			for(int j =i+1; j<N; ++j) { // 2번스티커
				int r2 = r[j];
				int c2 = c[j];

				for(int rot1=0; rot1<2; ++rot1) { //1번스티커를 몇번 돌릴건지 ==> 2번 돌리면된다.
					for(int rot2=0; rot2<2; ++rot2) { //2번스티커를 몇번 돌릴건지 ==> 2번 돌리면된다.
						//스티커를 세로로 붙여보는 방법.
						if(r1+r2 <= H && Math.max(c1, c2) <= W) {
							int temp = r1*c1 + r2*c2;
							if(ans < temp) ans = temp;
						}

						//스티커를 가로로 붙여보는 방법.
						if(Math.max(r1,r2) <= H && c1 + c2 <= W) {
							int temp = r1*c1 + r2*c2;
							if(ans < temp) ans = temp;
						}

						//2번스티커 회전
						int temp = r2;
						r2 = c2;
						c2 = temp;
					}
					//1번스티커 회전
					int temp = r1;
					r1 = c1;
					c1 = temp;
				}
			}
		}
		System.out.println(ans);
	}
}
