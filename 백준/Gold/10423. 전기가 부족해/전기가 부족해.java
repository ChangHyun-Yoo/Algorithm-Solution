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
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        for(int i = 0; i < K; i++) {
            int k = Integer.parseInt(st.nextToken());
            pq.offer(new Node(k, 0));
            visited[k] = true;
            count++;
        }

        for(int i = 0; i < M; i++) {
            st =  new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            roads.get(u).add(new Node(v, w));
            roads.get(v).add(new Node(u, w));
        }

        for(int i = 0; i < K; i++) {
            Node polled = pq.poll();

            for(Node next: roads.get(polled.num)) {
                if(!visited[next.num]) {
                    pq.offer(new Node(next.num, next.dis));
                }
            }
        }

        int answer = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.num]) continue;

            visited[now.num] = true;
            count++;
            answer += now.dis;
            if(count == N) break;

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num]) {
                    pq.offer(new Node(next.num, next.dis));
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
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }
}

