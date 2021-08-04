package day0804;

import java.util.Scanner;

public class 수들의합2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] a = new int[10001];
		for(int i=0; i<N; ++i) {
			a[i] = scan.nextInt();
		}

		int left = 0, right = 0, ans = 0;
		int sum = a[0];
		while(left <= right && right < N) {
			if(sum < M) {
				right += 1;
				sum += a[right];
			} else if (sum == M) {
				ans += 1;
				right += 1;
				sum += a[right];
			} else if (sum > M) {
				if(left == right) {
					right +=1;
					sum += a[right];
				}else {
					sum -= a[left];
					left += 1;
				}
			}
		}
		System.out.println(ans);
	}



	static void test() {
		int ans = 0;
		int n = 5;
		int m = 5;
		int[] a = new int[5];
		//방법1 O(N^3)
		for(int i =0; i<n; ++i) {
			for(int j = i; j<n; ++j) {
				int sum = 0;
				for(int k = i; k<=j; ++k) {
					sum += a[k];
				}
				if(sum == m)
					ans += 1;
			}
		}

		//방법2 O(N^2)
		for(int i =0; i<n; ++i) {
			int sum = 0;
			for(int j = i; j<n; ++j) {
				sum += a[j];
				if(sum == m)
					ans += 1;
			}
		}

		//방법3 O(N), 조건 a[i]가 모두 양수이면서 sum이 m보다 커지는 순간은 탈출한다. 두 포인터.
		int left = 0, right =0, sum=a[0];
		while(left <= right && right < n) {
			if(sum < m) {
				right += 1;
				sum += a[right];
			} else if (sum == m) {
				ans += 1;
				right += 1;
				sum += a[right];
			} else if (sum == m) {
				sum -= a[left];
				left += 1;
			}

		}


	}
}
