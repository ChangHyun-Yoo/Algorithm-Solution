import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(findRoot(a) == findRoot(b)) {
                answer = i + 1;
                break;
            }

            union(a, b);
        }

        System.out.println(answer);
    }

    static int findRoot(int i) {
        if(parent[i] == i) return i;

        return parent[i] = findRoot(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if(rootI == rootJ) return;

        if(height[rootI] == height[rootJ]) {
            parent[rootI] = rootJ;
            height[rootJ]++;
        } else if(height[rootI] < height[rootJ]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootI] = rootJ;
        }
    }
}