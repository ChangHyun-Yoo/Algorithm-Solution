import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        int count = 0;

        while(k != 1) {
            long l = 1;
            while(l < k) {
                l *= 2;
            }
            l /= 2;
            k -= l;
            count++;
        }
        if(count % 2 == 1) System.out.println(1);
        else System.out.println(0);
    }
}