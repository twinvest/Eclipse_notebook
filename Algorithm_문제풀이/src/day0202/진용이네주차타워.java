package day0202;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 진용이네주차타워 {
	static int parksize, numOfcar;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			Queue<Integer> q = new LinkedList<>();
			int sum = 0;
	        int[] parkingArea = new int[101]; //주차장
	        int[] parkingAreaprice = new int[101]; //i번째 주차공간의 단위 무게당 가격
	        int[] carWeight = new int[2001]; //차량의 무게
	        int[] order=new int[4001];
	        parksize = scan.nextInt();
	        numOfcar = scan.nextInt();

	        //주차장의 사이즈만큼 i번째 주차공간의 단위 무게당 가격을 입력받음
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
	            //i번째 순서가 0보다 크면서 주차장이 비어있으면
	            if (curCar > 0 && isEmpty_parkingArea(parkingArea))
	            {
	                //비어 있는 공간 중 가장 빠른 인덱스를 찾아서 차를 댄다.
	                for (int j = 1; j <= parksize; ++j)
	                {
	                    if (parkingArea[j] == 0)
	                    {
	                        parkingArea[j] = curCar;
	                        //그리고 차를 대자마자 요금을 징수한다.
	                        sum += parkingAreaprice[j] * carWeight[curCar];
	                        break;
	                    }
	                }
	            }
	            //i번째 순서가 0보다 작으면
	            else if (curCar < 0)
	            {
	                //주차 되어있던 차를 뺀다.
	                //그런데 만약 여기서 차를 뺐는데 큐에 대기하던 차가 있다면 그 차를 빼서 빈자리에 바로 집어넣는다.
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
	            //주차장이 가득차있는데 i번째 순서가 0보다크면
	            else if (curCar > 0 && !isEmpty_parkingArea(parkingArea))
	            {
	                //큐에서 대기한다.
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
