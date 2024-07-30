import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if(map.get(s) == null) map.put(s, 1);
            else map.replace(s, map.get(s) + 1);
        }

        int max = -1;
        String maxString = null;

        for(String key: map.keySet()) {
            int value = map.get(key);
            if(value > max) {
                max = value;
                maxString = key;
            } else if(value == max) {
                if(maxString.compareTo(key) > 0) maxString = key;
            }
        }

        System.out.println(maxString);
    }

}


