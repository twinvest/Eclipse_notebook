package day0425;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 컬러볼 {
	static int[][] balls;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfBall = scan.nextInt();
		balls = new int[numOfBall][2];

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i =0; i<=numOfBall;++i) {
			list.add(new ArrayList());
		}

		//startTime으로 오름차순정렬.
		Comparator<Integer> order = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		//입력
		for(int i =0; i<numOfBall;++i) {
			int color = scan.nextInt();
			int size = scan.nextInt();
			balls[i][0] = color;
			balls[i][1] = size;
			list.get(color).add(size);
		}
		//정렬
		for(int i =0; i<list.size(); ++i) {
			list.get(i).sort(order);
		}

		for(int i =0; i<numOfBall;++i) {
			int color = balls[i][0];
			int size = balls[i][1];
			int sum = 0;
			for(int j = 1; j<=numOfBall; ++j) {
				//색깔이 같은건 검사하지 않는다.
				if(color == j) continue;
				int index = 0;
				if(list.get(j).size()>0) {
					index = binarySearch(0, list.get(j).size(), list.get(j), size);
					for(int k=0; k<=index; ++k) {
						if(list.get(j).size() > k && list.get(j).get(k) < size) {
							sum += list.get(j).get(k);
						}
					}
				}
			}
			System.out.println(sum);
		}
	}

	static int binarySearch(int start, int end, ArrayList<Integer> list, int size) {
		int mid = (start + end) / 2;
		if(start >= end) {
			return mid;
		}else {
			if(list.get(mid) > size) {
				//왼쪽탐색
				return binarySearch(start, mid-1, list, size);
			} else if(list.get(mid) < size) {
				//오른쪽탐색
				return binarySearch(mid+1, end, list, size);
			} else {
				return mid;
			}
		}
	}
}
