import java.io.*;
import java.util.*;

public class Main {

    static int[] min;
    static List<List<Integer>> road;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        road = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            road.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            road.get(s).add(e);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        min[X] = 0;
        while(!pq.isEmpty()) {
            Node c = pq.poll();
            if(visited[c.number]) {
                continue;
            }

            visited[c.number] = true;

            for(int index: road.get(c.number)) {
                if(!visited[index] && min[index] > min[c.number] + 1) {
                    min[index] = min[c.number] + 1;
                    pq.offer(new Node(index, min[index]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < min.length; i++) {
            if(min[i] == K)
                sb.append(i).append('\n');
        }
        if(sb.toString().length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
