import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] heights = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                heights[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, heights[0][0]));

        int[][] dp = new int[M][N];
        dp[0][0] = 1;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            for(int i = 0; i < 4; i++) {
                int ni = now.i + dx[i];
                int nj = now.j + dy[i];

                if(ni >= 0 && ni < M && nj >= 0 && nj < N) {
                    if(heights[ni][nj] < now.height) {
                        if(dp[ni][nj] == 0) {
                            pq.offer(new Node(ni, nj, heights[ni][nj]));
                        }
                        dp[ni][nj] += dp[now.i][now.j];
                    }
                }
            }
        }

        System.out.println(dp[M - 1][N - 1]);
    }

    static class Node implements Comparable<Node> {
        int i;
        int j;
        int height;

        public Node(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        public int compareTo(Node n) {
            return n.height - this.height;
        }
    }
}
