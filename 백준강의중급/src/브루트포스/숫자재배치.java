package 브루트포스;

import java.util.Scanner;

public class 숫자재배치 {
	static String A,B;
	static boolean[] check;
	static int ans, N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A=scan.next();
		B=scan.next();
		N = A.length();
		check = new boolean[N];
		System.out.println(go(0,0));
	}


	static int go(int index, int num) { //index번째 수 추가, 현재까지 만든 수 = num
		if(index == N)
			return num;
		int ans = -1;
		for(int i =0; i<N;++i) {
			if(check[i] == true) //이미 사용한 수
				continue;
			if(index == 0 && Integer.parseInt(A.charAt(i)+"") == 0) //0으로 시작하면 안됨.
				continue;

			check[i] = true;
			int temp = go(index+1, num*10 + Integer.parseInt(A.charAt(i)+""));
			if(temp < Integer.parseInt(B)) {
				if(ans == -1 || ans < temp)
					ans = Math.max(ans, temp);
			}
			check[i] = false;
		}

		return ans;
	}
}
