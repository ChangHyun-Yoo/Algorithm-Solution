import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] lst = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            lst[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(lst);

        long answer = 0;

        if(N % 2 == 0) {
            int l = 0;
            int r = N - 1;

            while(l < r) {
                answer = Math.max(answer, lst[l++] + lst[r--]);
            }
        } else {
            int l = 0;
            int r = N - 2;

            while(l < r) {
                answer = Math.max(answer, lst[l++] + lst[r--]);
            }
            answer = Math.max(answer, lst[lst.length - 1]);
        }

        System.out.println(answer);
    }
}