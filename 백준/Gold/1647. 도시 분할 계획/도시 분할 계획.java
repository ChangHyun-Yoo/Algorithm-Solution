import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            roads.get(A).add(new Node(B, C));
            roads.get(B).add(new Node(A, C));
        }

        int max = 0;
        int dis = 0;
        int count = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.x]) continue;

            visited[now.x] = true;
            count += 1;
            dis += now.money;
            if(now.money != 0) {
                max = Math.max(max, now.money);
            }
            if(count == N) break;

            for(Node next: roads.get(now.x)) {
                if(!visited[next.x]) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(dis - max);

    }

    static class Node implements Comparable<Node> {
        int x;
        int money;

        public Node(int x, int money) {
            this.x = x;
            this.money = money;
        }

        public int compareTo(Node o) {
            return this.money - o.money;
        }
    }
}