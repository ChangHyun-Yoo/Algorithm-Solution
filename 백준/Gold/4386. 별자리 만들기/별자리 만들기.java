import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] place = new int[n][2];
        Edge[] edges = new Edge[n * (n - 1) / 2];
        parent = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            place[i][0] = (int) Double.parseDouble(st.nextToken()) * 100;
            place[i][1] = (int) Double.parseDouble(st.nextToken()) * 100;
        }
        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                edges[count] = new Edge(i, j, (int) Math.sqrt(Math.pow(place[j][1] - place[i][1], 2) + Math.pow(place[j][0] - place[i][0], 2)));
                count++;
            }
        }
        Arrays.sort(edges);

        int res = 0;
        int num = 0;
        for(Edge edge: edges) {
            if(union(edge.from, edge.to)) {
                res += edge.dis;
                num++;
                if(num == n) break;
            }
        }

        System.out.println(res / 100.0);
    }

    static int findRoot(int i) {
        if(i == parent[i])
            return i;

        return findRoot(parent[i]);
    }

    static boolean union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if(rootI == rootJ) return false;
        parent[rootI] = rootJ;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int dis;

        public Edge(int from, int to, int dis) {
            this.from = from;
            this.to = to;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dis - o.dis;
        }
    }
}
