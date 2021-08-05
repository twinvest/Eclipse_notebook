package BFS;
/*
 * 사실 이 문제는 bfs문제가 아니다.
 */

import java.util.Scanner;
public class 늑대와양 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
        }
        boolean ok = true;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                //양옆에 늑대가 있는지 확인
            	if (a[i].charAt(j) == 'S') {
                    for (int k=0; k<4; k++) {
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            //인접한 칸에 늑대발견
                        	if (a[x].charAt(y) == 'W') {
                                ok = false;
                            }
                        }
                    }
                }
            }
        }
        //위 for문에서 늑대발견시 바로 0 출력
        if (!ok) {
            System.out.println(0);
        }
        //그게 아니라면 그냥 모든 칸을 D로 바꾸자.
        else {
            System.out.println(1);
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i].charAt(j) == '.') {
                        System.out.print('D');
                    } else {
                        System.out.print(a[i].charAt(j));
                    }
                }
                System.out.println();
            }
        }
    }
}