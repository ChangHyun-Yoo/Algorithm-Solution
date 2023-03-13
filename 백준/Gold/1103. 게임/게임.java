import java.io.*;
import java.util.*;

public class Main {

    static int[][] info;
    static int[][] dp;
    static boolean[][] visited;
    static int N;
    static int M;
    static boolean circled;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        circled = false;
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                if(s.substring(j, j + 1).equals("H")) {
                    info[i][j] = 0;
                    dp[i][j] = 0;
                } else {
                    info[i][j] = Integer.parseInt(s.substring(j, j + 1));
                }
            }
        }
        int answer = move(0, 0, -1);

        if(circled) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static int move(int row, int col, int before) {
        if(circled) {
            return 0;
        }

        if(row < 0 || col < 0 || row >= N || col >= M) {//밖으로 나갈 경우
            return 0;
        }

        if(dp[row][col] == -1) {
            if(visited[row][col]) {
                circled = true;
                return 0;
            }
        }
        visited[row][col] = true;

        if(dp[row][col] != -1) {//이미 존재할 경우
            return dp[row][col];
        }
        
        int max = Math.max(Math.max(move(row + info[row][col], col, info[row][col]), move(row, col + info[row][col], info[row][col])), Math.max(move(row - info[row][col], col, info[row][col]), move(row, col - info[row][col], info[row][col])));

        dp[row][col] = max + 1;
        return max + 1;
    }

}
