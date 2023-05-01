import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] roads = new int[N + 1][N + 1];
        int[][] min = new int[N + 1][N + 1];
        for(int[] m: min) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < N + 1; j++) {
                roads[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N + 1; i++) {
            min[i][i] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));
            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(now.time > min[i][now.x]) continue;

                for(int j = 1; j < N + 1; j++) {
                    if(now.time + roads[now.x][j] < min[i][j]) {
                        min[i][j] = now.time + roads[now.x][j];
                        pq.offer(new Node(j, min[i][j]));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(min[A][B] <= C) {
                sb.append("Enjoy other party\n");
            } else {
                sb.append("Stay here\n");
            }
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }

        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }
}