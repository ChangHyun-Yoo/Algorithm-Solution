import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        height = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        Arrays.fill(height, 1);

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] check = new int[M];
        boolean no = false;
        for(int i = 0; i < M; i++) {
            check[i] = findRoot(Integer.parseInt(st.nextToken()));
            if(i > 0) {
                if(check[i - 1] != check[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    static int findRoot(int i) {
        if(i == parent[i])
            return i;

        return findRoot(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        if(rootI == rootJ)
            return;

        if(height[rootI] == height[rootJ]) {
            parent[rootJ] = rootI;
            height[rootI]++;
        } else if(height[rootI] < height[rootJ]) {
            parent[rootI] = rootJ;
        } else {
            parent[rootJ] = rootI;
        }
    }

}
