package day0613;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 야구공모양ㅋ {
	static int N;
    static int[][] players; // N번째 이닝에서 타자의 행동
    static boolean[] select; // 아래 순열에서 사용될 boolean 타입 배열
    static int[] lineUp; // 타순
    static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st;
	        N = Integer.parseInt(br.readLine());

	        players = new int[N + 1][10];
	        for (int i = 1; i <= N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 1; j <= 9; j++) {
	                players[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }

	        select = new boolean[10];
	        lineUp = new int[10];

	        select[4] = true; // 4번 타자는 1번으로 고정되어있음.
	        lineUp[4] = 1;

	        ans = 0;
	        perm(2);

	        bw.write(ans + "\n");
	        bw.flush();
	        bw.close();
	        br.close();
	}

	// 순열
    public static void perm(int num) {
        if (num == 10) {
            playBaseBall();
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (select[i]) {
                continue;
            }
            select[i] = true;
            lineUp[i] = num;
            perm(num + 1);
            select[i] = false;
        }
    }

    static playBaseBall() {
    	int score = 0;
    	int start_player = 1;
    	int[] Base_state = new int[4];

    }

}
