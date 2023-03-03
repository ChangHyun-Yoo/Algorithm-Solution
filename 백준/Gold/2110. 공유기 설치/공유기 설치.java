import java.io.*;
import java.util.*;

public class Main {

    static int[] homes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        homes = new int[N];
        for(int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int low = 1;
        int high = homes[N - 1] - homes[0] + 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(C > check(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }

    private static int check(int mid) {
        int result = 0;

        int value = homes[0];
        int low = 0;
        int high = homes.length;

        while(true) {
            while(low < high) {
                int m = low + (high - low) / 2;
                if(value <= homes[m]) {
                    high = m;
                } else {
                    low = m + 1;
                }
            }

            if(low < homes.length) {
                result++;
                high = homes.length;
                value = homes[low] + mid;
                low++;
            } else {
                break;
            }
        }

        return result;
    }
}
