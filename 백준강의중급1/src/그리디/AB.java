package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AB {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int aNum = 0;
        int bNum = 0;

        // A와 B의 개수를 구한다.
        // A+B == N
        for (int i = 0; i <= K; i++) {
            aNum = i;
            bNum = N - i;
            // 이때 만들 수 있는 쌍의 최대 갯수는
            // 모든 A가 앞에 있고 모든 B가 A 뒤에 위치할 때다
            // 이때 최대 갯수가 K보다 작다면 K개를 만들 수 없으므로
            // 다른 A 갯수, B 갯수를 찾는다
            if (aNum * bNum >= K) {
                break;
            }
            // 만들 수 없는 경우
            if (i == K) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        String[] answer = new String[N];
        Arrays.fill(answer, "B");

        // K가 0일 경우 N을 모두 B로 채운 문자열을 출력하면 된다.
        if (K == 0) {
            for (String s : answer) {
                System.out.print(s);
            }
            System.exit(0);
        }

        // A를 aNum - 1개 만큼 앞에서부터 채워준다.
        for (int i = 0; i < aNum - 1; i++) {
            answer[i] = "A";
        }
        // 이후 뒤에 A를 붙여보면
        // 예) AAABBBA가 된다.
        // 여기서 맨 뒤에 있는 A를 왼쪽으로 한칸씩 움직일 때마다
        // 만들 수 있는 쌍의 갯수가 + 1씩 늘어나며
        // 제일 왼쪽으로 가서 AAAABBB가 된다면
        // 가장 많이 만들 수 있는 쌍의 갯수가 된다.
        int currentTwins = (aNum - 1) * bNum;
        int haveMoveA = K - currentTwins;
        answer[N - 1 - haveMoveA] = "A";

        for (String s : answer) {
            System.out.print(s);
        }

        br.close();
    }
}