package 브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *
 * https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-14500-%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8
    시간 복잡도: O(n^2)
    공간 복잡도: O(n^2)
    사용한 알고리즘: 백트래킹 (DFS)
    사용한 자료구조: 2차원 배열
 */

public class 테트로미노 {

    private static int n, m, a[][], result;
    private static Boolean check[][];
    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {-1, 1, 0, 0};

    private static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    private static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        check = new Boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                check[i][j] = false;
            }
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2. 계산
        // 2. 2차원 배열 각각의 원소에서 검사를 수행합니다.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                // 1) DFS 로 검사

                // 방문했던 점을 또 방문해야하기 때문에
                // 들어가기전 체크를 해주고, 끝났을때 체크를 해제해줍니다.
                check[i][j] = true;

                dfs(i, j, a[i][j], 1);

                // 체크를 해제하면 무한루프에 들어가 않을까 걱정할 수 있습니다.
                // 길이로 재귀를 중단시키기 때문에, 수행횟수는 4 * 3 * 3, 한점에서 최대 36번 수행됩니다.
                check[i][j] = false;

                // 2) ㅏ 모양 검사
                check_exshape(i, j);
            }
        }

        // 3. 출력
        System.out.println(result);
    }

    public static int max(int a, int b){
        return a > b ? a: b;
    }

    // DFS 로 4가지 모양 검사 (ㅜ 제외)
    public static void dfs(int x, int y, int sum_value, int length){
        // 길이가 4 이상이면 종료햅줍니다.
        if(length >= 4){
            result = max(result, sum_value);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 넘어가는 경우 검사
            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;

            // 방문하지 않은 점이면
            if(check[nx][ny] == false) {

                // 들어가기전 체크해주고
                check[nx][ny] = true;

                dfs(nx, ny, sum_value + a[nx][ny], length + 1);
                // 하나의 탐색을 완료하면 여기로 돌아옵니다.

                // 나올때 체크를 해제합니다.
                check[nx][ny] = false;
            }
        }
    }

    // ㅜ 모양 검사
    public static void check_exshape(int x, int y){

        for(int i=0; i<4; i++){

            Boolean isOut = false;
            int sum_value = 0;

            for(int j=0; j<4; j++){
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if(nx < 1 || nx > n || ny < 1 || ny > m) {
                    isOut = true;
                    break;
                }
                else {
                    sum_value += a[nx][ny];
                }
            }
            if(!isOut) {
                result = max(result, sum_value);
            }
        }
        // 만약 배열로 정보 저장 안해놓았으면 아래처럼 작성할 수 있습니다.

//    int sum_value = 0;
//    // 1. ㅜ
//    if(x>=1 && x+1<=n && y>=1 && y+2<=m){
//        sum_value = a[x][y] + a[x][y+1] + a[x][y+2] + a[x+1][y+1];
//        result = max(result, sum_value);
//    }
//
//    // 2. ㅏ
//    if(x >= 1 && x+2 <=n && y>=1 && y+1<=m){
//        sum_value = a[x][y] + a[x+1][y] + a[x+2][y] + a[x+1][y+1];
//        result = max(result, sum_value);
//    }
//
//    // 3. ㅗ
//    if(x-1 >= 1&& x <=n && y >=1 && y+2 <=m){
//        sum_value = a[x][y] + a[x][y+1] + a[x][y+2] + a[x-1][y+1];
//        result = max(result, sum_value);
//    }
//
//    // 4. ㅓ
//    if(x-1 >= 1 && x+1 <=n && y >=1 && y+1 <=m){
//        sum_value = a[x][y] + a[x][y+1] + a[x-1][y+1] + a[x+1][y+1];
//        result = max(result, sum_value);
//    }
    }
}