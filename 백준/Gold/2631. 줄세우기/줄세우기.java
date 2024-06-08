import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] lst = new int[N];

        for (int i = 0; i < lst.length; i++) {
            lst[i] = Integer.parseInt(br.readLine());
        }

        int length = 1;
        int[] answer = new int[N];
        answer[0] = lst[0];

        for (int i = 1; i < lst.length; i++) {
            int low = 0;
            int high = length;

            while(low < high) {
                int mid = low + (high - low) / 2;

                if(answer[mid] >= lst[i]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            if(low == length) {
                length++;
            }
            answer[low] = lst[i];
        }

        System.out.println(N - length);
    }
}
