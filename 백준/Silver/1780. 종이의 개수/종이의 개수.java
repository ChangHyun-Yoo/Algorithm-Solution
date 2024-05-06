import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] info;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        info = new int[N][N];
        answer = new int[3];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dq(0, 0, N, N);

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    static void dq(int x1, int y1, int x2, int y2) {
        if(x2 - x1 == 1) {
            answer[info[x1][y1] + 1]++;
            return;
        }

        int init = info[x1][y1];
        boolean check = true;
        for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
                if(info[i][j] != init) check = false;
            }
        }
        if(check) {
            answer[init + 1]++;
        } else {
            int x0 = (2 * x1 + x2) / 3;
            int x3 = (x1 + 2 * x2) / 3;
            int y0 = (2 * y1 + y2) / 3;
            int y3 = (y1 + 2 * y2) / 3;
            dq(x1, y1, x0, y0);
            dq(x1, y0, x0, y3);
            dq(x1, y3, x0, y2);
            dq(x0, y1, x3, y0);
            dq(x0, y0, x3, y3);
            dq(x0, y3, x3, y2);
            dq(x3, y1, x2, y0);
            dq(x3, y0, x2, y3);
            dq(x3, y3, x2, y2);
        }
    }
}