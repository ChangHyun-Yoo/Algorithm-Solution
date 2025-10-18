import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Queue<Node> current = new LinkedList<>();
                if(map[i][j] == 1) {
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(i, j, 0));

                    while(!q.isEmpty()) {
                        Node now = q.poll();

                        if(map[now.x][now.y] != 1) continue;
                        current.add(new Node(now.x, now.y, 0));
                        map[now.x][now.y] = 0;

                        for(int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];

                            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if(map[nx][ny] == 1) q.offer(new Node(nx, ny, 0));
                            }
                        }
                    }
                }

                boolean[][] visited = new boolean[N][N];
                while(!current.isEmpty()) {
                    Node now = current.poll();

                    if(visited[now.x][now.y]) continue;
                    visited[now.x][now.y] = true;

                    if(map[now.x][now.y] == 1) {
                        answer = Math.min(answer, now.num - 1);
                        break;
                    }

                    for(int k = 0; k < 4; k++) {
                        int nx = now.x + dx[k];
                        int ny = now.y + dy[k];

                        if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            current.offer(new Node(nx, ny, now.num + 1));
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
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
