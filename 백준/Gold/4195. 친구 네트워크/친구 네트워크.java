import java.io.*;
import java.util.*;

public class Main {

    static Set<String> friends;
    static Map<String, Integer> index;
    static int[] parent;
    static int[] height;
    static int[] network;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            friends = new HashSet<>();
            index = new HashMap<>();
            parent = new int[2 * F + 1];
            height = new int[2 * F + 1];
            network = new int[2 * F + 1];

            for(int f = 0; f < F; f++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                if(friends.contains(s1) && friends.contains(s2)) {
                    union(index.get(s1), index.get(s2));
                } else if(!friends.contains(s1) && friends.contains(s2)) {
                    friends.add(s1);
                    index.put(s1, index.size());
                    parent[index.size() - 1] = index.size() - 1;
                    height[index.size() - 1] = 1;
                    network[index.size() - 1] = 1;
                    union(index.get(s1), index.get(s2));
                } else if(friends.contains(s1) && !friends.contains(s2)) {
                    friends.add(s2);
                    index.put(s2, index.size());
                    parent[index.size() - 1] = index.size() - 1;
                    height[index.size() - 1] = 1;
                    network[index.size() - 1] = 1;
                    union(index.get(s1), index.get(s2));
                } else {
                    friends.add(s1);
                    index.put(s1, index.size());
                    parent[index.size() - 1] = index.size() - 1;
                    height[index.size() - 1] = 1;
                    network[index.size() - 1] = 1;
                    friends.add(s2);
                    index.put(s2, index.size());
                    parent[index.size() - 1] = index.size() - 1;
                    height[index.size() - 1] = 1;
                    network[index.size() - 1] = 1;
                    union(index.get(s1), index.get(s2));
                }
            }
        }
        System.out.println(sb);
    }

    static int findRoot(int i) {
        if(i == parent[i])
            return i;

        return findRoot(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        if(rootI == rootJ) {
            sb.append(network[rootJ]).append('\n');
            return;
        }

        if(height[rootI] < height[rootJ]) {
            parent[rootI] = rootJ;
            network[rootJ] += network[rootI];
            sb.append(network[rootJ]).append('\n');
        } else if(height[rootI] > height[rootJ]) {
            parent[rootJ] = rootI;
            network[rootI] += network[rootJ];
            sb.append(network[rootI]).append('\n');
        } else {
            parent[rootJ] = rootI;
            height[rootI]++;
            network[rootI] += network[rootJ];
            sb.append(network[rootI]).append('\n');
        }
    }
}
