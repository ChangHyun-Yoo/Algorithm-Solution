import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads = new ArrayList<>();
    static int[][] min;
    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        min = new int[n + 1][n + 1];
        for(int[] mm: min) {
            Arrays.fill(mm, Integer.MAX_VALUE);
        }
        items = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            roads.get(s).add(new Node(e, v));
            roads.get(e).add(new Node(s, v));
        }

        for(int i = 1; i <= n; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));

            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(now.dis > min[i][now.x]) continue;

                min[i][now.x] = now.dis;

                for(Node next: roads.get(now.x)) {
                    if(min[i][next.x] > next.dis + now.dis) {
                        min[i][next.x] = next.dis + now.dis;
                        pq.offer(new Node(next.x, min[i][next.x]));
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            int a = 0;
            for(int j = 1; j <= n; j++) {
                if(min[i][j] <= m) {
                    a += items[j];
                }
            }
            if(max < a) max = a;
        }
        System.out.println(max);
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