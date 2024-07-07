import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String name = br.readLine();

            if(map.get(name) == null) {
                map.put(name, 1);
            } else {
                map.replace(name, map.get(name) + 1);
            }
        }

        for(int i = 0; i < N - 1; i++) {
            String name = br.readLine();

            if(map.get(name) == 1) map.remove(name);
            else map.replace(name, map.get(name) - 1);
        }

        for(String s: map.keySet()) {
            System.out.println(s);
        }
    }
}
