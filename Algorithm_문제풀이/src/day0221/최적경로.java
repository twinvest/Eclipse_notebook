package day0221;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 최적경로 {
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static boolean[] visit;
	static ArrayList<Pos> list;
	static int minvalue;
	static Stack<Integer> s;
	static Pos home;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for (int t = 1; t <= testcase; ++t) {
			s = new Stack<>();
			minvalue = 987654321;
			list = new ArrayList<>();
			int numOfcustomer = scan.nextInt();
			visit = new boolean[numOfcustomer];
			int x = scan.nextInt();
			int y = scan.nextInt();
			Pos company = new Pos(y, x);
			x = scan.nextInt();
			y = scan.nextInt();
			home = new Pos(y, x);
			for(int i=0; i<numOfcustomer; ++i)
			{
				x = scan.nextInt();
				y = scan.nextInt();
				list.add(new Pos(y, x));
			}
			perm(0,0,company); //ó���� �� company�� �Ѱ��� ������ �ϱⰡ �������. �׸��� perm(0,0,0)�� �Ѱ�µ�, �̶� ��������
							   //curdist += Math.abs(list.get(i).y - list.get(prev).y) + Math.abs(list.get(i).x - list.get(prev).x); �� �κп��� ������ ������ ��.
			                   //�� ������ ������ �� 1�� testcase�� 5���� ���� ���ؼ� ������ ���� ª�� �Ÿ��� ���غ��� �͵� �ǹ�������.
			                   //��, 01234 ~ 43210�� �湮�����߿� ���� ª�� ��θ� ���Ͻÿ�. �����߿� �� �غ���.
			System.out.println("#"+t+" "+minvalue);
		}

	}
	static void perm(int idx, int curdist, Pos prev)
	{
		if(idx == list.size())
		{
			curdist += Math.abs(prev.y - home.y) + Math.abs(prev.x - home.x);
			/* �湮��� �� �̾ƺ��� �ڵ�~~
			if(minvalue > curdist)
			{
				ArrayList<Integer> tmp = new ArrayList<>();
				minvalue = curdist;
				while(!s.isEmpty())
				{
					tmp.add(s.pop());
				}
				for(int i = tmp.size()-1; i>=0; --i)
				{
					System.out.print(tmp.get(i) + " ");
					s.push(tmp.get(i));
				}
				System.out.println("�̹��ҿ��� min = " + curdist);
				System.out.println();
			}*/
			minvalue = Math.min(curdist, minvalue);
			return;
		}
		for(int i=0; i<list.size(); ++i)
		{
			//if(i == idx && i != 0) continue;
			if(!visit[i])
			{
				visit[i] = true;
				//s.push(i);
				curdist += Math.abs(list.get(i).y - prev.y) + Math.abs(list.get(i).x - prev.x);


				perm(idx+1, curdist, list.get(i));


				curdist -= Math.abs(list.get(i).y - prev.y) + Math.abs(list.get(i).x - prev.x);
				//s.pop();
				visit[i] = false;
			}
		}
	}
}