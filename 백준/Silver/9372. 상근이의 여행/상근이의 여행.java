import java.io.*;
import java.util.*;

public class Main {

    public static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer sb = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(sb.nextToken());
            int M = Integer.parseInt(sb.nextToken());

            boolean[][] road = new boolean[N][N];
            for(int j = 0; j < M; j++) {
                sb = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(sb.nextToken());
                int b = Integer.parseInt(sb.nextToken());
                road[a - 1][b - 1] = true;
                road[b - 1][a - 1] = true;
            }

            System.out.println(N - 1);
        }

    }

}