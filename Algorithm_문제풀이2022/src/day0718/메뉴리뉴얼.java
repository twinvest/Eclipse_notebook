package day0718;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class 메뉴리뉴얼 {

    static class Pos implements Comparable<Pos>{
        String s = "";
        int count = 0;
        Pos(String s, int count){
            this.s=s;
            this.count=count;
        }

        @Override
        public boolean equals(Object o){

        	Pos comp = (Pos)o;
            if(this.s.equals(comp.s)){
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Pos comp){
            return Integer.compare(comp.count, this.count);
        }
    }
    static char[] arr;
    static char[] sel;
    static ArrayList<Pos> posList = new ArrayList<>();
    static void combination(int idx, int s_idx){
        if(s_idx == sel.length){
            String s = "";
            for(int i =0; i<sel.length; ++i){
                s += sel[i]+"";
            }
            Pos pos = new Pos(s, 1);
            if(!posList.contains(pos)){
                posList.add(pos);
            } else {
                for(int i =0; i<posList.size(); ++i){
                    if(posList.get(i).s.equals(s)){
                        posList.get(i).count++;
                        break;
                    }
                }
            }
            //System.out.println(Arrays.toString(sel));
            return;
        }
        if(idx == arr.length){
            return;
        }
        sel[s_idx] = arr[idx];
        combination(idx+1, s_idx+1);
        combination(idx+1, s_idx);
    }

    public static String[] solution(String[] orders, int[] course) {
       ArrayList<String> ansList = new ArrayList<>();
        for(int i =0; i < course.length; ++i){
            sel = new char[course[i]];
            posList = new ArrayList<>();
            for(int j =0; j<orders.length; ++j){
                arr = orders[j].toCharArray();
                Arrays.sort(arr);
                combination(0,0);
            }


            Collections.sort(posList);
            if(posList.size() != 0) {
            	int count = posList.get(0).count;
            	if(count != 1) {
            		ansList.add(posList.get(0).s);
            		for(int j=1; j<posList.size(); ++j){
            			if(count == posList.get(j).count){
            				ansList.add(posList.get(j).s);
            			}else{
            				break;
            			}
            		}
            	}
            }

        }

        String[] answer = new String[ansList.size()];
        for(int i  =0; i<ansList.size(); ++i){
            answer[i] = ansList.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}