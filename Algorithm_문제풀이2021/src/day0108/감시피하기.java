package day0108;

import java.util.Scanner;

//이문제를 보는 순간 2가지로 푸는 방법이 생각났다.
//1. 6중for문 ==> 쌉가능이라 생각했다. 왜냐하면 N의 최댓값이 6이기때문에 6^6 = 46,656개만 탐색하면된다.
//2. 2차원배열의 순열 ==> 이건 본적도 풀어본적도 구현해본적도 없지만 그냥 생각이 났다.
//1번이나 2번을 통해 장애물 3개를 세우고 마지막에 4방향으로 레이저를 쏘듯 조져준다.
//일단 6중 for문으로 풀고 2번방법으로 푼사람이 있는지 찾아보자.
public class 감시피하기 {
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static boolean inside(int y, int x, int n) {
		return (x>=0 && x<n) && (y>=0 && y<n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int numOfStudent = 0;
		String[][] map = new String[N][N];

		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				map[i][j] = scan.next();
				if(map[i][j].equals("S"))
					++numOfStudent;
			}
		}

		boolean ansFlag = false;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(map[i][j].equals("X")) {
					map[i][j] = "O";
				} else {
					continue;
				}
				for(int k = 0; k < N; ++k) {
					for(int l = 0; l < N; ++l) {
						if(map[k][l].equals("X")) {
							map[k][l] = "O";
						} else {
							continue;
						}
						for(int m = 0; m < N; ++m) {
							for(int n = 0; n < N; ++n) {
								if(map[m][n].equals("X")) {
									map[m][n] = "O";
								} else {
									continue;
								}

								String[][] tempMap = new String[N][N];
								tempMap = search(map);
								if(isAnswer(tempMap, numOfStudent)) {
									ansFlag = true;
								}

								if(map[m][n].equals("O")) {
									map[m][n] = "X";
								}
							}
						}
						if(map[k][l].equals("O")) {
							map[k][l] = "X";
						}
					}
				}
				if(map[i][j].equals("O")) {
					map[i][j] = "X";
				}
			}
		}

		if(ansFlag)
			System.out.println("YES");
		else
			System.out.println("NO");




	}
	static String[][] search(String[][] map){
		String[][] tempMap = new String[map.length][map.length];
		for(int i = 0; i<map.length; ++i) {
			for(int j = 0; j<map.length; ++j) {
				tempMap[i][j] = map[i][j];
			}
		}


		for(int i = 0; i<tempMap.length; ++i) {
			for(int j = 0; j<tempMap.length; ++j) {
				if(tempMap[i][j].equals("T")) {
					for(int d = 0; d<4; ++d) {
						int index = 1;
						while(true){
							int ny = i + (dir[d][0] * index);
							int nx = j + (dir[d][1] * index);
							if(inside(ny,nx,map.length) && !tempMap[ny][nx].equals("O")) {
								tempMap[ny][nx] = "K";
								++index;
							} else {
								break;
							}
						}
					}
				}
			}
		}
		return tempMap;
	}


	static boolean isAnswer(String[][] tempMap, int numOfStudent) {
		int num = 0;
		for(int i = 0; i<tempMap.length; ++i) {
			for(int j = 0; j<tempMap.length; ++j) {
				if(tempMap[i][j].equals("S"))
					++num;
			}
		}
		return num == numOfStudent ? true : false;
	}

}
