import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] s = new long[1000001];
        for(int i = 0; i < 1000001; i++) {
            s[i] = 1;
        }

        int last = 0;
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < T; i++) {
            a.add(Integer.parseInt(br.readLine()));
        }
        last = Collections.max(a);

        for(int i = 2; i < last + 1; i++) {
            for (int j = i; j < last + 1; j += i) {
                s[j] += i;
            }
        }
        
        for(int i = 2; i < last + 1; i++) {
            s[i] += s[i - 1];
        }

        StringBuffer sb = new StringBuffer();
        for(Integer aaa: a) {
            sb.append(s[aaa]).append("\n");
        }
        System.out.println(sb);
    }

}