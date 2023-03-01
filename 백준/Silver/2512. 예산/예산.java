import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;
    static int[] sums;
    static int max = -1;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        M = Integer.parseInt(br.readLine());

        int sum = 0;
        sums = new int[N];
        int index = -1;
        for(int i = 0; i < N; i++) {
            sum += nums[i];
            if(sum >= M && index == -1) {
                index = i;
            }
            sums[i] = sum;
        }

        if(index == -1) {
            System.out.println(nums[N - 1]);
            return;
        }

        binarySearch();

        if(max == -1) {
            System.out.println(M / N);
        } else
            System.out.println(max);
    }

    static void binarySearch() {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(mid)) {//가능하면
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    static boolean check(int mid) {
        if(nums.length - mid - 1 == 0) {
            return false;
        }
        int num = (M - sums[mid]) / (nums.length - mid - 1);
        if(num >= nums[mid]) {
            if(num > max) {
                max = num;
            }
            return true;
        }
        return false;
    }
}