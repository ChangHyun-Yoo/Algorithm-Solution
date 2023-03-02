import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(nums[i] > max)
                max = nums[i];
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += nums[i];
        }

        int low = max;
        int high = sum;

        while(low < high) {//lower bound
            int mid = low + (high - low) / 2;

            if(M >= check(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

    private static int check(int mid) {
        int saved = 1;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += nums[i];
            if(sum > mid) {
                saved++;
                sum = nums[i];
            }
        }

        return saved;
    }
}
