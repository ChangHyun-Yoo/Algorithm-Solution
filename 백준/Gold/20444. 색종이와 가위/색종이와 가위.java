import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long low = 0;
        long high = n / 2;
        long answer = -1;
        while(low <= high) {
            long mid = low + (high - low) / 2;

            long value = (mid + 1) * (n - mid + 1);
            if(value > k) {
                high = mid - 1;
            } else if(value < k) {
                low = mid + 1;
            } else {
                answer = mid;
                break;
            }
        }

        if(answer == -1) System.out.println("NO");
        else System.out.println("YES");
    }
}
