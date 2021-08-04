package day0803;
/*
 * 시간 복잡도는 (N-1) ^ N
 * N = 8 이므로 5,764,801번. 즉, 모든 경우를 시도해볼 수 있다.
 *
 * */
import java.util.Scanner;
public class 계란으로계란치기 {
    static int n;
    static int[] s = new int[10]; //내구도
    static int[] w = new int[10]; //무게

    //현재 index번째 계란을 손에 들고 있다.
    static int go(int index) {
        //가장 마지막 계란의 다음 계란에 도달하면(탈출조건)
    	if (index == n) {
            int cnt = 0;
            for (int i=0; i<n; i++) {
                //내구도가 0보다 작거나 같으면 깨진 계란들이다.
            	if (s[i] <= 0) {
                    cnt += 1;
                }
            }
            return cnt;
        }

    	//손에 든 계란이 깨져있는 경우. 내비두고 다음으로 넘어간다.
        if (s[index] <= 0) {
            return go(index+1);
        }

        //이 밑으로 왔다는것은 index번째 계란이 깨진 계란이 아니란것. 즉, index번째 계란으로 다른계란을 쳐야한다.
        int ans = 0;
        boolean ok = false;
        //다른 계단을 모두 쳐본다.
        for (int j=0; j<n; j++) {
            int i = index; //현재 i번쨰 계란
            //자기자신은 치지 않는다.
            if (i == j) continue;
            //박살난 계란이 아니라 정상 계란인 경우 깨트리러 진입.
            if (s[j] > 0) {
                ok = true; //ok변수는 index(i)계란으로 다른계란을 칠 수 있으면 true. 아니면 false. 즉, 깨지지 않은 다른계란이 없는 경우 false로 남아있고 이는 밑에 if문에 걸려 다음계란으로 그냥 넘어가게 된다.
                //깨트림.
                s[i] -= w[j];
                s[j] -= w[i];

                int temp = go(index+1);
                if (ans < temp) ans = temp;

                //다시 원상태로 돌려놓음.
                s[i] += w[j];
                s[j] += w[i];
            }
        }

        //즉, 깨지지 않은 다른계란이 없는 경우(정상계란이 없는 경우)는 그냥 다음으로 넘어간다.
        if (!ok) {
            return go(index+1);
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            s[i] = sc.nextInt(); //내구도
            w[i] = sc.nextInt(); //무게
        }
        System.out.println(go(0));
    }
}