import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] chs = new char[N][N];

        dq(0, N, 0, N, chs);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(chs[i][j] == '*') sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    static void dq(int sx, int ex, int sy, int ey, char[][] chs) {

        if(ex - sx == 1) {
            chs[sx][sy] = '*';
            return;
        }

        int d = (ex - sx) / 3;

        dq(sx, sx + d, sy, sy + d, chs);
        dq(sx, sx + d, sy + d, sy + 2 * d, chs);
        dq(sx, sx + d, sy + 2 * d, ey, chs);

        dq(sx + d, sx + 2 * d, sy, sy + d, chs);
        dq(sx + d, sx + 2 * d, sy + 2 * d, ey, chs);

        dq(sx + 2 * d, ex, sy, sy + d, chs);
        dq(sx + 2 * d, ex, sy + d, sy + 2 * d, chs);
        dq(sx + 2 * d, ex, sy + 2 * d, ey, chs);
    }
}
