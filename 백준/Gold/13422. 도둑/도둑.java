import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//마을의 집 개수
            int M = Integer.parseInt(st.nextToken());//연속된 집 개수
            long K = Long.parseLong(st.nextToken());//방범 장치 작동

            int[] homes = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                homes[j] = Integer.parseInt(st.nextToken());
            }

            int l = 0;
            int r = M - 1;
            long sum = 0;
            for(int j = 0; j <= r; j++) {
                sum += homes[j];
            }
            long answer = 0;
            while(r < N + M - 1) {
                if(sum < K)
                    answer++;
                sum -= homes[l];
                l++;
                r++;
                sum += homes[r % N];
            }
            if(N == M && sum < K)
                System.out.println(1);
            else
                System.out.println(answer);
        }
    }
}