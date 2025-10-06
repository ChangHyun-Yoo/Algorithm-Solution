import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        List<List<Node>> roads = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            while(true) {
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                int dis = Integer.parseInt(st.nextToken());
                roads.get(N).add(new Node(next, dis));
            }
        }

        boolean[] visited = new boolean[V + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        int maxDis = 0;
        int maxVertex = -1;
        while(!q.isEmpty()) {
            Node now = q.poll();
            visited[now.num] = true;
            if(now.dis > maxDis) {
                maxDis = now.dis;
                maxVertex = now.num;
            }

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num]) {
                    q.offer(new Node(next.num, now.dis + next.dis));
                }
            }
        }

        q.clear();
        Arrays.fill(visited, false);
        maxDis = 0;
        q.offer(new Node(maxVertex, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            visited[now.num] = true;
            if(now.dis > maxDis) {
                maxDis = now.dis;
            }

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num]) {
                    q.offer(new Node(next.num, now.dis + next.dis));
                }
            }
        }

        System.out.println(maxDis);
    }

    static class Node {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }
}
