package day1225;

import java.util.Scanner;

public class 자물쇠와열쇠 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N, M;
		N = scan.nextInt();
		M = scan.nextInt();
		int[][] key = new int[M][M] ;
		int[][] lock  =new int[N][N];
		for(int i = 0; i<M; ++i) {
			for(int j = 0; j<M; ++j) {
				key[i][j] = scan.nextInt();
			}
		}
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				lock[i][j] = scan.nextInt();
			}
		}

		자물쇠와열쇠 main = new 자물쇠와열쇠();
		boolean ans = main.Solution(key, lock);
		System.out.println(ans);
	}

	public boolean Solution(int[][] key, int[][] lock) {
		int N = lock.length;
		int M = key.length;
		//확장된 lock만들기
		int[][] spandLock = new int[N*3][N*3];
		for(int i = N; i<(2*N); ++i) {
			for(int j = N; j < (2*N); ++j) {
				spandLock[i][j] = lock[i-N][j-N];
			}
		}

		for(int d = 0; d<4; ++d) {
			//90도 회전
			key = turnRight(key);
			for(int i = 0; i <2*N; ++i) {
				for(int j = 0; j <2*N; ++j) {
					for(int k = i; k < i+M; ++k) {
						for(int l = j; l < j+M; ++l) {
							//attatch
							spandLock[k][l] += key[k-i][l-j];
						}
					}
					if(excuteJoin(key, spandLock, N))
						return true;
					for(int k = i; k < i+M; ++k) {
						for(int l = j; l < j+M; ++l) {
							//attatch
							spandLock[k][l] -= key[k-i][l-j];
						}
					}
				}
			}
		}
		return false;
	}


	public int[][] turnRight(int[][] key) {
		int M = key.length;
		int[][] ret = new int[M][M];
		for(int r = 0; r<M; ++r) {
			for(int c = 0; c<M; ++c) {
				ret[c][M-1-r] = key[r][c];
			}
		}
	    return ret;
	}


	public boolean excuteJoin(int[][] key, int[][] spandLock, int N) {
		for(int i = N; i<(2*N); ++i) {
			for(int j = N; j < (2*N); ++j) {
				if(spandLock[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
