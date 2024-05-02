import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] value = new long[N];
        for (int i = 0; i < N; i++) {
            value[i] = Long.parseLong(br.readLine());
        }

        long low = 1;
        long high = (long) Math.pow(10, 18);

        while(low < high) {
            long result = 0;
            long mid = low + (high - low) / 2;

            for (int i = 0; i < N; i++) {
                result += mid / value[i];
                if(result >= M) break;
            }

            if(result >= M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

}