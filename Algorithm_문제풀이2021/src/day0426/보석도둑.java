package day0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 보석도둑 {
	static class Diamond implements Comparable<Diamond>{
		int weight;
		int price;
		public Diamond(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo (Diamond comp) {
			if(this.price == comp.price) {
				return Integer.compare(this.weight, comp.weight);
			}
			return Integer.compare(comp.price, this.price);
		}

	}

	static ArrayList<Diamond> diamondList = new ArrayList<Diamond>();
	static ArrayList<Integer> poketList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for(int i =0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			diamondList.add(new Diamond(weight, price));
		}

		for(int i =0; i<K; ++i) {
			int num = Integer.parseInt(br.readLine());
			poketList.add(num);
		}

		Collections.sort(diamondList);
		Collections.sort(poketList);
		long ans = 0;
		for(int i =0; i<diamondList.size(); ++i) {
			int price = diamondList.get(i).price;
			int weight = diamondList.get(i).weight;
			if(poketList.size() > 0) {
				int flag = binarySearch(0, poketList.size()-1, weight);
				if(flag == -1) {
					continue;
				} else {
					ans += price;
					poketList.remove(flag);
				}
			}
		}
		System.out.println(ans);
	}

	static int binarySearch(int start, int end, int target) {

		int mid = (start + end) / 2;
		if(start >= end) {
			return mid;
		}
		if(target > poketList.get(end)) {
			return -1;
		}

		if(poketList.get(mid) > target) {
			return binarySearch(start, mid-1, target);
		} else if (poketList.get(mid) < target) {
			return binarySearch(mid+1, poketList.size()-1, target);
		} else {
			return mid;
		}
	}

}
