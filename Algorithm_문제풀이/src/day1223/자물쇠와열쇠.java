package day1223;

import java.util.Scanner;

public class 자물쇠와열쇠 {
	static int M,N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		M = scan.nextInt();
		N = scan.nextInt();
		int[][] key = new int[M][M];
		int[][] originKey = new int[M][M];
		int[][] lock = new int[N][N];
		int[][] originLock = new int[N][N];
		for(int i = 0; i<M; ++i) {
			for(int j = 0; j<M; ++j) {
				key[i][j] = scan.nextInt();
				originKey[i][j] = key[i][j];
			}

		}

		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				lock[i][j] = scan.nextInt();
				originLock[i][j] = lock[i][j];
			}

		}


		자물쇠와열쇠 main = new 자물쇠와열쇠();
		boolean ans = main.solution(key, lock);


	}

	public int[][] turnRight(int[][] key) {
		int[][] ret = new int[M][M];
		for(int r = 0; r<M; ++r) {
			for(int c = 0; c<M; ++c) {
				ret[c][N-1-r] = key[r][c];
			}
		}
	    return ret;
	}

	public void excuteJoin(int[][] key, int[][] lock) {
		for(int i = 0; i<M; ++i) {
        	for(int j = 0; j<M; ++j) {
            	System.out.print(key[i][j]+" ");
            }
        	System.out.println();
        }
	}

	public void print(int[][] key) {
		for(int i = 0; i<M; ++i) {
        	for(int j = 0; j<M; ++j) {
            	System.out.print(key[i][j]+" ");
            }
        	System.out.println();
        }
	}

	public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        //90도 회전 4번
        for(int i = 0; i<4; ++i) {
        	for(int c = 0; c<M; ++c) {

        	}



        }

        key = turnRight(key);



        return answer;
    }

}
