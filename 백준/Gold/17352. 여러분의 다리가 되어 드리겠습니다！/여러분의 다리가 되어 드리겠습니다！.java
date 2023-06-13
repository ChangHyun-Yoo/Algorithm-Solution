import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        height = new int[N + 1];
        Arrays.fill(height, 1);

        for(int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Set<Integer> s = new HashSet<>();
        for(int i = 1; i < N + 1 && s.size() != 2; i++) {
            s.add(findRoot(i));
        }
        for(int i: s) {
            System.out.print(i + " ");
        }
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
        } else if(height[rootJ] == height[rootJ]) {
            parent[rootI] = rootJ;
            height[rootJ]++;
        } else {
            parent[rootJ] = rootI;
        }
    }

}
