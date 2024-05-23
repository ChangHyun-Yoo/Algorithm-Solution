import java.util.*;
import java.io.*;

public class Main {

    static char[] chs;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            chs = br.readLine().toCharArray();
            s = "YES";
            dfs(0, chs.length);

            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int left, int right) {
        if(s.equals("NO")) return;
        if(left + 1 == right) return;

        int mid = left + (right - left) / 2;

        for(int i = left; i < mid; i++) {
            if(chs[i] == chs[right - 1 - i]) {
                s = "NO";
                break;
            }
        }

        dfs(left, mid);
        dfs(mid + 1, right);
    }
}
