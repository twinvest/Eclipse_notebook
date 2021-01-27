package day0127;

import java.util.Scanner;

public class 알파벳_구글링재밌게푼코드 {
	static boolean inside(int y, int x) {
		return (y>=0 && y<R) && (x>=0 && x<C);
	}
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int[] alphabet = new int[26]; //A~Z
	static Character[][] map;
	static int R;
	static int C;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		map = new Character[R][C];
		for(int i = 0; i<R; ++i) {
			String line = scan.next();
			for(int j =0; j<line.length(); ++j) {
				map[i][j] = line.charAt(j);
			}
		}
		alphabet[(int)map[0][0]-65]++; //(0,0)지점 방문 체크
	    dfs(0,0,1);
	    System.out.println(ans);
	}

	static void dfs(int y,int x,int cnt){

	    ans=Math.max(ans,cnt);

	    for(int i=0;i<4;i++){
	        int ny=y+dy[i];
	        int nx=x+dx[i];

	        //방문체크
	        if(!inside(ny,nx))
	        	continue;

	        //이 코드의 아름다운점. 방문체크를 alphabet배열로하는것. 나는 visitList를 사용.
	        int k=(int)map[ny][nx]-65;
	        if(alphabet[k] > 0)
	            continue;

	        alphabet[k]++;  //백트래킹
	        dfs(ny,nx,cnt+1);
	        alphabet[k]--;  //백트래킹

	    }
	}

}
