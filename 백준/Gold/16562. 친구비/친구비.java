import java.io.*;
import java.util.*;

public class Main {

    static int[] money;
    static int[] parent;
    static boolean[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        money = new int[N + 1];
        root = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N + 1; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            root[i] = true;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int m = 0;
        for(int i = 1; i < N + 1; i++) {
            if(root[i]) {
                m += money[i];
            }
        }

        if(k >= m) {
            System.out.println(m);
        } else {
            System.out.println("Oh no");
        }
    }

    static int findRoot(int i) {
        if(i == parent[i]) return i;

        return findRoot(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if(money[rootI] >= money[rootJ]) {
            parent[rootI] = rootJ;
            root[rootI] = false;
        } else {
            parent[rootJ] = rootI;
            root[rootJ] = false;
        }
    }
}