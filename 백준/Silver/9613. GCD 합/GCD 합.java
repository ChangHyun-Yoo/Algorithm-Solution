import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            int[] lst = new int[n];
            for(int i = 0; i < n; i++) {
                lst[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    sum += gcd(lst[i], lst[j]);
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }

    static int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
