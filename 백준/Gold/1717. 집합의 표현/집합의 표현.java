import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //초기화
        parent = new int[n + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        height = new int[n + 1];
        Arrays.fill(height, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(k == 1) {
                if(findRoot(a) == findRoot(b))
                    sb.append("YES").append('\n');
                else
                    sb.append("NO").append('\n');
            } else {
                union(a, b);
            }
        }
        System.out.println(sb);
    }

    static int findRoot(int i) {
        if(i == parent[i])
            return i;

        return findRoot(parent[i]);
    }

    static void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if(rootA == rootB)
            return;

        if(height[rootA] > height[rootB]) {
            parent[rootB] = rootA;
        } else if(height[rootB] > height[rootA]) {
            parent[rootA] = rootB;
        } else {
            parent[rootA] = rootB;
            height[rootB]++;
        }
    }

}
