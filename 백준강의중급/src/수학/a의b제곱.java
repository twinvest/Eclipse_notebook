package 수학;

/*
 *
 * a^b란 a x a x a ... x a이다. 즉, a를 b번 곱한것.
 *
 * int ans = 1;
 * for(int i = 1; i<=b; ++i){
 *     ans = ans * a;
 * }
 *
 * 이렇게 구할 수 있다. 직관적인 방법이지만, O(b)라는 시간이 걸리게 된다. 조금 더 빠른 방법이 없을까?
 * 1. 재귀를 이용한 분할정복
 * 2. 이진수를 이용해 풀기
 *
 * */

public class a의b제곱 {

	public static void main(String[] args) {
		System.out.println(calc1(2,5));
		System.out.println(calc2(2,10));
	}

	//calc(a, b)는 a^b를 리턴한다.
	static public int calc1(int a, int b) {
		//b가 짝수 일 때 : a^b = a^b/2 * a^b/2
		//b가 홀수 일 때 : a^b = a * a^b-1
		//이렇게 하면 시간복잡도가 O(logb)
		if(b == 0) {
			return 1; //a^0 = 1
		} else if( b == 1 ) {
			return a; //a^1 = a
		} else if ( b%2 == 0 ) { //b가 짝수인 경우
			int temp = calc1(a, b/2);
			return temp * temp;
			//retrun calc(a, b/2) * calc(a, b/2); 이딴식으로 구현하면 안됨. O(b)로 다시 돌아간다.
			//그런데, 컴파일러 최적화에 의해 같은 값을 뱉는 함수는 두번실행되지 않는다는 상식도 알아둬...
		} else { //b가 홀수인 경우
			return a * calc1(a, b-1);
		}
	}

	//O(logb)
	static public int calc2(int a, int b) {
		//3^27을 생각해보자. 27은 이진수로 11011이다.
		//11011이 의미하는 바는 2^4 + 2^3 + 2^1 + 2^0이다.
		//즉, 이것은 3^(16+8+2+1)이다.
		//이것은 3^16 * 3^8 * 3^2 * 3^1 와도 같은 식이다.
		int ans = 1;
		while(b>0) {
			if(b%2 == 1) {
				ans *= a;
			}
			a = a*a; //  3 ==> 3^2 ==> 3^4 ==> 3^8 ==> 3^16
			b = b/2; // 27 ==> 13  ==>  6  ==>  3  ==>  1
			         //11011  1101     110     11       1
		}
		return ans;
	}

}
