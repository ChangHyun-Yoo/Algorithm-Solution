import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weights = new int[N];

        for(int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        if(weights[0] != 1) {
            System.out.println(1);
            return;
        }

        int answer = -1;
        boolean breaked = false;
        int max = 1;
        for(int i = 1; i < weights.length; i++) {
            if(weights[i] > max + 1) {
                answer = max + 1;
                breaked = true;
                break;
            } else max += weights[i];
        }

        if(!breaked) answer = max + 1;

        System.out.println(answer);
    }
}
