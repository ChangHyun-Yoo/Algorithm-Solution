import java.io.*;
import java.util.*;

public class Main {

    public static int rooms = 0;
    public static int max = 0;
    public static int removeMax = 0;
    public static int N = 0;
    public static int M = 0;
    public static int currentS;
    public static int[][] info;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {//방문하지 않았다면
                    currentS = 0;
                    bfs(i, j);
                    rooms++;
                    if(currentS > max)
                        max = currentS;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int original = info[i][j];
                if((info[i][j] & 1) == 1) {//서쪽에 벽이 있음
                    info[i][j] -= 1;
                    visited = new boolean[M][N];
                    if(!visited[i][j]) {//방문하지 않았다면
                        currentS = 0;
                        bfs(i, j);
                        if(currentS > removeMax)
                            removeMax = currentS;
                    }
                    info[i][j] += 1;
                }


                if((info[i][j] & 2) == 2) {//북쪽에 벽이 있음
                    info[i][j] -= 2;
                    visited = new boolean[M][N];
                    if(!visited[i][j]) {//방문하지 않았다면
                        currentS = 0;
                        bfs(i, j);
                        if(currentS > removeMax)
                            removeMax = currentS;
                    }
                    info[i][j] += 2;
                }


                if((info[i][j] & 4) == 4) {//동쪽에 벽이 있음
                    info[i][j] -= 4;
                    visited = new boolean[M][N];
                    if(!visited[i][j]) {//방문하지 않았다면
                        currentS = 0;
                        bfs(i, j);
                        if(currentS > removeMax)
                            removeMax = currentS;
                    }
                    info[i][j] += 4;
                }


                if((info[i][j] & 8) == 8) {//서쪽에 벽이 있음
                    info[i][j] -= 8;
                    visited = new boolean[M][N];
                    if(!visited[i][j]) {//방문하지 않았다면
                        currentS = 0;
                        bfs(i, j);
                        if(currentS > removeMax)
                            removeMax = currentS;
                    }
                    info[i][j] += 8;
                }
            }
        }

        System.out.println(rooms);
        System.out.println(max);
        System.out.println(removeMax);
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        currentS++;
        if((info[x][y] & 1) != 1) {//서쪽 벽이 없을 때
            try {
                if(y != 0 && !visited[x][y - 1]) {
                    bfs(x, y - 1);
                }
            } catch(Exception e) {
            }
        }
        if((info[x][y] & 2) != 2) {//북쪽 벽이 없을 때
            try {
                if(x != 0 && !visited[x - 1][y]) {
                    bfs(x - 1, y);
                }
            } catch(Exception e) {
            }
        }
        if((info[x][y] & 4) != 4) {//동쪽 벽이 없을 때
            try {
                if(y != N - 1 && !visited[x][y + 1]) {
                    bfs(x, y + 1);
                }
            } catch(Exception e) {
            }
        }
        if((info[x][y] & 8) != 8) {//남쪽 벽이 없을 때
            try {
                if(x != M - 1 && !visited[x + 1][y]) {
                    bfs(x + 1, y);
                }
            } catch(Exception e) {
            }
        }
    }

}