package day1230;

import java.util.ArrayList;
import java.util.Collections;

public class 외벽점검 {

	public static void main(String[] args) {
		int n = 12;
		int[] weak = {1,5,6,10};
		int[] dist = {1,2,3,4};
		외벽점검 main = new 외벽점검();
		int ans = main.solution(n, weak, dist);
	}

	public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        for(int i = 0; i<visit.length; ++i)
        	visit[i] = false;

        //시계방향
        for(int i = 0; i < weak.length; ++i) {
        	int start = i;
        	for(int k = 0; k<visit.length; ++k)
            	visit[k] = false;


        	for(int j = start; j<start+weak.length; ++j) {
        		int coverNum = j%weak.length;

        		if(visit[coverNum] == true) continue;

        		ArrayList<Integer> distList = new ArrayList<>();
                for(int num : dist)
                	distList.add(num);
                Collections.reverse(distList);

        		System.out.print(weak[j%weak.length]+",");
        		while(!distList.isEmpty()) {
        			int animal = distList.get(0);
        			while(true) {
        				if(visit[coverNum % weak.length]) {
        					coverNum++;
        					continue;
        				}

            			int cur = weak[coverNum % weak.length];
            			int next = weak[(coverNum+1)%weak.length];

            			if(animal >= next - cur) {
            				animal = animal - (next - cur);
            				visit[coverNum % weak.length] = true;
            				visit[coverNum+1 % weak.length] = true;
            			}
            			if(animal <= 0) {
            				distList.remove(0);
            				break;
            			}
            			++coverNum;
        			}
        		}
        		int ans = n - distList.size();
        		ansList.add(ans);
        		System.out.println();
        		System.out.println(ans);
        	}
        	System.out.println();
        }



        return answer;
    }
}
