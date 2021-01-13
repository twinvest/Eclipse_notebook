package day0110;

import java.util.ArrayList;

public class 블록이동하기 {
	static class Pos{
		int y;
		int x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object obj) {
			Pos comparePos = (Pos)obj;
			if(this.y == comparePos.y && this.x == comparePos.x) {
				return true;
			}
			return false;
		}
	}
	static boolean[][] visit;
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static int min = 987654321;
	static boolean inside(int y,int x,int N) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}
	static int ans = 0;
	static ArrayList<Pos> posList = new ArrayList<>();
	public static void main(String[] args) {
		블록이동하기 block = new 블록이동하기();
		int[][] board = {
				{0,0,0,1,1},
				{0,0,0,1,0},
				{0,1,0,1,1},
				{1,1,0,0,1},
				{0,0,0,0,0}
		};
		int ans = block.solution(board);
		System.out.println(ans);
	}


	public int solution(int[][] board) {
        visit = new boolean[board.length][board.length];
        for(int i = 0; i<board.length; ++i) {
        	for(int j = 0; j<board.length; ++j) {
            	if(board[i][j] == 1) {
            		board[i][j] = -1;
            	}
            }
        }


        visit[0][0] = true;
        dfs(0,0, board, board.length);
        return ans;
    }

	static void dfs(int y, int x, int[][] board, int N) {
		if(y == N-1 && x == N-1 && min > board[y][x]) {
			min = Math.min(min, board[y][x]);
			ans = board[y][x] - 1;
			/*for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			int index = 0;
			for(Pos pos : posList) {
				++index;
				System.out.println("좌표"+ index + "["+pos.y+","+pos.x+"]");
			}*/
			return;
		}

		for(int d = 0; d<4; ++d) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			if(inside(ny,nx,N) && !visit[ny][nx] && board[ny][nx] == 0) {
				visit[ny][nx] = true;
				board[ny][nx] = board[y][x]+1;
				posList.add(new Pos(ny, nx));
				dfs(ny, nx, board, N);
				posList.remove(new Pos(ny, nx));
				board[ny][nx] = 0;
				visit[ny][nx] = false;
			}
		}
	}
}
