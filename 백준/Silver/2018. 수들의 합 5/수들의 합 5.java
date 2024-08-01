import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine()) * 2;

        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(N % i != 0) continue;

            int a = N / i - (i - 1);

            if(a <= 0) break;
            if(a % 2 == 0) {
                result++;
            }
        }

        System.out.println(result);

    }

}


