import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] lst = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                lst[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[N][M + 1];
        for(int i = 0; i < N; i++) {
            for(int j = 1; j < M + 1; j++) {
                sum[i][j] = sum[i][j - 1] + lst[i][j - 1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for(int l = i; l <= x; l++) {
                answer += sum[l][y + 1] - sum[l][j];
            }
            System.out.println(answer);
        }
    }
}