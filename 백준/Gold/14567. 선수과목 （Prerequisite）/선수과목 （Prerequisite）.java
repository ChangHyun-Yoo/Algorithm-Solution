import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> order = new ArrayList<>();
    static int[] beforeNum;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        beforeNum = new int[N + 1];
        visited = new boolean[N + 1];
        int[] answer = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            order.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            beforeNum[after] += 1;
            order.get(before).add(after);
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < N + 1; i++) {
            if(beforeNum[i] == 0 && !visited[i]) {
                q.offer(i);
            }
        }
        int semester = 1;
        while(!q.isEmpty()) {
            while(!q.isEmpty()) {
                int sub = q.poll();
                visited[sub] = true;
                answer[sub] = semester;
                for(int s: order.get(sub)) {
                    beforeNum[s] -= 1;
                }
                order.get(sub).clear();
            }
            for(int i = 1; i < N + 1; i++) {
                if(beforeNum[i] == 0 && !visited[i]) {
                    q.offer(i);
                }
            }
            semester++;
        }
        for(int i = 1; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
