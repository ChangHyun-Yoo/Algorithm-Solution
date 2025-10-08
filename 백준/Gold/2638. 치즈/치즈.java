import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] current = new int[N][M];
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int status = Integer.parseInt(st.nextToken());
                current[i][j] = status;
                if(status == 1) q.offer(new Node(i, j));
            }
        }

        int time = 0;
        while(!q.isEmpty()) {
            // 외부를 2로 변경
            Queue<Node> out = new LinkedList<>();
            out.offer(new Node(0, 0));
            boolean[][] visited = new boolean[N][M];
            while(!out.isEmpty()) {
                Node now = out.poll();

                if(visited[now.x][now.y]) continue;
                visited[now.x][now.y] = true;

                if(current[now.x][now.y] % 2 == 0) {
                    current[now.x][now.y] = 2;

                    for(int i = 0; i < 4; i++) {
                        int nx = now.x + dx[i];
                        int ny = now.y + dy[i];

                        if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if(current[nx][ny] % 2 == 0 && !visited[nx][ny]) out.offer(new Node(nx, ny));
                        }
                    }
                }
            }

            Queue<Node> removed = new LinkedList<>();
            boolean[][] visited2 = new boolean[N][M];

            int size = q.size();
            for(int j = 0; j < size; j++) {
                Node now = q.poll();

                if(visited2[now.x][now.y]) continue;
                visited2[now.x][now.y] = true;

                int touched = 0;
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(current[nx][ny] == 2) touched++;
                }
                if(touched >= 2) removed.offer(now);
                else q.offer(now);
            }

            while(!removed.isEmpty()) {
                Node now = removed.poll();
                current[now.x][now.y] = 0;
            }

            time++;
        }

        System.out.println(time);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
