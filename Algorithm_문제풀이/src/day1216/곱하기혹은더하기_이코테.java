package day1216;

import java.util.Scanner;

public class 곱하기혹은더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int sum = Integer.parseInt(str.charAt(0)+"");

		for( int i = 1; i< str.length(); ++i) {
			/*큰 구조는
			if( 0이거나 1이면 ) {
			            더하기
			} else (그 경우가 아니면) {
			          무조건 곱하기
			}
			*/
			if(str.charAt(i) == '0' || str.charAt(i) == '1') {
				sum += Integer.parseInt(str.charAt(i)+"");
			} else {
				//바로 직전숫자가 0이면 예외처리~현재숫자를 곱하는게 아니라 더해준다.
				if(i-1 >= 0  && str.charAt(i-1) == '0' ) {
					sum += Integer.parseInt(str.charAt(i)+"");
					continue;
				}
				sum *= Integer.parseInt(str.charAt(i)+"");
			}
		}
		System.out.println(sum);
	}

}
