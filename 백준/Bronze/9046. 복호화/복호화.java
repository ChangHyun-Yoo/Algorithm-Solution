import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            Map<Character, Integer> map = new HashMap<>();
            String s = br.readLine();
            int max = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != ' ') {
                    if(map.get(s.charAt(i)) == null) {
                        map.put(s.charAt(i), 1);
                        max = Math.max(1, max);
                    } else {
                        map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
                        max = Math.max(map.get(s.charAt(i)), max);
                    }
                }
            }

            char a = ' ';
            int count = 0;
            for(char c: map.keySet()) {
                if(map.get(c) == max) {
                    a = c;
                    count++;
                }
                if(count == 2) break;
            }
            if(count == 2) {
                System.out.println('?');
            } else {
                System.out.println(a);
            }
        }
    }
}