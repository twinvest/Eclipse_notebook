package day0702;

public class 비밀지도 {

	public static void main(String[] args) {
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30, 1, 21, 17, 28};

		//String a = Integer.toBinaryString(28);
		//System.out.println(a);
		String[] s = solution(5, arr1, arr2 );
		for(String str :s) {
			System.out.println(str);
		}
	}
	//static Stack<Integer> s = new Stack<>();

    public static String[] solution(int n, int[] arr1, int[] arr2) {

        String str1 = "";
        String str2 = "";
        String[] answer = new String[n];
        String s = "";

        for(int j =0; j<arr1.length; ++j){
            str1 = Integer.toBinaryString(arr1[j]);
            str2 = Integer.toBinaryString(arr2[j]);
            while(str1.length() != n) {
            	str1 = "0" + str1;
            }
            while(str2.length() != n) {
            	str2 = "0" + str2;
            }

            for(int i =0; i<n; ++i)
            if(str1.charAt(i) == '1' || str2.charAt(i) == '1') {
        		s += "#";
        	}else if(str1.charAt(i) == '0' && str2.charAt(i) == '0') {
        		s +=" ";
        	}
        	if(s.length() % n == 0) {
        		answer[j] = s;
        		s = "";
        	}

        }
        return answer;
    }

}
