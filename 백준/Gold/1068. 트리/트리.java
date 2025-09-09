import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            roads.add(new ArrayList<>());
        }

        int head = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num != -1) {
                roads.get(num).add(i);
            } else {
                head = i;
            }
        }

        int remove = Integer.parseInt(br.readLine());
        if(remove == head) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(head);

        int answer = 0;
        while(!q.isEmpty()) {
            int current = q.poll();

            int nextNum = 0;
            for(int next: roads.get(current)) {
                if(next != remove) {
                    nextNum++;
                    q.add(next);
                }
            }
            if(nextNum == 0) answer++;
        }

        System.out.println(answer);
    }
}
