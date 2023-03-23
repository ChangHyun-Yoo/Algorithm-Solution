import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a != b) {
                roads.get(a).add(new Node(b, c));
                roads.get(b).add(new Node(a, c));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        int count = 0;
        long answer = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.num]) continue;
            visited[now.num] = true;

            count++;
            answer += now.dis;
            if(count == N) {
                break;
            }

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
