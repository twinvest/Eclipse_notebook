package day1216;

import java.util.Arrays;
import java.util.Scanner;

public class 만들수없는금액_이코테 {
	static int N;
	static int[] coins;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		coins = new int[N];
		for(int i =0; i < N; ++i) {
			coins[i] = scan.nextInt();
		}
		Arrays.sort(coins);
		int target = 1;
		for(int coin : coins) {
			if(target < coin)
				break;
			target += coin;
		}
		System.out.println(target);

	}
}
