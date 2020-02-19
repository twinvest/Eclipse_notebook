package day0219;

public class 십진수_쉬프트 {
	public static void main(String[] args) {
		String str = "0000000111100000011000000111100110000110000111100111100111111001100111";
		for(int i = 0; i < str.length(); i +=7) {
			String num = str.substring(i, i+7);
			int sum = 0;
			for(int j = 0; j < 7; j++) {
				sum += ((num.charAt(j) - '0') * (1<<(6-j)));
			}
			System.out.println(sum);
		}
	}
}