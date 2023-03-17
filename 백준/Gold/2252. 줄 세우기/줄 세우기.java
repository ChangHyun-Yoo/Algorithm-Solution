import java.io.*;
import java.util.*;

public class Main {

    static int[] beforeNum;
    static List<List<Integer>> order = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        beforeNum = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            order.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            beforeNum[a]++;
            order.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < N + 1; i++) {
            if(beforeNum[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int i = q.poll();
            sb.append(i + " ");

            for(int next: order.get(i)) {
                beforeNum[next]--;
                if(beforeNum[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(sb);
    }

}
