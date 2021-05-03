package day0503;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 이전순열 {
	static Comparator<int[]> reverseOrder = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o2[1], o1[1]);
		}
	};

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = scan.nextInt();
		}

		if(N == 1) {
			System.out.println(-1);
		}

		int i = N-1;
		for(; i > 0; --i) {
			if(arr[i-1] > arr[i])
				break;
		}
		//i가 0이란것은 모두 오름차순정렬 되어있다는것. 즉, 1 2 3 4 5 같은 경우.
		if(i == 0) {
			System.out.println(-1);
		} else {
			int j = N-1;
			while(arr[i-1] < arr[j]) {
				--j;
			}

			//swap
			int tmp = arr[j];
			arr[j] = arr[i-1];
			arr[i-1] = tmp;
			Arrays.sort(arr);
			for(int k = 0; k<N; ++k) {
				System.out.print(arr[k]+" ");
			}
			//System.out.println(Arrays.toString(arr));
		}



	}
}
