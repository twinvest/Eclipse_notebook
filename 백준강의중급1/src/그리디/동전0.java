package 그리디;
import java.util.Scanner;
public class 동전0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int remain = scan.nextInt();
		int[] coins = new int[N];
		int ans = 0;
		for(int i = 0 ;i <N; ++i) {
			coins[i] = scan.nextInt();
		}
		for ( int i = coins.length -1; i >= 0; i-- ) {
			if(remain == 0) break;
			int coin = coins[i];
			ans += (remain / coin);
			remain %= coin;
		}
		System.out.println(ans);
	}
}
