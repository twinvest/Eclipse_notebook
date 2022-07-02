package day0131;

import java.util.Arrays;

public class 이차원배열조합 {
	/*
	 * 해당소스는 '연구소'와 '감시피하기'를 풀면서 이차원배열의 조합을 for문이 아닌 다른방식으로 풀 수 없을까를 고민하다가 찾아낸 소스이다.
	 * 즉, 2차원 배열에서의 조합을 구하는 소스이다.
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = new int[4][3];
		//solution1(map);
		solution2(map,0,0);
		//solution3(map,0,0);
	}
	static int cnt = 0;
	static void solution1(int[][] map) {
		int N = map.length;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
				} else {
					continue;
				}
				for(int k = 0; k < N; ++k) {
					for(int l = 0; l < N; ++l) {
						if(map[k][l] == 0 ) {
							map[k][l] = 1;
						} else {
							continue;
						}
						for(int m = 0; m < N; ++m) {
							for(int n = 0; n < N; ++n) {
								if(map[m][n] == 0) {
									map[m][n] = 1;
								} else {
									continue;
								}
								print(map);
								if(map[m][n] == 1) {
									map[m][n] = 0;
								}
							}
						}
						if(map[k][l] == 1) {
							map[k][l] = 0;
						}
					}
				}
				if(map[i][j] == 1) {
					map[i][j] = 0;
				}
			}
		}
	}

	static void solution2(int[][] map, int start, int depth) {
		int n = map.length;
		int m = map[0].length;
		if (depth == 3) {
			print(map);
			return;
		}

		for (int i = start; i < n * m; i++) {
			int x = i / m;
			int y = i % m;

			if (map[x][y] == 0) {
				map[x][y] = 1;
				solution2(map, i + 1, depth + 1);
				map[x][y] = 0;
			}
		}
	}

	static void solution3(int[][] map, int idx, int pick) {
		int N = map.length;
		int M = map[0].length;
		if (pick == 3) {
			print(map);
			return;
		}
		if (idx == N * M) {
			return;
		}
		int r = idx / M;
		int c = idx % M;
		if (map[r][c] == 0) {
			map[r][c] = 1;
			solution3(map, idx + 1, pick + 1);
			map[r][c] = 0;
		}
		solution3(map, idx + 1, pick);
	}

	static void print(int[][] map) {
		System.out.println(++cnt);
		for(int i = 0; i<map.length; ++i) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
