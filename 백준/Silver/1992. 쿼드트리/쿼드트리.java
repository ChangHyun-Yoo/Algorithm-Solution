import java.io.*;
import java.util.*;

public class Main {

    static int[][] info;
    static String answer = "";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        info = new int[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }

        dq(0, 0, N);

        System.out.println(answer);
    }

    static void dq(int x, int y, int length) {
        int color = info[x][y];
        if(length == 1) {
            answer += color;
            return;
        }
        boolean check = false;
        for(int i = x; i < x + length; i++) {
            for(int j = y; j < y + length; j++) {
                if(color != info[i][j]) {//다른 색이 존재할 때
                    check = true;
                    break;
                }
            }
            if(check)
                break;
        }

        if(check) {//다른 색이 존재하는 경우
            answer += "(";
            dq(x, y, length / 2);
            dq(x, y + length / 2, length / 2);
            dq(x + length / 2, y, length / 2);
            dq(x + length / 2, y + length / 2, length / 2);
            answer += ")";
        } else {
            answer += color;
        }
    }
}