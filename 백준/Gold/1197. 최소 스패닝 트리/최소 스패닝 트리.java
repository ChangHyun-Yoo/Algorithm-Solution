import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        roads = new ArrayList<>();
        for(int i = 0; i < V + 1; i++) {
            roads.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];
        for(int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            roads.get(A).add(new Node(B, C));
            roads.get(B).add(new Node(A, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        int count = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.num]) continue;
            visited[now.num] = true;
            count++;
            answer += now.dis;
            if(count == V) break;

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num]) {
                    pq.offer(new Node(next.num, next.dis));
                }
            }
        }
        System.out.println(answer);
    }

    private static class Node implements Comparable<Node> {
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
}
