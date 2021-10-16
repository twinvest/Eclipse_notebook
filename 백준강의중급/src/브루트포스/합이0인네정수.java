package 브루트포스;
/*
 * 이 코드 해시맵을 쓰면 시간초과나는데, 부분수열의합2처럼 투포인터를 쓰면 시간초과 안남.
 *
 * https://subbak2.tistory.com/24
 * 이 블로그 코드하고 부분수열의합2코드하고 정확히 일치함.
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class 합이0인네정수 {
	static int[] a = new int[4000];
	static int[] b = new int[4000];
	static int[] c = new int[4000];
	static int[] d = new int[4000];
	static int[] first = new int[16000000];
	static int[] second = new int[16000000];
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());

        for (int i=0; i<n; i++) {
            String[] line = bf.readLine().split(" ");
            a[i] = Integer.valueOf(line[0]);
            b[i] = Integer.valueOf(line[1]);
            c[i] = Integer.valueOf(line[2]);
            d[i] = Integer.valueOf(line[3]);
        }

        int p=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                first[p] = a[i]+b[j]; //앞에 두개 더한것
                second[p] = c[i] + d[j]; //뒤에 두개 더한것
                p += 1;
            }
        }
        //Arrays.sort(second);
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : second) {
            if (map.containsKey(x)) {
                int temp = map.get(x);
                map.put(x, temp+1);
            } else {
                map.put(x, 1);
            }
        }

        for (int num : first) {
            if (map.containsKey(-num)) {
                ans += map.get(-num);
            }
        }

        System.out.println(ans);
    }
}