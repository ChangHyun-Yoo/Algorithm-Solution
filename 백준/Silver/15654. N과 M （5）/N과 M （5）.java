import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;
    static int N;
    static int M;
    static List<Integer> lst = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int length) {
        if(length == M) {
            for(int s: lst) {
                sb.append(s + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!lst.contains(nums[i])) {
                lst.add(nums[i]);
                dfs(length + 1);
                lst.remove(lst.size() - 1);
            }
        }
    }
}