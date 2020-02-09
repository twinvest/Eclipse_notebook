package day0209;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class 비밀번호 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int t=1; t<=10; ++t)
		{
			ArrayList<Character> list = new ArrayList<>();
			Stack<Character> s = new Stack<>();
			int length = scan.nextInt();
			String str = scan.next();
			for(int i=0; i<str.length(); ++i)
			{
				char tmp = str.charAt(i);
				if(s.empty())
					s.add(tmp);
				else
				{
					if(s.peek() == tmp)
						s.pop();
					else
						s.add(tmp);
				}
			}
			while(!s.empty())
				list.add(s.pop());
			System.out.print("#"+t+" ");
			for(int i=list.size()-1; i>=0; --i)
				System.out.print(list.get(i));
			System.out.println();
		}
	}
}
