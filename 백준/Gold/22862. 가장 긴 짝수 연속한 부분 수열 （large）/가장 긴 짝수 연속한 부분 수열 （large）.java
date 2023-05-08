import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int odd = 0;
        int even = 0;
        if(num[0] % 2 == 0) even++;
        else odd++;
        int answer = 0;
        int o = 0;
        while(true) {
            if(odd <= K) {
                if(answer < r - l + 1) {
                    answer = r - l + 1;
                    o = odd;
                }
                r++;
                if(r == N) break;
                if(num[r] % 2 == 0) even++;
                else odd++;
            } else {
                if(num[l] % 2 == 0) even--;
                else odd--;
                l++;
            }
        }
        System.out.println(answer - o);
    }
}