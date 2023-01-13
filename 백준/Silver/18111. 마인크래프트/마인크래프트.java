import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] block = new int[N][M];

        int min = 257;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            int[] col = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a < min)
                    min = a;
                col[j] = a;
                sum += a;
            }
            block[i] = col;
        }

        int avg = (int) Math.floor(sum / (double) (N * M));
        int max = Math.min(256, (int) Math.floor((sum + B) / (double) (N * M)));

        int minTime = 512 * N * M;
        int height = -1;
        for(int i = min; i <= max; i++) {
            int time = 0;
            for(int[] j: block) {
                for(int k: j) {
                    if(k > i) {
                        time += (k - i) * 2;
                    } else if(k < i) {
                        time += (i - k) * 1;
                    } else
                        continue;
                }
            }
            if(time <= minTime) {
                minTime = time;
                height = i;
            }
        }

        System.out.println(minTime + " " + height);
    }

}