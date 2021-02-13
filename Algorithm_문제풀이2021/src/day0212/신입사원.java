package day0212;

import java.util.Scanner;

public class 신입사원 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for(int t=0; t<testCase; ++t) {
			int numOfStudent = scan.nextInt();
			int students[] = new int[numOfStudent+1];
			for(int i =0; i<numOfStudent; ++i) {
				students[scan.nextInt()] = scan.nextInt();
			}
			int ans = 1;
			int tmp = students[1];
			for(int i=2;i<=numOfStudent;i++) {
				if (tmp >= students[i]) {
					tmp = students[i];
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
