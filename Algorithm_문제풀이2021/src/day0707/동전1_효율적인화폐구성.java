package day0707;

import java.util.Scanner;

public class 동전1_효율적인화폐구성 {
	static int[] dp = new int[100001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//맨처음 dp배열을 100001로 초기화한다.
		for(int i=1; i<100000;++i) {
			dp[i] = 100001;
		}
		int numOfCoin = scan.nextInt();
		int target = scan.nextInt();
		int[] coins = new int[numOfCoin];
		for(int i=0; i<coins.length;++i) {
			coins[i] = scan.nextInt();
		}

		//coin의 개수만큼 for문을 돌면서
		for(int coin : coins) {
			//그때마다 1원부터 target금액까지 반복문을 돈다.
			for(int i=1; i<=target; ++i) {
				//이 조건은 ArrayIndexException을 피하기 위해 넣었다.
				if(i-coin>=0) {
					//dp[i]는 금액 i를 만들 수 있는 최소한의 화폐 개수
					dp[i] = Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
		if (dp[target] ==100001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[target]);
		}


	}

}
