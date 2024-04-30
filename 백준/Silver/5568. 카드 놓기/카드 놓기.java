import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int k;
    static String[] val;
    static List<Integer> cur = new ArrayList<>();
    static Set<Integer> curSet = new HashSet<>();
    static Set<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        val = new String[n];
        for(int i = 0; i < n; i++) {
            val[i] = br.readLine();
        }

        dfs();

        System.out.println(answer.size());
    }

    static void dfs() {
        if(cur.size() == k) {
            //  정수들 합치기
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < cur.size(); i++) {
                sb.append(val[cur.get(i)]);
            }
            answer.add(sb.toString());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!curSet.contains(i)) {
                cur.add(i);
                curSet.add(i);
                dfs();
                cur.remove(cur.size() - 1);
                curSet.remove(i);
            }
        }
    }

}