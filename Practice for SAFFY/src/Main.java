public class Main {

	public static void main(String[] args) {
		Integer obj = new Integer(3);//박싱. 기본 자료형을 Wrapper클래스의 객체로 변환하는 과정
		int age = obj.intValue(); //언박싱. 각각의 객체를 기본 자료형으로 변경하여 사용하는 과정.
		//참고로 intValue는 Wrapper클래스의 기본 메소드이다. 이것외에도 doubleValue/floatValue/longValue/booleanValue 기타 등등이 있다.
		System.out.println(age);
	}
}
