interface Paintable {
	public void paint();
}

interface Drawable {
	public int PLAIN_PEN = 1;
	public int BOLD_PEN = 2;
	public int ITALIC_PEN = 3;
	
	public void draw();
	public void move(int x, int y);
}

interface Printable extends Paintable, Drawable {
	public void print();
}

class Circle implements Printable {
	public void draw() {
		System.out.println("�� �׸���!");
	}
	public void move(int x, int y) {
		System.out.println("�� �̵��ϱ�!");
	}
	public void paint() {
		System.out.println("�� ��ĥ�ϱ�!");
	}
	public void print() {
		System.out.println("�� ����ϱ�!");
	}
	
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle();
		c.draw();
		c.move(5, 5);
		c.paint();
		c.print();
	}

}
