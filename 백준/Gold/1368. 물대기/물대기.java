import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] roads;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        roads = new int[N + 1][N + 1];

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            roads[0][i + 1] = value;
            roads[i + 1][0] = value;
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                roads[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        int answer = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.num]) continue;
            visited[now.num] = true;
            answer += now.dis;

            for(int i = 0; i < roads[now.num].length; i++) {
                if(roads[now.num][i] != 0 && !visited[i]) {
                    pq.offer(new Node(i, roads[now.num][i]));
                }
            }
        }

        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }
}