package 수학;
/*
 *
 * 나중에 다시 도전해보자...
 *
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class 제곱ㄴㄴ {
    static final int MAX = 100000;
    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean[] c = new boolean[MAX+1];
    static int calc(int index, long num, long m) {
        if (index >= primes.size()) return 0;
        int ans = 0;
        if (num*primes.get(index) > m) return 0;
        ans += m/(num*primes.get(index));
        ans += calc(index+1, num, m);
        ans -= calc(index+1, num*primes.get(index), m);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=2; i<=MAX; i++) {
            if (c[i])
            	continue;
            primes.add(i*i);
            for (int j=i+i; j<=MAX; j+=i) {
                c[j] = true;
            }
        }

        int n = sc.nextInt();
        long left = 0;
        long right = 2147483647;
        long ans = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = (int)mid - calc(0, 1, mid); // 제곱ㄴㄴ수의 개수 = 범위 - 제곱수로 나누어 떨어지는 수의 개수
            if (cnt >= n) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        System.out.println(ans);
    }
}