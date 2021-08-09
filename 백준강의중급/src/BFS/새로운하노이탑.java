package BFS;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class 새로운하노이탑 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[3]; //s[i] : i번 탑의 원판이 어떤 상태인지 보여준다.
        for (int i=0; i<3; i++) {
            int cnt = sc.nextInt();
            if (cnt > 0) {
                s[i] = sc.next();
            } else {
                s[i] = "";
            }
        }


        int[] cnt = {0, 0, 0}; //cnt[i] : i번 탑에 i번 원판의 개수. 즉, 우리가 구하고자 하는 모양이다. 나중에 밑에서 map안에서 키로써 정답을 찾으려고 사용하게 된다.
        for (String str : s) {
            for (char ch : str.toCharArray()) {
                cnt[ch-'A'] += 1;
            }
        }


        HashMap<List<String>, Integer> d = new HashMap<>();
        Queue<List<String>> q = new LinkedList<>();
        q.add(Arrays.asList(s));
        d.put(Collections.unmodifiableList(Arrays.asList(s)), 0);
        while (!q.isEmpty()) {
            String[] now = q.remove().toArray(new String[3]);

            //이동하는 방법은 총 여섯가지이다. A ==> B, A ==> C
            //                      B ==> A, B ==> C
            //                      C ==> A, C ==> B
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (i == j)
                    	continue;
                    if (now[i].length() == 0)
                    	continue;
                    String[] next = {now[0], now[1], now[2]};
                    next[j] += next[i].charAt(next[i].length()-1);      // i ==> j로 옮긴다.
                    next[i] = next[i].substring(0, next[i].length()-1); //i에서는 하나 없앤다.

                    List<String> key = Collections.unmodifiableList(Arrays.asList(next));
                    //만든 적이 없다면
                    if (d.containsKey(key) == false) {
                        d.put(key, d.get(Arrays.asList(now)) + 1);
                        q.add(Arrays.asList(next));
                    }
                }
            }
        }

        String[] ans = new String[3];
        for (int i=0; i<3; i++) {
            ans[i] = "";
            for (int j=0; j<cnt[i]; j++) {
                ans[i] += (char)('A'+i);
            }
        }
        System.out.println(d.get(Arrays.asList(ans)));
    }
}