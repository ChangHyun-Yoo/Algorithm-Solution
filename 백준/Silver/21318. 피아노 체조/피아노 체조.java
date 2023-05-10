import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] song = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            song[i] = Integer.parseInt(st.nextToken());
        }

        int[] mistake = new int[N + 1];
        int n = 0;
        mistake[0] = n;
        for(int i = 0; i < N - 1; i++) {
            if(song[i] > song[i + 1]) {
                mistake[i + 1] = ++n;
            } else {
                mistake[i + 1] = n;
            }
        }
        mistake[N] = n;

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(mistake[y] != mistake[y - 1]) {
                sb.append(mistake[y] - mistake[x - 1] - 1).append('\n');
            } else {
                sb.append(mistake[y] - mistake[x - 1]).append('\n');
            }
        }
        System.out.println(sb);
    }
}