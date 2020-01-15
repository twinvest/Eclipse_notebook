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
				System.out.println("Àü¿øÀ»ÄÒ´Ù");
			}
			public void powerOff() {
				System.out.println("Àü¿øÀ»²ö´Ù");
			}
			public void volumeUp() {
				System.out.println("º¼·ýÀ» ³ôÀÎ´Ù");
			}
			public void volumeDown() {
				System.out.println("º¼·ýÀ» ³·Ãá´Ù");
			}
		});
	}
}
