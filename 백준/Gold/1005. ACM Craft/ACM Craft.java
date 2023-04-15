import java.io.*;
import java.util.*;

public class Main {

    static int[] time;
    static int[] before;
    static List<List<Integer>> next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            next = new ArrayList<>();
            for(int i = 0; i < N + 1; i++) {
                next.add(new ArrayList<>());
            }

            time = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i < N + 1; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            before = new int[N + 1];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                next.get(s).add(e);
                before[e]++;
            }

            int W = Integer.parseInt(br.readLine());
            int[] min = new int[N + 1];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i = 1; i < N + 1; i++) {
                if(before[i] == 0) {
                    pq.offer(new Node(i, time[i]));
                }
            }

            while(!pq.isEmpty()) {
                Node now = pq.poll();
                if(now.num == W) {
                    min[now.num] = now.time;
                    break;
                }
                for(int ne: next.get(now.num)) {
                    before[ne]--;
                    if(before[ne] == 0) {
                        pq.offer(new Node(ne, time[ne] + now.time));
                    }
                }
            }
            System.out.println(min[W]);
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }

        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}