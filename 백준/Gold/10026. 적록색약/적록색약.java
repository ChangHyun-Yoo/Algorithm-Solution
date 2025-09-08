import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] chs = new char[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                chs[i][j] = input.charAt(j);
            }
        }

        result = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(result[i][j] == 0) {
                    answer++;
                    result[i][j] = answer;
                    dfs(i, j, chs, chs[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append(' ');

        answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(chs[i][j] == 'R') chs[i][j] = 'G';
            }
        }
        result = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(result[i][j] == 0) {
                    answer++;
                    result[i][j] = answer;
                    dfs(i, j, chs, chs[i][j]);
                }
            }
        }

        sb.append(answer);

        System.out.println(sb.toString());
    }

    static void dfs(int i, int j, char[][] chs, char start) {
        for(int a = 0; a < 4; a++) {
            int newI = i + dx[a];
            int newJ = j + dy[a];

            if(newI >= 0 && newI < N && newJ >= 0 && newJ < N) {
                if(result[newI][newJ] == 0 && chs[newI][newJ] == start) {
                    result[newI][newJ] = answer;
                    dfs(newI, newJ, chs, start);
                }
            }
        }
    }
}
