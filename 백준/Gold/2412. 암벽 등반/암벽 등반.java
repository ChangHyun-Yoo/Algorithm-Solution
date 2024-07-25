import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int T;
    static Node[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        nodes = new Node[n + 1];
        visited = new boolean[n + 1];

        nodes[0] = new Node(0, 0, 0);
        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y, 0);
        }

        Arrays.sort(nodes);

        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0, 0));

        int answer = -1;

        while(!q.isEmpty()) {
            Info now = q.poll();

            if(visited[now.index]) continue;
            visited[now.index] = true;
            if(nodes[now.index].y == T) {
                answer = now.num;
                break;
            }

            int low1 = 0;
            int high1 = nodes.length;

            while(low1 < high1) {
                int mid = low1 + (high1 - low1) / 2;

                if(nodes[mid].x > nodes[now.index].x - 3) {
                    high1 = mid;
                } else {
                    low1 = mid + 1;
                }
            }

            int low2 = 0;
            int high2 = nodes.length;

            while(low2 < high2) {
                int mid = low2 + (high2 - low2) / 2;

                if(nodes[mid].x > nodes[now.index].x + 2) {
                    high2 = mid;
                } else {
                    low2 = mid + 1;
                }
            }

            for(int j = low1; j < low2; j++) {
                if(Math.abs(nodes[now.index].y - nodes[j].y) <= 2) {
                    q.offer(new Info(j, now.num + 1));
                }
            }
        }

        System.out.println(answer);
    }

    static class Info {
        int index;
        int num;

        public Info(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        public int compareTo(Node n) {
            if(this.x == n.x) {
                return this.y - n.y;
            }
            return this.x - n.x;
        }
    }
}
