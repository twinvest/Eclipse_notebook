package day0212;

import java.util.ArrayList;
import java.util.Scanner;

public class 정올_종교 {
	static class Node
	{
		int num;
		ArrayList<Node> lists;
		Node(int num, ArrayList<Node> lists)
		{
			this.num = num;
			this.lists = lists;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Node> list = new ArrayList<>();
		int student = scan.nextInt();
		int numofpair = scan.nextInt();
		for(int k=0; k<numofpair; ++k)
		{
			int i = scan.nextInt();
			int j = scan.nextInt();

			if(list.isEmpty())
			{
				ArrayList<Node> lists = new ArrayList<>();
				lists.addAll(j, new ArrayList());
				list.add(new Node(i, lists));
			}
			else
			{
				for(int l=0; l<list.size(); ++l)
				{
					if(list.get(l).num == i)
					{
						list.get(l).lists.add(j, null);
					}


				}
			}
		}
		System.out.println(list.size());
	}

}
