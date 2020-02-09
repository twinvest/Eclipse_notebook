package hw_java_0204;

public class ProductMgr {
	private Product[] pList;
	private int MAX = 3;
	private int idx = 0;

	public ProductMgr() {
		pList = new Product[MAX];
	}

	private void checkMax() {
		Product[] tmp = new Product[MAX];
		System.arraycopy(pList, 0, tmp, 0, MAX);
		if(idx == MAX) {
			MAX += MAX;
		}
		pList = new Product[MAX];
		System.arraycopy(tmp, 0, pList, 0, tmp.length);
	}

	public void insert(int id, String name, int price, int count, int inch, String type) {
		pList[idx] = new TV(id, name, price, count, inch, type);
		idx++;
		checkMax();
	}

	public void insert(int id, String name, int price, int count, long capacity) {
		pList[idx] = new Refrigerator(id, name, price, count, capacity);
		idx++;
		checkMax();
	}

	public String searchAll() {
		String tmp = "***************** 전체 상품 검색 *******************\n";
		for(int i = 0; i < idx; i++) {
			tmp += pList[i].toString() + "\n";
		}

		return tmp;
	}

	public String search(int id) {
		for(int i = 0; i < idx; i++) {
			if(pList[i].getId() == id) {
				return pList[i].toString();
			}
		}
		return "일치하는 id가 없습니다.";
	}

	public String search(String name) {
		for(int i = 0; i < idx; i++) {
			if(pList[i].getName().contains(name)) {
				return pList[i].toString();
			}
		}
		return "일치하는 상품명이 없습니다.";
	}

	public String searchTVAll() {
		String tmp = "***************** 전체 TV 검색 *******************\n";
		for(int i = 0; i < idx; i++) {
			if(pList[i] instanceof TV) {
				tmp += ((TV) pList[i]).toString() + "\n";
			}
		}

		return tmp;
	}

	public String searchRefrigeratorAll() {
		String tmp = "***************** 전체 냉장고 검색 *******************\n";
		for(int i = 0; i < idx; i++) {
			if(pList[i] instanceof Refrigerator) {
				tmp += ((Refrigerator) pList[i]).toString() + "\n";
			}
		}

		return tmp;
	}

	public void deleteProduct(int id) {
		for(int i = 0; i < idx; i++) {
			if(pList[i].getId() == id) {
				pList[i] = pList[--idx];
			}
		}
	}

	public int sumPrice() {
		int sum = 0;

		for(int i = 0; i < idx; i++) {
			sum += pList[i].getPrice();
		}

		return sum;
	}
}