import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] roads = new int[N][N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                roads[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        long dis = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(0, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.x]) continue;

            visited[now.x] = true;
            count++;
            dis += now.dis;
            if(count == N) break;

            for(int i = 0; i < roads[now.x].length; i++) {
                if(!visited[i]) {
                    pq.offer(new Node(i, roads[now.x][i]));
                }
            }
        }
        System.out.println(dis);
    }

    static class Node implements Comparable<Node> {
        int x;
        int dis;

        public Node(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }

        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }
}