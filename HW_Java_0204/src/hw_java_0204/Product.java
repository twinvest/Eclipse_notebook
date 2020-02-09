package hw_java_0204;

public class Product {
	private int id;
	private String name;
	private int price;
	private int count;

	public Product() {}

	public Product(int id, String name, int price, int count) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return ", id=" + id + ", name=" + name + ", price=" + price + ", count=" + count;
	}

}