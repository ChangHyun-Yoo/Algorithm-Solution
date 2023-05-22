import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] lst;
    static List<Integer> nums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lst = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lst);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int index, int num) {
        if(num + N - index < M) return;

        if(num == M) {
            for(int n: nums) {
                sb.append(n + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = index; i < N; i++) {
            nums.add(lst[i]);
            dfs(i + 1, num + 1);
            nums.remove(nums.size() - 1);
        }
    }
}