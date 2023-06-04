import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int min = Math.min(A, B);
            int answer = 0;

            for(int i = 1; i <= min; i++) {
                if(A % i == 0 && B % i == 0) {
                    answer = i;
                }
            }

            sb.append(A * B / answer).append('\n');
        }

        System.out.println(sb);
    }
}