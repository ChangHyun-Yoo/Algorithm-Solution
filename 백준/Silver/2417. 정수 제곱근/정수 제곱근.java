import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long low = 0;
        long high = Long.MAX_VALUE;

        while(low < high) {
            long mid = low + (high - low) / 2;

            if(Math.pow(mid, 2) >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}