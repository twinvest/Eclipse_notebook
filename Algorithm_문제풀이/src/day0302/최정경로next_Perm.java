package day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최정경로next_Perm {
	static int N, p[]; // N : 고객집수, p : 고객집의 순서를 만들 순열용배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; ++t)
		{
			N = Integer.parseInt(in.readLine());
			int[][] customers = new int[N][2]; //N명의 고객집좌표
			int[][] distance = new int[N+2][2]; //회사좌표(0), N명의 고객좌표(순열로 순서 결정:1-N), 집 좌표(N+1)
			p = new int[N];
			int min = Integer.MAX_VALUE;

			//0하고 N+1위치는 고정. 그 사이(1부터N)인 고객집을 순열로 돌리즈아~
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			distance[0][0] = Integer.parseInt(st.nextToken()); //회사
			distance[0][1] = Integer.parseInt(st.nextToken());
			distance[N+1][0] = Integer.parseInt(st.nextToken()); //집
			distance[N+1][1] = Integer.parseInt(st.nextToken());

			for(int i=0; i<N; ++i)
			{
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
				p[i] = i+1;
			}
			//p배열 = {1,2,3,4,5,....}
			//넥퍼호출 ==> 12354
			//넥퍼호출 ==> 12435

			do {
				//순열로처리
				for(int i=0; i<N; ++i)
				{
					distance[p[i]] = customers[i];
				}
				int temp = 0;
				for(int i=0; i<=N; ++i)
				{
					//앞집부터 뒷집(인접한 두 집 처리)
					temp += Math.abs(distance[i][0] - distance[i+1][0]);
					temp += Math.abs(distance[i][1] - distance[i+1][1]);
				}
				if(min > temp)
					min = temp;
			}while(nextPermutation());
			System.out.println("#"+t+" "+min);
		}
	}
	//boolean : true ==> 다음순열ok , false ==> 다음순열 생성불가(이미 제일 큰 순열)
	private static boolean nextPermutation()
	{
		//1. 뒤쪽부터 탐색하며 꼭대기(i) 찾기. (i-1과 j의 위치를 바꿀거니까!)
		int i = N-1;
		while(i>0 && p[i-1] >= p[i])
		{
			--i;
		}
		//while문을 빠져나왔을때는 두 가지임. i가 0이거나, 뒤에 조건 p[i-1] >= p[i]만족하지 못했거나
		if(i == 0) return false; //더 이상만든 순열이 없음.

		//2. 뒤쪽부터 탐색하며 교환할 큰 값(j)를 찾음
		int j = N-1;
		while(p[i-1] >= p[j]) --j;

		//3. i-1, j 위치값 변경;
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;

		//4. i위치부터 N-1(맨뒤)까지 내림차순형태의 숫자를 오름차순으로 가장 작은 수로 만들기 위해 정렬
		int k = N-1;
		while(i<k)
		{
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			++i;
			--k;
		}
		return true;
	}
}
