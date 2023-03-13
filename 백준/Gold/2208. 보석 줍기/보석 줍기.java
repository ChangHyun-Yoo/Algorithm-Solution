import java.io.*;
import java.util.*;

public class Main {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sums = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N - M + 1; i++) {
            for(int j = i + M; j < N + 1; j++) {
                if(sums[j] - sums[i] > max)
                    max = sums[j] - sums[i];
            }
        }

        System.out.println(max);
    }
}
