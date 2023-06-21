import java.io.*;
import java.util.*;

public class Main {

    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        long answer = 0;
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                if(num[i] + num[j] + num[j + 1] > 0) break;

                int value = -num[i] - num[j];

                int low = lowerBound(j + 1, N, value);
                int high = upperBound(j + 1, N, value);

                answer += high - low;
            }
        }
        System.out.println(answer);
    }

    static int lowerBound(int low, int high, int value) {
        while(low < high) {
            int mid = low + (high - low) / 2;

            if(num[mid] >= value) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int low, int high, int value) {
        while(low < high) {
            int mid = low + (high - low) / 2;

            if(num[mid] > value) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}