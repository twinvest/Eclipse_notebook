package day0206;
import java.util.Scanner;
public class 색종이붙이기 {
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int[][] map = new int[10][10];
	static int result = Integer.MAX_VALUE;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				map[i][j] = sc.nextInt();
			}
		}

		sol(0, 0);

		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	public static void sol(int y, int x) {
		if(x == 10) {
			sol(y+1 , 0);
			return;
		}
		if(y == 10) {
			result = Math.min(result, cnt);
			return;
		}
		if(map[y][x] == 0) {
			sol(y, x+1);
			return;
		}

		//색종이 사이즈 바꾸기
		for(int len=5;len>=1;len--)
		{
			//만약 남은 색종이의 개수가 0이거나 범위를 초과하면
			if(paper[len] == 0 || x+len > 10 || y+len > 10)
			{
				continue;
			}


			//색종이를 덮을 수 있는지 확인
			boolean flag = true;
			label : for(int i=0;i<len;i++)
			{
				for(int j=0;j<len;j++)
				{
					if(map[y+i][x+j] == 0)
					{
						flag = false;
						break label;
					}
				}
			}

			//덮을 수 없으면 다시 사이즈를 바꾸러 for문으로 ㄱㄱ
			if(flag == false)
			{
				continue;
			}

			//여기를 잘 지나왔단건 색종이를 덮을 수 있다는 것임. 따라서 덮는다. 덮는건 0으로 표현
			for(int i=0;i<len;i++)
			{
				for(int j=0;j<len;j++)
				{
					map[y+i][x+j] = 0;
				}
			}
			//덮었으니 사용할 수 있는 색종이의 개수를 하나 줄이고
			paper[len]--;
			//색종이를 사용했으니 cnt를 하나 올리는거임
			cnt++;
			//일단 여긴 덮었으니까 다음으로 가즈아
			sol(y, x+1);


			//백트래킹. 즉, 모든걸 덮고 돌아왔을 때임. 다시원래대로 1로 돌려놓즈아
			for(int i=0;i<len;i++)
			{
				for(int j=0;j<len;j++)
				{
					map[y+i][x+j] = 1;
				}
			}
			//사용할 수 있는 색종이의 개수도 다시 원상태로
			paper[len]++;
			//cnt도 다시 원래대로
			cnt--;
		}
	}
}