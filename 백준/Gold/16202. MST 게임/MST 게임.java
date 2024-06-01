import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] roads = new int[M][3];
        parent = new int[N + 1];
        height = new int[N + 1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            roads[i - 1][0] = Integer.parseInt(st.nextToken());
            roads[i - 1][1] = Integer.parseInt(st.nextToken());
            roads[i - 1][2] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < K; k++) {
            init();

            int count = 0;
            int length = 0;
            for(int j = k; j < roads.length; j++) {
                if(findParent(roads[j][0]) == findParent(roads[j][1])) continue;
                else {
                    union(roads[j][0], roads[j][1]);
                    length += roads[j][2];
                    count++;
                    if(count == N - 1) break;
                }
            }

            if(count == N - 1) sb.append(length).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.print(sb);
    }

    static void init() {
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.fill(height, 0);
    }

    static int findParent(int i) {
        if(i == parent[i]) return i;

        return parent[i] = findParent(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findParent(i);
        int rootJ = findParent(j);

        if(rootI == rootJ) return;

        if(height[rootI] < height[rootJ]) {
            parent[rootI] = rootJ;
        } else if(height[rootJ] < height[rootI]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootI] = rootJ;
            height[rootJ]++;
        }
    }
}
