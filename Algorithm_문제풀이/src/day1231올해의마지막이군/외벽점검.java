package day1231올해의마지막이군;
import java.util.Arrays;
import java.util.LinkedList;

public class 외벽점검 {
    static int Nsize;
    static int[] weakPoint;
    static LinkedList<Integer> weak_expand;

    static boolean[] checked;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};

        int answer = solution(n, weak, dist);
        System.out.println(answer);
    }

    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        Nsize = n;
        weakPoint = weak.clone();
        Arrays.sort(dist);
        checked = new boolean[dist.length];

		//출발지를 기준으로 한바퀴를 돌 때 nSize만큼 늘려주기 위해
        weak_expand = new LinkedList<>();
        for(int i=0; i<weakPoint.length; ++i)
            weak_expand.add(weakPoint[i]);

        for(int i=0; i<weakPoint.length; ++i)
            weak_expand.add(weakPoint[i] + Nsize);


        int count = 0;
        //친구가 검사 가능한 거리 -> 순열
        LinkedList<Integer> list = new LinkedList<>();
        makePermutation(0, count, list, dist);

        if(result == Integer.MAX_VALUE) answer = -1;
        else answer = result;

        return answer;
    }

    private static void makePermutation(int index, int count, LinkedList<Integer> list, int[] dist) {
        if(count == dist.length){
            deterPossible(list);
            return;
        }

        for(int i=0; i<dist.length; ++i){
            if(!checked[i]){
                checked[i] = true;
                list.add(dist[i]);
                makePermutation(i, count+1, list, dist);
                list.removeLast();
                checked[i] = false;
            }
        }
    }

    private static void deterPossible(LinkedList<Integer> friendLists) {
        //시작점
        for(int i=0; i<weakPoint.length; ++i){
            int idx = 0;
            int startPoint = weak_expand.get(i);
            boolean mark = false;

            for(int j=i; j<i + weakPoint.length; ++j){
                //두 점 사이의 거리가 검사 가능한 친구의 거리보다 크다면 -> 커버가 불가능
                //-> 해당 지점을 출발지로 설정
                if(weak_expand.get(j) - startPoint > friendLists.get(idx)){
                    startPoint = weak_expand.get(j);
                    idx++;

                    //모든 친구를 다 사용한 경우
                    if(idx == friendLists.size()){
                        mark = true;
                        break;
                    }
                }
            }

            //모든 친구를 사용하지 않고도 가능하다면
            if(!mark) result = Math.min(result, idx+1);
        }
        return;
    }
}