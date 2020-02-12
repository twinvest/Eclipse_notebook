package day0212;

import java.io.IOException;
import java.util.Scanner;

public class ����_����_���۸� {
    static int [] parents;
    static int [] rank;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // ��� ��
        int m = scan.nextInt(); // ���� ��

        parents = new int[n+1];
        rank = new int[n+1];   // Ʈ���� ���̸� ����

        //union-find�� ���� �ʱ⼼��
        for(int i = 1; i<=n; i++) {
            parents[i] = i;
        }

        //�Էº�. �Է¹��� �� union������ ���� Ʈ���� �������ش�.
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
        //��Ʈ ���� �θ� ��� ��ȣ�� �ڱ� �ڽ��� ����.
    	if(x == parents[x]) {
            return x;
        }
    	//�� ����� �θ� ��带 ã�� �ö󰣴�.
    	else {
    		return parents[x] = find(parents[x]);
    	}
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        //�׻� ���̰� �� ���� Ʈ���� ���̰� ���� Ʈ�� �ؿ� �ִ´�. ��, ���̰� �� ���� ���� root�� ����.
        if(rank[px]<rank[py]) {  // ��, Ʈ���� ���̸� ���� ���ؼ� �������� ū�;Ʒ��� ���δ�.(Ʈ���� ���� �ּ�ȭ)
            parents[px] = py; //x�� root�� y�� �����Ѵ�.
        }
        //�׷��� ���� ��쿣 �ݴ��
        else {
            parents[py] = px; //y�� root�� x�� �����Ѵ�.
            if(rank[px] == rank[py]) {
                rank[px]++; //���� ���̰� ���ٸ� ��ģ �� x�� ���̸� 1 ������Ų��.(x�� ���� + 1)
            }
        }
    }
}