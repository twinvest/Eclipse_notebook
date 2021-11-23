import java.util.Scanner;

public class 이엔타일링_류지훈 {
	static int[] DP = new int[1001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		//N이 짝수인 경우
		if(N % 2 == 0) {
			int sum = 0;
			int a1 = 0;
			int a2 = 0;
			int a3 = 0;
			for(int i =0; i<=(N/2); ++i) {
				a1 = factorial(N-i);
				a2 = (factorial(N-(2*i)) * factorial(i));
				a3 = (a1 / a2) % 10007;
				sum += a3;
			}
			System.out.println(sum);
		}
		//N이 홀수인 경우
		else {


		}
	}
	static int[] fact = new int[1001];
	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		else {
			if(fact[n-1] != 0) {
				return fact[n-1] * n;
			}
			fact[n]= factorial(n-1) * n;
			return fact[n];
		}
	}

}
