import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] nums = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            nums[i][0] = A;
            nums[i][1] = B;
            nums[i][2] = C;
        }

        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        maxDp[0] = nums[0][0];
        maxDp[1] = nums[0][1];
        maxDp[2] = nums[0][2];
        minDp[0] = nums[0][0];
        minDp[1] = nums[0][1];
        minDp[2] = nums[0][2];

        for(int i = 1; i < N; i++) {
            int maxdp1 = maxDp[0];
            int maxdp2 = maxDp[1];
            int maxdp3 = maxDp[2];
            int mindp1 = minDp[0];
            int mindp2 = minDp[1];
            int mindp3 = minDp[2];

            // 첫번째
            int max = Math.max(maxdp1, maxdp2);
            int min = Math.min(mindp1, mindp2);
            maxDp[0] = max + nums[i][0];
            minDp[0] = min + nums[i][0];
            // 두번째
            max = Math.max(max, maxdp3);
            min = Math.min(min, mindp3);
            maxDp[1] = max + nums[i][1];
            minDp[1] = min + nums[i][1];
            // 세번째
            max = Math.max(maxdp2, maxdp3);
            min = Math.min(mindp2, mindp3);
            maxDp[2] = max + nums[i][2];
            minDp[2] = min + nums[i][2];
        }

        int answer1 = -1;
        for(int m: maxDp) {
            answer1 = Math.max(answer1, m);
        }
        int answer2 = Integer.MAX_VALUE;
        for(int m: minDp) {
            answer2 = Math.min(answer2, m);
        }

        System.out.println(answer1 + " " + answer2);
    }
}
