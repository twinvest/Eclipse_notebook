package day0204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 실패율 {
	static class Stage implements Comparable<Stage> {
		int stage;
		double failPercent;
		public Stage(int stage, double failPercent) {
			this.stage = stage;
			this.failPercent = failPercent;
		}
		@Override
		public int compareTo(Stage o) {
			if(this.failPercent == o.failPercent) {
				return Integer.compare(this.stage, o.stage);
			}
			return Double.compare(o.failPercent, this.failPercent);
		}

	}
	public static void main(String[] args) {
		실패율 main = new 실패율();
		int[] stages = {4,4,4,4,4};
		int[] ans = main.solution(4, stages);
		System.out.println(Arrays.toString(ans));
	}

	public int[] solution(int N, int[] stages) {
        int size = stages.length;
		int[] arr = new int[N+1];
		int[] answer = new int[N];
		for(int i =0; i<stages.length; ++i) {
        	++arr[stages[i]-1];
        }
		ArrayList<Stage> list = new ArrayList<>();
		for(int i = 0; i<N; ++i) {
			double failPercent = (double)arr[i]/(double)size;
			//스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의한다.
			if(arr[i] == 0) {
				list.add(new Stage(i+1, 0.0));
			}
			//일반적인 경우
			else {
				list.add(new Stage(i+1, failPercent));
			}
			size = size - arr[i];
		}
        Collections.sort(list);
        for(int i = 0; i< list.size(); ++i) {
        	answer[i] = list.get(i).stage;
        }
		return answer;
    }
}
