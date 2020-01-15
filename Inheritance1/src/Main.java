class SuperClass
{
	int num1;
	//super클래스에 매개변수가 있는 생성자를 정의했기 때문에 기본 생성자가 자동으로 제공되지 않음
	public SuperClass(int num) {
		System.out.println("super생성자!");
		num1 = num;
	}
}
class SubClass extends SuperClass
{
	int num2;
	public SubClass() { //부모클래스에 '기본 생성자'가 없기 때문에 컴파일되지 않음.
		System.out.println("sub생성자!");
		num2 = 10000;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass sub = new SubClass();
		System.out.println(sub.num1);
		System.out.println(sub.num2);
	}

}
