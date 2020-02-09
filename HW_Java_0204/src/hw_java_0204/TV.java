package hw_java_0204;

public class TV extends Product{
	private int inch;
	private String type;

	public TV() {
		super();
	}

	public TV(int id, String name, int price, int count, int inch, String type) {
		super(id, name, price, count);
		this.inch = inch;
		this.type = type;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TV [inch=" + inch + ", type=" + type + super.toString() + "]";
	}
}