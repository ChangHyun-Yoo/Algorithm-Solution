import java.io.*;
import java.util.*;

public class Main {

    public static int N = 0;
    public static int S = 0;
    public static List<Integer> lst;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        lst = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(lst);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(-100001);
        queue.add(1);
        queue.add(lst.get(0));
        queue.add(1);

        while(!queue.isEmpty()) {
            int sum = queue.poll();
            int level = queue.poll();

            if(sum == S && level == N) {
                answer++;
                continue;
            }

            if(level != N) {
                if(sum == -100001) {
                    queue.add(lst.get(level));
                    queue.add(level + 1);
                    queue.add(-100001);
                    queue.add(level + 1);
                } else {
                    queue.add(sum + lst.get(level));
                    queue.add(level + 1);
                    queue.add(sum);
                    queue.add(level + 1);
                }
            }
        }

        System.out.println(answer);
    }


}