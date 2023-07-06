import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int K = Integer.parseInt(br.readLine());

            parent = new int[N];
            height = new int[N];
            for(int i = 0; i < N; i++) {
                parent[i] = i;
            }
            Arrays.fill(height, 1);

            for(int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int M = Integer.parseInt(br.readLine());

            sb.append("Scenario " + t + ":").append('\n');
            for(int m = 0; m < M; m++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(findRoot(a) == findRoot(b)) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int findRoot(int i) {
        if(i == parent[i]) return i;

        return parent[i] = findRoot(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if(rootI == rootJ) return;

        if(height[rootI] < height[rootJ]) {
            parent[rootI] = rootJ;
        } else if(height[rootI] > height[rootJ]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootJ] = rootI;
            height[rootI]++;
        }
    }
}