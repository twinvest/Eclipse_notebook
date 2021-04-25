package day0422;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
/*
 *
 * 구글링코드. 덱쓰는거 생각도 못함. 아직도 접근법 ㅈㄴ기가막히네...
 * 핵심은 순차적으로 숫자를 보면서
 * 배열에서 큰게 등장하면 기존 자릿수에서 교체하고 작은게 등장하면 하나를 넣어서 자릿수를 창출함.
 * 이렇게하면 작은게 나와서 자릿수를 창출했더라도 배열을 훑으면서 결국 큰수로 교체됨.
 * 만약, 내림차순으로 4321 같은 배열이 들어와도 마지막 while문에서 걸래냄.
 * https://steady-coding.tistory.com/54
 *
 * */
public class 크게만들기_구글링 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		String num = scan.next();
		char[] arr = num.toCharArray();
		Deque<Character> dq = new ArrayDeque<>();
		for(int i =0; i<arr.length;++i) {
			//덱의 맨 뒤의 값이 arr[i]보다 작으면 dq의 마지막을 삭제.
			while(K>0 && !dq.isEmpty() && dq.getLast()<arr[i]) {
				dq.removeLast();
				K--;
			}
			dq.addLast(arr[i]);
		}
		StringBuilder ans = new StringBuilder();
		while(dq.size() > K) {
			ans.append(dq.removeFirst());
		}
		System.out.println(ans.toString());
	}
}