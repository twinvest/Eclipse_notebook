package 수학;
/*
 * i 2진수표현      j 시프트연산자 결과    2진수표현
 * 1  0001    0   1<<0 = 1    0001
 * 2  0010    1   1<<1 = 2    0010
 * 3  0011    2   1<<2 = 4    0100
 * 4  0100
 * 5  0101
 * 6  0110
 * 7  0111
 *
 *
 * &연산자는 두 비트가 모두 1일때만 1로된다.
 * 0 & 0 = 0
 * 0 & 1 = 0
 * 1 & 0 = 0
 * 1 & 1 = 1
 *
 *
 * */
public class 비트마스크부분집합만들기 {

	public static void main(String[] args) {
		int[] set = new int[] { 1, 2, 3};
		int cnt = 0;
		for (int i = 1; i < (1 << set.length); i++) {
			for (int j = 0; j < set.length; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(set[j]);
				}
			}
			System.out.println();
		}

	}

}


