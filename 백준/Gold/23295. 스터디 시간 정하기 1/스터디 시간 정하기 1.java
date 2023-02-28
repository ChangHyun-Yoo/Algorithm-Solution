import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] times = new int[100000];
        for(int i = 0; i < N; i++) {
            int j = Integer.parseInt(br.readLine());
            for(int k = 0; k < j; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                for(int l = start; l < end; l++) {
                    times[l]++;
                }
            }
        }

        int maxStart = 0;
        int maxEnd = 0;
        int l = 0;
        int r = T - 1;
        long sum = 0;
        for(int i = 0; i < T; i++) {
            sum += times[i];
        }
        long max = 0;
        while(true) {
            if(max < sum) {
                max = sum;
                maxStart = l;
                maxEnd = r;
            }
            sum -= times[l];
            l++;
            if(r == times.length - 1) {
                break;
            } else {
                r++;
                sum += times[r];
            }
        }

        System.out.println(maxStart + " " + ++maxEnd);
    }
}