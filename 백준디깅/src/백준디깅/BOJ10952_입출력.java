package 백준디깅;

import java.util.Scanner;

public class BOJ10952_입출력 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if(a == 0 && b == 0) break;;
			System.out.println(a+b);
		}
	}
}
