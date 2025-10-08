import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        long[] sums = new long[N + 1];

        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = (sums[i] + nums[i]) % M;
        }

        Map<Long, Long> map = new HashMap<>();
        long answer = 0;
        for(int i = 0; i < sums.length; i++) {
            if(!map.containsKey(sums[i])) map.put(sums[i], 0L);
            else {
                long value = map.get(sums[i]);
                map.replace(sums[i], value + 1);
                answer += value + 1;
            }
        }
        System.out.println(answer);
    }
}
