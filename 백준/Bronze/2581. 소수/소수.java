import java.io.*;
import java.util.*;

public class Main {

    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        prime[1] = true;
        for(int i = 2; i < 10000; i++) {
            for(int j = 2; i * j <= 10000; j++) {
                prime[i * j] = true;
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = M; i <= N; i++) {
            if(!prime[i]) {
                if(min > i) {
                    min = i;
                }
                sum += i;
            }
        }
        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}