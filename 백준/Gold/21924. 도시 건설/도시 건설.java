import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads = new ArrayList<>();
    static int N;
    static int M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        long sum = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            roads.get(a).add(new Node(b, c));
            roads.get(b).add(new Node(a, c));
            sum += c;
        }

        int count = 0;
        long answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.x]) continue;

            visited[now.x] = true;
            count++;
            answer += now.dis;
            if(count == N) break;

            for(Node next: roads.get(now.x)) {
                if(!visited[next.x]) {
                    pq.offer(next);
                }
            }
        }

        if(count == N) System.out.println(sum - answer);
        else System.out.println(-1);
    }

    static class Node implements Comparable<Node> {
        int x;
        int dis;

        public Node(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }

        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }
}