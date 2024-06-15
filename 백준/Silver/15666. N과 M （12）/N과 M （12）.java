import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static Set<Integer> set;
    static List<Integer> lst;
    static List<Integer> current;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        lst = new ArrayList<>();
        current = new ArrayList<>();
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!set.contains(num)) {
                set.add(num);
                lst.add(num);
            }
        }

        Collections.sort(lst);

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int cur) {
        if(current.size() == M) {
            for(int i = 0; i < current.size(); i++) {
                sb.append(current.get(i)).append(' ');
            }
            sb.append('\n');

            return;
        }

        for(int i = cur; i < lst.size(); i++) {
            current.add(lst.get(i));
            dfs(i);
            current.remove(current.size() - 1);
        }
    }
}
