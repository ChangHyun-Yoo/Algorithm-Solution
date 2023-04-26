import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] lst = new int[N * N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                lst[N * i + j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(lst);
        System.out.println(lst[N * N - N]);
    }
}