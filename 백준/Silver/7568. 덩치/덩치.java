import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] info = new int[2 * N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            info[2 * i] = Integer.parseInt(st.nextToken());
            info[2 * i + 1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            int answer = 1;
            for(int j = 0; j < N; j++) {
                if(i == j)
                    continue;
                else {
                    if(info[2 * i] < info[2 * j] && info[2 * i + 1] < info[2 * j + 1])
                        answer++;
                }
            }
            System.out.print(answer + " ");
        }
    }

}