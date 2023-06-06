import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int[] m: map) {
            Arrays.fill(m, -2);
        }

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                if(s.charAt(j) == 'O') {
                    map[i][j] = -1;
                }
            }
        }

        for(int i = 1; i < N; i++) {
            if(i % 2 == 1) {//빈 곳 채우기
                for(int j = 0; j < R; j++) {
                    for(int k = 0; k < C; k++) {
                        if(map[j][k] == -2) {
                            map[j][k] = i;
                        }
                    }
                }
            } else {//폭발
                for(int j = 0; j < R; j++) {
                    for(int k = 0; k < C; k++) {
                        if(map[j][k] == i - 3) {
                            explode(j, k, i - 3);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == -2) {
                    sb.append('.');
                } else {
                    sb.append('O');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void explode(int i, int j, int l) {
        map[i][j] = -2;
        change(i - 1, j, l);
        change(i + 1, j, l);
        change(i, j - 1, l);
        change(i, j + 1, l);
    }

    static void change(int i, int j, int l) {
        if(i >= 0 && i < R && j >= 0 && j < C) {
            if (map[i][j] == l) {
                explode(i, j, l);
            } else {
                map[i][j] = -2;
            }
        }
    }
}