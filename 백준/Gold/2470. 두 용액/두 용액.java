import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] lst = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lst);

        int answer1 = 0;
        int answer2 = 0;
        int min = Integer.MAX_VALUE;

        int l = 0;
        int r = N - 1;
        while(r != l) {
            int current = lst[l] + lst[r];

            if(min > Math.abs(current)) {
                min = Math.abs(current);
                answer1 = lst[l];
                answer2 = lst[r];
            }

            if(current < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
