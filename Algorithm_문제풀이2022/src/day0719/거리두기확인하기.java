package day0719;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
	static int[][] dir = {
	        {0,1},
	        {0,-1},
	        {1,0},
	        {-1,0}
	    };

	    static boolean inside(int y, int x){
	        return (y>=0 && y<5) && (x>=0 && x<5);
	    }

	    static class Pos{
	        int y;
	        int x;
	        int distance;
	        char status;
	        Pos(int y, int x, int distance, char status){
	            this.y=y;
	            this.x=x;
	            this.distance = distance;
	            this.status = status;
	        }
	    }

	    static char[][] map;
	    static boolean[][] visit;
	    static int startY;
	    static int startX;

	public static void main(String[] args) {
		String[][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
					{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
					{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
					{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
					{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}

		};
		int[] arr = solution(places);
		System.out.println(Arrays.toString(arr));
	}
	public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i =0; i<places.length; ++i){
            map = new char[5][5];
            visit = new boolean[5][5];

            for(int j =0; j<places[0].length; ++j) {
                String s = places[i][j];
                for(int k =0; k<5; ++k){
                    map[j][k] = s.charAt(k);
                }
            }

            boolean flag = true;
            for(int j =0; j<5; ++j){
                for(int k =0; k<5; ++k){
                    if(map[j][k] == 'P'){
                    	visit = new boolean[5][5];
                        startY = j;
                        startX = k;
                        if(!bfs(j,k)){
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag)
                    break;
            }
            answer[i] = flag == true ? 1 : 0;
        }

        return answer;
    }

    static boolean bfs(int y, int x) {

        visit[y][x] = true;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(y,x,0,'S'));
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.distance<=2 && cur.status == 'P'){
                return false;
            }
            if(cur.distance>2 && (cur.status == 'P' || cur.status == 'O')) {
            	return true;
            }


            for(int d =0; d<4; ++d) {
                int ny = cur.y + dir[d][0];
                int nx = cur.x + dir[d][1];
                if(!inside(ny,nx))
                    continue;
                if(map[ny][nx] == 'X')
                    continue;
                if(visit[ny][nx])
                	continue;
                if(map[ny][nx] == 'O' || map[ny][nx] == 'P'){
                    visit[ny][nx] = true;
                    if(map[ny][nx] == 'O'){
                        q.add(new Pos(ny,nx,Math.abs(startY - ny) + Math.abs(startX - nx), 'O'));
                    }else{
                        q.add(new Pos(ny,nx,Math.abs(startY - ny) + Math.abs(startX - nx), 'P'));
                    }

                }
            }
        }
        return true;
    }

}
