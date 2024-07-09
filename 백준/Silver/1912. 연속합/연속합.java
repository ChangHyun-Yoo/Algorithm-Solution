import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sum = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int[][] info = new int[n + 1][2];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n + 1; i++) {
            if(min > sum[i]) {
                min = sum[i];
            }
            info[i][0] = min;
        }
        int max = Integer.MIN_VALUE;
        for(int i = n; i >= 0; i--) {
            if(max < sum[i]) {
                max = sum[i];
            }
            info[i][1] = max;
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(answer < info[i + 1][1] - info[i][0]) answer = info[i + 1][1] - info[i][0];
        }
        System.out.println(answer);
    }
}
