package 브루트포스;

import java.util.Scanner;

public class 캠프준비 {
	static int N,L,R,X;
	static int[] a = new int[15];
	static boolean[] c = new boolean[15];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		L = scan.nextInt();
		R = scan.nextInt();
		X = scan.nextInt();
		for(int i =0; i<N; ++i)
			a[i] = scan.nextInt();
		System.out.println(go(0));
	}

	static int go(int index) {
		if(index == N) {
			int cnt = 0;
			int sum = 0;
			int hard = -1;
			int easy = -1;
			for(int i =0; i<N; ++i) {
				if(c[i] == false) continue;
				sum += a[i];
				cnt +=1;
				if(hard == -1 || hard < a[i]) hard = a[i];
				if(easy == -1 || easy > a[i]) easy = a[i];
			}
			if(cnt >= 2 && L<=sum && sum <= R && hard-easy >= X) return 1;
			else return 0;
		}

		//선택하는 경우
		c[index] = true;
		int cnt1 = go(index+1);

		//선택하지 않는경우
		c[index] = false;
		int cnt2 = go(index+1);

		return cnt1 + cnt2;
	}

	static int go2(int index, int cnt, int sum, int easy, int hard) {
		if(index == N) {
			if(cnt >= 2 && L<=sum && sum <= R && hard-easy >= X) return 1;
			else return 0;
		}
		int cnt1 = go2(index+1, cnt+1, sum+a[index], Math.min(easy,a[index]), Math.max(hard, a[index]));
		int cnt2 = go2(index+1, cnt, sum, easy, hard);
		return cnt1 + cnt2;
	}

}
