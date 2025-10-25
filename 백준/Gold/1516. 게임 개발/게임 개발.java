import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N + 1];
        int[] before = new int[N + 1];
        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            while(true) {
                int b = Integer.parseInt(st.nextToken());

                if(b == -1) break;

                before[i]++;
                roads.get(b).add(i);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0) pq.offer(new Node(i, times[i]));
        }

        int[] answer = new int[N + 1];
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            answer[now.x] = now.time;

            for(int next: roads.get(now.x)) {
                if(--before[next] == 0) pq.offer(new Node(next, answer[now.x] + times[next]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append('\n');
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
