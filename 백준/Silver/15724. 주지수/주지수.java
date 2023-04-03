import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] num = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum = new int[N][M + 1];
        for(int i = 0; i < N; i++) {
            int s = 0;
            for(int j = 1; j < M + 1; j++) {
                sum[i][j] = s + num[i][j - 1];
                s += num[i][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            long answer = 0;
            for(int j = x1 - 1; j < x2; j++) {
                answer += sum[j][y2] - sum[j][y1 - 1];
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}

