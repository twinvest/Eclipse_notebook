package day0514;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 소코반 {
	static int[][] dir = {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0}
	};

	static boolean inside(int y, int x) {
		return (y>=0 && y<R) && (x>=0 && x<C);
	}
	static class Pos{
		int y; int x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}


	static int R,C;
	static char[][] map;
	static ArrayList<Pos> targetList;
	static int testCase = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			targetList = new ArrayList<>();
			R = scan.nextInt();
			C = scan.nextInt();
			if(R == 0 && C==0) {
				break;
			}

			map = new char[R][C];
			int curY = 0;
			int curX = 0;

			for(int i =0; i<R; ++i) {
				String s = scan.next();
				for(int j =0; j<C; ++j) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '+') {
						targetList.add(new Pos(i,j));
					}
					if(map[i][j] == 'w') {
						map[i][j] = '.';
						curY =i;
						curX =j;
					}
					if(map[i][j] == 'W') {
						targetList.add(new Pos(i,j));
						map[i][j] = '+';
						curY =i;
						curX =j;
					}
					if(map[i][j] == 'B') {
						targetList.add(new Pos(i,j));
					}
				}
			}

			String cmdLine = scan.next();
			Queue<Character> q = new LinkedList<>();
			for(int i =0; i<cmdLine.length(); ++i) {
				q.add(cmdLine.charAt(i));
			}
			boolean flag = false;
			while(!q.isEmpty()) {
				//완료했을시에는 명령어를 그냥 무시한다.
				if(flag) {
					q.poll();
				} else {
					char cmd = q.poll();
					int[] nynx = next(curY, curX, cmd);
					int ny = nynx[0];
					int nx = nynx[1];
					if(inside(ny,nx)) {

						//캐릭터에게 지시한 방향이 빈 칸(박스나 벽이 아닌 곳)인 경우에는 그 칸으로 이동
						if(map[ny][nx] == '.') {
							curY = ny;
							curX = nx;
						}
						else if(map[ny][nx] == '+') {
							curY = ny;
							curX = nx;
						}
						//지시한 방향에 박스가 있는 경우에는, 박스를 민다. 이 경우에는 박스가 이동할 칸도 비어있어야 한다.
						else if(map[ny][nx] == 'b') {
							int nny = next(ny,nx,cmd)[0];
							int nnx = next(ny,nx,cmd)[1];
							//박스 놓을곳이 비어있는지 확인
							if(inside(nny,nnx) && map[nny][nnx] == '.') {
								map[ny][nx] = '.';
								map[nny][nnx] = 'b';
								curY = ny;
								curX = nx;
							}
							//박스 놓을곳이 만약에 +일 경우
							else if(inside(nny,nnx) && map[nny][nnx] == '+') {
								map[ny][nx] = '.';
								map[nny][nnx] = 'B';
								curY = ny;
								curX = nx;
							}
						}
						//지시한 방향에 박스가 있는 경우에는, 박스를 민다. 이 경우에는 박스가 이동할 칸도 비어있어야 한다.
						else if(map[ny][nx] == 'B') {
							int nny = next(ny,nx,cmd)[0];
							int nnx = next(ny,nx,cmd)[1];
							if(inside(nny,nnx) && map[nny][nnx] == '.') {
								map[ny][nx] = '+';
								map[nny][nnx] = 'b';
								curY = ny;
								curX = nx;
							}
							if(inside(nny,nnx) && map[nny][nnx] == '+') {
								map[ny][nx] = '+';
								map[nny][nnx] = 'B';
								curY = ny;
								curX = nx;
							}
						}
						flag = check();
					}


				}
			}

			if(map[curY][curX] == '+') {
				map[curY][curX] = 'W';
			}else {
				map[curY][curX] = 'w';
			}

			String msg = "";
			if(flag) {
				msg+= "complete";
			}else {
				msg+= "incomplete";
			}
			System.out.println("Game "+(++testCase)+": "+msg);
			for(int i=0; i<R; ++i) {
				for(int j=0; j<C; ++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}


	}

	static boolean check() {
		int cnt = 0;
		for(Pos cur : targetList) {
			if(map[cur.y][cur.x] == 'B')
				++cnt;
		}
		return cnt == targetList.size() ? true : false;
	}
	static int[] next(int curY, int curX, char cmd) {
		int ny=0;
		int nx=0;
		int[] nynx = new int[2];
		if(cmd == 'U') {
			ny = curY + dir[3][0];
			nx = curX + dir[3][1];
		}
		else if(cmd == 'D') {
			ny = curY + dir[1][0];
			nx = curX + dir[1][1];
		}
		else if(cmd == 'L') {
			ny = curY + dir[2][0];
			nx = curX + dir[2][1];
		}else if(cmd == 'R') {
			ny = curY + dir[0][0];
			nx = curX + dir[0][1];
		}
		nynx[0] = ny;
		nynx[1] = nx;
		return nynx;
	}
}
