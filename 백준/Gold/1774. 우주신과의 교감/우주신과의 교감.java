import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] height;
    static Edge[] edges;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        height = new int[N + 1];
        Arrays.fill(height, 1);
        edges = new Edge[N * (N - 1) / 2];
        double[][] places = new double[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double X = Long.parseLong(st.nextToken());
            double Y = Long.parseLong(st.nextToken());
            places[i][0] = X;
            places[i][1] = Y;
        }

        int count = 0;
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                edges[count] = new Edge(i + 1, j + 1, Math.sqrt(Math.pow(places[j][0] - places[i][0], 2) + Math.pow(places[j][1] - places[i][1], 2)));
                count++;
            }
        }

        Arrays.sort(edges);
        int num = 0;
        double answer = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(findRoot(a) != findRoot(b)) {
                union(a, b);
                num++;
            }
        }

        for(Edge now: edges) {
            if(findRoot(now.from) != findRoot(now.to)) {
                union(now.from, now.to);
                if(num == N - 1)
                    break;
                num++;
                answer += now.dis;
            }
        }

        System.out.println(String.format("%.2f", Math.round(answer * 100) / 100.0));
    }

    static int findRoot(int i) {
        if(i == parent[i])
            return i;

        return findRoot(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if(rootI == rootJ) return;

        if(height[rootI] < height[rootJ]) {
            parent[rootI] = rootJ;
        } else if(height[rootJ] < height[rootI]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootJ] = rootI;
            height[rootI]++;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double dis;

        public Edge(int from, int to, double dis) {
            this.from = from;
            this.to = to;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge e) {
            if(this.dis - e.dis < 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

