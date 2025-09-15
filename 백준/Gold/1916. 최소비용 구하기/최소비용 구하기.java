import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            roads.get(s).add(new Node(e, d));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.dis > min[now.x]) continue;
            min[now.x] = now.dis;

            for(Node next: roads.get(now.x)) {
                if(now.dis + next.dis < min[next.x]) {
                    min[next.x] = now.dis + next.dis;
                    pq.offer(new Node(next.x, min[next.x]));
                }
            }
        }
        
        System.out.println(min[end]);
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
