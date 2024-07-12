import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Map<String, Integer> map = new HashMap<>();

        int M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            String A = st.nextToken();
            int X = Integer.parseInt(st.nextToken());

            map.put(A, X);
        }

        int[] dp = new int[S.length() + 1];

        for(int i = 1; i < S.length() + 1; i++) {
            int max = dp[i - 1] + 1;

            for(String key: map.keySet()) {
                if(i < key.length()) continue;

                if(S.substring(i - key.length(), i).equals(key)) {
                    if(max < dp[i - key.length()] + map.get(key)) {
                        max = dp[i - key.length()] + map.get(key);
                    }
                }
            }

            dp[i] = max;
        }

        System.out.println(dp[dp.length - 1]);
    }
}
