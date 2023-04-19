import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> ropes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropes, Collections.reverseOrder());

        int max = -1;

        for(int i = 1; i < N + 1; i++) {
            if(i * ropes.get(i - 1) > max) max = i * ropes.get(i - 1);
        }

        System.out.println(max);
    }
}