import java.util.*;
import java.io.*;

public class Main {

    static List<List<Node>> roads = new ArrayList<>();
    static int[] max;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        max = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            roads.get(h1).add(new Node(h2, k));
            roads.get(h2).add(new Node(h1, k));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, Integer.MAX_VALUE));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.x]) continue;
            visited[now.x] = true;
            max[now.x] = now.val;

            for(Node next: roads.get(now.x)) {
                if(!visited[next.x]) {
                    pq.offer(new Node(next.x, Math.min(next.val, now.val)));
                }
            }
        }

        System.out.println(max[e]);
    }

    static class Node implements Comparable<Node> {
        int x;
        int val;

        public Node(int x, int val) {
            this.x = x;
            this.val = val;
        }

        public int compareTo(Node n) {
            return n.val - this.val;
        }
    }
}