import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int W;
    static double M;
    static double[][] roads;
    static long[][] points;
    static double[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(br.readLine());

        roads = new double[N + 1][N + 1];
        for(double[] road: roads) {
            Arrays.fill(road, -1);
        }
        points = new long[N + 1][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            points[i + 1][0] = Long.parseLong(st.nextToken());
            points[i + 1][1] = Long.parseLong(st.nextToken());
        }
        min = new double[N + 1];
        Arrays.fill(min, Double.MAX_VALUE);

        for(int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            roads[s][e] = 0;
            roads[e][s] = 0;
        }

        for(int i = 1; i < N; i++) {
            for(int j = i + 1; j <= N; j++) {
                double length = Math.sqrt((points[j][0] - points[i][0])*(points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]));

                if(length <= M) {
                    if(roads[j][i] == -1) {
                        roads[j][i] = length;
                        roads[i][j] = length;
                    } else {
                        if(roads[j][i] > length) {
                            roads[j][i] = length;
                            roads[i][j] = length;
                        }
                    }
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.dis > min[now.x]) continue;

            for(int i = 1; i <= N; i++) {
                if(roads[now.x][i] != -1)
                    if(now.dis + roads[now.x][i] < min[i]) {
                        min[i] = now.dis + roads[now.x][i];
                        pq.offer(new Node(i, min[i]));
                    }
            }
        }
        System.out.println((long) (min[N] * 1000));
    }

    static class Node implements Comparable<Node> {
        int x;
        double dis;

        public Node(int x, double dis) {
            this.x = x;
            this.dis = dis;
        }

        public int compareTo(Node n) {
            return (this.dis - n.dis) < 0 ? -1 : 1;
        }
    }
}