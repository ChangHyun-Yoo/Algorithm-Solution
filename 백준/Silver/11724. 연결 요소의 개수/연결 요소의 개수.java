import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            roads.get(u).add(v);
            roads.get(v).add(u);
        }

        int answer = 1;

        int[] check = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            if(check[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while(!q.isEmpty()) {
                    int now = q.poll();

                    if(check[now] != 0) continue;
                    check[now] = answer;

                    for(int next: roads.get(now)) {
                        if(check[next] == 0) {
                            q.offer(next);
                        }
                    }
                }

                answer++;
            }
        }
        System.out.println(answer - 1);
    }
}
