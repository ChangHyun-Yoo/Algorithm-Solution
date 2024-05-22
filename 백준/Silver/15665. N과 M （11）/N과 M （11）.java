import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static Set<Integer> set = new HashSet<>();
    static List<Integer> lst = new ArrayList<>();
    static List<Integer> current = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int j = Integer.parseInt(st.nextToken());

            if(set.contains(j)) continue;
            else {
                set.add(j);
                lst.add(j);
            }
        }
        Collections.sort(lst);

        dfs();

        System.out.print(sb);
    }

    static void dfs() {
        if(current.size() == M) {
            for(int i = 0; i < current.size(); i++) {
                sb.append(current.get(i)).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < lst.size(); i++) {
            current.add(lst.get(i));
            dfs();
            current.remove(current.size() - 1);
        }
    }
}
