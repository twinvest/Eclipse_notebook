package day0208;

import java.util.Scanner;
import java.util.Stack;

public class 단어뒤집기2 {

	public static void main(String[] args) {
		Stack<Character> s = new Stack<>();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
			for(int j =0; j<str.length(); ++j)
			{
				if(str.charAt(j) == '<')
				{
					System.out.print(str.charAt(j));
					do
					{
						System.out.print(str.charAt(++j));
					}while(str.charAt(j) != '>');
				}
				else
				{
					while(true)
					{
						s.add(str.charAt(j++));
						if(j == str.length()) break;
						if(str.charAt(j) == '<') break;
					}
					--j;
					while(!s.empty())
						System.out.print(s.pop());
				}
			}
			System.out.print(" ");
		}
	}