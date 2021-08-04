package day0804;

import java.util.Scanner;

public class A화살표B_다르게풀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        for(int i = 1; a<=b; ++i) {
        	if(a==b) {
        		System.out.println(i);
        	}
        	if(b%10 == 1) {
        		b = (b-1) / 10;
        	} else if ( b%2 == 0) {
        		b = b/2;
        	}else {
        		break;
        	}
        }
        System.out.println(-1);
	}
}
