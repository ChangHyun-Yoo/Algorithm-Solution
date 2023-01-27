import java.io.*;
import java.util.*;

public class Main {

    public static int N = 0;
    public static int M = 0;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        dfs(0, "");

        System.out.println(sb);
    }

    public static void dfs(int length, String now) {
        if(length == M) {
            sb.append(now).append('\n');
            return;
        }

        int count = 0;
        for(boolean v: visited) {
            if(!v)
                count++;
        }
        if(length + count < M)
            return;

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(length + 1, now + i + " ");
                visited[i] = false;
            }
        }
    }
}