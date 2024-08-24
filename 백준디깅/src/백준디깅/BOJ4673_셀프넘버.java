package 백준디깅;

public class BOJ4673_셀프넘버 {
	static boolean[] visit = new boolean[10001];
	public static void main(String[] args) {
		int num = 1;
		for(int i =1; i<=10000; ++i) {
			num = i;
			if(visit[i])
				continue;
			while(true) {
				num = makeSelfNumber(num);
				if(num > 10000)
					break;
				visit[num] = true;
			}
		}
		for(int i=1; i<=10000; ++i) {
			if(!visit[i])
				System.out.println(i);
		}

	}

	static int makeSelfNumber(int num) {
		String s = num +"";
		int sum = 0;
		for(int i=0; i<s.length(); ++i) {
			sum += Integer.parseInt(s.charAt(i)+"");
		}
		sum += num;
		return sum;
	}

}
