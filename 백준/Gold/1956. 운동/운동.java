import java.util.*;
import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] min = new int[V + 1][V + 1];
        for(int[] m: min) {
            Arrays.fill(m, INF);
        }
        for(int i = 1; i < V + 1; i++) {
            min[i][i] = 0;
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            min[s][e] = v;
        }

        for(int k = 1; k < V + 1; k++) {
            for(int i = 1; i < V + 1; i++) {
                for(int j = 1; j < V + 1; j++) {
                    if(min[i][k] == INF || min[k][j] == INF) continue;
                    else min[i][j] = Math.min(min[i][j], min[i][k] + min[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < V + 1; i++) {
            for(int j = 1; j < V + 1; j++) {
                if(i != j) {
                    if(min[i][j] != INF && min[j][i] != INF) {
                        answer = Math.min(answer, min[i][j] + min[j][i]);
                    }
                }
            }
        }

        if(answer == INF) System.out.println(-1);
        else System.out.println(answer);
    }
}