import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            map.put(i, new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num != -1) {
                List<Integer> l = map.get(num);
                l.add(i);
                map.replace(num, l);
            }
        }

        int r = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);

        while(!queue.isEmpty()) {
            int q = queue.poll();
            for(int a: map.get(q)) {
                queue.add(a);
            }
            map.remove(q);
        }

        int answer = 0;
        for(int s: map.keySet()) {
            if(map.get(s).contains(r) && map.get(s).size() == 1) {
                answer++;
                break;
            }
        }
        for(int s: map.keySet()) {
            if(map.get(s).size() == 0)
                answer++;
        }

        System.out.println(answer);
    }
}
