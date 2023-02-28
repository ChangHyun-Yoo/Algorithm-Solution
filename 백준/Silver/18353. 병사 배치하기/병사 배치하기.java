import java.io.*;
import java.util.*;

public class Main {

    static int[] info;
    static int[] result;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        info = new int[N];
        for(int i = N - 1; i >= 0; i--) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[N];

        int current = 1;
        length = 1;
        result[0] = info[0];

        while(current != N) {
            int index = binarySearch(info[current]);
            if(index == -1) {
                result[length++] = info[current++];
            } else {
                result[index] = info[current++];
            }
        }

        System.out.println(N - length);
    }

    static int binarySearch(int value) {

        int low = 0;
        int high = length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(value < result[mid]) {
                high = mid - 1;
            } else if(value > result[mid]) {
                low = mid + 1;
            } else {
                break;
            }
        }

        if(low == length) {
            return -1;
        } else {
            return low;
        }
    }
}