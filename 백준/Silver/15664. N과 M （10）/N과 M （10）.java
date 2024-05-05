import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] lst;
    static List<Integer> current = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lst = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lst);

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int cur) {
        if(current.size() == M) {
            StringBuilder context = new StringBuilder();
            for(int c: current) {
                context.append(c + " ");
            }
            if(set.contains(context.toString())) return;
            else {
                sb.append(context.toString());
                set.add(context.toString());
            }
            sb.append('\n');
            return;
        }

        if(cur >= N) return;

        for(int i = cur; i < N; i++) {
            current.add(lst[i]);
            dfs(i + 1);
            current.remove(current.size() - 1);
        }
    }

}