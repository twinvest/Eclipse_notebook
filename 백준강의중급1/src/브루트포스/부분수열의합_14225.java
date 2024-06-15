package 브루트포스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 부분수열의합_14225 {
	static int[] sel;
	static int[] arr;
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		for ( int i = 0; i<N; ++i) {
			arr[i] = scan.nextInt();
		}
		for(int i =1; i<=N; ++i) {
			sel = new int[i];
			search(0,0);
		}
		Collections.sort(list);
		int index = 0;
		for(int i=1; i<=list.get(list.size()-1); ++i) {
			if(index == list.size()-1) {
				/*
				 *  1
					1
					의 정답은 2

					1
					2
					의 정답은
					1
				 *
				 * */

				if(i==1 && list.get(index) > 1) {
					System.out.println(1);
				}else {
					System.out.println(i+1);
				}
				break;
			}

			if(i == list.get(index++)) {
				//list의 다음 숫자가 같으면 그만큼 index를 증가시켜줌
				while(true) {
					if(list.get(index) == i) {
						++index;
					}else {
						break;
					}
				}
				continue;
			}
			else {
				System.out.println(i);
				break;
			}

		}
	}

	static public void search(int idx, int s_idx) {
		if(sel.length == s_idx) {
			int tmpSum=0;
			for(int i =0; i<sel.length; ++i)
				tmpSum += sel[i];
			list.add(tmpSum);
			return;
		}
		if(arr.length == idx) {
			return;
		}
		sel[s_idx] = arr[idx];
		search(idx+1, s_idx+1);
		search(idx+1, s_idx);
	}
}
