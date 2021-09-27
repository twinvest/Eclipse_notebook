package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *
 * i 에서 상담을 하는 경우 i + T[i]일이 된다. (P[i]원을 더해준다)
 * i 에서 상담을 하지않는 경우 i + 1일이 된다. (0원을 더해준다)
 *
 * D[i] = i일까지 상담했을 때 얻는 최대수익
 *
 * */

public class 퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        int[] d = new int[n+50];
        for (int i=0; i<n; i++) {
            String[] temp = bf.readLine().split(" ");
            t[i] = Integer.parseInt(temp[0]);
            p[i] = Integer.parseInt(temp[1]);
        }

        for (int i=0; i<n; i++) {
            d[i+t[i]] = Math.max(d[i+t[i]],d[i]+p[i]); //상담을 하면 i일에서 i+T[i]일이 된다.
            d[i+1] = Math.max(d[i+1],d[i]);            //상담을 하지 않으면 i일에서 i+1일이 된다.
        }
        System.out.println(d[n]);
    }
}