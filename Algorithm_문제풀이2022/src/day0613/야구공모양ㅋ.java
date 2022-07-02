package day0613;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 야구공모양ㅋ {
	static int playerNum = 10;
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

    static void playBaseBall() {

    	int score = 0;
    	int start_player = 1;
    	int[] Base_state = new int[4];

    	//N이닝 동안 진행
    	for( int i = 1; i <= N; ++i ) {
    		int outCnt = 0;
    		boolean nextIning = false;
    		for(int k=0; k<4; ++k)
    			Base_state[k] = 0;

    		while(true) {
    			for(int j = start_player; j<playerNum; ++j) {
    				int player = players[i][lineUp[j]];

    				//아웃
    				if(player == 0) outCnt++;
    				//안타
    				else if(player == 1) {

    					for(int F=3; F>=1; F--) {
    						if(Base_state[F] == 1) {
    							if(F==3) {
    								Base_state[F] = 0;
    								score++;
    							} else {
    								Base_state[F+1] = 1;
    								Base_state[F] = 0;
    							}
    						}
    					}
    					Base_state[1] = 1;

    				}
    				//2루타
    				else if(player == 2) {
    					for(int F=3; F>=1; F--) {
    						if(Base_state[F] == 1) {
    							if(F==3 || F==2) {
    								Base_state[F] = 0;
    								score++;
    							} else {
    								Base_state[F+2] = 1;
    								Base_state[F] = 0;
    							}
    						}
    					}
    					Base_state[2] = 1;
    				}
    				//3루타
    				else if(player == 3) {
    					for(int F=3; F>=1; F--) {
    						if(Base_state[F] == 1) {
    							Base_state[F] = 0;
    							score++;
    						}
    					}
    					Base_state[3] = 1;
    				}
    				//홈런
    				else {
    					for(int F=1;F<=3; ++F) {
    						if(Base_state[F] == 1) {
    							Base_state[F] = 0;
    							score++;
    						}
    					}
    					score++;
    				}

    				if(outCnt == 3) {
    					start_player = j + 1;
    					if(start_player == playerNum) start_player = 1;
    					nextIning = true;
    					break;
    				}
    			}
    			if(nextIning)
    				break;
    			start_player = 1;
    		}
    	}
    	ans = Math.max(score, ans);
    }

}
