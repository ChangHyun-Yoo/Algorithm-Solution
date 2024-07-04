import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        height = new int[N + 1];
        Arrays.fill(height, 1);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            union(X, Y);
        }

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int c = findRoot(C);
        int h = findRoot(H);

        int count = 0;
        int[] root = new int[N + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < N + 1; i++) {
            root[i] = findRoot(i);
            if(root[i] == c) count++;

            if(root[i] != c && root[i] != h)
                if(map.get(root[i]) == null) {
                    map.put(root[i], 1);
                } else {
                    map.replace(root[i], map.get(root[i]) + 1);
                }
        }

        List<Node> lst = new ArrayList<>();
        for(int r: map.keySet()) {
            lst.add(new Node(r, map.get(r)));
        }
        Collections.sort(lst);

        for(int i = 0; i < lst.size() && i < K; i++) {
            count += lst.get(i).num;
        }

        System.out.println(count);
    }

    static class Node implements Comparable<Node> {
        int parent;
        int num;

        public Node(int parent, int num) {
            this.parent = parent;
            this.num = num;
        }

        public int compareTo(Node n) {
            return n.num - this.num;
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

        if(height[rootI] > height[rootJ]) {
            parent[rootJ] = rootI;
        } else if(height[rootJ] > height[rootI]) {
            parent[rootI] = rootJ;
        } else {
            parent[rootI] = rootJ;
            height[rootJ]++;
        }
    }
}
