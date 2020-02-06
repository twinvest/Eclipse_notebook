package day0206;
import java.util.Scanner;
public class �����̺��̱� {
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

		//������ ������ �ٲٱ�
		for(int len=5;len>=1;len--)
		{
			//���� ���� �������� ������ 0�̰ų� ������ �ʰ��ϸ�
			if(paper[len] == 0 || x+len > 10 || y+len > 10)
			{
				continue;
			}


			//�����̸� ���� �� �ִ��� Ȯ��
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

			//���� �� ������ �ٽ� ����� �ٲٷ� for������ ����
			if(flag == false)
			{
				continue;
			}

			//���⸦ �� �����Դܰ� �����̸� ���� �� �ִٴ� ����. ���� ���´�. ���°� 0���� ǥ��
			for(int i=0;i<len;i++)
			{
				for(int j=0;j<len;j++)
				{
					map[y+i][x+j] = 0;
				}
			}
			//�������� ����� �� �ִ� �������� ������ �ϳ� ���̰�
			paper[len]--;
			//�����̸� ��������� cnt�� �ϳ� �ø��°���
			cnt++;
			//�ϴ� ���� �������ϱ� �������� �����
			sol(y, x+1);


			//��Ʈ��ŷ. ��, ���� ���� ���ƿ��� ����. �ٽÿ������ 1�� ���������
			for(int i=0;i<len;i++)
			{
				for(int j=0;j<len;j++)
				{
					map[y+i][x+j] = 1;
				}
			}
			//����� �� �ִ� �������� ������ �ٽ� �����·�
			paper[len]++;
			//cnt�� �ٽ� �������
			cnt--;
		}
	}
}