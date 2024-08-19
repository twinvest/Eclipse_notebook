package 브루트포스;

import java.util.ArrayList;
import java.util.Scanner;
class CCTV {
    public int x, y, type, dir;
    CCTV(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.dir = 0; //90도로 몇번 회전했는가.
    }
}

public class 감시 {
    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {1,0,-1,0};
    static int ans = 64;
    static void check(int[][] a, int[][] b, int x, int y, int dir) {
        int n = a.length, m = a[0].length;
        int i = x, j = y;
        while (0 <= i && i < n && 0 <= j && j < m) {
            if (a[i][j] == 6)
            	break;
            b[i][j] = a[x][y];
            i += dx[dir];
            j += dy[dir];
        }
    }

    static int go(int[][] a, ArrayList<CCTV> cctv, int index) {
        if (index == cctv.size()) { //모든 CCTV의 방향을 결정하면 이 if문에 진입한다.
            int n = a.length, m = a[0].length;
            int[][] b = new int[n][m]; //원본 map을 복사할 b배열
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    b[i][j] = a[i][j];
                }
            }

            for (CCTV c : cctv) {
                int what = c.type;
                int x = c.x, y = c.y;
                int dir = c.dir;
                if (what == 1) {
                    check(a,b,x,y,dir);
                } else if (what == 2) {
                    check(a,b,x,y,dir);
                    check(a,b,x,y,(dir+2)%4);
                } else if (what == 3) {
                    check(a,b,x,y,dir);
                    check(a,b,x,y,(dir+1)%4);
                } else if (what == 4) {
                    check(a,b,x,y,dir);
                    check(a,b,x,y,(dir+1)%4);
                    check(a,b,x,y,(dir+2)%4);
                } else if (what == 5) {
                    check(a,b,x,y,dir);
                    check(a,b,x,y,(dir+1)%4);
                    check(a,b,x,y,(dir+2)%4);
                    check(a,b,x,y,(dir+3)%4);
                }
            }
            int cnt = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (b[i][j] == 0) {
                        cnt += 1;
                    }
                }
            }
            return cnt;
        }
        //index번째 CCTV의 방향을 결정하는 부분.
        for (int i=0; i<4; i++) {
            cctv.get(index).dir = i;
            int temp = go(a, cctv, index+1); //이제 index번째의 CCTV는 방향을 바꿨으니 그 다음 index+1번째 CCTV의 방향을 결정하러 재귀 타고ㄱㄱ
            if (ans > temp) {
                ans = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        ArrayList<CCTV> cctv = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] >= 1 && a[i][j] <= 5) {
                    cctv.add(new CCTV(i, j, a[i][j]));
                }
            }
        }
        System.out.println(go(a, cctv, 0)); //0번 CCTV부터 탐색을 시작한다.
    }
}