import java.io.*;
import java.util.*;

public class Main {

    static int[][] thr = new int[4][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            if(dir == 1 && y != M - 1) {
                y++;
                roll(dir);
                if(map[x][y] == 0) {
                    map[x][y] = thr[3][1];
                } else {
                    thr[3][1] = map[x][y];
                    map[x][y] = 0;
                }
                sb.append(thr[1][1]).append('\n');
                continue;
            }

            if(dir == 2 && y != 0) {
                y--;
                roll(dir);
                if(map[x][y] == 0) {
                    map[x][y] = thr[3][1];
                } else {
                    thr[3][1] = map[x][y];
                    map[x][y] = 0;
                }
                sb.append(thr[1][1]).append('\n');
                continue;
            }

            if(dir == 3 && x != 0) {
                x--;
                roll(dir);
                if(map[x][y] == 0) {
                    map[x][y] = thr[3][1];
                } else {
                    thr[3][1] = map[x][y];
                    map[x][y] = 0;
                }
                sb.append(thr[1][1]).append('\n');
                continue;
            }

            if(dir == 4 && x != N - 1) {
                x++;
                roll(dir);
                if(map[x][y] == 0) {
                    map[x][y] = thr[3][1];
                } else {
                    thr[3][1] = map[x][y];
                    map[x][y] = 0;
                }
                sb.append(thr[1][1]).append('\n');
                continue;
            }
        }
        System.out.println(sb);
    }

    static void roll(int dir) {
        if(dir == 1) {
            int t12 = thr[1][1];
            int t10 = thr[3][1];
            int t11 = thr[1][0];
            int t31 = thr[1][2];
            thr[1][2] = t12;
            thr[1][0] = t10;
            thr[1][1] = t11;
            thr[3][1] = t31;
            return;
        }

        if(dir == 2) {
            int t12 = thr[3][1];
            int t10 = thr[1][1];
            int t11 = thr[1][2];
            int t31 = thr[1][0];
            thr[1][2] = t12;
            thr[1][0] = t10;
            thr[1][1] = t11;
            thr[3][1] = t31;
            return;
        }

        if(dir == 3) {
            int temp = thr[0][1];
            thr[0][1] = thr[1][1];
            thr[1][1] = thr[2][1];
            thr[2][1] = thr[3][1];
            thr[3][1] = temp;
            return;
        }

        if(dir == 4) {
            int temp = thr[3][1];
            thr[3][1] = thr[2][1];
            thr[2][1] = thr[1][1];
            thr[1][1] = thr[0][1];
            thr[0][1] = temp;
            return;
        }
    }
}

