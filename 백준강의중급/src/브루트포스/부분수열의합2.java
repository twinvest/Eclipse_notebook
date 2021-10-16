package 브루트포스;
import java.util.Arrays;
import java.util.Scanner;

public class 부분수열의합2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        //절반으로 나누기
        int m = n/2; //뒤의 크기
        n = n-m;     //앞의 크기

        //앞에서 만들 수 있는 모든 부분수열의 합을 만들어서 first에 저장
        int[] first = new int[1<<n];
        for (int i=0; i<(1<<n); i++) {
            for (int k=0; k<n; k++) {
                if ((i&(1<<k)) == (1<<k)) { //(i&(1<<k))>0과 같은 표현
                    first[i] += a[k];
                }
            }
        }

        //뒤에서 만들 수 있는 모든 부분수열의 합을 만들어서 second에 저장
        int[] second = new int[1<<m];
        for (int i=0; i<(1<<m); i++) {
            for (int k=0; k<m; k++) {
                if ((i&(1<<k)) == (1<<k)) { //(i&(1<<k))>0과 같은 표현
                    second[i] += a[k+n];
                }
            }
        }
        //정렬수행
        Arrays.sort(first);
        Arrays.sort(second);
        n = (1<<n);
        m = (1<<m);
        //뒷부분은 내림차순으로 다시 정렬
        for (int i=0; i<m/2; i++) {
            int temp = second[i];
            second[i] = second[m-i-1];
            second[m-i-1] = temp;
        }
        int i = 0;
        int j = 0;
        long ans = 0;
        while (i < n && j < m) {
        	//합이 s와 같으면
            if (first[i] + second[j] == s) {
                long c1 = 1;
                long c2 = 1;
                i += 1;
                j += 1;
                //앞 부분 몇개가 같은지
                while (i < n && first[i] == first[i-1]) {
                    c1 += 1;
                    i += 1;
                }
                //뒷 부분 몇개가 같은지
                while (j < m && second[j] == second[j-1]) {
                    c2 += 1;
                    j += 1;
                }
                ans += c1*c2;
            }
            //합이 더 작으면
            else if (first[i] + second[j] < s) {
                i += 1; //앞 부분이동
            }
            //합이 더 크면
            else {
                j += 1; //뒷 부분이동
            }
        }
        if (s == 0) ans -= 1;

        System.out.println(ans);
    }
}