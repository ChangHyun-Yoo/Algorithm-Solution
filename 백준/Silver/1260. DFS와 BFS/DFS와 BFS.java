import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean[][] road = new boolean[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road[a-1][b-1] = true;
            road[b-1][a-1] = true;
        }

        int start = V-1;
        visited = new boolean[N];
        visited[start] = true;
        dfs(road, start);


        System.out.println("");

        boolean[] visitedBfs = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V-1);
        int current = V-1;
        visitedBfs[current] = true;

        while(!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current + 1 + " ");

            for(int i = 0; i < N; i++) {
                if(road[current][i] && !visitedBfs[i]) {
                    queue.add(i);
                    visitedBfs[i] = true;
                }
            }
        }
    }

    public static void dfs(boolean[][] road, int current) {
        System.out.print(current + 1 + " ");

        for(int i = 0; i < road.length; i++) {
            if(road[current][i] && !visited[i]) {//길이 있고, 방문한 적 없다면
                visited[i] = true;
                dfs(road, i);
            }
        }
    }
}