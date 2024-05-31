import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] parent;
    static int[] height;
    static boolean[] truths;
    static List<Integer> g = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        height = new int[N + 1];
        truths = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        int tn = Integer.parseInt(st.nextToken());

        for(int i = 0; i < tn; i++) {
            truths[Integer.parseInt(st.nextToken())] = true;
        }

        for(int i = 0;i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int sn = Integer.parseInt(st.nextToken());

            int f = Integer.parseInt(st.nextToken());

            g.add(f);

            for(int j = 0; j < sn - 1; j++) {
                union(f, Integer.parseInt(st.nextToken()));
            }
        }

        int answer = 0;
        for(int i = 0; i < g.size(); i++) {
            if(!truths[findRoot(g.get(i))]) answer++;
        }

        System.out.println(answer);
    }

    static int findRoot(int i) {
        if(i == parent[i]) return i;

        return parent[i] = findRoot(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);

        if(truths[rootI] || truths[rootJ]) {
            truths[rootI] = true;
            truths[rootJ] = true;
        }

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
