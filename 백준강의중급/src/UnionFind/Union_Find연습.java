package UnionFind;
/*
 * 상호 배타적 집합(Disjoint-set)이라고도 함.
 * 2가지 연산으로 이루어져있음.
 * ㄱ. Find : x가 어던 집합에 포함되어 있는지 찾는 연산. 루트를 찾는 연산이라고 볼 수 있음.
 * ㄴ. Union : x와  y가 포함되어 있는 집합을 합치는 연산.
 *
 * 구현은 트리를 이용한다.
 * parent[i] = i의 parent가 저장되어 있음.
 *
 * */
public class Union_Find연습 {

	public static void main(String[] args) {

	}

	//이는 시간복잡도가 O(N)이다.
	static int Find(int x) {
		if( x == parent[x]) {
			return x;
		} else {
			return Find(parent[x]);
		}
	}

	//근데 부모 자식은 아무 의미가 사실 없다. 루트가 제일 중요할 뿐.
	/*
	 *     1                  1
	 *      \                / \
	 *       2              2   3
	 *        \
	 *         3
	 *   두 트리는 사실 UnionFind자료구조에서 별 차이가 없음. 왼쪽 트리에서 2의 루트도 1 3의 루트도 1이다.
	 *   즉, 하고 싶은 말은 하나로 묶여 있다는 사실이 중요한거지 하나의 원소의 부모가 누구인지는 중요하지 않음.
	 *   그럼 반환을 하면서 바로바로 오른쪽처럼 만들어 주자!!
	 * */
	static int Find2(int x) {
		if( x == parent[x]) {
			return x;
		} else {
			int temp = Find(parent[x]);
			parent[x] = temp; //부모를 전부 루트로 만들어 주는 코드.
			return temp;
		}
	}



	//Union(x,y) : y의 parent를 x로 설정한다.
	static int Union(int x , int y) {
		x = Find(x); //x의 부모를 찾는다.
		y = Find(y); //y의 부모를 찾는다.
		parent[y] = x; //y의 부모를 x로 만들어준다.
	}

	//한층 진화된 Union연산
	static int Union(int x , int y) {
		x = Find(x); //x의 부모를 찾는다.
		y = Find(y); //y의 부모를 찾는다.

		if ( x == y )
			return;
		if(rank[x] < rank[y]) swap(x,y);

		parent[y] = x; //y의 부모를 x로 만들어준다.

		if(rank[x] == rank[y]) {
			rank[x] = rank[y] + 1;
		}

	}

}
