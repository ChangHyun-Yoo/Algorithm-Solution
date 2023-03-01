import java.io.*;
import java.util.*;

public class Main {

    static int[] info;
    static int[] result;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        info = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[N];
        result[0] = info[0];
        length = 1;
        int current = 1;
        while(current != N) {
            int index = binarySearch(info[current]);
            if(index == -1) {
                result[length++] = info[current++];
            } else {
                result[index] = info[current++];
            }
        }

        System.out.println(length);
    }

    static int binarySearch(int value) {

        int low = 0;
        int high = length;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(value <= result[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if(low == length) {
            return -1;
        } else {
            return low;
        }
    }
}