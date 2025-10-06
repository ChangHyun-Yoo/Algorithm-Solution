import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int length = 1;

        for(int i = 1; i < N; i++) {
            int current = list[i];

            int low = 0;
            int high = length;
            while(low < high) {
                int mid = low + (high - low) / 2;

                if(list[mid] >= current) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            if(low == length) {
                list[low] = current;
                length++;
            } else {
                if(list[low] > current) {
                    list[low] = current;
                }
            }
        }

        System.out.println(length);
    }
}
