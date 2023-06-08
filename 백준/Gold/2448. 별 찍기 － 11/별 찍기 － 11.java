import java.io.*;
import java.util.*;

public class Main {

    static char[][] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        chars = new char[N][2 * N];

        dq(0, N, 0 , 2 * N);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2 * N; j++) {
                sb.append((chars[i][j] == '*') ? chars[i][j] : " ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dq(int sx, int fx, int sy, int fy) {
        if(fx - sx == 3) {
            chars[fx - 3][(sy + fy) / 2 - 1] = '*';
            chars[fx - 2][sy + 1] = '*';
            chars[fx - 2][fy - 3] = '*';
            for(int i = sy; i < fy - 1; i++) {
                chars[fx - 1][i] = '*';
            }
            return;
        }

        dq(sx, (sx + fx) / 2, sy + (fy - sy) / 4, fy - (fy - sy) / 4);
        dq((sx + fx) / 2, fx, sy, (sy + fy) / 2);
        dq((sx + fx) / 2, fx, (sy + fy) / 2, fy);
    }
}