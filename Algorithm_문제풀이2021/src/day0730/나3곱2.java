package day0730;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * 나3을 하면 3의개수가 줄어들고 곱2를 하면 2의 개수가 늘어난다.
어떤수를 3으로 나누면
그 후에 나온수를 소인수분해했을 때 3의 개수는 줄어들거나 같을 수 밖에 없음.

4 = 2 ^ 2
8 = 2 ^ 3
6 = 2 * 3
3 = 3
12 = 2 ^ 2 * 3
9 = 3 ^ 2

즉, 이렇게 봤을 때 3의 개수가 가장 많은 9가 처음에 오게 된다.
소인수분해 시 3의 개수가 같을 때는 항상 오름 차순임.
왜냐하면 나3을 쓰면 3의 개수가 줄어들기 때문에 곱2 연산을 사용한게 자명하다. 곱2 연산은 다음 수가 커지기만 한다.
따라서 오름차순이다.

이렇게하면 정렬문제가 된다.
 * */
public class 나3곱2 {
	static class Num implements Comparable<Num> {
		int numOfThree;
		long realNum;
		public Num(int numOfThree, long realNum) {
			this.numOfThree = numOfThree;
			this.realNum = realNum;
		}

		@Override
		public int compareTo(Num comp) {
			if(comp.numOfThree == this.numOfThree) {
				return Long.compare(this.realNum, comp.realNum);
			}
			return Integer.compare(comp.numOfThree, this.numOfThree);
		}

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Num> list = new ArrayList<>();
		for(int i =0; i<N; ++i ) {
			long realNum = scan.nextLong();
			long temp = realNum;
			int numOfThree = 0;
			while(temp % 3 == 0) {
				temp /= 3;
				++numOfThree;
			}
			list.add(new Num(numOfThree, realNum));
		}

		Collections.sort(list);
		for(Num num : list) {
			System.out.print(num.realNum +" ");
		}
	}

}
