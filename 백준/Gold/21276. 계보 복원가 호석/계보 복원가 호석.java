import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> sons = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<List<Integer>> roads = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Map<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < N; i++) {
            names.add(st.nextToken());
            roads.add(new ArrayList<>());
            sons.add(new ArrayList<>());
        }
        Collections.sort(names);
        for(int i = 0; i < names.size(); i++) {
            indices.put(names.get(i), i);
        }

        int[] before = new int[N];
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String f = st.nextToken();
            String s = st.nextToken();

            int ff = indices.get(f);
            int ss = indices.get(s);

            roads.get(ss).add(ff);
            before[ff]++;
        }

        StringBuilder sb = new StringBuilder();
        int top = 0;
        List<String> topS = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < before.length; i++) {
            if(before[i] == 0) {
                top++;
                topS.add(names.get(i));
                q.offer(i);
            }
        }

        sb.append(top).append('\n');
        for(String t: topS) {
            sb.append(t).append(' ');
        }
        sb.append('\n');

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next: roads.get(now)) {
                before[next]--;
                if(before[next] == 0) {
                    q.offer(next);
                    sons.get(now).add(next);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            sb.append(names.get(i)).append(' ');
            sb.append(sons.get(i).size()).append(' ');
            Collections.sort(sons.get(i));
            for(int j = 0; j < sons.get(i).size(); j++) {
                sb.append(names.get(sons.get(i).get(j))).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
