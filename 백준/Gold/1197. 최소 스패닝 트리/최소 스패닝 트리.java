import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> roads = new ArrayList<>();
        for(int i = 0; i < V + 1; i++) {
            roads.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            roads.get(A).add(new Node(B, C));
            roads.get(B).add(new Node(A, C));
        }

        int num = 0;
        long answer = 0;
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.x]) continue;
            visited[now.x] = true;

            answer += (long) now.dis;
            if(++num == V) break;

            for(Node next: roads.get(now.x)) {
                if(!visited[next.x]) {
                    pq.offer(new Node(next.x, next.dis));
                }
            }
        }

        System.out.println(answer);
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
