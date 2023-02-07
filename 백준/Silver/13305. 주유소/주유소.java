import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N - 1];
        int[] price = new int[N];
        int[] prefix = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++) {
            int value = Integer.parseInt(st.nextToken());
            distance[i] = value;
            prefix[i + 1] = value + prefix[i];
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> charge = new ArrayList<>();
        int current = 0;
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

        int answer = 0;
        for(int i = 0; i < charge.size() - 1; i++) {
            int city = charge.get(i);
            int pr = price[city];
            answer += pr * (prefix[charge.get(i + 1)] - prefix[city]);
        }

        System.out.println(answer);
    }
}