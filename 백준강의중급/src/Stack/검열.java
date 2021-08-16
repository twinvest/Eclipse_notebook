package Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 왼쪽 스택과 오른쪽 스택으로 나눠서 문제를 푼다.
 * 왼쪽에서 검사한건 왼쪽에 넣어주고 오른쪽에서 검사한건 오른쪽에 넣어준다.
 *
 * */

public class 검열 {
    static char[] l = new char[300001];
    static char[] r = new char[300001];
    static int ln = 0, rn = 0;
    static char[] a;
    static char[] ar;
    static char[] b;
    static int n, m; //n은 원본문자열에서 지울문자열 A의 길이, m은 원본문자열 T의 길이
    static boolean check(int where) {
        //왼쪽일때 세팅
    	char[] stack = l;
        int len = ln;
        char[] str = ar;

        //오른쪽일때 세팅
        if (where == 1) {
            stack = r;
            len = rn;
            str = a;
        }

        //스택의 사이즈가 A의 길이보다 작다면
        if (len-n < 0) {
            return false;
        }

        //일치하는지 비교
        for (int i=0; i<n; i++) {
            if (stack[len-i-1] != str[i]) {
                return false;
            }
        }

        //스택의 사이즈를 A의 길이만큼 줄여준다.
        if (where == 0) {
            ln -= n;
        } else {
            rn -= n;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	//Scanner sc = new Scanner(System.in);
        a = br.readLine().toCharArray();
        n = a.length;

        ar = new char[n]; //왼쪽 스택을 검사할때 이거랑 비교할거임.
        for (int i=0; i<n; i++) {
            ar[i] = a[n-i-1];
        }
        b = br.readLine().toCharArray();
        m = b.length;
        int left = 0;   //어디까지왔는지 확인하려고 선언한 변수
        int right = m-1;//어디까지왔는지 확인하려고 선언한 변수
        int where = 0;  //where가 0이면 왼쪽검사 1이면 오른쪽검사

        while (left <= right) {
            if (where == 0) {
                l[ln++] = b[left++]; //왼쪽 스택에 값 넣어주기
            } else {
                r[rn++] = b[right--];//오른쪽 스택에 값 넣어주기
            }

            //왼쪽스택이나 오른쪽 스택의 가장위에 A문자가 있으면 방향을 바꿔준다.
            if (check(where)) {
                where = 1-where;
            }
        }

        //마지막에는 왼쪽스택에 남아 있는것들을 전부 오른쪽 스택에 넣어준다.
        for (int i=ln-1; i>=0; i--) {
            r[rn++] = l[i];
            check(1);
        }

        for (int i=rn-1; i>=0; i--){
            bw.write(r[i]);
        }
        bw.flush();
        //System.out.println();
    }
}