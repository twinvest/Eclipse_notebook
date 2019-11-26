
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		String s= "predict : [0]\nprobability : [[0.963548 0.036452]]";
		System.out.println(s);
		
		String[] words1 = s.split(" ",0);
		for(String w : words1) {
			System.out.println(w);
		}
		
		
		
		char tw = s.charAt(1);
		String tw2 = tw+"";
		//String tw2 = s.substring(5,10);
		
		System.out.println(tw);
		System.out.println(tw2);
		tw2 = tw2+s;
	}

}
