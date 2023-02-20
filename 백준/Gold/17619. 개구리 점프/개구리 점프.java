import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int x1;
        int x2;
        int y;

        public Node(int x1, int x2, int y) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }

        public int compareTo(Node n) {
            if(this.x1 == n.x1) {
                return this.x2 - n.x2;
            } else {
                return this.x1 - n.x1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            pq.offer(new Node(x1, x2, i + 1));
        }

        int[] check = new int[N + 1];
        Node init = pq.poll();
        int x1 = init.x1;
        int x2 = init.x2;
        check[init.y] = 1;

        int move = 1;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(x2 >= node.x1) {//점프할 수 있으면
                check[node.y] = move;
                x2 = Math.max(x2, node.x2);
            } else {
                move++;
                check[node.y] = move;
                x1 = node.x1;
                x2 = node.x2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            if(check[i1] == check[i2])
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }

        System.out.println(sb);
    }
}
