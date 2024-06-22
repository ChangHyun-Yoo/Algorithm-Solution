import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        double L = Double.parseDouble(st.nextToken());

        double[] nums = new double[n];
        double[] sum = new double[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < sum.length; i++) {
            nums[i] = Double.parseDouble(st.nextToken());
            if(i == 0) sum[i] = nums[i];
            else sum[i] = nums[i] + sum[i - 1];
        }

        for(int i = 0; i < sum.length - 1; i++) {
            double avg = (sum[sum.length - 1] - sum[i])/(sum.length - 1 - i);
            if(nums[i] - L < avg && nums[i] + L > avg) continue;
            else {
                System.out.println("unstable");
                return;
            }
        }

        System.out.println("stable");
    }
}
