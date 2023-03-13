import java.io.*;
import java.util.*;

public class Main {

    static int[][] buses;
    static boolean[] visited;
    static int[] min;

    static class Node implements Comparable<Node> {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        buses = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        min = new int[N + 1];

        for(int[] bus : buses) {
            Arrays.fill(bus, -1);
        }
        Arrays.fill(min, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(buses[s][e] == -1 || buses[s][e] > m) {
                buses[s][e] = m;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        min[s] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(visited[node.num]) {
                continue;
            }

            visited[node.num] = true;

            for(int i = 1; i < N + 1; i++) {
                if(buses[node.num][i] != -1 && min[i] > min[node.num] + buses[node.num][i]) {
                    min[i] = min[node.num] + buses[node.num][i];
                    pq.offer(new Node(i, min[i]));
                }
            }
        }

        System.out.println(min[e]);
    }
}
