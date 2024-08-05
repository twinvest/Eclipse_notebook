package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 대회OR인턴 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int K = Integer.parseInt(split[2]);
        int answer = 0;

        // 2명의 여학생과 1명의 남학생이 팀을 결성
        // 현재 여학생이 2명 이상이고 남학생이 1명 이상이여서 한팀을 결성할 수 있다
        // 이때 팀을 결성하면 총 인원에서 3명이 빠지고 또한 K명을 또 빼야한다
        // 즉, 총 인원에서 K명을 인턴에 보내고 나머지 인원들 중
        // 3명으로 팀을 만들 수 있는지 확인
        while (N >= 2 && M >= 1 && (N + M) - K >= 3) {
            answer++;
            N -= 2;
            M--;
        }
        System.out.println(answer);
        br.close();
    }
}