import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] sums = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            sums[i] = sums[i - 1] + num[i - 1];
        }

        long answer = 0;
        for(int i = 0; i < N - 1; i++) {
            answer += num[i] * (sums[N] - sums[i + 1]);
        }
        System.out.println(answer);
    }
}