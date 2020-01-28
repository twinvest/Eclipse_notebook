import java.io.*;
import java.util.*;
 
public class Solution {
    static int data[];
    static int answer,n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            data=new int[n];
            for(int i=0;i<n;i++) data[i]=Integer.parseInt(st.nextToken());
            answer=Integer.MIN_VALUE;
            dfs(0,0,0);
            if(answer==Integer.MIN_VALUE) answer=-1;
            System.out.println("#"+tc+" "+answer);
        }
    }
    static void dfs(int v,int cur,int count) {
        if(cur>m) return;
        if(count==2) {
            if(answer<cur) answer=cur;
            return;
        }
        if(v==n) return;
        dfs(v+1,cur+data[v],count+1);
        dfs(v+1,cur,count);
    }
}