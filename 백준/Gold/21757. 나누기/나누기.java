import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + Integer.parseInt(st.nextToken());
        }

        long answer = 0;

        for(int i = 1; i <= N - 3; i++) {
            int fir = sum[i] - sum[0];
            if(fir == sum[N] / 4) {
                for(int j = i + 1; j <= N - 2; j++) {
                    if(sum[j] - sum[i] == fir) {
                        for(int k = j + 1; k <= N - 1; k++) {
                            if(sum[k] - sum[j] == fir && sum[N] - sum[k] == fir) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}