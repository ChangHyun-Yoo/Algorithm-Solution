import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            roads.get(a).add(new Node(b, c));
            roads.get(b).add(new Node(a, c));
        }
        long[][] min = new long[N + 1][3];
        for(long[] m: min) {
            Arrays.fill(m, Long.MAX_VALUE);
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.dis > min[now.x][0]) continue;
            min[now.x][0] = now.dis;

            for(Node next: roads.get(now.x)) {
                if(min[next.x][0] > now.dis + next.dis) {
                    min[next.x][0] = now.dis + next.dis;
                    pq.offer(new Node(next.x, min[next.x][0]));
                }
            }
        }

        pq.clear();
        pq.offer(new Node(v1, 0));
        
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.dis > min[now.x][1]) continue;
            min[now.x][1] = now.dis;

            for(Node next: roads.get(now.x)) {
                if(min[next.x][1] > now.dis + next.dis) {
                    min[next.x][1] = now.dis + next.dis;
                    pq.offer(new Node(next.x, min[next.x][1]));
                }
            }
        }

        pq.clear();
        pq.offer(new Node(v2, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.dis > min[now.x][2]) continue;
            min[now.x][2] = now.dis;

            for(Node next: roads.get(now.x)) {
                if(min[next.x][2] > now.dis + next.dis) {
                    min[next.x][2] = now.dis + next.dis;
                    pq.offer(new Node(next.x, min[next.x][2]));
                }
            }
        }

        long answer = Long.MAX_VALUE;
        if(min[v1][0] != Long.MAX_VALUE && min[v2][1] != Long.MAX_VALUE && min[N][2] != Long.MAX_VALUE) {
            answer = Math.min(answer, min[v1][0] + min[v2][1] + min[N][2]);
        }
        if(min[v2][0] != Long.MAX_VALUE && min[v1][2] != Long.MAX_VALUE && min[N][1] != Long.MAX_VALUE) {
            answer = Math.min(answer, min[v2][0] + min[v1][2] + min[N][1]);
        }
        if(answer == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        int x;
        long dis;

        public Node(int x, long dis) {
            this.x = x;
            this.dis = dis;
        }

        public int compareTo(Node n) {
            if(this.dis - n.dis < 0) return -1;
            else if(this.dis - n.dis == 0) return 0;
            else return 1;
        }
    }
}
