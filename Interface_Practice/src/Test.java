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
		System.out.println("원 그리기!");
	}
	public void move(int x, int y) {
		System.out.println("원 이동하기!");
	}
	public void paint() {
		System.out.println("원 색칠하기!");
	}
	public void print() {
		System.out.println("원 출력하기!");
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
