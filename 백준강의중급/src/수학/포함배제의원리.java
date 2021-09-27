package 수학;
import java.util.Scanner;

/*
 * 소수의 배수란 문제를 통해 포함배제의 원리를 공부해보자.
 * 100이하의 자연수 중 2와 3으로 나누어 떨어지는 수의 개수를 센다면
 * |2의배수| + |3의배수| - |2*3의배수|이다.
 *
 * 100이하의 자연수 중 2,3,5로 나누어 떨어지는 수의 개수를 센다면
 * |2의배수| + |3의배수| + |5의배수| - |2*3의배수| - |2*5의배수| - |3*5의배수| + |2*3*5의배수|
 *
 *
 *
 *
 * */
public class 포함배제의원리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        long ans = 0;
        for (int i=1; i<(1<<n); i++) { //비트마스크로 부분집합을 구한다.
            int cnt = 0;
            long p = 1;
            for (int j=0; j<n; j++) {
                if ((i&(1<<j))>0) { //j번째 소수를 포함시킬지 말지
                    p = p * a[j];     //p를 이용해 배수를 만들어준다.
                    cnt += 1;
                    if (p > m) {
                        cnt = -1;
                        break;
                    }
                }
            }
            if (cnt == -1) continue;
            if (cnt % 2 == 0) {
                ans -= (m/p);
            } else {
                ans += (m/p);
            }
        }
        System.out.println(ans);
    }
}