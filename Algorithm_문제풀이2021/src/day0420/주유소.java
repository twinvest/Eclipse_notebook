package day0420;

import java.util.Scanner;

public class 주유소 {
	static long[] edgeCost;
	static long[] prices;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		edgeCost = new long[N];
		prices = new long[N];
		for(int i =0; i<N-1;++i) {
			edgeCost[i] = scan.nextLong();
		}
		for(int i =0; i<N;++i) {
			prices[i] = scan.nextLong();
		}

		long minCost = prices[0];
		long totalCost = minCost * edgeCost[0];
		for(int i=1; i<N-1; ++i) {
			if(minCost > prices[i] ) {
				minCost = prices[i];
			}
			totalCost += minCost * edgeCost[i];
		}
		System.out.println(totalCost);
	}
}
