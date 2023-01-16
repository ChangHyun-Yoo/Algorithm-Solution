import java.io.*;
import java.util.*;

public class Main {

    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[][] road = new boolean[C][C];
        boolean[] visited = new boolean[C];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            road[a - 1][b - 1] = true;
            road[b - 1][a - 1] = true;
        }

        bfs(road);

        System.out.println(set.size() - 1);
    }

    public static void bfs(boolean[][] road) {
        boolean[] visited = new boolean[road.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            set.add(now);

            for(int i = 0; i < road.length; i++) {
                if(road[now][i] && !visited[i]) {//도로가 있고, 지나지 않았다면
                    queue.add(i);
                }
            }
        }
    }
}