import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] sumA = new long[n + 1];
        for(int i = 1; i < n + 1; i++) {
            sumA[i] = Long.parseLong(st.nextToken()) + sumA[i - 1];
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long[] sumB = new long[m + 1];
        for(int i = 1; i < m + 1; i++) {
            sumB[i] = Long.parseLong(st.nextToken()) + sumB[i - 1];
        }

        Map<Long, Long> mapA = new HashMap<>();
        Map<Long, Long> mapB = new HashMap<>();

        for(int i = 0; i < sumA.length - 1; i++) {
            for(int j = i + 1; j < sumA.length; j++) {
                long value = sumA[j] - sumA[i];

                if(!mapA.containsKey(value)) mapA.put(value, 1L);
                else mapA.replace(value, mapA.get(value) + 1L);
            }
        }

        for(int i = 0; i < sumB.length - 1; i++) {
            for(int j = i + 1; j < sumB.length; j++) {
                long value = sumB[j] - sumB[i];

                if(!mapB.containsKey(value)) mapB.put(value, 1L);
                else mapB.replace(value, mapB.get(value) + 1L);
            }
        }

        long answer = 0;
        for(long key: mapA.keySet()) {
            long need = T - key;

            if(mapB.containsKey(need)) answer += mapA.get(key) * mapB.get(need);
        }

        System.out.println(answer);
    }
}
