package day0130;

public class �κ����� {
	static int[] arr = {1,2,3};
	static boolean[] sel;
	public static void main(String[] args) {
		sel = new boolean[arr.length];
		powerset(0, 0);
	}
	
	//��� �κ������� ���� ����Ѵ�.
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
	//������ Ʈ�� ���δ� �׷���. ������ ����뵵 ���� �Ǵµ� �� �ڵ带 ���������� ���ظ��ϰ� ����.
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