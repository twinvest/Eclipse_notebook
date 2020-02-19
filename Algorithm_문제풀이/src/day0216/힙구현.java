package day0216;

public class 힙구현 {
	static int[] heap = new int[100];
	static void swap(int a, int b)
	{
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	static int heap_size = 0;
	void push(int data) {

		// 힙의 가장 끝에 데이터 추가
		heap[++heap_size] = data;

		// 아래의 과정은 child를 parent와 비교하면서 알맞은 위치로 하나씩 올리는 부분
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

		// 힙의 가장 첫번째 원소를 반환
		// 힙의 가장 앞만 보고 있다!
		int result = heap[1];

		// 첫번째 원소를 힙의 가장 끝에 원소와 바꾸고
		// 가장 끝은 이제 쓰지 않을 예정이니 heap_count를 내려준다.
		swap(1, heap_size); //즉, 힙의 가장 첫번째 위치에 힙의 가장 끝 원소를 대입.
		heap_size--;

		// 아래의 과정은 child를 parent와 비교하면서 알맞은 위치로 하나씩 내리는 부분
		// 즉, 이제 첫번째 원소를 자식과 계속 비교하면서 값을 바꿔가면서 재정렬할거임!
		int parent = 1;
		int child = parent * 2;
		if (child + 1 <= heap_size)
		{
			child = (heap[child] > heap[child + 1]) ? child : child + 1; //왼쪽놈이 큰지 오른쪽 놈이 큰지 확인해서 더 큰놈으로 child의 인데스를 맞춰줌.
		}

		//만약 child가 heap의 size보다 작거나 같으면서, 부모보다 자식이 더 크면
		// ==> 자리를 바꿔야함!!
		while (child <= heap_size && heap[parent] < heap[child])
		{
			swap(parent, child);

			parent = child;      //자리 바꾼후 다시 세팅
			child = child * 2;   //자리 바꾼후 다시 세팅
			if (child + 1 <= heap_size) //여전히 힙의 사이즈보다 child가 더 작은지 확인해서 작으면 이 과정을 반복.
			{
				child = (heap[child] > heap[child + 1]) ? child : child + 1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		힙구현 h = new 힙구현();
		int[] arr = {50,30,40,20,80,70,45,33,48,79};
		for(int i =0; i<arr.length; ++i)
			h.push(arr[i]);

		for (int i = 0; i < arr.length; i++)
			System.out.print(h.pop()+" ");

	}
}
