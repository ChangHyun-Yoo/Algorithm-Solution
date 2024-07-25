import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lengths = new int[28];
        lengths[0] = 3;
        for(int i = 1; i < 28; i++) {
            lengths[i] = lengths[i - 1] * 2 + i + 3;
        }

        int N = Integer.parseInt(br.readLine());

        while(true) {
            int low = 0;
            int high = lengths.length;

            while(low < high) {
                int mid = low + (high - low) / 2;

                if(lengths[mid] >= N) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            if(low == 0) {
                if(N == 1) {
                    System.out.println("m");
                    return;
                } else {
                    System.out.println("o");
                    return;
                }
            }

            if(N > lengths[low - 1] && N <= lengths[low] - lengths[low - 1]) {
                if(N == lengths[low - 1] + 1) {
                    System.out.println("m");
                    return;
                } else {
                    System.out.println("o");
                    return;
                }
            } else if(N > lengths[low] - lengths[low - 1]) {
                N -= lengths[low] - lengths[low - 1];
            }
        }
    }
}
