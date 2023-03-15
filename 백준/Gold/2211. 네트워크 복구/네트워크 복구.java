import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads;
    static int[] before;
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
        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        roads = new ArrayList<>();
        before = new int[N + 1];
        min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        for(int i = 0 ; i < N + 1; i++) {
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

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        min[1] = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(now.dis > min[now.num])
                continue;
            for(Node next: roads.get(now.num)) {
                if(min[next.num] > min[now.num] + next.dis) {
                    min[next.num] = min[now.num] + next.dis;
                    before[next.num] = now.num;
                    pq.offer(new Node(next.num, min[next.num]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - 1).append('\n');
        for(int i = 1; i < before.length; i++) {
            if(before[i] != 0) {
                sb.append(i + " " + before[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
