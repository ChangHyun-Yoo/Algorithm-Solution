import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer> nums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] lst;

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

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int length) {
        if(length == M) {
            for(int num: nums) {
                sb.append(num + " ");
            }
            sb.append('\n');
            return;
        }

        for(int l: lst) {
            nums.add(l);
            dfs(length + 1);
            nums.remove(nums.size() - 1);
        }
    }
}