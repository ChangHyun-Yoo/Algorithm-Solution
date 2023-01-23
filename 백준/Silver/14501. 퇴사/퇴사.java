import java.io.*;
import java.util.*;

public class Main {

    private static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        bfs(info, 0, 0);

        System.out.println(max);
    }

    public static void bfs(int[][] info, int current, int money) {
        if(current >= info.length) {//모두 스캔완료하면
            if(money > max)
                max = money;
        } else {
            if(current + info[current][0] >= info.length + 1) {//일할 수 없는 경우
                bfs(info, current + 1, money);
            } else {
                bfs(info, current + info[current][0], money + info[current][1]);
                bfs(info, current + 1, money);
            }

        }
    }

}