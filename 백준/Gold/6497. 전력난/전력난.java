import java.util.*;
import java.io.*;

public class Main {

    static int m;
    static int n;
    static int[] parent;
    static int[] heights;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0) break;
            parent = new int[m];
            heights = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            Road[] roads = new Road[n];

            int max = 0;
            int current = 0;
            int connected = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                roads[i] = new Road(x, y, z);
                max += z;
            }

            Arrays.sort(roads);

            for (int i = 0; i < n; i++) {
                int x = roads[i].x;
                int y = roads[i].y;
                int z = roads[i].z;

                if (findRoot(x) == findRoot(y)) continue;

                union(x, y);
                current += z;
                connected++;
                if (connected == m - 1) break;
            }

            System.out.println(max - current);

        }
    }

    static int findRoot(int n) {
        if(parent[n] == n) return n;
        return parent[n] = findRoot(parent[n]);
    }

    static void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if(rootX != rootY) {
            if(heights[rootX] == heights[rootY]) {
                parent[rootY] = rootX;
                heights[rootX]++;
            } else if(heights[rootX] < heights[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }
    }

    static class Road implements Comparable<Road> {
        int x;
        int y;
        int z;

        public Road(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Road r) {
            return this.z - r.z;
        }
    }
}