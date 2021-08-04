package day0804;
/*
 * 두 연산을 적용할 시 수가 매우 빠르게 커진다.
 * 그렇기 때문에 10^9 = 10억임에도 불구하고 해당 수까지 도달할 수 있다.
 * */
import java.util.Scanner;
public class A화살표B {
    static int go(long a, long b) {
        if (a == b) return 1;
        if (a > b) return -1;
        int t1 = go(a*2, b);     //1번 연산 적용
        int t2 = go(a*10+1, b);  //2번 연산 적용
        //둘다 불가능한 경우
        if (t1 == -1 && t2 == -1)
        	return -1;
        //위 if문을 통과했단 것은 둘 중 하나가 가능했거나 둘다 가능한 경우임.
        //만약에 t2가 가능했고 t1은 불가능했다면
        if (t1 == -1)
        	return t2+1;
        //만약에 t1이 가능했고 t2는 불가능했다면
        if (t2 == -1)
        	return t1+1;
        //둘다 가능한 경우라면 둘 중 작은것을 선택
        return Math.min(t1,t2)+1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(go(a, b));
    }
}