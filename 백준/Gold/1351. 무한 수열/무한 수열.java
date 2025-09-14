import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(dp(map, N, P, Q));
    }

    static long dp(Map<Long, Long> map, long N, long P, long Q) {
        if(map.get(N) != null) return map.get(N);

        long result = dp(map, N / P, P, Q) + dp(map, N / Q, P, Q);
        map.put(N, result);

        return result;
    }
}
