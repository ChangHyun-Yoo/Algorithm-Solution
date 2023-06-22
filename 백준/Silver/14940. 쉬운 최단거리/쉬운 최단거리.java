import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] time;
    static boolean[][] visited;
    static int startX;
    static int startY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        time = new int[n][m];
        for(int[] t: time) {
            Arrays.fill(t, -1);
        }
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                int m = Integer.parseInt(st.nextToken());

                if(m == 2) {
                    startX = i;
                    startY = j;
                }
                map[i][j] = m;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x >= 0 && now.x < n && now.y >= 0 && now.y < m) {
                if(visited[now.x][now.y]) continue;

                visited[now.x][now.y] = true;
                if(map[now.x][now.y] == 0) {
                    time[now.x][now.y] = 0;
                    continue;
                }

                time[now.x][now.y] = now.time;

                q.offer(new Node(now.x - 1, now.y, now.time + 1));
                q.offer(new Node(now.x + 1, now.y, now.time + 1));
                q.offer(new Node(now.x, now.y - 1, now.time + 1));
                q.offer(new Node(now.x, now.y + 1, now.time + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0)
                    sb.append(0 + " ");
                else
                    sb.append(time[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}