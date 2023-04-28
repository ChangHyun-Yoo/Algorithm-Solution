import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Long> num = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            num.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(num, Collections.reverseOrder());

        long answer = 0;
        for(int i = 1; i < N + 1; i++) {
            long n = num.get(i - 1) - (i - 1);
            if(n > 0) answer += n;
        }
        System.out.println(answer);
    }
}