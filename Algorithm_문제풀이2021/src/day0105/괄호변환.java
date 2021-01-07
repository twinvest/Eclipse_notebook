package day0105;

import java.util.ArrayList;
import java.util.Stack;

public class 괄호변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		괄호변환 main = new 괄호변환();
		String answer = main.solution("(()())()");
		System.out.println(answer);

	}


	public String solution(String p) {
		String answer = "";
		answer = dfs(p);
		return answer;
	}

	public String dfs(String input) {
		if(input.length() == 0)
			return "";

		ArrayList<String> list = new ArrayList<>();
		int boundary = -1;
		for(int i = 0; i<input.length(); ++i) {
			list.add(input.charAt(i)+"");

			int left = 0;
			int right = 0;
			for(String str : list) {
				if(str.equals("(")) ++left;
				else ++right;
			}

			if(left == right) {
				boundary = i;
				break;
			}
		}
		String u = input.substring(0, boundary+1);
		String v = input.substring(boundary+1, input.length());

		//올바르지 않은 문자열이라면
		if(!isNested(u)) {
			String tempU = "";
			u = u.substring(1,u.length()-1);
			for(int index = 0; index < u.length(); ++index) {
				if(u.charAt(index) == '(')
					tempU += ")";
				else
					tempU += "(";
			}

			u = tempU;
			return "("+ dfs(v) +")" + u;
		} else {
			v = dfs(v);
			return u+v;
		}
	}

	public boolean isNested(String input) {
		Stack<Character> s = new Stack<>();
		for(int i = 0; i<input.length(); ++i) {
			if(input.charAt(i) == '(')
				s.push('(');
			else if(!s.isEmpty() && input.charAt(i) == ')')
				s.pop();
		}
		if(s.size() == 0)
			return true;
		return false;
	}

}
