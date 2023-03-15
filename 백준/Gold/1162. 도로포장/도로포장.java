import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads;
    static long[][] min;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int num;
        long dis;
        int cnt;

        public Node(int num, long dis, int cnt) {
            this.num = num;
            this.dis = dis;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            if(this.dis - n.dis > 0)
                return 1;
            else if(this.dis == n.dis) return 0;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        min = new long[N + 1][K + 1];
        for(long[] m: min) {
            Arrays.fill(m, Long.MAX_VALUE);
        }
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            roads.get(s).add(new Node(e, l, 0));
            roads.get(e).add(new Node(s, l, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));
        min[1][0] = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.dis > min[now.num][now.cnt])
                continue;

            for(Node next: roads.get(now.num)) {
                if(now.cnt < K) {//현재 도로 포장이 K보다 적을 때
                    if(min[next.num][now.cnt + 1] > min[now.num][now.cnt]) {//도로 포장할 때
                        min[next.num][now.cnt + 1] = min[now.num][now.cnt];
                        pq.offer(new Node(next.num, min[next.num][now.cnt + 1], now.cnt + 1));
                    }
                }

                if(min[next.num][now.cnt] > min[now.num][now.cnt] + next.dis) {//도로 포장 안할 때
                    min[next.num][now.cnt] = min[now.num][now.cnt] + next.dis;
                    pq.offer(new Node(next.num, min[next.num][now.cnt], now.cnt));
                }
            }
        }

        long answer = Long.MAX_VALUE;
        for(int i = 0; i < min[N].length; i++) {
            if(min[N][i] < answer)
                answer = min[N][i];
        }
        System.out.println(answer);
    }
}
