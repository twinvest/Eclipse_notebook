package 그리디;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 *
 * 비트마스킹 + 그리디
 * 아주 ㅈ되는 깔끔한 문제...오랜만에 전율을 느낀다잉
 *
 * */
public class 동전뒤집기 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

    	solution();
    }

    public static void solution() throws IOException {
        int ans = Integer.MAX_VALUE;
        //n이 3이면 0부터 7까지 for
        for(int bitCase = 0; bitCase<(1<<n);bitCase++){ // 행을 뒤집는 경우의 수
            int sum = 0;
            for(int j=0;j<n;j++){ // 열을 기준으로 뒤집기
                int count = 0;
                for(int i=0;i<n;i++){
                    char tmp = map[i][j];
                    if(( bitCase & (1<<i) ) != 0) { // 행뒤집기, i번째 행이 1이면 뒤집는다. ( &(AND) 연산자로 1여부를 판단 )
                        tmp = reverse(tmp); // 행을 뒤집는 경우의 수에 포함되는 행의 값이면 뒤집는다.
                    }
                    if(tmp == 'T')  count += 1;
                }
                sum += min(count,n-count); // 행을 뒤집은 결과로 열을 뒤집을지 결정 ( count : 안 뒤집는다. n-count : 뒤집는다. )
            }
            ans = min(ans,sum); // 행을 뒤집는 경우 중 최솟값이 답이다.
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static char reverse(char value){
        if( value=='T') return 'H';
        else return 'T';
    }
}