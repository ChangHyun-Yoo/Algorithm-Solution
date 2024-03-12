import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static List<List<Node>> roads = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            roads.get(s).add(new Node(e, d));
            roads.get(e).add(new Node(s, d));
        }

        int max = -1;
        int maxNode = 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();

            visited[now.num] = true;
            if(max < now.dis) {
                max = now.dis;
                maxNode = now.num;
            }

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num]) {
                    q.offer(new Node(next.num, now.dis + next.dis));
                }
            }
        }

        int first = maxNode;
        max = -1;
        maxNode = 0;
        visited = new boolean[n + 1];

        q.clear();
        q.offer(new Node(first, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();

            visited[now.num] = true;
            if(max < now.dis) {
                max = now.dis;
                maxNode = now.num;
            }

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num]) {
                    q.offer(new Node(next.num, now.dis + next.dis));
                }
            }
        }

        System.out.println(max);
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