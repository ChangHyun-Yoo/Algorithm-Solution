import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for(int i = 0; i < G + 1; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for(int i = 0; i < P; i++) {
            int p = Integer.parseInt(br.readLine());
            int find = findRoot(p);
            if(find == 0) break;
            else {
                union(find - 1, find);
                answer++;
            }
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

        if(rootI != rootJ)
            parent[rootJ] = rootI;
    }
}