import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static List<Integer> nums = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    static List<Integer> selected = new ArrayList<>();
    static StringBuffer sb;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checked = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

        sb = new StringBuffer();

        for(int i = 0; i < N; i++) {
            selected.add(nums.get(i));
            checked[i] = true;
            dfs(i, 1);
            checked[i] = false;
            selected.remove(selected.size() - 1);
        }

        System.out.print(sb);
    }

    static void dfs(int current, int length) {
        if(length == M) {
            String s = "";
            for(int se: selected) {
                s += se + " ";
            }
            if(!set.contains(s)) {
                set.add(s);
                sb.append(s + "\n");
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(current != i && !checked[i]) {
                selected.add(nums.get(i));
                checked[i] = true;
                dfs(i, length + 1);
                checked[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }

}