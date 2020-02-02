package day0130;

public class 부분집합 {
	static int[] arr = {1,2,3};
	static boolean[] sel;
	public static void main(String[] args) {
		sel = new boolean[arr.length];
		powerset(0, 0);
	}
	
	//모든 부분집합의 합을 출력한다.
	static void powerset(int idx, int sum) 
	{
		if( idx == arr.length ) 
		{
			System.out.println(sum);
			return;
		}
		powerset(idx + 1, sum + arr[idx]);
		powerset(idx + 1, sum);
	}
	//리컬전 트리 전부다 그려봄. 실제로 디버깅도 이제 되는데 이 코드를 직관적으로 이해못하고 있음.
	/*
	static void powerset(int idx) {
		if(idx == sel.length) 
		{
			for(int i = 0; i < sel.length; i++) 
			{
				if(sel[i])
					System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
	 
	}
	*/
}