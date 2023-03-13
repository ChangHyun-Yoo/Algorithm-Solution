import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> road = new ArrayList<>();
    static boolean[] visited;
    static int[] min;

    static class Node implements Comparable<Node> {
        int place;
        int dis;

        public Node(int place, int dis) {
            this.place = place;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        min = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            road.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            road.get(s).add(new Node(e, d));
        }

        int max = -1;
        int[] way1 = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            if(i != X) {
                Arrays.fill(min, Integer.MAX_VALUE);
                Arrays.fill(visited, false);

                PriorityQueue<Node> pq = new PriorityQueue<>();
                pq.offer(new Node(i, 0));
                min[i] = 0;
                while(!pq.isEmpty()) {
                    Node now = pq.poll();

                    if(visited[now.place]) {
                        continue;
                    }

                    visited[now.place] = true;

                    for(Node cand: road.get(now.place)) {
                        if(min[cand.place] > min[now.place] + cand.dis) {
                            min[cand.place] = min[now.place] + cand.dis;
                            pq.offer(new Node(cand.place, min[cand.place]));
                        }
                    }
                }
                way1[i] = min[X];
            }
        }

        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        min[X] = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.place]) {
                continue;
            }

            visited[now.place] = true;

            for(Node cand: road.get(now.place)) {
                if(min[cand.place] > min[now.place] + cand.dis) {
                    min[cand.place] = min[now.place] + cand.dis;
                    pq.offer(new Node(cand.place, min[cand.place]));
                }
            }
        }

        int answer = -1;
        for(int i = 1; i < N + 1; i++) {
            if(i != X && answer < min[i] + way1[i]) {
                answer = min[i] + way1[i];
            }
        }
        System.out.println(answer);
    }
}
