import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int val = Integer.parseInt(br.readLine());

        int[][] lst = new int[N][N];

        lst[N / 2][N / 2] = 1;
        lst[N / 2 - 1][N / 2] = 2;

        int dir = 0;

        int start = 3;
        int curX = N / 2 - 1;
        int curY = N / 2 + 1;

        int answerX = -1;
        int answerY = -1;
        for(; start <= N * N; start++) {
            lst[curX][curY] = start;
            if(start == val) {
                answerX = curX;
                answerY = curY;
            }

            if(dir % 4 == 0) {
                if(lst[curX][curY - 1] == 0) {
                    dir++;
                    curY--;
                    continue;
                }
                curX++;
            }
            if(dir % 4 == 1) {
                if(lst[curX - 1][curY] == 0) {
                    dir++;
                    curX--;
                    continue;
                }
                curY--;
            }
            if(dir % 4 == 2) {
                if(lst[curX][curY + 1] == 0) {
                    dir++;
                    curY++;
                    continue;
                }
                curX--;
            }
            if(dir % 4 == 3) {
                if(lst[curX + 1][curY] == 0) {
                    dir++;
                    curX++;
                    continue;
                }
                curY++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(lst[i][j]).append(' ');
            }
            sb.append('\n');
        }

        if(val == 1) {
            answerX = N / 2;
            answerY = N / 2;
        }
        if(val == 2) {
            answerX = N / 2 - 1;
            answerY = N / 2;
        }
        sb.append(answerX + 1).append(' ').append(answerY + 1);

        System.out.println(sb);
    }
}
