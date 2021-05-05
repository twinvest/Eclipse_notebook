package day0503;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
		ArrayList<Integer> list = new ArrayList<Integer>();
		//int[] arr = new int[N];
		for(int i = 0; i<N; ++i) {
			//arr[i] = scan.nextInt();
			list.add(scan.nextInt());
		}

		if(N == 1) {
			System.out.println(-1);
			return;
		}

		int i = N-1;
		for(; i > 0; --i) {
			if(list.get(i-1) > list.get(i))
				break;
		}
		//i가 0이란것은 모두 오름차순정렬 되어있다는것. 즉, 1 2 3 4 5 같은 경우.
		if(i == 0) {
			System.out.println(-1);
		} else {
			int j = N-1;
			while(list.get(i-1) < list.get(j)) {
				--j;
			}

			//swap
			Collections.swap(list, i-1, j);


			List<Integer> subList1 = list.subList(i, list.size());
			Collections.reverse(subList1);
			List<Integer> subList2 = list.subList(0, i);

			ArrayList<Integer> sumList = new ArrayList<Integer>();
			sumList.addAll(subList2);
			sumList.addAll(subList1);


			for(int k = 0; k<N; ++k) {
				System.out.print(sumList.get(k)+" ");
			}
		}
	}
}
