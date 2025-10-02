import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        boolean[][] visited = new boolean[N][M];
        boolean[][] visitedBreaked = new boolean[N][M];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));
        visited[0][0] = true;

        int answer = -1;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == N - 1 && now.y == M - 1) {
                answer = now.move;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(!visitedBreaked[nx][ny]) {
                        if(map[nx][ny] == '1' && !now.breaked) {
                            q.offer(new Node(nx, ny, now.move + 1, true));
                            visitedBreaked[nx][ny] = true;
                        }

                        if(map[nx][ny] == '0' && now.breaked) {
                            q.offer(new Node(nx, ny, now.move + 1, now.breaked));
                            visitedBreaked[nx][ny] = true;
                        }
                    }

                    if(!visited[nx][ny]) {
                        if(map[nx][ny] == '0' && !now.breaked) {
                            q.offer(new Node(nx, ny, now.move + 1, now.breaked));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;
        int move;
        boolean breaked;

        public Node(int x, int y, int move, boolean breaked) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.breaked = breaked;
        }
    }
}
