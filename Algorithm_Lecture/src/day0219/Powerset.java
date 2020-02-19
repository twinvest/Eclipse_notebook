package day0219;
public class Powerset {
	public static void main(String[] args) {
		String[] arr = {"A","B","C"};
		//부분집합의 개수만큼 반복. 부분집합의 개수는 2의 원소의개수만큼 제곱
		for(int i = 0; i < (1 << arr.length); i++) {
			//각각의 부분집합에 대해 식별자로 i를 쓰자. 0~7까지의 정수
			//각 원소가 포함되는지 검사
			for(int j = 0; j < arr.length; j++) {
				//오른쪽에서 j번째 원소가 포함되는지 검사할 비트는 1 << j
				if( (i & (1 << j) ) != 0) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}
	}
}
