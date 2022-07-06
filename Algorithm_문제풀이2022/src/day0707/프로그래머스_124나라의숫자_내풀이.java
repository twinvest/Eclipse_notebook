package day0707;

public class 프로그래머스_124나라의숫자_내풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(11);
	}
	static int[] arr = {1,2,4};
    static int[] sel;
    static void perm(int depth){

        if(depth == sel.length){
            ++s;

            if(s == target){
                String answer = "";
                for(int i : sel){
                    answer += i+"";
                }
                ans = answer;
            }
            //System.out.println(Arrays.toString(sel));
            return;
        }

        for(int i =0; i<3; ++i){
            sel[depth] = arr[i];
            perm(depth+1);
            sel[depth] = -1;
        }

        return;
    }

    static int target;
    static long s;
    static String ans;
    static public String solution(int n) {

        int x = 0;
        long num = 0;
        while(true){
            ++x;
            num += (long)Math.pow(3,x);
            if(n <= num){
                break;
            }
        }

        sel = new int[x];
        long start = num - (long)Math.pow(3,x);
        target = n;
        s = start;
        perm(0);
        String answer = ans;
        return answer;
    }
}
