package day0425;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 우체국 {
	static class Pos implements Comparable<Pos>{
		long idx;
		long numOfPeople;
		Pos(long idx, long numOfPeople){
			this.idx = idx;
			this.numOfPeople = numOfPeople;
		}
		@Override
		public int compareTo(Pos comp) {
			return Long.compare(this.idx, comp.idx);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Pos> list = new ArrayList<Pos>();
		long sum = 0;
		for(int i =0; i<N; ++i) {
			long idx = scan.nextLong();
			long numOfPeople = scan.nextLong();
			Pos cur = new Pos(idx, numOfPeople);
			list.add(cur);
			sum+=numOfPeople;
		}
		Collections.sort(list); //idx로 오름차순정렬
		solve(list, sum);
	}

	static void solve(ArrayList<Pos> list , long sum) {
		long tempSum = 0;
		for(int i =0; i<list.size(); ++i) {
			tempSum += list.get(i).numOfPeople;
			/*
			 * sum / 2 가 아닌
			 * (sum + 1) / 2를 하는 이유는
			 * 2         2
			 * 1 1       1 1
			 * 2 1       2 2
			 * 과 같은 케이스때문
			 * https://dirmathfl.tistory.com/371?category=825041
			 *
			 * */
			if(tempSum >= (sum+1)/2) {
				System.out.println(list.get(i).idx);
				break;
			}
		}
	}

	static void solve2(ArrayList<Pos> list , long sum) {
		sum /=2;
		long tempSum = 0;
		int index = 0;
		while(tempSum <= sum) {
			tempSum += list.get(index).numOfPeople;
			++index;
		}
		System.out.println(list.get(index-1).idx);
	}
}
