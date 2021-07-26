package day0726;

import java.util.Scanner;

public class 양념반후라이드반 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		int X = scan.nextInt();
		int Y = scan.nextInt();
		int ans = 0;

		if(A+B > 2*C) {
			int remain = 0;
			if( X >= Y ) {
				ans = C * 2 * Y;
				remain = X-Y;
				if( A > 2 * C) {
					ans += (remain * 2 * C);
				} else {
					ans += (remain * A);
				}
			} else {
				ans = C * 2 * X;
				remain = Y-X;
				if( B > 2 * C) {
					ans += (remain * 2 * C);
				} else {
					ans += (remain * B);
				}
			}
		} else {
			ans = (A*X) + (B*Y);
		}
		System.out.println(ans);

	}

}
