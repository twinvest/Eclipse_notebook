package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {
	static class Pos{
		int currentNum;
		String operStr;
		Pos(int currentNum, String operStr){
			this.currentNum = currentNum;
			this.operStr = operStr;
		}
	}
	static int N, A, B;
	static String ans;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for(int i=0;i<N; ++i) {
			A = scan.nextInt();
			B = scan.nextInt();
			ans = "";
			visit  = new boolean[10000];
			bfs();
			System.out.println(ans);
		}
	}
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(A, ""));
		visit[A] = true;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.currentNum == B) {
				ans = cur.operStr;
				return;
			}

			for(int d=1; d<=4; ++d) {
				int nextNum = 0;
				String oper = "";
				if(d==1) {
					nextNum = operD(cur.currentNum);
					oper = "D";
				}
				else if(d==2) {
					nextNum = operS(cur.currentNum);
					oper = "S";
				}
				else if(d==3) {
					nextNum = operL(cur.currentNum);
					oper = "L";
				}
				else if(d==4) {
					nextNum = operR(cur.currentNum);
					oper = "R";
				}

				if(visit[nextNum])
					continue;

				visit[nextNum] = true;
				q.add(new Pos(nextNum, cur.operStr+oper));

			}
		}
	}

	static int operD(int num) {
		int strNum = num*2;
		if(strNum > 9999)
			strNum = strNum % 10000;
		return strNum;
	}

	static int operS(int num) {
		int strNum = num-1;
		if(num == 0)
			strNum = 9999;
		return strNum;
	}

	static int operL(int num) {
		String str = num+"";
		String resultStr = "";
		if(str.length()==1) {
			str = "000"+str;
		}
		if(str.length()==2) {
			str = "00"+str;
		}
		if(str.length()==3) {
			str = "0"+str;
		}
		resultStr = str.charAt(1)+"" + str.charAt(2)+"" + str.charAt(3)+"" + str.charAt(0)+"";
		return Integer.parseInt(resultStr);
	}

	static int operR(int num) {
		String str = num+"";
		String resultStr = "";
		if(str.length()==1) {
			str = "000"+str;
		}
		if(str.length()==2) {
			str = "00"+str;
		}
		if(str.length()==3) {
			str = "0"+str;
		}
		resultStr = str.charAt(3)+"" + str.charAt(0)+"" + str.charAt(1)+"" + str.charAt(2)+"";
		return Integer.parseInt(resultStr);
	}
}
