package day0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//완전 탐색 : 부분집합 ==> 조합
public class 벌꿀채취 {
	static int N, M, C;
	static int[][] map, maxMap;

	public static void main(String[] args) throws NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; ++t)
		{
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map =  new int[N][N];
			maxMap = new int[N][N];
		}
	}


	private static void makeMaxMap()
	{
		for(int i=0; i<N; ++i)
		{
			for(int j=0; j<=N-M; j++)
			{
				makeMaxSubset(i,j,0,0,0);
			}
		}
	}

	//cnt : 직전까지 고려한 원소 수, sum : 부분집합에 속한 원소의 합
	//powSum : 부분집합에 속한 원소의 이익
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum)
	{
		//가지치기
		if(sum>C) return; //부분집합의 합이 목표량 C를 초과하면 리턴
		//기저조건
		if(cnt == M)
		{
			//maxMap[i][j-M]는 재귀가 시작한  초기위치
			if(maxMap[i][j-M] < powSum)
			{
				maxMap[i][j-M] = powSum;
			}
			return;
		}
		//i,j위치 원소 선택
		makeMaxSubset(i,j+1,cnt+1, sum+map[i][j], powSum+(map[i][j]*map[i][j]));

		//i,j위치 원소 비선택
		makeMaxSubset(i,j+1,cnt+1, sum, powSum);
	}

	private static int getMaxBenefit()
	{
		int max =0, temp = 0; //max : 조합적 선택후의 최대이익값
		//1. 일꾼A 기준선택
		for(int i=0; i<N; ++i)
		{
			for(int j=0; j<=N-M; ++j) //a일꾼
			{
				//2. 일꾼b선택
				//같은행 기준 선택
				for(int j2 = j+M; j2<= N-M; j2++)
				{
					temp = maxMap[i][j] + maxMap[i][j2]; //두 일꾼 조합의 최대값
					if(max < temp)
						max = temp;
				}

				//다음행부터 마지막행까지 선택
				for(int i2 =i+1; i2<N; i2++)
				{
					for(int j2 = 0; j2 <= N-M; j2++)
					{
						temp = maxMap[i][j] + maxMap[i2][j2];
						if(max < temp)
							max = temp;
					}
				}
			}
		}

		return max;
	}

}
