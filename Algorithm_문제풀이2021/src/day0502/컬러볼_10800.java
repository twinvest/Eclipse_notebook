package day0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class 컬러볼_10800 {
  public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = stoi(br.readLine());
      ArrayList<Ball> balls = new ArrayList<>();
      long[] colors = new long[200001];
      for(int n = 0 ; n < N ; n++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         balls.add(new Ball(n,stoi(st.nextToken()),stoi(st.nextToken())));
      }

      Collections.sort(balls);

      long[] answers = new long[N];
      long sum = 0;

      for(int i = 0 ; i < N ;i++) {

          Ball now = balls.get(i);
          colors[now.color] += now.size;
          sum+=now.size;

          long tmp = 0;
          //1 2 3 3 3 3 3 3  크기
          //1 2 1 1 2 2 3 3  컬러
          //1 3 6 9 12
          for(int j = i-1 ; j >= 0 ;j--){
              Ball prev = balls.get(j);
              //다른 색상, 같은 사이즈 일때 처리해줘야함.
              if(j >= 0 && now.size == prev.size&& now.color!= prev.color){
                  tmp += prev.size;
                  continue;
              }
              if(now.size != prev.size){
                  break;
              }
          }

          answers[now.num] = (sum-tmp) - colors[now.color];

      }
       for(int i = 0 ; i< N ;i++){
           System.out.println(answers[i]);
       }

   }
   public static int stoi(String str) {
      return Integer.parseInt(str);
   }

   static class Ball implements Comparable<Ball>{
      int num;
      int color;
      long size;
      public Ball(int num, int color, long size) {
         this.num = num;
         this.color = color;
         this.size = size;
      }
      @Override
      public int compareTo(Ball o) {
         if(this.size<=o.size) {
            return -1;
         }
         return 0;
      }
      @Override
      public String toString(){
        return num+ ", " +color +" , " +size;
       }
   }
}