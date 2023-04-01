import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> name1 = new HashMap<>();
        Map<Integer, String> name2 = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            name1.put(s, i + 1);
            name2.put(i + 1, s);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            try {
                int n = Integer.parseInt(command);
                sb.append(name2.get(n)).append('\n');
            } catch(Exception e) {
                sb.append(name1.get(command)).append('\n');
            }
        }
        System.out.println(sb);
    }
}

