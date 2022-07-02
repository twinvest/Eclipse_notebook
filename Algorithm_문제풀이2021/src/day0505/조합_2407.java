package day0505;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class 조합_2407 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		ArrayList<Integer> list1 = new ArrayList<>(); //분자
		ArrayList<Integer> list3 = new ArrayList<>(); //분모
		ArrayList<Integer> list2 = new ArrayList<>(); //정제된 분모


		for(int i =1; i<=M; ++i) {
			list3.add(i);
			list1.add(N-(i-1));
		}

		//맨처음에 들어가기전에 합성수를 모두 소수로 만든다.
		for(int i = 0; i<list3.size(); ++i) {
			if(isPrime(list3.get(i)))
				list2.add(list3.get(i));
			else {
				int index = 2;
				while(true) {
					if(list3.get(i) % index == 0) {
						int temp = list3.get(i) / index;
						if(temp >= 2) {
							list3.remove(i);
							list3.add(i,index);
							list3.add(i,temp);
							--i;
							break;
						}
					}
					++index;
				}
			}
		}


		label :
			for(int i =0; i<list1.size(); ++i) {
				int child = list1.get(i);
				for(int j = 0; j<list2.size(); ++j) {
					int mom = list2.get(j);
					//나누려는 수가 1이면 remove
					if(mom == 1) {
						list2.remove(j);
						--j;
						continue;
					}
					//그렇지 않으면 실제로 나눠준다. 그리고 나눠진수를 list1에 다시 넣어준다. 그리고 list2에는 1을 넣어준다.
					if(child % mom == 0) {
						child /= mom;
						list1.remove(i);
						list1.add(i, child);
						--i;

						mom = 1;
						list2.remove(j);
						list2.add(j, mom);
						continue label;
					}
				}
			}

		BigDecimal ans = new BigDecimal(list1.get(0));
		for(int i =1; i<list1.size(); ++i) {
			ans = ans.multiply(new BigDecimal(list1.get(i)));
		}
		System.out.println(ans);
	}

	public static boolean isPrime(int num){
		for(int i=2; i<=num/2; i++){
			if(num % i == 0) return false;
		}
		return true;
	}
}
