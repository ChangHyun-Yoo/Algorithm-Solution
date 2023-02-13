import java.io.*;
import java.util.*;

public class Main {

    static int[][] info;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        info = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dq(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void dq(int x, int y, int length) {
        int color = info[x][y];
        if(length == 1 && color == 1) {
            blue++;
            return;
        }
        else if(length == 1 && color == 0) {
            white++;
            return;
        }

        boolean check = false;
        for(int i = x; i < x + length; i++) {
            for(int j = y; j < y + length; j++) {
                if(info[i][j] != color) {
                    check = true;
                    break;
                }
            }
            if(check)
                break;
        }

        if(check) {//하나의 색이 아닌 경우
            dq(x, y, length / 2);
            dq(x + length / 2, y, length / 2);
            dq(x, y + length / 2, length / 2);
            dq(x + length / 2, y + length / 2, length / 2);
        } else {
            if(color == 1)
                blue++;
            else
                white++;
        }
    }
}