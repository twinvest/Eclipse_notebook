package 백준디깅;

import java.util.Scanner;

public class BOJ1065_수학 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int ans = 0;
		for(int i =1; i<=N; ++i) {
			if(isHanNumber(i)) ++ans;
		}
		System.out.println(ans);
	}

	static boolean isHanNumber(int num){
		String s = num + "";
		if(s.length() == 1) {
			return true;
		} else {
			int diff = Integer.parseInt(s.charAt(1)+"") - Integer.parseInt(s.charAt(0)+"");
			for(int i=1; i<s.length(); ++i) {
				int a1 = Integer.parseInt(s.charAt(i-1)+"");
				int a2 = Integer.parseInt(s.charAt(i)+"");
				if(diff != (a2-a1))
					return false;
			}
		}
		return true;
	}
}
