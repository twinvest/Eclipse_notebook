public class Main {

	public static void main(String[] args) {
		Integer obj = new Integer(3);//�ڽ�. �⺻ �ڷ����� WrapperŬ������ ��ü�� ��ȯ�ϴ� ����
		int age = obj.intValue(); //��ڽ�. ������ ��ü�� �⺻ �ڷ������� �����Ͽ� ����ϴ� ����.
		//����� intValue�� WrapperŬ������ �⺻ �޼ҵ��̴�. �̰Ϳܿ��� doubleValue/floatValue/longValue/booleanValue ��Ÿ ����� �ִ�.
		System.out.println(age);
	}
}
