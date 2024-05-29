import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> roads = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] min = new int[N + 1][N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for(int[] m: min) {
            Arrays.fill(m, INF);
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            roads.get(A).add(B);
        }

        for(int i = 1; i < N + 1; i++) {
            Arrays.fill(visited, false);
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            while(!q.isEmpty()) {
                int now = q.poll();
                if(visited[now]) continue;
                visited[now] = true;
                min[i][now] = 1;

                for(int next: roads.get(now)) {
                    if(!visited[next]) {
                        q.offer(next);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + 1; i++) {
            int answer = 0;
            for(int j = 1; j < N + 1; j++) {
                if(min[i][j] == INF && min[j][i] == INF) {
                    answer++;
                }
            }

            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
