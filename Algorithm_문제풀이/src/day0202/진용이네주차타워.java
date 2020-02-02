package day0202;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class �����̳�����Ÿ�� {
	static int parksize, numOfcar;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			Queue<Integer> q = new LinkedList<>();
			int sum = 0;
	        int[] parkingArea = new int[101]; //������
	        int[] parkingAreaprice = new int[101]; //i��° ���������� ���� ���Դ� ����
	        int[] carWeight = new int[2001]; //������ ����
	        int[] order=new int[4001];
	        parksize = scan.nextInt();
	        numOfcar = scan.nextInt();

	        //�������� �����ŭ i��° ���������� ���� ���Դ� ������ �Է¹���
	        for (int i = 1; i <= parksize; ++i)
	        	parkingAreaprice[i] = scan.nextInt();
	 
	        for (int i = 1; i <= numOfcar; ++i)
	        	carWeight[i] = scan.nextInt();

	        for (int i = 1; i <= 2 * numOfcar; ++i)
	        {
	            int carnum = scan.nextInt();
	            order[i] = carnum;
	        }
	 
	        for (int i = 1; i <= 2 * numOfcar; ++i)
	        {
	            int curCar = order[i];
	            //i��° ������ 0���� ũ�鼭 �������� ���������
	            if (curCar > 0 && isEmpty_parkingArea(parkingArea))
	            {
	                //��� �ִ� ���� �� ���� ���� �ε����� ã�Ƽ� ���� ���.
	                for (int j = 1; j <= parksize; ++j)
	                {
	                    if (parkingArea[j] == 0)
	                    {
	                        parkingArea[j] = curCar;
	                        //�׸��� ���� ���ڸ��� ����� ¡���Ѵ�.
	                        sum += parkingAreaprice[j] * carWeight[curCar];
	                        break;
	                    }
	                }
	            }
	            //i��° ������ 0���� ������
	            else if (curCar < 0)
	            {
	                //���� �Ǿ��ִ� ���� ����.
	                //�׷��� ���� ���⼭ ���� ���µ� ť�� ����ϴ� ���� �ִٸ� �� ���� ���� ���ڸ��� �ٷ� ����ִ´�.
	                for (int j = 1; j <= parksize; ++j)
	                {
	                    if (parkingArea[j] == Math.abs(curCar))
	                    {
	                        parkingArea[j] = 0;
	                        if (!q.isEmpty())
	                        {
	                            parkingArea[j] = q.poll();
	                            //q.pop();
	                            sum += parkingAreaprice[j] * carWeight[parkingArea[j]];
	                            break;
	                        }
	                    }
	                         
	                }
	            }
	            //�������� �������ִµ� i��° ������ 0����ũ��
	            else if (curCar > 0 && !isEmpty_parkingArea(parkingArea))
	            {
	                //ť���� ����Ѵ�.
	                q.offer(curCar);
	            }
	        }
			
			System.out.println("#"+t+" "+sum);
		}
	}
	static boolean isEmpty_parkingArea(int park[])
	{
	    boolean flag;
	    for (int i = 1; i <= parksize; ++i)
	        if (park[i] == 0) 
	            return flag = true;
	    return flag = false;
	}
}
