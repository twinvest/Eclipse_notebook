package BFS;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 모양만들기 {
    static int n, m;
    static int[][] a;
    static int[][] group; //어떠 그룹에 속하는지
    static int[] group_size; //그룹의 크기
    static int groupn; //그룹의 개수
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    static void bfs(int sx, int sy) {
        groupn += 1; //새로운 그룹이 시작된거니 +1
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        group[sx][sy] = groupn;
        int cnt = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (group[nx][ny] == 0 && a[nx][ny] == 1) {
                        group[nx][ny] = groupn;
                        q.add(nx);
                        q.add(ny);
                        cnt += 1;
                    }
                }
            }
        }
        group_size[groupn] = cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        group = new int[n][m];
        group_size = new int[n*m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
            	//1인데 아직 그룹이 형성되지 않은 애들이면 탐색시작. 이건 방문체크도 동시에 할 수 있누?
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                //0을 1로 바꾸는 부분
            	if (a[i][j] == 0) {
                    HashSet<Integer> near = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            //인접한 곳이 1이면
                        	if (a[nx][ny] == 1) {
                                //그 그룹의 번호를 hashset에 넣는다.
                        		near.add(group[nx][ny]);
                            }
                        }
                    }
                    int sum = 1;
                    //hashset에서 그룹의 번호를 하나씩 빼본다.
                    for (int neighbor : near) {
                    	//그리고 그 그룹의 size를 더해준다.
                        sum += group_size[neighbor];
                    }
                    if (ans < sum) ans = sum;
                }
            }
        }
        System.out.println(ans);
    }
}