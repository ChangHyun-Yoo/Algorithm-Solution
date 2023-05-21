import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int country;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = (int) s.charAt(j) - 48;
            }
        }

        country = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    country++;

                    bfs(i, j);
                }
            }
        }

        int[] count = new int[country + 1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0) {
                    count[map[i][j]]++;
                }
            }
        }
        Arrays.sort(count);
        System.out.println(country - 1);
        for(int i = 2; i < country + 1; i++) {
            System.out.println(count[i]);
        }
    }

    static void bfs(int i, int j) {
        if(i >= 0 && i < N && j >= 0 && j < N) {
            if(map[i][j] == 1) {
                map[i][j] = country;
                visited[i][j] = true;
                bfs(i - 1, j);
                bfs(i + 1, j);
                bfs(i, j + 1);
                bfs(i, j - 1);
            }
        }
    }
}