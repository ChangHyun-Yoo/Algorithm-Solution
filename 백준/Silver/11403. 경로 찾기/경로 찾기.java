import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> roads = new ArrayList<>();
    static int[][] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        min = new int[N + 1][N + 1];
        for(int[] m: min) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for(int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < N + 1; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    roads.get(i).add(j);
                }
            }
        }

        for(int i = 1; i < N + 1; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));

            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(now.dis > min[i][now.x]) continue;

                for(int next: roads.get(now.x)) {
                    if(min[i][next] > now.dis + 1) {
                        min[i][next] = 1;
                        pq.offer(new Node(next, 1));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(min[i][j] == 1)
                    sb.append(1 + " ");
                else
                    sb.append(0 + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int x;
        int dis;

        public Node(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }

        public int compareTo(Node node) {
            return this.dis - node.dis;
        }
    }
}
