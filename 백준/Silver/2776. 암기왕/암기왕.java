import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int n = 0; n < N; n++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int m = 0; m < M; m++) {
                if(set.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }
}
