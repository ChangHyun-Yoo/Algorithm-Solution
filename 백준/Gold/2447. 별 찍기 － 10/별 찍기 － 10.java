import java.io.*;
import java.util.*;

public class Main {

    static int[][] info;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        info = new int[N][N];

        dq(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(info[i][j] == 1) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dq(int x, int y, int length) {
        if(length == 1) {
            return;
        }

        for(int i = x + length / 3; i < x + length * 2 / 3; i++) {
            for(int j = y + length / 3; j < y + length * 2 / 3; j++) {
                info[i][j] = 1;
            }
        }

        dq(x, y, length / 3);
        dq(x, y + length / 3, length / 3);
        dq(x, y + 2  * length / 3, length / 3);
        dq(x + length / 3, y, length / 3);
        dq(x + length / 3, y + 2  * length / 3, length / 3);
        dq(x + 2 * length / 3, y, length / 3);
        dq(x + 2 * length / 3, y + length / 3, length / 3);
        dq(x + 2 * length / 3, y + 2 * length / 3, length / 3);
    }
}