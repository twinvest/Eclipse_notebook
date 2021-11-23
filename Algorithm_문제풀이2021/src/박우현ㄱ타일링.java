
import java.util.Scanner;

public class 박우현ㄱ타일링 {
	static int[] DP1 = new int[1001];
	static int[] DP2 = new int[1001];
	static int[] DP = new int[1001];

	public static void main(String[] args) {
		DP1[1] = 1;
		DP1[2] = 2;
		for(int i =3; i<= 1000; ++i) {
			DP1[i] = (DP1[i-1] + DP1[i-2]) % 10007;
		}

		DP2[1] = 0;
		DP2[2] = 0;
		DP2[3] = 2;
		int cnt = -1;
		for(int i = 4; i<=1000; ++i) {
			int k = i*2;
			DP2[i] = DP2[i-2] * 2;
			if(k>=8) {
				++cnt;
				DP2[i] += DP2[i-1]*2 - (2*cnt);
			}
			if(k%6 == 0) {
				DP2[i] += DP2[i-3]*2;
			}

			DP2[i] = DP2[i] % 10007;
		}

		for(int i =1; i<=1000; ++i) {
			DP[i] = (DP1[i] + DP2[i]) % 10007;
		}

		Scanner scan = new Scanner(System.in);
		System.out.println(DP[scan.nextInt()]);
	}
}