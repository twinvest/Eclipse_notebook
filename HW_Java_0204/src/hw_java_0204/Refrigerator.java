package hw_java_0204;

public class Refrigerator extends Product {
	private long capacity;

	public Refrigerator() {
		super();
	}

	public Refrigerator(int id, String name, int price, int count, long capacity) {
		super(id, name, price, count);
		this.capacity = capacity;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Refrigerator [capacity=" + capacity + super.toString() + "]";
	}
}