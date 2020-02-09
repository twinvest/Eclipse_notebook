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
		String tmp = "***************** ��ü ��ǰ �˻� *******************\n";
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
		return "��ġ�ϴ� id�� �����ϴ�.";
	}

	public String search(String name) {
		for(int i = 0; i < idx; i++) {
			if(pList[i].getName().contains(name)) {
				return pList[i].toString();
			}
		}
		return "��ġ�ϴ� ��ǰ���� �����ϴ�.";
	}

	public String searchTVAll() {
		String tmp = "***************** ��ü TV �˻� *******************\n";
		for(int i = 0; i < idx; i++) {
			if(pList[i] instanceof TV) {
				tmp += ((TV) pList[i]).toString() + "\n";
			}
		}

		return tmp;
	}

	public String searchRefrigeratorAll() {
		String tmp = "***************** ��ü ����� �˻� *******************\n";
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