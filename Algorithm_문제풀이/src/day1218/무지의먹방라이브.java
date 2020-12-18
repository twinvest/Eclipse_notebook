package day1218;

import java.util.Arrays;

public class 무지의먹방라이브 {
	public static void main(String[] args) {
		int[] arr = {946, 314, 757, 322, 559, 647, 983, 482, 145};
		int ans = solution(arr, 1833);
		System.out.println(ans);
	}

	public static int solution(int[] food_times, long k) {
        int time = 0;
        int maxIndex = food_times.length;
        int index = 0;
        while(true) {
        	if(time == k)
        		break;
        	++time;
        	System.out.println(index%maxIndex);
        	if(food_times[index%maxIndex] != 0) {
        		--food_times[index%maxIndex];
        	}else {
        		--food_times[++index%maxIndex];

        	}
        	++index;
        	System.out.println(Arrays.toString(food_times));
        }
        boolean flag = true;
        for(int i : food_times) {
        	if(i != 0) {
        		flag = false;
        		break;
        	}
        }
        if(flag == true) {
        	return -1;
        }
        return (index%maxIndex)+1;
    }
}
