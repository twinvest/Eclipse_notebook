package 백준디깅;

import java.util.Scanner;

public class BOJ2739_수학 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i =1; i<=9; ++i) {
			System.out.println(n+" * "+i+" = "+n*i);
		}
	}
}
