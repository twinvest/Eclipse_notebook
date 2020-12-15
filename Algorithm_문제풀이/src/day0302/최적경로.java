package day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {
	static int N;
	static int min, CX, CY, HX, HY;
	static int[][] customers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; ++t)
		{
			N = Integer.parseInt(in.readLine());
			customers = new int[N][2]; // [i][0] : x좌표 , [i][1] : y좌표
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			CX = Integer.parseInt(st.nextToken());
			CY = Integer.parseInt(st.nextToken());
			HX = Integer.parseInt(st.nextToken());
			HY = Integer.parseInt(st.nextToken());

			//고객집 좌표
			for(int i=0; i<customers.length; ++i)
			{
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			go(0, 0, CX, CY, 0);
			System.out.println("#"+t+" "+min);
		}
	}

	//순열코드
	private static void go(int count, int visited, int bx, int by, int result)
	{
		//가지치기 : 기존까지 순열로 처리 중인 고객집들까지 이동했던 거리가 기존 min값 보다 크다면 더이상 고객집을 방문해도 이동거리는 커질 수 밖에 없으므로 가지치기를 진행!
		if(result >= min)
			return;

		//순열을 다 만든 기저조건
		if(count == N) {
			result += Math.abs(bx - HX) + Math.abs(by - HY);
			if(min > result)
				min = result;
			return;
		}
		for(int i=0; i<N; ++i) //모든 고객 집을 다 count 위치에 시도
		{
			if((visited & 1<<i) == 0) //visited & 1<<i : i고객집이 기존 순열에 처리되었는지 확인 : 0-> 처리 안됨 , 0아님 -> 처리되었음
			{
				// visited | (1<<i) : 기존 순열상태에 i 고객집 추가
				go(count+1, visited | (1<<i), customers[i][0], customers[i][1], result + Math.abs(bx - customers[i][0]) + Math.abs(by - customers[i][1]));
			}
		}
	}
}
