package 연습장;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class 해시맵해시셋 {

	public static void main(String[] args) {
		HashMap<String, Integer> hashmap = new HashMap<>();
		hashmap.put("taewoo", 1);
		hashmap.put("gilju", 2);
		hashmap.put("dowoon", 3);

		if(hashmap.containsKey("taewoo")) {
			System.out.println("taewoo란 키가 있음. 그 값은 "+hashmap.get("taewoo")+"입니다.");
			hashmap.put("taewoo", hashmap.get("taewoo")+1);
			System.out.println(hashmap.get("taewoo"));
		}

		System.out.println();
		System.out.println();

		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);

		//set에는 index를 통해 get()할수 있는 방법이 없다.
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(set.toString());
		System.out.println(set.contains(1));
		System.out.println(set.contains(4));
	}

}
