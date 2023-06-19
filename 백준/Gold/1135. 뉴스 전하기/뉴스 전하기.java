import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> child = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N + 1; i++) {
            child.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(i != 1) {
                child.get(a).add(i - 1);
            }
        }

        System.out.println(dfs(0));
    }

    static int dfs(int n) {
        if(child.get(n).isEmpty()) return 0;

        List<Integer> lst = new ArrayList<>();
        for(int next: child.get(n)) {
            lst.add(dfs(next));
        }
        Collections.sort(lst, Collections.reverseOrder());
        int max = -1;
        for(int i = 0; i < lst.size(); i++) {
            max = Math.max(max, i + 1 + lst.get(i));
        }

        return max;
    }
}