package day0208;

public class Calc {
	static int calcIndex(int N)
	{
		int sum = 5;
		if(N==3 || N==1) return 1;
		if(N==5) return 5;

		int base = 5;
		int index = 0;
		while(base != N)
		{
			base +=2;
			++index;
		}

		for(int i =1; i<=index; ++i)
		{
			sum += (4 * (i+1));
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = calcIndex(5);
		System.out.println(num);
	}

}
