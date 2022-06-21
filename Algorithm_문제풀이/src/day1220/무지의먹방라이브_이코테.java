package day1220;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 무지의먹방라이브_효율성 {
	class Food {
		int time;
		int idx;
		Food(int t, int i){
			time = t;
			idx = i;
		}
	}
	//시간순으로 정렬
	Comparator<Food> CompTime = new Comparator<Food>() {
		@Override
		public int compare(Food a, Food b) {
			//return a.time - b.time; //오름차순정렬
			return Integer.compare(a.time, b.time);
		}
	};

	//음식순으로 정렬
	Comparator<Food> CompIdx = new Comparator<Food>() {
		@Override
		public int compare(Food a, Food b) {
			//return a.idx - b.idx; //오름차순정렬
			return Integer.compare(a.idx, b.idx);
		}
	};


	public static void main(String[] args) {
		int[] arr = { 8,6,4 };
		무지의먹방라이브_효율성 func = new 무지의먹방라이브_효율성();
		int ans = func.solution(arr, 15);
		System.out.println(ans);

	}

	public int solution(int[] food_times, long k) {

		List<Food> foods = new LinkedList<Food>();
		int n = food_times.length; //음식의 총 개수
		for(int i =0; i<n; ++i) {
			foods.add(new Food(food_times[i], i+1));
		}
		foods.sort(CompTime);
		int pretime = 0; //이전시간
		int i = 0;       //현재 몇번째인지
		for(Food f : foods) {
			long diff = f.time - pretime;
			if(diff != 0) {
				long spend = diff * n;
				if(spend <= k) {
					k -= spend;
					pretime = f.time;
				} else {
					k %= n;//남은 시간을 남은 음식의 개수로 나눈 나머짓값. ==> 이 부분을 생각하는게 넘 어려움.
					foods.subList(i, food_times.length).sort(CompIdx); //다시 원래순서로 리스트를 돌려놓음. 근데 그것도 i번째부터임. 즉, 이미 처리한 음식은 정렬안시킨다는말.
					return foods.get(i+(int)k).idx; //i에다가 k를 더해줌. 즉, 정렬시킨 다음의 원소부터 위에서 구해놓은 남은 시간을 남은 음식의 개수로 나눈 나머짓값을 더해줌.
				}
			}
			++i;
			--n;
		}

		return -1;
	}
}
