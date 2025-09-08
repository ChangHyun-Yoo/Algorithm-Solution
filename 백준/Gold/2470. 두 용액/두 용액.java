import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int answerLeft = 0;
        int answerRight = 0;
        int min = Integer.MAX_VALUE;

        while(left < right) {
            int current = nums[right] + nums[left];

            if(Math.abs(current) < min) {
                min = Math.abs(current);
                answerRight = nums[right];
                answerLeft = nums[left];
            }

            if(current > 0) {
                right--;
            } else if(current < 0) {
                left++;
            } else break;
        }

        System.out.println(answerLeft + " " + answerRight);
    }
}