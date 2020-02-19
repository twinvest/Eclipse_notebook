package day0216;

public class ������ {
	static int[] heap = new int[100];
	static void swap(int a, int b)
	{
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	static int heap_size = 0;
	void push(int data) {

		// ���� ���� ���� ������ �߰�
		heap[++heap_size] = data;

		// �Ʒ��� ������ child�� parent�� ���ϸ鼭 �˸��� ��ġ�� �ϳ��� �ø��� �κ�
		int child = heap_size;
		int parent = child / 2;
		while (child > 1 && heap[parent] < heap[child])
		{
			swap(parent, child);
			child = parent;
			parent = child / 2;
		}
	}
	static int pop() {

		// ���� ���� ù��° ���Ҹ� ��ȯ
		// ���� ���� �ո� ���� �ִ�!
		int result = heap[1];

		// ù��° ���Ҹ� ���� ���� ���� ���ҿ� �ٲٰ�
		// ���� ���� ���� ���� ���� �����̴� heap_count�� �����ش�.
		swap(1, heap_size); //��, ���� ���� ù��° ��ġ�� ���� ���� �� ���Ҹ� ����.
		heap_size--;

		// �Ʒ��� ������ child�� parent�� ���ϸ鼭 �˸��� ��ġ�� �ϳ��� ������ �κ�
		// ��, ���� ù��° ���Ҹ� �ڽİ� ��� ���ϸ鼭 ���� �ٲ㰡�鼭 �������Ұ���!
		int parent = 1;
		int child = parent * 2;
		if (child + 1 <= heap_size)
		{
			child = (heap[child] > heap[child + 1]) ? child : child + 1; //���ʳ��� ū�� ������ ���� ū�� Ȯ���ؼ� �� ū������ child�� �ε����� ������.
		}

		//���� child�� heap�� size���� �۰ų� �����鼭, �θ𺸴� �ڽ��� �� ũ��
		// ==> �ڸ��� �ٲ����!!
		while (child <= heap_size && heap[parent] < heap[child])
		{
			swap(parent, child);

			parent = child;      //�ڸ� �ٲ��� �ٽ� ����
			child = child * 2;   //�ڸ� �ٲ��� �ٽ� ����
			if (child + 1 <= heap_size) //������ ���� ������� child�� �� ������ Ȯ���ؼ� ������ �� ������ �ݺ�.
			{
				child = (heap[child] > heap[child + 1]) ? child : child + 1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		������ h = new ������();
		int[] arr = {50,30,40,20,80,70,45,33,48,79};
		for(int i =0; i<arr.length; ++i)
			h.push(arr[i]);

		for (int i = 0; i < arr.length; i++)
			System.out.print(h.pop()+" ");

	}
}
