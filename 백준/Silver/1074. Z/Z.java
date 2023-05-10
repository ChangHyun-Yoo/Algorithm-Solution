import java.io.*;
import java.util.*;

public class Main {

    static int num = 0;
    static int r;
    static int c;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);

        div(0, 0, len);

        System.out.println(answer);
    }

    static void div(int x1, int y1, int len) {
        if(answer != -1) return;

        if(!(r >= x1 && r < x1 + len && c >= y1 && c < y1 + len)) {
            num += len * len;
            return;
        }
        if(len == 1) {
            if(x1 == r && y1 == c) {
                answer = num;
            }
            num++;
            return;
        }

        div(x1, y1, len / 2);
        div(x1, y1 + len / 2, len / 2);
        div(x1 + len / 2, y1, len / 2);
        div(x1 + len / 2, y1 + len / 2, len / 2);
    }
}