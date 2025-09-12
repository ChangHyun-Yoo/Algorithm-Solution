import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[H + 1];
        int[] up = new int[H + 1];

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if(i % 2 == 0) down[value]++;
            else up[H - value + 1]++;
        }

        for(int i = H - 1; i >= 0; i--) {
            down[i] += down[i + 1];
        }

        for(int i = 1; i < H + 1; i++) {
            up[i] += up[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 1; i < H + 1; i++) {
            if(min > down[i] + up[i]) {
                min = down[i] + up[i];
                count = 1;
            } else if(min == down[i] + up[i]) count++;
        }

        System.out.println(min + " " + count);
    }
}
