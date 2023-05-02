import java.io.*;
import java.util.*;

public class Main {

    static int[] parent = new int[1000001];
    static int[] height = new int[1000001];
    static int[] n = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.fill(height, 1);
        Arrays.fill(n, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String c = st.nextToken();
            if(c.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int a = Integer.parseInt(st.nextToken());
                sb.append(n[find(a)]).append('\n');
            }
        }
        System.out.print(sb);

    }

    static int find(int i) {
        if(parent[i] == i) return i;

        return find(parent[i]);
    }

    static void union(int i, int j) {
        int findI = find(i);
        int findJ = find(j);
        
        if(findI == findJ) return;

        if(height[findI] > height[findJ]) {
            parent[findJ] = findI;
            n[findI] += n[findJ];
        } else if(height[findI] < height[findJ]) {
            parent[findI] = findJ;
            n[findJ] += n[findI];
        } else {
            parent[findI] = findJ;
            height[findJ]++;
            n[findJ] += n[findI];
        }
    }
}