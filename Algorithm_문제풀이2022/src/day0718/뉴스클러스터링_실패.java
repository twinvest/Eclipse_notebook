package day0718;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class 뉴스클러스터링_실패 {

	public static void main(String[] args) {
		String str1 = "CECEFECE";
		String str2 = "CEFECE";
		solution(str1, str2);
	}
     public static ArrayList<String> makeList(String str1){
        ArrayList<String> list1 = new ArrayList<>();
        for(int i =0; i<str1.length(); i++){
            if(i+1<str1.length()){
                if(!Character.isAlphabetic(str1.charAt(i)) || !Character.isAlphabetic(str1.charAt(i+1))){
                    continue;
                }
                String a = str1.charAt(i)+"";
                String b = str1.charAt(i+1)+"";
                String ab = a+b;
                ab = ab.toUpperCase();
                list1.add(ab);
            }
        }
        return list1;
    }

    public static int solution(String str1, String str2) {
        ArrayList<String> list1;
        ArrayList<String> list2;
        list1 = makeList(str1);
        list2 = makeList(str2);

        Collections.sort(list1);
        Collections.sort(list2);

        //합집합
        HashSet<String> set1 = new HashSet<>();
        for(int i =0; i<list1.size(); ++i){
            set1.add(list1.get(i));
        }
        for(int i =0; i<list2.size(); ++i){
            set1.add(list2.get(i));
        }

        //교집합
        HashSet<String> set2 = new HashSet<>();
        for(int i =0; i<list1.size(); ++i){
            for(int j =0; j<list2.size(); ++j){
                if(list1.get(i).equals(list2.get(j))){
                    set2.add(list2.get(j));
                }
            }
        }


        int a = set1.size();
        int b = set2.size();

        //반복구하기

        for(int i =0; i<list1.size(); ++i){
            String comp = "";
            for(int j =0; j<list2.size(); ++j){
                if(list1.get(i).equals(list2.get(j))){
                    comp = list1.get(i);
                    int pointer1 = i;
                    int pointer2 = j;
                    while(pointer1 < list1.size() && comp.equals(list1.get(pointer1))){
                           pointer1++;
                    }
                    --pointer1;

                    while(pointer2 < list2.size() && comp.equals(list2.get(pointer2))){
                           pointer2++;
                    }
                    --pointer2;

                    int recur1 = pointer1 - i;
                    int recur2 = pointer2 - j;
                    if(recur1 < recur2){
                        a += recur2;
                        b += recur1;
                    } else {
                        a += recur1;
                        b += recur2;
                    }

                    i = pointer1;
                    break;
                }
            }
        }


        double a1 = Double.parseDouble(a+"");
        double b1 = Double.parseDouble(b+"");
        System.out.println(a1);
        System.out.println(b1);
        double ans = 1;
        if(a1 == 0 && b1 == 0){
            ans = 1 * 65536;
        }else{
            ans = (b1/a1)*65536;
        }
        int answer = (int)ans;
        System.out.println(answer);

        return answer;
    }

}