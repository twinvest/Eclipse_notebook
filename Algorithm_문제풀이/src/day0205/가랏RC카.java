package day0205;

import java.util.Scanner;

public class °¡¶ùRCÄ« {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase=scan.nextInt();
		for(int t=1; t<=10; ++t)
		{
			int commandNum = scan.nextInt();
			int curSpeed =0;
			int curDist=0;
			for(int i=0; i<commandNum; ++i)
			{
				int command = scan.nextInt();
				if(command == 1)
				{
					int accel = scan.nextInt();
					curSpeed += accel;
					curDist += curSpeed;
				}
				else if(command == 0) 
				{
					curDist +=curSpeed;
				}
				else
				{
					int deaccel = scan.nextInt();
					curSpeed -= deaccel;
					if(curSpeed <= 0)
						curSpeed = 0;
					curDist += curSpeed;
				}
			}
			System.out.println("#"+t+" "+curDist);
		}
	}

}
