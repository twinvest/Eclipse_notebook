package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 연구소3 {
    static int[][] a;
    static int[][] d;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n, m;
    static ArrayList<Integer> candix = new ArrayList<>();;
    static ArrayList<Integer> candiy = new ArrayList<>();;
    static int ans = -1;
    static void bfs() {
        d = new int[n][n];
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = -1;
                if (a[i][j] == 3) {
                    q.add(i);q.add(j);
                    d[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (a[nx][ny] != 1 && d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.add(nx); q.add(ny);
                    }
                }
            }
        }
        int cur = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                //빈칸만 조사하기 위해서
            	if (a[i][j] == 0) { // 차이 3
                    if (d[i][j] == -1) return;
                    if (cur < d[i][j])
                    	cur = d[i][j];
                }
            }
        }
        if (ans == -1 || ans > cur) {
            ans = cur;
        }
    }
    static void go(int index, int cnt) {
        if (index == candix.size()) {
            if (cnt == m) {
                bfs();
            }
        } else {
            int x = candix.get(index);
            int y = candiy.get(index);
            a[x][y] = 3; //활성virus로 바꾼다.
            go(index+1, cnt+1);
            a[x][y] = 2; // 차이 2(연구소 2에서는 이를 0으로 바꿨지만 연구소3에서는 비활성virus로 바꾼다.)
            go(index+1, cnt);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2) {
                    // 차이 1 (연구소 2는 a[i][j] = 0; 이 적혀있음)
                    candix.add(i);
                    candiy.add(j);
                }
            }
        }
        go(0,0);
        System.out.println(ans);
    }
}