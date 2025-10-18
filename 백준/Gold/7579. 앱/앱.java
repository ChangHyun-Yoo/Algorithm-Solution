import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] m = new int[N];
        int[] c = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 10000; j >= 0; j--) {
                if(dp[j] != -1 && dp[j] < M) {
                    dp[j + c[i]] = Math.max(dp[j + c[i]], dp[j] + m[i]);
                }
            }
        }

        for(int i = 0; i < dp.length; i++) {
            if(dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
