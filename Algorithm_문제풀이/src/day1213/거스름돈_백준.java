package day1213;

import java.util.Scanner;

public class 거스름돈_백준 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N =scan.nextInt();
		int[] coins = {500, 100, 50, 10, 5, 1};
		int remain = 1000 - N;
		int ans = 0;
		for(int coin : coins) {
			if(remain == 0) break;
			ans += (remain / coin);
			remain %= coin;
		}
		System.out.println(ans);
	}
}