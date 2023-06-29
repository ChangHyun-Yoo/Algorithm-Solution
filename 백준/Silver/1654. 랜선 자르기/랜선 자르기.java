import java.io.*;
import java.util.*;

public class Main {

    static int[] lans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        lans = new int[K];

        for(int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        long low = 1;
        long high = Long.MAX_VALUE;

        // upper -> 보다 큰

        while(low < high) {
            long mid = low + (high - low) / 2;

            if(check(mid) < N) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }

    static long check(long value) {
        long result = 0;
        for(int i = 0; i < lans.length; i++) {
            result += lans[i] / value;
        }
        return result;
    }
}