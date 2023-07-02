import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lst = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        long sum = 0;

        for(int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            lst[i + 1] = (int) (sum % M);
        }

        int[] r = new int[M];
        for(int i: lst) {
            r[i]++;
        }

        long answer = 0;
        for(int i = 0; i < lst.length - 1; i++) {
            r[lst[i]]--;
            answer += r[lst[i]];
        }
        System.out.println(answer);
    }
}