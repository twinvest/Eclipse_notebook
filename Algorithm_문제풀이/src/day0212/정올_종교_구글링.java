package day0212;

import java.io.IOException;
import java.util.Scanner;

public class 정올_종교_구글링 {
    static int [] parents;
    static int [] rank;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 사람 수
        int m = scan.nextInt(); // 쌍의 수

        parents = new int[n+1];
        rank = new int[n+1];   // 트리의 깊이를 측정

        //union-find를 위한 초기세팅
        for(int i = 1; i<=n; i++) {
            parents[i] = i;
        }

        //입력부. 입력받은 후 union연산을 통해 트리를 구성해준다.
        for(int i = 0; i<m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            union(a,b);
        }

        int cnt = 0;
        for(int i = 1; i<=n; i++) {
            if(i == parents[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static int find(int x) {
        //루트 노드는 부모 노드 번호로 자기 자신을 가짐.
    	if(x == parents[x]) {
            return x;
        }
    	//각 노드의 부모 노드를 찾아 올라간다.
    	else {
    		return parents[x] = find(parents[x]);
    	}
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        //항상 높이가 더 낮은 트리를 높이가 높은 트리 밑에 넣는다. 즉, 높이가 더 높은 쪽을 root로 삼음.
        if(rank[px]<rank[py]) {  // 즉, 트리의 깊이를 서로 비교해서 작은것을 큰것아래에 붙인다.(트리의 깊이 최소화)
            parents[px] = py; //x의 root를 y로 변경한다.
        }
        //그렇지 않은 경우엔 반대로
        else {
            parents[py] = px; //y의 root를 x로 변경한다.
            if(rank[px] == rank[py]) {
                rank[px]++; //만약 높이가 같다면 합친 후 x의 높이를 1 증가시킨다.(x의 높이 + 1)
            }
        }
    }
}