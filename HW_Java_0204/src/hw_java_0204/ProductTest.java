package hw_java_0204;

public class ProductTest {

	public static void main(String[] args) {

		ProductMgr man = new ProductMgr();
		man.insert(11, "Tizen", 120000, 20, 40, "LCD");
		man.insert(12, "µı√§", 520000, 30, 5152125125L);
		System.out.println(man.searchAll());
		System.out.println(man.search(11));
		System.out.println(man.searchRefrigeratorAll());
		man.deleteProduct(12);
		System.out.println(man.searchAll());
		System.out.println(man.sumPrice());
	}
}