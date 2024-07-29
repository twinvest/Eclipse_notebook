package 그리디;
import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		int[] ans = new int[N];

		for(int i = 0 ; i < N; ++i) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 0; i<arr.length; ++i){
			sum = sum + arr[i];
			ans[i] = sum;
		}
		sum = 0;
		for(int i = 0 ; i < N; ++i)
			sum += ans[i];
		System.out.println(sum);

	}

}