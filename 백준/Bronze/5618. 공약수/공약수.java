import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nums = new int[n];

        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(min > number) min = number;
            nums[i] = number;
        }

        int max = -1;
        for(int i = 1; i <= min; i++) {
            if(check(i)) max = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= max; i++) {
            if(max % i == 0) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    static boolean check(int input) {
        boolean b = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % input == 0) continue;
            else {
                b = false;
                break;
            }
        }
        return b;
    }
}