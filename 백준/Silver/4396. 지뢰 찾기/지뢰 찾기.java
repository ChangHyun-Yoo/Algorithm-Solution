import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static boolean[][] bomb;
    static boolean[][] opened;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        bomb = new boolean[n][n];
        opened = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            char[] chs = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                if(chs[j] == '*') {
                    bomb[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            char[] chs = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                if(chs[j] == 'x') {
                    opened[i][j] = true;
                }
            }
        }

        char[][] answer = new char[n][n];
        int[][] answerInt = new int[n][n];

        boolean bombOpened = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!opened[i][j]) answer[i][j] = '.';
                else {
                    if(bomb[i][j]) {
                        bombOpened =  true;
                        answer[i][j] = '*';
                    } else {
                        answerInt[i][j] = find(i, j);
                    }
                }
            }
        }
        
        if(bombOpened) {
            for(int i = 0; i < n ;i++) {
                for(int j = 0; j < n ; j++) {
                    if(bomb[i][j]) answer[i][j] = '*';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(answer[i][j] == '\0') {
                    sb.append(answerInt[i][j]);
                } else {
                    sb.append(answer[i][j]);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int find(int i, int j) {
        int answer = 0;
        if(i != 0)
            if(bomb[i - 1][j]) answer++;
        if(i != 0 && j != n - 1)
            if(bomb[i - 1][j + 1]) answer++;
        if(j != n - 1)
            if(bomb[i][j + 1]) answer++;
        if(i != n - 1 && j != n - 1)
            if(bomb[i + 1][j + 1]) answer++;
        if(i != n - 1)
            if(bomb[i + 1][j]) answer++;
        if(i != n - 1 && j != 0)
            if(bomb[i + 1][j - 1]) answer++;
        if(j != 0)
            if(bomb[i][j - 1]) answer++;
        if(i != 0 && j != 0)
            if(bomb[i - 1][j - 1]) answer++;
        return answer;
    }
}
