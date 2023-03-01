import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(num) - lowerBound(num) + " ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int num) {

        int low = 0;
        int high = nums.length;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(num <= nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int upperBound(int num) {

        int low = 0;
        int high = nums.length;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(num < nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}