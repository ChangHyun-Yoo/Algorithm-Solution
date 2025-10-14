import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answer = Math.max(answer, dp(i, j, map, dp));
            }
        }
        System.out.println(answer);
    }

    static int dp(int i, int j, int[][] map, int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];

        int max = 1;

        // 모든 주변들이 현재보다 작거나 같으면 0
        // 하나라도 크면 탐색
        for(int a = 0; a < 4; a++) {
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                // 하나라도 더 커서 탐색
                if(map[nx][ny] > map[i][j]) {
                    max = Math.max(max, dp(nx, ny, map, dp) + 1);
                }
            }
        }

        return dp[i][j] = max;
    }
}
