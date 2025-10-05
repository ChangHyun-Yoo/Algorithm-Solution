import java.util.*;
import java.io.*;

public class Main {

    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        long answer1 = 0;
        long answer2 = 0;
        long answer3 = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                long sum = nums[i] + nums[left] + nums[right];

                if(min > Math.abs(sum)) {
                    answer1 = nums[i];
                    answer2 = nums[left];
                    answer3 = nums[right];

                    min = Math.abs(sum);
                    if(min == 0) {
                        System.out.println(answer1 + " " + answer2 + " " + answer3);
                        return;
                    }
                }

                if(sum > 0) right--;
                else left++;
            }
        }
        System.out.println(answer1 + " " + answer2 + " " + answer3);
    }
}
