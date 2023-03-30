import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> connections = new ArrayList<>();
    static int[][] min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N + 1; i++) {
            connections.add(new ArrayList<>());
        }
        min = new int[N + 1][2];
        for(int[] m: min) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connections.get(a).add(b);
            connections.get(b).add(a);
        }

        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(Math.min(min[1][1], min[1][0]));
    }

    static void dfs(int i) {
        visited[i] = true;

        int count = 0;
        int trues = 0;
        int com = 0;
        for(int next: connections.get(i)) {
            if(!visited[next]) {
                dfs(next);
                trues += min[next][1];
                com += Math.min(min[next][0], min[next][1]);
                count++;
            }
        }

        if(count == 0) {
            min[i][1] = 1;
            min[i][0] = 0;
        } else {
            min[i][1] = com + 1;
            min[i][0] = trues;
        }
    }
}

