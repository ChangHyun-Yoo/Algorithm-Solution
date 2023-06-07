import java.io.*;
import java.util.*;

public class Main {

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        String[] lst = new String[K];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            lst[i] = st.nextToken();
        }

        Queue<String> q = new LinkedList<>();
        for(String n: lst) {
            q.offer(n);
        }
        while(!q.isEmpty()) {
            String poll = q.poll();

            if(poll.length() > N.length()) continue;

            if(Integer.parseInt(poll) <= Integer.parseInt(N) && answer < Integer.parseInt(poll)) {
                answer = Integer.parseInt(poll);
            }
            for(String n: lst) {
                q.offer(new String(poll + n));
            }
        }

        System.out.println(answer);
    }
}