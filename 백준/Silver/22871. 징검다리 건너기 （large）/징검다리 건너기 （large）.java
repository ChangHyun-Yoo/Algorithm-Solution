import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long[] stones;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stones = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            stones[i] = Long.parseLong(st.nextToken());
        }

        long low = 1;
        long high = (N - 1) * (1 + Math.abs(stones[N - 1] - stones[0]));

        while(low < high) {
            long mid = low + (high - low) / 2;

            boolean[] checked = new boolean[N];
            checked[0] = true;

            for(int i = 1; i < N; i++) {
                for(int j = 0; j < i; j++) {
                    long p = (i - j) * (1 + Math.abs(stones[i] - stones[j]));
                    if(checked[j] && p <= mid) {
                        checked[i] = true;
                        break;
                    }
                }
            }

            if(checked[N - 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

}