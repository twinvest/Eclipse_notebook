package day0205;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		for(int t=1; t<=10; t++)
		{
			int testcase = scan.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int i =0; i<8; i++)
			{
				int num = scan.nextInt();
				q.add(num);
			}
			boolean flag = true;
			while(flag)
			{				
				for(int i =1; i<=5; ++i)
				{
					int num = q.poll();
					num -= i;
					if(num <= 0)
					{
						flag = false;
						num = 0;
						q.add(num);
						break;
					}
					q.add(num);
				}
			}
			System.out.print("#"+t+" ");
			while(!q.isEmpty())
				System.out.print(q.poll()+" ");
			System.out.println();
		}
	}
}
