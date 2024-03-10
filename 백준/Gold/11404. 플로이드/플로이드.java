import java.util.*;
import java.io.*;

public class Main {

    static List<List<Node>> roads = new ArrayList<>();
    static int[][] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        min = new int[n + 1][n + 1];
        for(int[] mm: min) {
            Arrays.fill(mm, Integer.MAX_VALUE);
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            roads.get(s).add(new Node(e, d));
        }

        for(int i = 1; i < n + 1; i++) {

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));

            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(min[i][now.num] < now.dis) continue;
                min[i][now.num] = now.dis;

                for(Node next: roads.get(now.num)) {
                    if(min[i][next.num] > min[i][now.num] + next.dis) {
                        min[i][next.num] = min[i][now.num] + next.dis;
                        pq.offer(new Node(next.num, min[i][next.num]));
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                sb.append((min[i][j] == Integer.MAX_VALUE ? 0 : min[i][j]) + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
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