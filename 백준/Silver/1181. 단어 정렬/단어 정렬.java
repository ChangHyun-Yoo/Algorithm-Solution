import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] s = new String[N];

        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length; i++) {
            if(!set.contains(s[i])) {
                sb.append(s[i] + '\n');
                set.add(s[i]);
            }
        }

        System.out.print(sb);
    }
}