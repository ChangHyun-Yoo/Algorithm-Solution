import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < N + 1; i++) {
            map.put(i, Integer.parseInt(br.readLine()));
        }

        while(true) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> keySet = new HashSet<>();
            for(int i: map.keySet()) {
                set.add(map.get(i));
                keySet.add(i);
            }

            int removed = 0;

            for(int key: keySet) {
                if(!set.contains(key)) {
                    map.remove(key);
                    removed++;
                }
            }
            if(removed == 0) break;

        }

        Set<Integer> answer = map.keySet();
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for(int a: answer) {
            sb.append(a).append('\n');
        }
        System.out.print(sb);
    }

}


