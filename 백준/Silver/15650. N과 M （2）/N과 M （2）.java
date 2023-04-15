import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> lst = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            lst.add(i);
            dfs(i, 1);
            lst.remove(lst.size() - 1);
        }

        System.out.println(sb);
    }

    static void dfs(int n, int num) {
        if(num + N - n < M) return;

        if(num == M) {
            for (int value : lst) {
                sb.append(value + " ");
            }
            sb.append('\n');
            return;
        } else {
            for(int i = n + 1; i <= N; i++) {
                lst.add(i);
                dfs(i, num + 1);
                lst.remove(lst.size() - 1);
            }
        }
    }
}