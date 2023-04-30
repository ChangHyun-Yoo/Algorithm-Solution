import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer> lst = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1, 0);

        System.out.println(sb);
    }

    static void dfs(int num, int g) {
        if(g == M) {
            for(int i: lst) {
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = num; i <= N; i++) {
            lst.add(i);
            dfs(i, g + 1);
            lst.remove(lst.size() - 1);
        }
    }
}