import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Math.min(a, b);
        int max = Math.min(a, b);

        int m = 0;
        int mm = 0;

        for(int i = 1; i <= min; i++) {
            if(a % i == 0 && b % i == 0) {
                m = i;
            }
        }

        mm = m * (a / m) * (b / m);
        System.out.println(m);
        System.out.println(mm);
    }
}