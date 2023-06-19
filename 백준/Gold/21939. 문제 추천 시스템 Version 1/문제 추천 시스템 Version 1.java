import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        Map<Integer, Integer> m = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            if(map.get(L) == null) {
                map.put(L, new TreeSet<>());
                map.get(L).add(P);
            } else {
                map.get(L).add(P);
            }
            m.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if(command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                if(map.get(L) == null) {
                    map.put(L, new TreeSet<>());
                    map.get(L).add(P);
                } else {
                    map.get(L).add(P);
                }
                m.put(P, L);
            } else if(command.equals("recommend")) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    sb.append(map.get(map.lastKey()).last()).append('\n');
                } else {
                    sb.append(map.get(map.firstKey()).first()).append('\n');
                }
            } else {
                int P = Integer.parseInt(st.nextToken());

                map.get(m.get(P)).remove(P);
                if(map.get(m.get(P)).isEmpty()) {
                    map.remove(m.get(P));
                }
                m.remove(P);
            }
        }

        System.out.println(sb);
    }
}