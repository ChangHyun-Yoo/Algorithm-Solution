import java.util.*;
import java.io.*;

public class Main {

    static List<List<Node>> roads = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            roads.get(A).add(new Node(B, C));
            roads.get(B).add(new Node(A, C));
        }

        int count = 0;
        int dis = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.num]) continue;
            visited[now.num] = true;
            dis += now.dis;
            count++;
            if(count == N) break;

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num]) {
                    pq.offer(next);
                }
            }
        }

        if(N >= 2) {
            dis += (N - 2)*(t + t * (N - 2)) / 2;
        }

        System.out.println(dis);
    }

    static class Node implements Comparable<Node> {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }
}
