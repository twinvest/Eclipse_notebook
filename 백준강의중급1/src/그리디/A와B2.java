package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A와B2 {

    public static String S, T;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);
        System.out.println(answer);
        br.close();
    }

    public static void dfs(String t) {
        // 1. T 문자열의 맨뒤가 A 일 경우 A 를 제거
        // 2. T 문자열의 맨앞이 B일 경우 문자열을 뒤집고 맨 뒤의 B를 제거
        int lenT = t.length();
        // S와 문자열의 길이가 같아질 때까지 반복
        if (lenT == S.length()) {
            if (t.equals(S)) {
                answer = 1;
            }
            return;
        }
        // 1. T 문자열의 맨뒤가 A 일 경우 A 를 제거
        if (t.endsWith("A")) {
            dfs(t.substring(0, lenT - 1));
        }
        // 2. T 문자열의 맨앞이 B일 경우 문자열을 뒤집고 맨 뒤의 B를 제거
        if (t.startsWith("B")) {
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}