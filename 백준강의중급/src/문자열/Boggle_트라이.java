package 문자열;

import java.util.*;
public class Boggle_트라이 {
    static int[] dx = {0,0,1,-1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int[] scores = {0,0,0,1,1,2,3,5,11};
    static boolean[][] c = new boolean[4][4];
    static void generate(int x, int y, String word, String[] board, ArrayList<String> words) {
        words.add(word);
        if (word.length() == 8) return;
        for (int k=0; k<8; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && c[nx][ny] == false) {
                c[nx][ny] = true;
                generate(nx, ny, word+board[nx].charAt(ny), board, words);
                c[nx][ny] = false;
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] dictionary = new String[n];
        for (int i=0; i<n; i++) {
            dictionary[i] = sc.next();
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            String[] board = new String[4];
            for (int i=0; i<4; i++) {
                board[i] = sc.next();
            }
            ArrayList<String> words = new ArrayList<>();
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++) {
                    c[i][j] = true;
                    generate(i, j, Character.toString(board[i].charAt(j)), board, words);
                    c[i][j] = false;
                }
            }
            HashSet<String> wordset = new HashSet<>(words);
            int score=0;
            String longest="";
            int cnt=0;
            for (String a : dictionary) {
                if (wordset.contains(a)) {
                    score += scores[a.length()];
                    cnt += 1;
                    if (longest.length() < a.length()) {
                        longest = a;
                    } else if (longest.length() == a.length() && longest.compareTo(a) > 0) {
                        longest = a;
                    }
                }
            }
            System.out.println(score + " " + longest + " " + cnt);
        }
    }
}