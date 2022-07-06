package day0707;

public class 프로그래머스_124나라의숫자_구글링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans = solution(11);
		System.out.println(ans);
	}

    static public String solution(int n) {
    	String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        while(num > 0){
            int remainder = num % 3;
            num /= 3;

            if(remainder == 0) num--;

            answer = numbers[remainder] + answer;
        }

        return answer;
    }
}
