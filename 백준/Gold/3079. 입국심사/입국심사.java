import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] times = new long[N];

        for(int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
        }

        long low = 0;
        long high = Long.MAX_VALUE;

        while(low < high) {
            long mid = low + (high - low) / 2;

            long num = 0;
            for(int i = 0; i < N; i++) {
                num += mid / times[i];
                if(num >= M) break;
            }

            if(num < M) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
    }
}
