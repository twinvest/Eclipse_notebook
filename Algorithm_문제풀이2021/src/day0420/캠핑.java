package day0420;

import java.util.Scanner;

public class 캠핑 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCaseNum = 1;
		while(true) {
			int ans = 987654321;
			int L = scan.nextInt();
			int P = scan.nextInt();
			int V = scan.nextInt();
			if(L == 0 && P == 0 && V ==0 ) {
				break;
			}
			boolean flag = true;
			int recurNum = V / P; //반복횟수
			int remainNum = V % P; //반복후에 남은 일수

			//2 8 20, 3 5 19같은 반례를 위해 넣음...
			int num = 0;
			if(remainNum > L) {
				flag = false;
				int progress = L;
				int stop = P-L;
				while(remainNum > 0) {
					remainNum = remainNum - progress;
					remainNum = remainNum - stop;
					++num;
					break;
				}
			}

			if(flag) {
				ans = (recurNum * L) + remainNum ; //반복횟수에 L을 곱해주고 반복 후 남은  일수를 더해주면 그게 정답.
			} else {
				ans = (recurNum * L) + (num * L);
			}


			System.out.println("Case "+testCaseNum+": "+ans);
			++testCaseNum;
		}
	}

}
