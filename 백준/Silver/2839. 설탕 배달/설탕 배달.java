import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int k5 = N / 5;
        int k3 = 0;
        while(true) {
            if(k5 == -1) {
                System.out.println(-1);
                return;
            }

            k3 = (N - 5*k5) / 3;

            if(5*k5 + 3*k3 == N) {
                break;
            }
            k5--;
        }

        System.out.println(k3 + k5);
    }
}