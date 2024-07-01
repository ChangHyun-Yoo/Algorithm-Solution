import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, c));
        }

        long[] min = new long[N + 1];
        Arrays.fill(min, Long.MAX_VALUE);
        min[1] = 0;

        for(int i = 1; i <= N; i++) {

            for(Edge edge: edges) {

                if(min[edge.start] == Long.MAX_VALUE) continue;

                if(min[edge.end] > min[edge.start] + edge.cost) {
                    min[edge.end] = min[edge.start] + edge.cost;

                    if(i == N) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for(int i = 2; i < min.length; i++) {
            if(min[i] == Long.MAX_VALUE) System.out.println(-1);
            else System.out.println(min[i]);
        }
    }

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
