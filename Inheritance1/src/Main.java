class SuperClass
{
	int num1;
	//superŬ������ �Ű������� �ִ� �����ڸ� �����߱� ������ �⺻ �����ڰ� �ڵ����� �������� ����
	public SuperClass(int num) {
		System.out.println("super������!");
		num1 = num;
	}
}
class SubClass extends SuperClass
{
	int num2;
	public SubClass() { //�θ�Ŭ������ '�⺻ ������'�� ���� ������ �����ϵ��� ����.
		System.out.println("sub������!");
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
