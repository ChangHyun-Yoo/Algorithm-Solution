import java.io.*;
import java.util.*;

public class Main {

    static long[] nums;
    static long[] sums;
    static long N;
    static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        nums = new long[(int) N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sums = new long[(int) N + 1];
        Arrays.sort(nums);
        long sum = 0;
        for(int i = 0; i < N; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }

        int minIndex = binarySearch();
        long start;
        if(minIndex == 0) {
            start = 0;
        } else {
            start = nums[minIndex - 1];
        }

        while(true) {
            long temp = (sums[(int) N] - sums[minIndex]) - start * (N - minIndex);
            if(temp < M) {
                System.out.println(start - 1);
                return;
            }
            start++;
        }
    }

    private static int binarySearch() {
        int low = 0;
        int high = (int) N;

        while(low < high) {
            int mid = low + (high - low) / 2;

            long temp = (sums[(int) N] - sums[mid]) - nums[mid] * (N - mid);
            if(temp >= M) {//가능하면
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
