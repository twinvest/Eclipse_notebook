package day1218;
//정확성통과코드, 효율성은 통과못함. 즉, 그리디로 풀어야한다는말.
public class 무지의먹방라이브 {
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1};
		int ans = solution(arr, 20);
		System.out.println(ans);
	}

	public static int solution(int[] food_times, long k) {
        int[] arr = food_times;
		int time = 0;
        int index = 0;
        int maxIndex = arr.length;
        while(true) {
        	if(time == k) break;
        	if(arr[index%maxIndex] != 0) {
        		--arr[index%maxIndex];
        		++time;
        		++index;
        	} else {
        		++index;
        	}
        	boolean flag = true;
            for(int i :arr) {
            	if(i != 0)
            		flag =false;
            }
            if(flag) return -1;
        }

        while(arr[index%maxIndex] == 0) {
    		++index;
    	}
        return (index % maxIndex) +1;
    }
}