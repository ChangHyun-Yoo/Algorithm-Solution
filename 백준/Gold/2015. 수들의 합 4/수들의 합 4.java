import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N + 1];

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + Integer.parseInt(st.nextToken());
            if(map.get(sum[i + 1]) == null) {
                map.put(sum[i + 1], 1);
            } else {
                map.replace(sum[i + 1], map.get(sum[i + 1]) + 1);
            }
        }
        if(map.get(sum[0]) == null) {
            map.put(sum[0], 1);
        } else {
            map.replace(sum[0], map.get(sum[0]) + 1);
        }

        long answer = 0;
        for(int i = 0; i <= N; i++) {
            map.replace(sum[i], map.get(sum[i]) - 1);
            if(map.get(K + sum[i]) != null)
                answer += map.get(K + sum[i]);
        }
        System.out.println(answer);
    }
}