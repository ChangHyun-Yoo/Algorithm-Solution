import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lst = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lst);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            //s 보다 크거나 같은 -> upperBound - 1
            //e 보다 작거나 같은 -> lowerBound

            int low = 0;
            int high = N;

            while(low < high) {
                int mid = low + (high - low) / 2;

                if(lst[mid] <= s) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if(low != 0) {
                if(lst[low - 1] == s) {
                    low--;
                }
            }
            int a1 = low;

            low = 0;
            high = N;

            while(low < high) {
                int mid = low + (high - low) / 2;

                if(lst[mid] >= e) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            if(low == N) {
                low--;
            } else {
                if(lst[low] != e) {
                    low--;
                }
            }
            sb.append(low - a1 + 1).append('\n');
        }

        System.out.println(sb);
    }
}