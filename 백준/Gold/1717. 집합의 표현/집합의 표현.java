import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] height = new int[n + 1];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(c == 0) {
                union(a, b, parent, height);
            } else {
                if(findParent(a, parent) == findParent(b, parent)) sb.append("YES");
                else sb.append("NO");
                sb.append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    static int findParent(int x, int[] parent) {
        if(x == parent[x]) return x;

        return parent[x] = findParent(parent[x], parent);
    }

    static void union(int a, int b, int[] parent, int[] height) {
        int rootA = findParent(a, parent);
        int rootB = findParent(b, parent);

        if(rootA == rootB) return;

        if(height[rootA] > height[rootB]) {
            parent[rootB] = rootA;
        } else if(height[rootA] < height[rootB]) {
            parent[rootA] = rootB;
        } else {
            parent[rootA] = rootB;
            height[rootB]++;
        }
    }
}
