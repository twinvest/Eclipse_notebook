package 브루트포스;
//https://dawninthemoon.tistory.com/72 이 블로그의 코드말고 그림을 볼것.
import java.util.Scanner;
public class 삼각형의값 {
	static int[][] a = new int[401][801];
	static int[][] s = new int[401][801];
	static int N, ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int tc = 1;; ++tc) {
			N = scan.nextInt();
			if(N == 0) break;
			ans = -987654321;
			for(int i=1; i<=N; ++i) {
				for(int j =1; j<=2*i-1; ++j) {
					a[i][j] = scan.nextInt();
					s[i][j] = s[i][j-1] + a[i][j];
				}
			}
			for(int i =1; i<=N; ++i) {
				for(int j = 1; j<=2*i-1; ++j) {
						calc(i,j,j,0);
				}
			}
			System.out.println(tc+". "+ans);
		}
	}

	//현재 가장 윗변(역삼각형) 또는 아랫변(제대로된 삼각형)이 row행이고
	//left와 right는 가장 왼쪽 삼각형의 열과 가장 오른쪽 삼각형의 열을 의미한다.(제대로된 삼각형의 열의 번호는 항상 홀수, 역삼각형의 열의 번호는 항상 짝수)
	//합은 sum인 삼각형을 의미한다.
	static void calc(int row, int left, int right, int sum) {
		//범위체크
		if(row < 1 || row > N) return;
		if(left < 1 || right > 2*row -1 ) return;

		sum += s[row][right] - s[row][left-1]; //left부터 right까지의 합을 계산.
		if(sum > ans) ans = sum;
		//역삼각형의 경우
		if(left % 2 == 0) {
			calc(row-1, left-2, right, sum);
		}
		//제대로된 삼각형의 경우
		else {
			calc(row+1, left, right+2, sum);
		}
	}

}
