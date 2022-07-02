package 브루트포스;

import java.util.Scanner;

public class 로마숫자만들기 {
/*
 * 중복조합 또는 차량번호판1과 같은 완전탐색 방법으로는 풀 수 없다.
 * 왜냐하면 완전탐색의 경우 시간복잡도는 4^20으로 10조가 넘기때문이다.
 * 순서만 다른것은 의미가 없기때문에 N^4으로 접근가능하다. 즉, I가 몇 개 사용됐는지 V가 몇 개 사용됐는지...
 * 이때 I,V,X,의 개수를 알고 있다면, L의 개수도 알 수 있기때문에 N^3까지도 줄일 수 있다.
 *
 * */
/*
 * https://subin-programming.tistory.com/292     for문이 아닌 재귀로 푼 좋은 코드
 * */

	//L이 20번 나오는 경우 1000이 최대이기때문에 배열 크기를 다음과 같이 선언한다.
	//check[i] = 수 i를 만들었으면 true. 아니면 false.
	static boolean[] check = new boolean[50*20+1];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = 0; i <= N; ++i) { //I몇개 사용?
			for(int j = 0; j <= N-i; ++j) { //V몇개 사용?
				for(int k = 0; k <= N-i-j; ++k) { //X몇개 사용?
					int l = N-i-j-k; //L몇개 사용?
					int sum = i + 5*j + 10*k + 50*l;
					check[sum] = true;
				}
			}
		}
		int ans = 0;
		for(int i=1; i<=50*20; ++i) {
			if(check[i]) ++ans;
		}
		System.out.println(ans);

	}

}
