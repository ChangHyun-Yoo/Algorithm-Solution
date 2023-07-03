import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> roads = new ArrayList<>();
    static int[][] min = new int[123][123];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < 123; i++) {
            roads.add(new ArrayList<>());
        }
        for(int[] m: min) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " => ");
            int s = (int) st.nextToken().charAt(0);
            int e = (int) st.nextToken().charAt(0);

            roads.get(s).add(e);
        }

        for(int i = 65; i <= 90; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));
            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(min[i][now.x] < now.dis) continue;
                min[i][now.x] = now.dis;

                for(int next: roads.get(now.x)) {
                    if(min[i][next] > now.dis + 1) {
                        min[i][next] = now.dis + 1;
                        pq.offer(new Node(next, now.dis + 1));
                    }
                }
            }
        }

        for(int i = 97; i <= 122; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));
            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(min[i][now.x] < now.dis) continue;
                min[i][now.x] = now.dis;

                for(int next: roads.get(now.x)) {
                    if(min[i][next] > now.dis + 1) {
                        min[i][next] = now.dis + 1;
                        pq.offer(new Node(next, now.dis + 1));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        //자기 자신의 길은 체크하지 않는다
        for(int i = 65; i <= 90; i++) {
            for(int j = 65; j <= 122; j++) {
                if(min[i][j] != 0 && min[i][j] != Integer.MAX_VALUE) {
                    sb.append((char) i + " => " + (char) j).append('\n');
                    count++;
                }
            }
        }

        for(int i = 97; i <= 122; i++) {
            for(int j = 65; j <= 122; j++) {
                if(min[i][j] != 0 && min[i][j] != Integer.MAX_VALUE) {
                    sb.append((char) i + " => " + (char) j).append('\n');
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(sb);
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