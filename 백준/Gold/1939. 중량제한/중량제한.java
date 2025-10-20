import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> roads = new ArrayList<>();
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

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] max = new int[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, Integer.MAX_VALUE));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.dis < max[now.num]) continue;
            max[now.num] = now.dis;

            for(Node next: roads.get(now.num)) {
                int min = Math.min(now.dis, next.dis);

                if(max[next.num] < min) {
                    max[next.num] = min;
                    pq.offer(new Node(next.num, min));
                }
            }
        }

        System.out.println(max[e]);
    }

    static class Node implements Comparable<Node> {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        public int compareTo(Node n) {
            return n.dis - this.dis;
        }
    }
}
