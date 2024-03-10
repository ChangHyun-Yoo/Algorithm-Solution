import java.util.*;
import java.io.*;

public class Main {

    static int[][] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        min = new int[n + 1][n + 1];
        for(int[] mm: min) {
            Arrays.fill(mm, Integer.MAX_VALUE);
        }
        for(int i = 1; i < n + 1; i++) {
            min[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            min[s][e] = Math.min(min[s][e], d);
        }

        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    if(min[i][k] != Integer.MAX_VALUE && min[k][j] != Integer.MAX_VALUE) {
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k][j]);
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                sb.append((min[i][j] == Integer.MAX_VALUE ? 0 : min[i][j]) + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}