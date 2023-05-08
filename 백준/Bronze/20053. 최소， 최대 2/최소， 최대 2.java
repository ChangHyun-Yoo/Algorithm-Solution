import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < N; j++) {
                if(num[j] < min) min = num[j];
                if(num[j] > max) max = num[j];
            }

            sb.append(min + " " + max).append('\n');
        }
        System.out.println(sb);

    }
}