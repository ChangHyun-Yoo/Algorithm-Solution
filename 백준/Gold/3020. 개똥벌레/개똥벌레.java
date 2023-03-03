import java.io.*;
import java.util.*;

public class Main {

    static int[] under;
    static int[] over;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        under = new int[N / 2];
        over = new int[N / 2];

        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) {
                under[i / 2] = Integer.parseInt(br.readLine());
            } else {
                over[i / 2] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(under);
        Arrays.sort(over);

        int min = Integer.MAX_VALUE;
        int num = 0;

        for(int n = 1; n <= H; n++) {
            int underLower = binarySearchUnder(n);
            int overLower = binarySearchOver(H + 1 - n);

            if(N - underLower - overLower < min) {
                min = N - underLower - overLower;
                num = 1;
            } else if(N - underLower - overLower == min) {
                num++;
            }
        }

        System.out.println(min + " " + num);
    }

    private static int binarySearchOver(int n) {

        int low = 0;
        int high = over.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(n <= over[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int binarySearchUnder(int n) {

        int low = 0;
        int high = under.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(n <= under[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
