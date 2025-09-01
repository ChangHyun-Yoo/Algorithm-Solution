import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomatoes = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Node> q = new LinkedList<>();
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for(int m = 0; m < M; m++) {
                int tomato = Integer.parseInt(st.nextToken());
                tomatoes[n][m] = tomato;

                if(tomato == 1) {
                    q.offer(new Node(n, m));
                    visited[n][m] = true;
                }
            }
        }

        int answer = -1;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Node now = q.poll();

                if(now.x != 0 && !visited[now.x - 1][now.y] && tomatoes[now.x - 1][now.y] != -1) {
                    tomatoes[now.x - 1][now.y] = 1;
                    visited[now.x - 1][now.y] = true;

                    q.offer(new Node(now.x - 1, now.y));
                }

                if(now.y != 0 && !visited[now.x][now.y - 1] && tomatoes[now.x][now.y - 1] != -1) {
                    tomatoes[now.x][now.y - 1] = 1;
                    visited[now.x][now.y - 1] = true;

                    q.offer(new Node(now.x, now.y - 1));
                }

                if(now.x != N - 1 && !visited[now.x + 1][now.y] && tomatoes[now.x + 1][now.y] != -1) {
                    tomatoes[now.x + 1][now.y] = 1;
                    visited[now.x + 1][now.y] = true;

                    q.offer(new Node(now.x + 1, now.y));
                }

                if(now.y != M - 1 && !visited[now.x][now.y + 1] && tomatoes[now.x][now.y + 1] != -1) {
                    tomatoes[now.x][now.y + 1] = 1;
                    visited[now.x][now.y + 1] = true;

                    q.offer(new Node(now.x, now.y + 1));
                }
            }

            answer++;
        }

        boolean isZeroExists = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomatoes[i][j] == 0) isZeroExists = true;
            }
        }

        if(isZeroExists) System.out.println(-1);
        else System.out.println(answer);
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