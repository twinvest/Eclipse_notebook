package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 거울설치 {
	static class Pair {
	    int x, y;
	    Pair(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] map = new String[n];
        int[][] b = new int[n][n]; //거울에 번호를 매겨준다. b[i][j] = 2 ==> i,j번위치의 2번 거울.
        ArrayList<Pair> v = new ArrayList<>();
        int start=-1, end=-1;
        for (int i=0; i<n; i++) {
        	map[i] = sc.next(); //맵을 입력받음.

            for (int j=0; j<n; j++) {
                char ch = map[i].charAt(j);
                //문도 거울처럼 번호를 매겨준다.
                if (ch == '#') {
                	//첫번째 문
                    if (start == -1) {
                        start = v.size();
                    }
                    //두번째 문
                    else {
                        end = v.size();
                    }
                    v.add(new Pair(i,j)); //위치를 v에 넣어줌. 즉, v.get(i)에는 i번 거울의 위치가 들어있음.
                    b[i][j] = v.size()-1;
                } else if (ch == '!') {
                    v.add(new Pair(i,j));
                    b[i][j] = v.size()-1;
                }
            }
        }

        int m = v.size();
        boolean[][] a = new boolean[m][m]; //a[i][j] ==> i번 거울에서 j번 거울로 이동할 수 있는지 이동할 수 있으면 true
        for (int i=0; i<v.size(); i++) {
            for (int k=0; k<4; k++) {
                int nx = v.get(i).x + dx[k];
                int ny = v.get(i).y + dy[k];
                while (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    char ch = map[nx].charAt(ny);
                    if (ch == '*') break;
                    //거울이나 문이 있으면 true
                    if (ch == '!' || ch == '#') {
                        a[i][b[nx][ny]] = true;
                    }
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }


        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[m];
        Arrays.fill(dist,-1);
        q.add(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int i=0; i<m; i++) {
                //now에서 i로 갈 수 있고 i를 방분한 적이 없다면
            	if (a[now][i] && dist[i] == -1) {
                    dist[i] = dist[now]+1;
                    q.add(i);
                }
            }
        }
        //-1을 하는 이유는 거울을 네 개 거치면 선은 3개이기 때문에
        System.out.println(dist[end]-1);
    }
}
