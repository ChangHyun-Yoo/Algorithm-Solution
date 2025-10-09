import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] times = new int[N + 1];
            int[] before = new int[N + 1];
            List<List<Integer>> roads = new ArrayList<>();
            for(int i = 0; i < N + 1; i++) {
                roads.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < N + 1; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                roads.get(X).add(Y);
                before[Y]++;
            }
            int W = Integer.parseInt(br.readLine());

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i = 1; i < N + 1; i++) {
                if(before[i] == 0) pq.offer(new Node(i, times[i]));
            }

            int[] answer = new int[N + 1];
            while(!pq.isEmpty()) {
                Node now = pq.poll();

                answer[now.x] = Math.max(answer[now.x], now.time);

                for(int next: roads.get(now.x)) {
                    if(--before[next] == 0) {
                        pq.offer(new Node(next, answer[now.x] + times[next]));
                    }
                }
            }
            sb.append(answer[W]).append('\n');
        }

        System.out.print(sb.toString());
    }

    static class Node implements Comparable<Node> {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }

        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }
}
