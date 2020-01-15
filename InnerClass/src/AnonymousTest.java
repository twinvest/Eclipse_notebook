abstract class TV {
	public abstract void powerOn();
	public abstract void powerOff();
	public abstract void volumeUp();
	public abstract void volumeDown();
}

public class AnonymousTest {
	public static void watchTV(TV tv) {
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		watchTV(new TV() {
			public void powerOn() {
				System.out.println("�������Ҵ�");
			}
			public void powerOff() {
				System.out.println("����������");
			}
			public void volumeUp() {
				System.out.println("������ ���δ�");
			}
			public void volumeDown() {
				System.out.println("������ �����");
			}
		});
	}
}
