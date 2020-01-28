import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int N = scan.nextInt();
			int[] arr =new int[N];
			for(int i =0; i<arr.length; ++i)
				arr[i] = scan.nextInt();
			Arrays.sort(arr);
			System.out.print("#"+t);
			for(int i =0; i<arr.length; ++i)
				System.out.print(" "+arr[i]);
			System.out.println();
		}
	}
}