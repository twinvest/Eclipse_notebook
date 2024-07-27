package 그리디;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정{

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Conference> list = new ArrayList<Conference>();

        for (int i = 0; i < n; i++) {
            list.add(new Conference(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list, new Comparator<Conference>() {
            @Override
			public int compare(Conference c1, Conference c2) {
                if (c1.getEnd() > c2.getEnd()) {
                    return 1;
                } else if (c1.getEnd() < c2.getEnd()) {
                    return -1;
                }
                return c1.getStart() - c1.getEnd();

            }
        });

        int end = -1;
        int start;
        int count = 0;

        for (int j = 0; j < n; j++) {
            start = list.get(j).getStart();

            if (start >= end) {
                end = list.get(j).getEnd();
                count++;
            }
        }
        System.out.println(count);
    }
}

class Conference {
    int start;
    int end;

    Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}