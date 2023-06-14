import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static char[] sex;
    static boolean[] visited;
    static List<List<Node>> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sex = new char[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++) {
            sex[i] = st.nextToken().charAt(0);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(sex[s] != sex[e]) {
                roads.get(s).add(new Node(e, d));
                roads.get(e).add(new Node(s, d));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int dis = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.x]) continue;

            visited[now.x] = true;
            dis += now.dis;
            count++;
            if(count == N) break;

            for(Node next: roads.get(now.x)) {
                if(!visited[next.x]) {
                    pq.offer(next);
                }
            }
        }

        if(count == N) System.out.println(dis);
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