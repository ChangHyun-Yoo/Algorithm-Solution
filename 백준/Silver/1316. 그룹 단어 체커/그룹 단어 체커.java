import java.util.*;
import java.io.*;

public class Main {

    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            char[] chs = br.readLine().toCharArray();
            Set<Character> s = new HashSet<>();

            char before = chs[0];
            s.add(before);

            boolean b = true;

            for(int j = 1; j < chs.length; j++) {
                if(chs[j] == before) {
                    continue;
                } else {
                    if(s.contains(chs[j])) b = false;
                    else {
                        s.add(chs[j]);
                        before = chs[j];
                    }
                }
            }
            if(b) answer++;
        }
        System.out.println(answer);
    }

}