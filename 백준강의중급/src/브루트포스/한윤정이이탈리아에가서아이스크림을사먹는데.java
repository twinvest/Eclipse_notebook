package 브루트포스;
import java.util.Scanner;

public class 한윤정이이탈리아에가서아이스크림을사먹는데 {
	static int[] sel =  new int[3];
	static int[][] arr = new int[201][201];
	static int N,M;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		for(int i =0; i<M; ++i) {
			int ice1 = scan.nextInt();
			int ice2 = scan.nextInt();
			arr[ice1][ice2] = 1;
			arr[ice2][ice1] = 1;
		}
		combination(1,0);
		System.out.println(ans);
	}
	static int ans = 0;
	static void combination(int idx, int s_idx) {
		if(sel.length == s_idx) {
			int a,b,c;
		    a=sel[0];
		    b=sel[1];
		    c=sel[2];

		    if(arr[a][b]==1||arr[b][c]==1||arr[c][a]==1){
		        return;
		    }
		    ++ans;
		    return;
		}
		if(idx == N+1) {
			return;
		}
		sel[s_idx] = idx;
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
	}
}