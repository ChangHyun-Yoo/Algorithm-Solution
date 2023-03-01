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
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(num) == -1) {
                sb.append(0 + " ");
            } else if(nums[binarySearch(num)] == num) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int value) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(value < nums[mid]) {
                high = mid - 1;
            } else if(value > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        if(low == nums.length) {
            return -1;
        } else {
            return low;
        }
    }
}