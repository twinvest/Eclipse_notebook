package 수학;
/*
 *
 * N이하의 소수를 모두 구하는 알고리즘.
 * 소수의 정의 : 1과 자기자신으로만 나누어지는 수. 즉, 2~N-1로 나누어 떨어지지 않는 수.
 *
 * 제곱ㄴㄴ수 : 2*2, 3*3, ... 제곱수로 나누어 떨어지지 않는 수
 * 소수를 구하는 방법인 에라토스테네스의 체를 응용해서 풀 수 있다.
 * max - min의 차이가 문제에 명시되어 있듯이 1,000,000이기 때문에 배열을 이용할 수 있다. 이 조건때문에 문제를 풀 수 있다.
 * max, min <= 10^12
 *
 *
 *
 * ㄱ. 2^2 = 4이다. 즉, 4의 배수를 모두 지운다.
 * ㄴ. 3^2 = 9이다. 즉, 9의 배수를 모두 지운다.
 * ㄷ. 4^2 = 16이다. 즉, 16의 배수를 모두 지운다.
 * ㄹ. 5^2 = 25이다. 즉, 25의 배수를 모두 지운다.
 * ㅁ. 6^2 = 36이다. 즉, 36의 배수를 모두 지운다.
 *
 * 아래 코드는 백준의 '제곱ㄴㄴ수' 문제 코드이다.
 * */

import java.util.Scanner;
public class 에라토스테네스의체 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] check = new boolean[(int)(max-min)+1]; // check[i] = min + i가 지워졌으면 true. 아니면 false.

        //2의 제곱부터 제곱수가 max를 넘지 않을때까지. for문을 돌린다.
        for (long i=2; i*i <= max; i++) {
            long w = i*i-min%(i*i); //w는 min보다는 크면서 i^2의 배수를 의미한다.
            if (w == i*i) {
                w = 0;
            }
            while (w <= max-min) {
            	check[(int)w] = true;
                w += i*i;
            }
        }
        int ans = 0;
        for (int i=0; i<= max-min; i++) {
            if (check[i] == false) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}