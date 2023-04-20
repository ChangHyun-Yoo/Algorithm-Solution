import java.io.*;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static int[][] map;
    static int[][] hwak;
    static int cleanerX;
    static int cleanerY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        hwak = new int[R][C];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                int info = Integer.parseInt(st.nextToken());
                if(info == -1) {
                    cleanerX = i;
                    cleanerY = j;
                }
                map[i][j] = info;
            }
        }



        for(int t = 0; t < T; t++) {

            for(int[] h: hwak) {
                Arrays.fill(h, 0);
            }
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(map[i][j] > 0) {
                        hwaksan(i, j);
                    }
                }
            }
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    map[i][j] += hwak[i][j];
                }
            }

            up(cleanerX - 2, cleanerY);
            down(cleanerX + 1, cleanerY);
            map[cleanerX - 1][cleanerY + 1] = 0;
            map[cleanerX][cleanerY + 1] = 0;
        }

        int answer = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] > 0) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    static void up(int x, int y) {
        while(x != 0) {
            map[x][y] = map[x - 1][y];
            x--;
        }
        while(y != C - 1) {
            map[x][y] = map[x][y + 1];
            y++;
        }
        while(x != cleanerX - 1) {
            map[x][y] = map[x + 1][y];
            x++;
        }
        while(y != 1) {
            map[x][y] = map[x][y - 1];
            y--;
        }
    }

    static void down(int x, int y) {
        while(x != R - 1) {
            map[x][y] = map[x + 1][y];
            x++;
        }
        while(y != C - 1) {
            map[x][y] = map[x][y + 1];
            y++;
        }
        while(x != cleanerX) {
            map[x][y] = map[x - 1][y];
            x--;
        }
        while(y != 1) {
            map[x][y] = map[x][y - 1];
            y--;
        }
    }

    static void hwaksan(int x, int y) {
        int value = map[x][y] / 5;
        if(x != 0) {
            if(map[x - 1][y] != -1) {
                hwak[x - 1][y] += value;
                hwak[x][y] -= value;
            }
        }
        if(y != 0) {
            if(map[x][y - 1] != -1) {
                hwak[x][y - 1] += value;
                hwak[x][y] -= value;
            }
        }
        if(x != R - 1) {
            if(map[x + 1][y] != -1) {
                hwak[x + 1][y] += value;
                hwak[x][y] -= value;
            }
        }
        if(y != C - 1) {
            if(map[x][y + 1] != -1) {
                hwak[x][y + 1] += value;
                hwak[x][y] -= value;
            }
        }
    }
}