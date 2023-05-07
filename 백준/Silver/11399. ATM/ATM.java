import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] work = new int[N];
        int[] sum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(work);

        for(int i = 1; i < N + 1; i++) {
            sum[i] = work[i - 1] + sum[i - 1];
        }

        int answer = 0;
        for(int w: sum) {
            answer += w;
        }
        System.out.println(answer);
    }
}