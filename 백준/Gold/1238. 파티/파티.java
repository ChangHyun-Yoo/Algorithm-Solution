import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Node>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            roads.get(A).add(new Node(B, T));
        }

        int[][] min = new int[N + 1][N + 1];
        for(int[] m: min) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for(int i = 1; i < N + 1; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));

            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(now.dis > min[i][now.num]) continue;
                min[i][now.num] = now.dis;

                for(Node next: roads.get(now.num)) {
                    if(min[i][next.num] > now.dis + next.dis) {
                        min[i][next.num] = now.dis + next.dis;
                        pq.offer(new Node(next.num, min[i][next.num]));
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i < N + 1; i++) {
            max = Math.max(max, min[i][X] + min[X][i]);
        }
        System.out.println(max);
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
