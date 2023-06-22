import java.io.*;
import java.util.*;

public class Main {

    static int[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cows = new int[11];

        Arrays.fill(cows, -1);

        int answer = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(cows[n] == -1) {
                cows[n] = p;
            } else if(cows[n] == p) {
                continue;
            } else {
                cows[n] = p;
                answer++;
            }
        }

        System.out.println(answer);
    }
}