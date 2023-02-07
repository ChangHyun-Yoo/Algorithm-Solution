import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N - 1];
        long[] price = new long[N];
        long[] prefix = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++) {
            long value = Long.parseLong(st.nextToken());
            distance[i] = value;
            prefix[i + 1] = value + prefix[i];
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> charge = new ArrayList<>();
        long current = 0;
        for(int i = 0; i < N - 1; i++) {
            if(i == 0) {
                current = price[i];
                charge.add(i);
            } else {
                if(current > price[i]) {
                    current = price[i];
                    charge.add(i);
                }
            }
        }
        charge.add(N - 1);

        long answer = 0;
        for(int i = 0; i < charge.size() - 1; i++) {
            int city = charge.get(i);
            long pr = price[city];
            answer += pr * (prefix[charge.get(i + 1)] - prefix[city]);
        }

        System.out.println(answer);
    }
}
