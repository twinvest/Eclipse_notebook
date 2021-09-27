package DP;

import java.util.Scanner;

public class 이동하기 {

	public static void main(String[] args) {
		method1();
		method2();
		method3();
		method4();
	}

	static void method1() {
		//dp[i][j] = (1,1)에서 시작해서 (i,j)에 도착하는 최댓값
		//즉, dp[i][j] = max(dp[i-1][j-1], dp[i-1][j], dp[j-1][i]) + A[i][j]
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n+1][m+1];
        int[][] d = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                d[i][j] = Math.max(Math.max(d[i-1][j],d[i][j-1]), d[i-1][j-1]) + a[i][j];
            }
        }
        System.out.println(d[n][m]);
	}


	static void method2() {
		//method1에서는 어디서부터 왔는지를 기록했다.
		//method2에서는  (i,j)까지 채웠고 그 다음 오른쪽으로 이동하는것, 아래로 이동하는것, 대각선으로 이동하는것을 채워나가는 방법이다.
		//method1과 method2에 dp배열에 채워지는값에 차이는 전혀 없다. 왜냐하면 정의가 같으니까.
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n+1][m+1];
        int[][] d = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        d[1][1] = a[1][1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (j+1 <= m && d[i][j+1] < d[i][j] + a[i][j+1]) {
                    d[i][j+1] = d[i][j] + a[i][j+1];
                }
                if (i+1 <= n && d[i+1][j] < d[i][j] + a[i+1][j]) {
                    d[i+1][j] = d[i][j] + a[i+1][j];
                }
                if (i+1 <= n && j+1 <= m && d[i+1][j+1] < d[i][j] + a[i+1][j+1]) {
                    d[i+1][j+1] = d[i][j] + a[i+1][j+1];
                }
            }
        }
        System.out.println(d[n][m]);
    }

	static void method3() {
		//문제의 연산과 조건(A[i][j] >= 0)을 활용한 방법이다.
		//잘 생각해보면 대각선이동은 처리할 필요가 없다.
		/*
		 * 1 ㅇ    1 2
		 * ㅇ 2    ㅇ  3
		 *
		 * 1 ㅇ    1  ㅇ
		 * ㅇ 2  2 3
		 *
		 * 대각선 이동은 다른 2가지 방법보다 항상 작거나 같다.
		 *
		 *
		 *
		 * */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n+1][m+1];
		int[][] d = new int[n+1][m+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				d[i][j] = Math.max(d[i-1][j],d[i][j-1]) + a[i][j]; //오른쪽하고 아래만 따져준다.
			}
		}
		System.out.println(d[n][m]);

	}



	static int[][] a;
    static int[][] d;
    public static int go(int x, int y) {
        if (x < 1 || y < 1) {
            return 0;
        }
        if (d[x][y] >= 0) {
            return d[x][y];
        }
        d[x][y] = Math.max(go(x,y-1), go(x-1,y)) + a[x][y];
        return d[x][y];
    }
	static void method4() {
		//지금까지는 dp방식의 bottom-up방식이었다.
		//이제 top-down방식의 재귀로 바꿔보자.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[n+1][m+1];
		d = new int[n+1][m+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				a[i][j] = sc.nextInt();
				d[i][j] = -1;
			}
		}
		System.out.println(go(n,m));
	}



	static int n;
    static int m;
    public static int go2(int x, int y) {
        if (x > n || y > m) {
            return 0;
        }
        if (d[x][y] >= 0) {
            return d[x][y];
        }
        d[x][y] = Math.max(go(x+1,y),go(x,y+1)) + a[x][y];
        return d[x][y];
    }
	static void method5() {
		//dp[i][j] = (i,j)에서 시작해서 (N,M)도착
		/*
		 *
		 *                        ====>(x+1, y)  ==>(N,M)
		 * (1, 1)  ...  ==> (x,y)
		 *                        ====>(x, y+1)  ==>(N,M)
		 *
		 *
		 * */
		Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n+1][m+1];
        d = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                a[i][j] = sc.nextInt();
                d[i][j] = -1;
            }
        }
        System.out.println(go2(1,1));

	}


}
