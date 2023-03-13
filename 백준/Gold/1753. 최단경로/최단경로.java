import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> info = new ArrayList<>();
    static int[] min;
    static boolean[] visited;

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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        min = new int[V + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i = 0; i < V + 1; i++) {
            info.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            info.get(s).add(new Node(e, d));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        min[K] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(visited[node.num]) {
               continue;
            }

            visited[node.num] = true;

            for(Node n: info.get(node.num)) {
                if(min[n.num] > min[node.num] + n.dis) {
                    min[n.num] = min[node.num] + n.dis;
                    pq.offer(new Node(n.num, min[n.num]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < min.length; i++) {
            if(min[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
            } else {
                sb.append(min[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
