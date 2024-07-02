import java.util.*;
import java.io.*;

public class Main {

    static int[] before;
    static boolean[] visited;
    static int[] target;
    static List<List<Integer>> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        before = new int[M];
        visited = new boolean[N + 1];
        target = new int[M];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            before[i] = k;

            for(int j = 0; j < k; j++) {
                roads.get(Integer.parseInt(st.nextToken())).add(i);
            }

            target[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        int L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int l = 0; l < L; l++) {
            int y = Integer.parseInt(st.nextToken());
            visited[y] = true;
            q.offer(y);
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next: roads.get(now)) {
                before[next]--;
                if(before[next] == 0 && !visited[target[next]]) {
                    visited[target[next]] = true;
                    q.offer(target[next]);
                }
            }
        }

        int answerNum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + 1; i++) {
            if(visited[i]) {
                sb.append(i).append(' ');
                answerNum++;
            }
        }

        System.out.println(answerNum);
        System.out.println(sb);
    }
}
