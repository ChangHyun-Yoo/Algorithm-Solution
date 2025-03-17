import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        height = new int[N + 1];
        Arrays.fill(height, 0);

        List<Edge> edges = new ArrayList<>();
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }
        Collections.sort(edges);

        int count = 0;
        int answer = 0;
        int max = 0;
        for(int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if(findParent(edge.start) == findParent(edge.end)) continue;
            union(edge.start, edge.end);
            count++;
            answer += edge.cost;
            max = Math.max(max, edge.cost);

            if(count == N - 1) break;
        }

        System.out.println(answer - max);
    }

    static int findParent(int i) {
        if(parent[i] == i) return i;
        return parent[i] = findParent(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findParent(i);
        int rootJ = findParent(j);

        if(rootI != rootJ) {
            if(height[rootI] > height[rootJ]) {
                parent[rootJ] = rootI;
            } else if(height[rootJ] > height[rootI]) {
                parent[rootI] = rootJ;
            } else {
                parent[rootI] = rootJ;
                height[rootJ]++;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
}
