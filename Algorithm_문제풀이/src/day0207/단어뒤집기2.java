package day0207;

import java.util.Scanner;
import java.util.Stack;

public class 단어뒤집기2 {

	public static void main(String[] args) {
		Stack<Character> s = new Stack<>();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] sub = str.split(" ");
		boolean flag = false;
		for(int i=0; i<sub.length; ++i)
		{
			for(int j =0; j<sub[i].length(); ++j)
			{
				if(sub[i].charAt(j) == '<' || flag)
				{
					flag = true;
					System.out.print(sub[i].charAt(j));
					while(true)
					{
						if(sub[i].charAt(j) == '>')
						{
							flag = false;
							break;
						}
						if(j+1 == sub[i].length()) break;
						System.out.print(sub[i].charAt(++j));
					}
				}
				else
				{
					while(true)
					{
						s.add(sub[i].charAt(j++));
						if(j == sub[i].length()) break;
						if(sub[i].charAt(j) == '<') break;
					}
					--j;
					while(!s.empty())
						System.out.print(s.pop());
				}
			}
			System.out.print(" ");
		}
	}
}